package net.roadkill.redev.common.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.roadkill.redev.core.init.EffectInit;
import org.jetbrains.annotations.Nullable;

public class WitherWraith extends AbstractSkeleton implements TraceableEntity {
    @Nullable
    Mob owner;
    public WitherWraith(EntityType<? extends AbstractSkeleton> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return WitherSkeleton.createAttributes().add(Attributes.ATTACK_DAMAGE, 3).add(Attributes.ARMOR, 5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        //this.goalSelector.addGoal(4, new Vex.VexChargeAttackGoal());
        //this.goalSelector.addGoal(8, new Vex.VexRandomMoveGoal());
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, LivingEntity.class).setAlertOthers());
        this.targetSelector.addGoal(2, new WitherWraith.WitherProtectOwnerTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Nullable
    @Override
    public Mob getOwner() {
        return this.owner;
    }

    public void setOwner(Mob owner) {
        this.owner = owner;
    }

    @Override
    public void restoreFrom(Entity entity) {
        super.restoreFrom(entity);
        if (entity instanceof WitherWraith witherHead) {
            this.owner = witherHead.getOwner();
        }
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Override
    public boolean isInvulnerableTo(ServerLevel level, DamageSource source) {
        return (source.getEntity() != null && owner != null && source.getEntity().is(owner)) || super.isInvulnerableTo(level, source);
    }

    @Override
    protected void tickDeath() {
        if (owner != null) owner.addEffect(new MobEffectInstance(EffectInit.DE_ADDED, 200, 0, true, false));
        super.tickDeath();
    }

    class WitherProtectOwnerTargetGoal extends TargetGoal {
        private final TargetingConditions copyOwnerTargeting = TargetingConditions.forNonCombat().ignoreLineOfSight().ignoreInvisibilityTesting();

        public WitherProtectOwnerTargetGoal(PathfinderMob mob) {
            super(mob, false);
        }

        @Override
        public boolean canUse() {
            return WitherWraith.this.owner != null && WitherWraith.this.owner.getTarget() != null && this.canAttack(WitherWraith.this.owner.getTarget(), this.copyOwnerTargeting);
        }

        @Override
        public void start() {
            WitherWraith.this.setTarget(WitherWraith.this.owner.getTarget());
            super.start();
        }
    }
}
