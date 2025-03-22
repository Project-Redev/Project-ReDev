package net.roadkill.redev.common.entity;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class WitherHead extends Monster implements TraceableEntity {
    @Nullable
    Mob owner;
    protected WitherHead(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
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
        this.targetSelector.addGoal(2, new WitherHead.WitherProtectOwnerTargetGoal(this));
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
        if (entity instanceof WitherHead witherHead) {
            this.owner = witherHead.getOwner();
        }
    }

    class WitherProtectOwnerTargetGoal extends TargetGoal {
        private final TargetingConditions copyOwnerTargeting = TargetingConditions.forNonCombat().ignoreLineOfSight().ignoreInvisibilityTesting();

        public WitherProtectOwnerTargetGoal(PathfinderMob mob) {
            super(mob, false);
        }

        @Override
        public boolean canUse() {
            return WitherHead.this.owner != null && WitherHead.this.owner.getTarget() != null && this.canAttack(WitherHead.this.owner.getTarget(), this.copyOwnerTargeting);
        }

        @Override
        public void start() {
            WitherHead.this.setTarget(WitherHead.this.owner.getTarget());
            super.start();
        }
    }
}
