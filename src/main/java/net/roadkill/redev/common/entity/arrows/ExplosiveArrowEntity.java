package net.roadkill.redev.common.entity.arrows;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.roadkill.redev.core.init.ItemInit;

public class ExplosiveArrowEntity  extends CustomArrowsBaseEntity {



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
                null, this.getX(), this.getY(0.0625), this.getZ(),3, false, Level.ExplosionInteraction.MOB);
        super.setInGround(true);
        this.discard();
    }


}