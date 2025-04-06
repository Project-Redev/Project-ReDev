package net.roadkill.redev.common.entity.arrows;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.roadkill.redev.core.init.ItemInit;

public class ExplosiveArrowEntity  extends CustomArrowsBaseEntity {
    public class EntityOnlyExplosionDamageCalculator extends ExplosionDamageCalculator {
        public EntityOnlyExplosionDamageCalculator(){
            super();
        }

        @Override
        public boolean shouldBlockExplode(Explosion explosion, BlockGetter reader, BlockPos pos, BlockState state, float power) {
            return false;
        }

        @Override
        public boolean shouldDamageEntity(Explosion explosion, Entity entity) {
            return true;
        }
    };



    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemInit.EXPLOSIVE_ARROW.get());
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.EXPLOSIVE_ARROW.get());
    }




    public ExplosiveArrowEntity(EntityType type, Level level) {
        super(type, level);
        this.setBaseDamage(this.getBaseDamage() + 2.0d);

    }

    @Override
    protected void onHitBlock(BlockHitResult result)
    {

        this.level().explode(this, Explosion.getDefaultDamageSource(this.level(), this),
                new EntityOnlyExplosionDamageCalculator(), this.getX(), this.getY(0.0625), this.getZ(),3, false, Level.ExplosionInteraction.TNT);
        super.setInGround(true);
        this.discard();
    }

 //  @Override
 //  public boolean shouldBlockExplode(Explosion explosion, BlockGetter level, BlockPos pos, BlockState blockState, float explosionPower) {
 //      return false;
 //  }

}