package net.roadkill.redev.common.entity.arrows;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.roadkill.redev.core.init.ItemInit;

import java.util.*;

//Doesnt update the chunks after placing the amethysts
public class DripstoneArrowEntity extends CustomArrowsBaseEntity  {



    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemInit.DRIPSTONE_ARROW.get());
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.DRIPSTONE_ARROW.get());
    }




    public DripstoneArrowEntity(EntityType type, Level level) {
        super(type, level);
        this.pickup = Pickup.DISALLOWED;
        this.setBaseDamage(6.0d);

    }



    @Override//  Wierd behaviour but such are the specs
    protected void applyGravity() {
        double grav = this.getGravity();
        Vec3 deltaVel = this.getDeltaMovement();
        if (deltaVel.y>0)
            grav*=2; //double gravity if going up
        else
            grav*=3; //triple gravity if going down

        if (grav != 0.0) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, -grav, 0.0));
        }
    }

    @Override // slight trick. Normal arrows deals up to 6 depending on speed, this is supposed to deal up to 12. Temporary *2 of the speed should have
    //the same effect
    protected void onHitEntity(EntityHitResult result) {
        this.setDeltaMovement(this.getDeltaMovement().multiply(2,2,2));
        super.onHitEntity(result);
        this.setDeltaMovement(this.getDeltaMovement().multiply(0.5,0.5,0.5));

    }


}
