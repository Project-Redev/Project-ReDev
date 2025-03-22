package net.roadkill.redev.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(WitherBoss.class)
public abstract class MixinWitherBoss extends Monster implements RangedAttackMob {
    // Shadow fields from WitherBoss
    @Shadow public abstract int getInvulnerableTicks();
    @Shadow public abstract void setInvulnerableTicks(int ticks);
    @Shadow protected abstract void customServerAiStep(ServerLevel level);

    // Custom fields for stage mechanics
    private int stage = 1; // 1 = 3 heads, 2 = 2 heads, 3 = 1 head
    private List<WitherSkeleton> summonedSkeletons = new ArrayList<>();
    private int rechargeTimer = 0;
    private static final int[] STAGE_HEALTH = {50, 100, 150}; // Health per stage
    private static final int RECHARGE_DURATION = 200; // 10 seconds (200 ticks)
    private static final int[] SKELETON_COUNTS = {0, 3, 5}; // Skeletons per stage transition (0 for Stage 1 -> 2)

    protected MixinWitherBoss(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    // Inject into constructor to initialize stage
    @Inject(method = "<init>", at = @At("TAIL"))
    private void initStage(EntityType<? extends WitherBoss> entityType, Level level, CallbackInfo ci) {
        this.stage = 1;
        this.setHealth(STAGE_HEALTH[0]);
        this.setInvulnerableTicks(0); // Disable initial invulnerability
        this.rechargeTimer = 0;
        this.summonedSkeletons.clear();
    }

    // Override max health based on stage
    @Inject(method = "createAttributes", at = @At("RETURN"), cancellable = true)
    private static void modifyAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        AttributeSupplier.Builder builder = cir.getReturnValue();
        builder.add(Attributes.MAX_HEALTH, STAGE_HEALTH[0]); // Start with Stage 1 health
        cir.setReturnValue(builder);
    }

    // Inject into hurtServer to handle stage transitions
    @Inject(method = "hurtServer", at = @At("HEAD"), cancellable = true)
    private void onHurtServer(ServerLevel level, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (this.rechargeTimer > 0 || !this.summonedSkeletons.isEmpty()) {
            cir.setReturnValue(false); // Invulnerable during recharge or skeleton phase
            return;
        }

        if (this.getInvulnerableTicks() > 0 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            cir.setReturnValue(false);
            return;
        }

        float newHealth = this.getHealth() - amount;
        if (newHealth <= 0 && this.stage < 3) {
            // Transition to next stage
            this.transitionToNextStage(level);
            cir.setReturnValue(true);
        } else if (newHealth <= 0 && this.stage == 3) {
            // Final stage defeated
            cir.setReturnValue(super.hurtServer(level, source, amount));
        } else {
            // Normal damage application
            cir.setReturnValue(super.hurtServer(level, source, amount));
        }
    }

