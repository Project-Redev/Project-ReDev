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
import net.roadkill.redev.common.entity.arrows.ObsidianArrowEntity;
import net.roadkill.redev.core.init.EntityInit;

import javax.annotation.Nullable;

public class ObsidianArrowItem extends ArrowItem implements ProjectileItem {
    public ObsidianArrowItem(Properties properties)
    {
        super (properties);
    }

   @Override
   public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
       ObsidianArrowEntity arrow = new ObsidianArrowEntity(EntityInit.OBSIDIAN_ARROW.get(), level);
       arrow.setOwner(shooter);
       arrow.setPos(shooter.getEyePosition());
       arrow.setXRot(shooter.getXRot());
       arrow.setYRot(shooter.yHeadRot);
       ReDev.LOGGER.debug("ARROW created");

       return arrow;
   }


}
