package net.roadkill.redev.common.entity.arrows;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.roadkill.redev.core.init.EffectInit;
import net.roadkill.redev.core.init.ItemInit;

//Doesnt update the chunks after placing the amethysts
public class InkArrowEntity extends CustomArrowsBaseEntity {



    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemInit.QUARTZ_ARROW.get());
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.QUARTZ_ARROW.get());
    }




    public InkArrowEntity(EntityType type, Level level) {
        super(type, level);
        this.setBaseDamage(this.getBaseDamage() + 2.0d);

    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        BlockPos hitPos = result.getBlockPos();
        AABB effectArea = new AABB(hitPos.getCenter().add(new Vec3(3,3,3)),hitPos.getCenter().subtract(new Vec3(3,3,3)));

        var entities = level().getEntitiesOfClass(LivingEntity.class, effectArea);
        entities.forEach(entity -> {
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,10*16,1));
            if(level().isClientSide) return;
            ((ServerLevel) level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.BLACK_WOOL.defaultBlockState()),
                    entity.position().x,entity.position().y,entity.position().z,40,0.2,1,0.2,2);
        });

    }

    @Override
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);
        target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,10*16,1));

    }


}
