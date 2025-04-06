package net.roadkill.redev.common.entity.arrows;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.roadkill.redev.ReDev;
import net.roadkill.redev.core.init.ItemInit;
import org.joml.Vector3f;

public abstract class CustomArrowsBaseEntity extends AbstractArrow {


  // @Override
  // protected boolean tryPickup(Player player) {
  //     return false;
  // }


    public CustomArrowsBaseEntity(EntityType type, Level level){
        super(type, level);
    }




}
