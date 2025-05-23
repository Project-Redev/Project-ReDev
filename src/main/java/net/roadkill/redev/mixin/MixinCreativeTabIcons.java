package net.roadkill.redev.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.roadkill.redev.common.event.CycleColorTab;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Supplier;

@Mixin(CreativeModeTab.Builder.class)
public class MixinCreativeTabIcons
{
    @Shadow
    private Component displayName;

    @Shadow
    private Supplier<ItemStack> iconGenerator;

    @Inject(method = "icon(Ljava/util/function/Supplier;)Lnet/minecraft/world/item/CreativeModeTab$Builder;",
            at = @At(value = "RETURN"))
    private void setIcon(Supplier<ItemStack> icon, CallbackInfoReturnable<CreativeModeTab.Builder> cir)
    {
        if (this.displayName.equals(Component.translatable("itemGroup.combat")))
        {   this.iconGenerator = () -> new ItemStack(Items.GOLDEN_SWORD);
        }
        else if (this.displayName.equals(Component.translatable("itemGroup.foodAndDrink")))
        {   this.iconGenerator = () -> new ItemStack(Items.APPLE);
        }
        else if (this.displayName.equals(Component.translatable("itemGroup.functional")))
        {   this.iconGenerator = () -> new ItemStack(Items.FURNACE);
        }
        else if (this.displayName.equals(Component.translatable("itemGroup.coloredBlocks")))
        {   this.iconGenerator = () -> CycleColorTab.COLORED_BLOCKS_ICON;
        }
        else if (this.displayName.equals(Component.translatable("itemGroup.spawnEggs")))
        {   this.iconGenerator = () -> new ItemStack(Items.CREEPER_SPAWN_EGG);
        }
        else if (this.displayName.equals(Component.translatable("itemGroup.tools")))
        {
            this.iconGenerator = () -> new ItemStack(Items.IRON_AXE);
        }
    }

    @Mixin(CreativeModeTab.class)
    static final class ColorTabReset
    {
        @Final
        @Shadow
        private Supplier<ItemStack> iconGenerator;

        @Inject(method = "getIconItem()Lnet/minecraft/world/item/ItemStack;", at = @At("HEAD"), cancellable = true)
        private void onGetDisplayItem(CallbackInfoReturnable<ItemStack> cir)
        {
            Holder<CreativeModeTab> coloredBlocks = BuiltInRegistries.CREATIVE_MODE_TAB.get(CreativeModeTabs.COLORED_BLOCKS).orElse(null);
            if (coloredBlocks != null && (Object) this == coloredBlocks.value())
            {   cir.setReturnValue(iconGenerator.get());
            }
        }
    }
}
