package net.roadkill.redev.common.entity.arrows;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);
        target.addEffect(new MobEffectInstance(EffectInit.BLEEDING,10*16,1));

    }


}