    // Inject into customServerAiStep to manage recharge and skeleton logic
    @Inject(method = "customServerAiStep", at = @At("HEAD"), cancellable = true)
    private void customServerAiStep(ServerLevel level, CallbackInfo ci) {
        if (this.getInvulnerableTicks() > 0) {
            // Vanilla invulnerability logic (initial spawn)
            int i = this.getInvulnerableTicks() - 1;
            boss().bossEvent.setProgress(1.0F - (float)i / 220.0F);
            if (i <= 0) {
                level.explode(this, this.getX(), this.getEyeY(), this.getZ(), 7.0F, false, Level.ExplosionInteraction.MOB);
                if (!this.isSilent()) {
                    level.globalLevelEvent(1023, this.blockPosition(), 0);
                }
            }
            this.setInvulnerableTicks(i);
            if (this.tickCount % 10 == 0) {
                this.heal(10.0F);
            }
            ci.cancel(); // Skip normal AI during initial invulnerability
            return;
        }

        // Custom recharge phase
        if (this.rechargeTimer > 0) {
            this.rechargeTimer--;
            this.setInvulnerableTicks(Math.max(this.getInvulnerableTicks(), 1)); // Keep invulnerable

            if (this.rechargeTimer == RECHARGE_DURATION / 2) {
                // Mid-recharge: explode and summon skeletons
                level.explode(this, this.getX(), this.getEyeY(), this.getZ(), 3.0F, false, Level.ExplosionInteraction.MOB);
                this.summonSkeletons(level);
            }
            ci.cancel(); // Skip normal AI during recharge
            return;
        }

        // Skeleton phase: remain inactive until all skeletons are dead
        if (!this.summonedSkeletons.isEmpty()) {
            this.summonedSkeletons.removeIf(Entity::isRemoved);
            if (this.summonedSkeletons.isEmpty()) {
                // Skeletons defeated, resume fight with full health for current stage
                this.setHealth(STAGE_HEALTH[this.stage - 1]);
            } else {
                this.setInvulnerableTicks(Math.max(this.getInvulnerableTicks(), 1)); // Stay invulnerable
                ci.cancel(); // Skip normal AI while skeletons are alive
                return;
            }
        }

        // Update health for current stage if not already set
        if (this.getMaxHealth() != STAGE_HEALTH[this.stage - 1]) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(STAGE_HEALTH[this.stage - 1]);
            this.setHealth(STAGE_HEALTH[this.stage - 1]);
        }

        // Proceed with normal AI
        super.customServerAiStep(level);
    }

    // Save custom data
    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void saveCustomData(CompoundTag compound, CallbackInfo ci) {
        compound.putInt("CustomStage", this.stage);
        compound.putInt("RechargeTimer", this.rechargeTimer);
        compound.putInt("SkeletonCount", this.summonedSkeletons.size());
    }

    // Load custom data
    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void readCustomData(CompoundTag compound, CallbackInfo ci) {
        this.stage = compound.getInt("CustomStage");
        if (this.stage < 1 || this.stage > 3) this.stage = 1; // Validate
        this.rechargeTimer = compound.getInt("RechargeTimer");
        // Skeletons will repopulate naturally during tick if rechargeTimer > 0
    }

    // Transition to next stage
    private void transitionToNextStage(ServerLevel level) {
        this.stage++;
        this.rechargeTimer = RECHARGE_DURATION;
        this.setInvulnerableTicks(RECHARGE_DURATION);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(STAGE_HEALTH[this.stage - 1]);
        this.setHealth(0); // Prevent death during transition
        this.summonedSkeletons.clear();
    }

    // Summon skeletons based on stage
    private void summonSkeletons(ServerLevel level) {
        int skeletonCount = SKELETON_COUNTS[this.stage - 1];
        this.summonedSkeletons.clear();

        for (int i = 0; i < skeletonCount; i++) {
            WitherSkeleton skeleton = EntityType.WITHER_SKELETON.create(level, EntitySpawnReason.MOB_SUMMONED);
            if (skeleton != null) {
                skeleton.setPos(this.getX() + (random.nextDouble() - 0.5) * 8, this.getY(), this.getZ() + (random.nextDouble() - 0.5) * 8);
                skeleton.finalizeSpawn(level, level.getCurrentDifficultyAt(skeleton.blockPosition()), EntitySpawnReason.MOB_SUMMONED, null);
                level.addFreshEntity(skeleton);
                this.summonedSkeletons.add(skeleton);
            }
        }
    }

    // Optional: Modify head count (affects targeting logic, not rendering)
    @Inject(method = "getAlternativeTarget", at = @At("RETURN"), cancellable = true)
    private void modifyHeadCount(int head, CallbackInfoReturnable<Integer> cir) {
        if (head >= (4 - this.stage)) {
            cir.setReturnValue(0); // Disable targets for heads beyond current stage
        }
    }
    @Unique
    private WitherBoss boss() {
        return ((WitherBoss)(Object)this);
    }
}
