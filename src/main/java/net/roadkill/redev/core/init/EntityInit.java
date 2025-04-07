package net.roadkill.redev.core.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.roadkill.redev.ReDev;
import net.roadkill.redev.common.entity.*;
// import net.roadkill.redev.common.entity.Illusion;

public class EntityInit
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, ReDev.MOD_ID);

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
// public static final DeferredHolder<EntityType<Illusion>, EntityType<Illusion>> ILLUSION = ENTITY_TYPES.register("illusion", () ->
//         EntityType.Builder.of(Illusion::new, MobCategory.CREATURE).sized(0.9f, 0.9f)
//                           .build(ResourceKey.create(Registries.ENTITY_TYPE, new ResourceLocation(ReDev.MOD_ID, "illusion"))));

}
