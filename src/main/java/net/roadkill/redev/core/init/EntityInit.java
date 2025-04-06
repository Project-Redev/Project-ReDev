package net.roadkill.redev.core.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.roadkill.redev.ReDev;
import net.roadkill.redev.common.entity.*;
import net.roadkill.redev.common.entity.arrows.*;

public class EntityInit
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, ReDev.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<BouncingArrowEntity>> BOUNCING_ARROW = ENTITY_TYPES.register("bouncing_arrow", () ->
            EntityType.Builder.of(BouncingArrowEntity::new, MobCategory.MISC).sized(0.5f, 0.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "bouncing_arrow"))));
    public static final DeferredHolder<EntityType<?>, EntityType<ExplosiveArrowEntity>> EXPLOSIVE_ARROW = ENTITY_TYPES.register("explosive_arrow", () ->
            EntityType.Builder.of(ExplosiveArrowEntity::new, MobCategory.MISC).sized(0.5f, 0.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "explosive_arrow"))));

    public static final DeferredHolder<EntityType<?>, EntityType<QuartzArrowEntity>> QUARTZ_ARROW = ENTITY_TYPES.register("quartz_arrow", () ->
            EntityType.Builder.of(QuartzArrowEntity::new, MobCategory.MISC).sized(0.5f, 0.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "quartz_arrow"))));
    public static final DeferredHolder<EntityType<?>, EntityType<AmethystArrowEntity>> AMETHYST_ARROW = ENTITY_TYPES.register("amethyst_arrow", () ->
            EntityType.Builder.of(AmethystArrowEntity::new, MobCategory.MISC).sized(0.5f, 0.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "amethyst_arrow"))));
    public static final DeferredHolder<EntityType<?>, EntityType<ObsidianArrowEntity>> OBSIDIAN_ARROW = ENTITY_TYPES.register("obsidian_arrow", () ->
            EntityType.Builder.of(ObsidianArrowEntity::new, MobCategory.MISC).sized(0.5f, 0.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "obsidian_arrow"))));


    public static final DeferredHolder<EntityType<?>, EntityType<HomingArrowEntity>> HOMING_ARROW = ENTITY_TYPES.register("homing_arrow", () ->
            EntityType.Builder.of(HomingArrowEntity::new, MobCategory.MISC).sized(0.5f, 0.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "homing_arrow"))));


    public static final DeferredHolder<EntityType<?>, EntityType<DripstoneArrowEntity>> DRIPSTONE_ARROW = ENTITY_TYPES.register("dripstone_arrow", () ->
            EntityType.Builder.of(DripstoneArrowEntity::new, MobCategory.MISC).sized(0.5f, 0.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "dripstone_arrow"))));
    public static final DeferredHolder<EntityType<?>, EntityType<InkArrowEntity>> INK_ARROW = ENTITY_TYPES.register("ink_arrow", () ->
            EntityType.Builder.of(InkArrowEntity::new, MobCategory.MISC).sized(0.5f, 0.5f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "ink_arrow"))));

    public static final DeferredHolder<EntityType<?>, EntityType<LithicanEntity>> LITHICAN = ENTITY_TYPES.register("lithican", () ->
            EntityType.Builder.of(LithicanEntity::new, MobCategory.MONSTER).sized(0.6f, 1.95f)
                              .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "lithican"))));

    public static final DeferredHolder<EntityType<?>, EntityType<RevenantEntity>> REVENANT = ENTITY_TYPES.register("revenant", () ->
            EntityType.Builder.of(RevenantEntity::new, MobCategory.MONSTER).sized(0.6f, 1.95f)
                              .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "revenant"))));

    public static final DeferredHolder<EntityType<?>, EntityType<DurianThornEntity>> DURIAN_THORN = ENTITY_TYPES.register("durian_thorn", () ->
            EntityType.Builder.of(DurianThornEntity::new, MobCategory.MISC).sized(0.5f, 0.5f)
                              .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "durian_thorn"))));

    public static final DeferredHolder<EntityType<?>, EntityType<HoveringInfernoEntity>> HOVERING_INFERNO = ENTITY_TYPES.register("hovering_inferno", () ->
            EntityType.Builder.of(HoveringInfernoEntity::new, MobCategory.MONSTER).sized(1.5f, 2.5f)
                              .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "hovering_inferno"))));
}
