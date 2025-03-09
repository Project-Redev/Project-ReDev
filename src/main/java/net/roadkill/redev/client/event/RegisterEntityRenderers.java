package net.roadkill.redev.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.roadkill.redev.client.model.armor.HoglinHideCloakModel;
import net.roadkill.redev.client.model.armor.HoglinHideHeadModel;
import net.roadkill.redev.client.model.armor.HoglinHideHoovesModel;
import net.roadkill.redev.client.model.entity.HoveringInfernoModel;
import net.roadkill.redev.client.renderer.entity.*;
import net.roadkill.redev.core.init.EntityInit;
import net.roadkill.redev.core.init.ItemInit;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterEntityRenderers
{
    public static HoglinHideHeadModel<?> HOGLIN_HIDE_HEAD_MODEL = null;
    public static HoglinHideCloakModel<?> HOGLIN_HIDE_CLOAK_MODEL = null;
    public static HoglinHideHoovesModel<?> HOGLIN_HIDE_HOOVES_MODEL = null;
    public static final IClientItemExtensions CLIENT_ITEM_EXTENSIONS = new IClientItemExtensions()
    {
        @Override
        public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original)
        {
            checkForInitModels();
            if (layerType == EquipmentClientInfo.LayerType.HUMANOID)
            {
                Equippable equippable = itemStack.get(DataComponents.EQUIPPABLE);
                if (equippable == null)
                {   return IClientItemExtensions.super.getHumanoidArmorModel(itemStack, layerType, original);
                }
                return switch (equippable.slot())
                {
                    case HEAD -> HOGLIN_HIDE_HEAD_MODEL;
                    case CHEST -> HOGLIN_HIDE_CLOAK_MODEL;
                    case FEET -> HOGLIN_HIDE_HOOVES_MODEL;
                    default -> IClientItemExtensions.super.getHumanoidArmorModel(itemStack, layerType, original);
                };
            }
            return IClientItemExtensions.super.getHumanoidArmorModel(itemStack, layerType, original);
        }
    };

    public static void checkForInitModels()
    {
        if (HOGLIN_HIDE_HEAD_MODEL != null) return;

        EntityModelSet mcModels = Minecraft.getInstance().getEntityModels();

        HOGLIN_HIDE_HEAD_MODEL = new HoglinHideHeadModel<>(mcModels.bakeLayer(HoglinHideHeadModel.LAYER_LOCATION));
        HOGLIN_HIDE_CLOAK_MODEL = new HoglinHideCloakModel<>(mcModels.bakeLayer(HoglinHideCloakModel.LAYER_LOCATION));
        HOGLIN_HIDE_HOOVES_MODEL = new HoglinHideHoovesModel<>(mcModels.bakeLayer(HoglinHideHoovesModel.LAYER_LOCATION));
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event)
    {   event.registerEntityRenderer(EntityInit.LITHICAN.get(), LithicanRenderer::new);
        event.registerEntityRenderer(EntityInit.REVENANT.get(), RevenantRenderer::new);
        event.registerEntityRenderer(EntityInit.DURIAN_THORN.get(), DurianThornRenderer::new);
        event.registerEntityRenderer(EntityInit.DURIAN_THORN.get(), DurianThornRenderer::new);
        event.registerEntityRenderer(EntityInit.HOVERING_INFERNO.get(), HoveringInfernoRenderer::new);
        event.registerEntityRenderer(EntityInit.BOUNCING_ARROW.get(), BouncingArrowRenderer::new);
        event.registerEntityRenderer(EntityInit.EXPLOSIVE_ARROW.get(), ExplosiveArrowRenderer::new);
        event.registerEntityRenderer(EntityInit.AMETHYST_ARROW.get(), AmethystArrowRenderer::new);
        event.registerEntityRenderer(EntityInit.QUARTZ_ARROW.get(), QuartzArrowRenderer::new);
        event.registerEntityRenderer(EntityInit.OBSIDIAN_ARROW.get(), ObsidianArrowRenderer::new);

    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(HoveringInfernoModel.LAYER_LOCATION, HoveringInfernoModel::createBodyLayer);

        event.registerLayerDefinition(HoglinHideHeadModel.LAYER_LOCATION, HoglinHideHeadModel::createArmorLayer);
        event.registerLayerDefinition(HoglinHideCloakModel.LAYER_LOCATION, HoglinHideCloakModel::createArmorLayer);
        event.registerLayerDefinition(HoglinHideHoovesModel.LAYER_LOCATION, HoglinHideHoovesModel::createArmorLayer);
    }

    @SubscribeEvent
    public static void registerArmorModels(RegisterClientExtensionsEvent event)
    {
        event.registerItem(CLIENT_ITEM_EXTENSIONS, ItemInit.HOGLIN_HIDE_CAP, ItemInit.HOGLIN_HIDE_TUNIC, ItemInit.HOGLIN_HIDE_HOOVES);
    }
}
