package net.roadkill.redev.common.item.arrows;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import net.roadkill.redev.ReDev;
import net.roadkill.redev.common.entity.arrows.BouncingArrowEntity;
import net.roadkill.redev.core.init.EntityInit;

import javax.annotation.Nullable;

public class PrismarineArrowItem extends ArrowItem implements ProjectileItem {
    public PrismarineArrowItem(Properties properties)
    {
        super (properties);
    }

   @Override
   public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
       BouncingArrowEntity arrow = new BouncingArrowEntity(EntityInit.BOUNCING_ARROW.get(), level);
       arrow.setOwner(shooter);
       arrow.setPos(shooter.getEyePosition());
       arrow.setXRot(shooter.getXRot());
       arrow.setYRot(shooter.yHeadRot);
       ReDev.LOGGER.debug("ARROW created");

       return arrow;
   }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, net.minecraft.core.Direction direction) {
        BouncingArrowEntity arrow = new BouncingArrowEntity(EntityInit.BOUNCING_ARROW.get(), level);
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        arrow.setPos(pos.x(),pos.y(),pos.z());
        ReDev.LOGGER.debug("ARROW as projectile");
        return arrow;
    }
}
