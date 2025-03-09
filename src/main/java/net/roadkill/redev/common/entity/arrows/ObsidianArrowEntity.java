package net.roadkill.redev.common.entity.arrows;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.roadkill.redev.core.damageTypes.DamageTypes;
import net.roadkill.redev.core.init.ItemInit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Doesnt update the chunks after placing the amethysts
public class ObsidianArrowEntity extends CustomArrowsBaseEntity {



    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemInit.OBSIDIAN_ARROW.get());
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.OBSIDIAN_ARROW.get());
    }




    public ObsidianArrowEntity(EntityType type, Level level) {
        super(type, level);
        this.setBaseDamage(0);

    }

    @Override
    protected void onHitEntity(EntityHitResult result) {

        super.onHitEntity(result);
        if(result.getEntity().level().isClientSide)
            return;
        var dmgSource = new DamageSource(registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(DamageTypes.IGNORE_ARMOR));
        result.getEntity().hurtServer((ServerLevel)result.getEntity().level(),dmgSource,4 );
    }
}
