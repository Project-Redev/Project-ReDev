package net.roadkill.redev.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.roadkill.redev.ReDev;
import net.roadkill.redev.common.item.*;
import net.roadkill.redev.common.item.arrows.*;
import net.roadkill.redev.util.registries.ModArmorMaterials;
import net.roadkill.redev.util.registries.ModItems;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ItemInit
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReDev.MOD_ID);

    public static final DeferredHolder<Item, Item> HOGLIN_HIDE = ITEMS.registerItem("hoglin_hide", Item::new, new Item.Properties());
    public static final DeferredHolder<Item, ArmorItem> HOGLIN_HIDE_CAP = ITEMS.registerItem("hoglin_hide_head", props -> new HoglinArmorItem(ModArmorMaterials.HOGLIN_HIDE, ArmorType.HELMET, props));
    public static final DeferredHolder<Item, ArmorItem> HOGLIN_HIDE_TUNIC = ITEMS.registerItem("hoglin_hide_cloak", props -> new HoglinArmorItem(ModArmorMaterials.HOGLIN_HIDE, ArmorType.CHESTPLATE, props));
    public static final DeferredHolder<Item, ArmorItem> HOGLIN_HIDE_HOOVES = ITEMS.registerItem("hoglin_hide_hooves", props -> new ArmorItem(ModArmorMaterials.HOGLIN_HIDE, ArmorType.BOOTS, props));
    public static final DeferredHolder<Item, Item> BOUNCING_ARROW = ITEMS.registerItem("bouncing_arrow", props -> new BouncingArrowItem(props),  new Item.Properties().stacksTo(12));
    public static final DeferredHolder<Item, Item> EXPLOSIVE_ARROW = ITEMS.registerItem("explosive_arrow", props -> new ExplosiveArrowItem(props),  new Item.Properties().stacksTo(12));
    public static final DeferredHolder<Item, Item> QUARTZ_ARROW = ITEMS.registerItem("quartz_arrow", props -> new QuartzArrowItem(props),  new Item.Properties().stacksTo(12));
    public static final DeferredHolder<Item, Item> AMETHYST_ARROW = ITEMS.registerItem("amethyst_arrow", props -> new AmethystArrowItem(props),  new Item.Properties().stacksTo(12));
    public static final DeferredHolder<Item, Item> OBSIDIAN_ARROW = ITEMS.registerItem("obsidian_arrow", props -> new ObsidianArrowItem(props),  new Item.Properties().stacksTo(12));

    public static final DeferredHolder<Item, Item> WOOD_SCRAP = ITEMS.registerItem("wood_scrap", Item::new, new Item.Properties());

    public static final DeferredHolder<Item, Item> AURUM_NUGGET = ITEMS.registerSimpleItem("aurum_nugget", new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_INGOT = ITEMS.registerSimpleItem("aurum_ingot", new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_SWORD = ITEMS.registerItem("aurum_sword", props -> new SwordItem(ModItems.ToolMaterials.AURUM, 3f, 1.6f-4f, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_PICKAXE = ITEMS.registerItem("aurum_pickaxe", props -> new PickaxeItem(ModItems.ToolMaterials.AURUM, 1f, 1.2f-4f, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_AXE = ITEMS.registerItem("aurum_axe", props -> new AxeItem(ModItems.ToolMaterials.AURUM, 7f, 0.8f-4f, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_SHOVEL = ITEMS.registerItem("aurum_shovel", props -> new ShovelItem(ModItems.ToolMaterials.AURUM, 1.5f, 1f-4f, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_HOE = ITEMS.registerItem("aurum_hoe", props -> new HoeItem(ModItems.ToolMaterials.AURUM, -1f, 2f-4f, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_HELMET = ITEMS.registerItem("aurum_helmet", props -> new ArmorItem(ModArmorMaterials.AURUM, ArmorType.HELMET, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_CHESTPLATE = ITEMS.registerItem("aurum_chestplate", props -> new ArmorItem(ModArmorMaterials.AURUM, ArmorType.CHESTPLATE, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_LEGGINGS = ITEMS.registerItem("aurum_leggings", props -> new ArmorItem(ModArmorMaterials.AURUM, ArmorType.LEGGINGS, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> AURUM_BOOTS = ITEMS.registerItem("aurum_boots", props -> new ArmorItem(ModArmorMaterials.AURUM, ArmorType.BOOTS, props), new Item.Properties());

    public static final DeferredHolder<Item, Item> CHARRED_BONE = ITEMS.registerSimpleItem("charred_bone", new Item.Properties());

    public static final DeferredHolder<Item, Item> WITHERED_INGOT = ITEMS.registerSimpleItem("withered_ingot", new Item.Properties());
    public static final DeferredHolder<Item, Item> WITHERED_SWORD = ITEMS.registerItem("withered_sword", props -> new SwordItem(ModItems.ToolMaterials.WITHERED, 3f, 1.6f-4f, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> WITHERED_PICKAXE = ITEMS.registerItem("withered_pickaxe", props -> new PickaxeItem(ModItems.ToolMaterials.WITHERED, 1f, 1.2f-4f, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> WITHERED_AXE = ITEMS.registerItem("withered_axe", props -> new AxeItem(ModItems.ToolMaterials.WITHERED, 6f, 0.9f-4f, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> WITHERED_SHOVEL = ITEMS.registerItem("withered_shovel", props -> new ShovelItem(ModItems.ToolMaterials.WITHERED, 1.5f, 1f-4f, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> WITHERED_HOE = ITEMS.registerItem("withered_hoe", props -> new HoeItem(ModItems.ToolMaterials.WITHERED, 0f, 3f-4f, props),  new Item.Properties());
    public static final DeferredHolder<Item, Item> WITHERED_HELMET = ITEMS.registerItem("withered_helmet", props -> new ArmorItem(ModArmorMaterials.WITHERED, ArmorType.HELMET, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> WITHERED_CHESTPLATE = ITEMS.registerItem("withered_chestplate", props -> new ArmorItem(ModArmorMaterials.WITHERED, ArmorType.CHESTPLATE, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> WITHERED_LEGGINGS = ITEMS.registerItem("withered_leggings", props -> new ArmorItem(ModArmorMaterials.WITHERED, ArmorType.LEGGINGS, props), new Item.Properties());
    public static final DeferredHolder<Item, Item> WITHERED_BOOTS = ITEMS.registerItem("withered_boots", props -> new ArmorItem(ModArmorMaterials.WITHERED, ArmorType.BOOTS, props), new Item.Properties());

    public static final DeferredHolder<Item, Item> CARAMINE_RYE_SEEDS = ITEMS.registerItem("caramine_rye_seeds", props -> new ItemNameBlockItem(BlockInit.CARAMINE_RYE.get(), props), new Item.Properties());
    public static final DeferredHolder<Item, Item> CHURK = ITEMS.registerSimpleItem("churk", new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f).build(), Consumable.builder().consumeSeconds(0.8f).build()));
    public static final DeferredHolder<Item, Item> CARAMINE_RYE = ITEMS.registerSimpleItem("caramine_rye", new Item.Properties());
    public static final DeferredHolder<Item, Item> WARPED_DRUPEL = ITEMS.registerSimpleItem("warped_drupel", new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build(), Consumable.builder().consumeSeconds(0.8f).build()));

    public static final DeferredHolder<Item, Item> NETHERITE_HORSE_ARMOR = ITEMS.registerItem("netherite_horse_armor", props -> new AnimalArmorItem(ModArmorMaterials.HORSE_ARMOR_NETHERITE, AnimalArmorItem.BodyType.EQUESTRIAN, props), new Item.Properties().stacksTo(1).fireResistant());

    public static final DeferredHolder<Item, Item> LITHICAN_SPAWN_EGG = ITEMS.registerItem("lithican_spawn_egg", props -> new SpawnEggItem(EntityInit.LITHICAN.value(), props), new Item.Properties());
    public static final DeferredHolder<Item, Item> REVENANT_SPAWN_EGG = ITEMS.registerItem("revenant_spawn_egg", props -> new SpawnEggItem(EntityInit.REVENANT.value(), props), new Item.Properties());
    public static final DeferredHolder<Item, Item> HOVERING_INFERNO_SPAWN_EGG = ITEMS.registerItem("hovering_inferno_spawn_egg", props -> new SpawnEggItem(EntityInit.HOVERING_INFERNO.value(), props), new Item.Properties());

    public static final DeferredHolder<Item, Item> DURIAN_SLICE = ITEMS.registerSimpleItem("durian_slice", new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build()));

    public static final DeferredHolder<Item, Item> NETHERITE_SHIELD = ITEMS.registerItem("netherite_shield", ShieldItem::new, new Item.Properties().durability(1200).fireResistant());
    public static final DeferredHolder<Item, Item> INFERNAL_PLATE = ITEMS.registerItem("infernal_plate", ShieldItem::new, new Item.Properties().durability(600).fireResistant());

    /*
     Block Items
     */
    public static final DeferredHolder<Item, BlockItem> ACACIA_BOOKSHELF = ITEMS.registerSimpleBlockItem("acacia_bookshelf", BlockInit.ACACIA_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> BIRCH_BOOKSHELF = ITEMS.registerSimpleBlockItem("birch_bookshelf", BlockInit.BIRCH_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_BOOKSHELF = ITEMS.registerSimpleBlockItem("crimson_bookshelf", BlockInit.CRIMSON_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_BOOKSHELF = ITEMS.registerSimpleBlockItem("dark_oak_bookshelf", BlockInit.DARK_OAK_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_BOOKSHELF = ITEMS.registerSimpleBlockItem("jungle_bookshelf", BlockInit.JUNGLE_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_BOOKSHELF = ITEMS.registerSimpleBlockItem("mangrove_bookshelf", BlockInit.MANGROVE_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_BOOKSHELF = ITEMS.registerSimpleBlockItem("spruce_bookshelf", BlockInit.SPRUCE_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> WARPED_BOOKSHELF = ITEMS.registerSimpleBlockItem("warped_bookshelf", BlockInit.WARPED_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_BOOKSHELF = ITEMS.registerSimpleBlockItem("scrapwood_bookshelf", BlockInit.SCRAPWOOD_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_BOOKSHELF = ITEMS.registerSimpleBlockItem("whispur_bookshelf", BlockInit.WHISPUR_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_BOOKSHELF = ITEMS.registerSimpleBlockItem("petrified_bookshelf", BlockInit.PETRIFIED_BOOKSHELF);
    public static final DeferredHolder<Item, BlockItem> SHADE_BOOKSHELF = ITEMS.registerSimpleBlockItem("shade_bookshelf", BlockInit.SHADE_BOOKSHELF);

    public static final DeferredHolder<Item, BlockItem> ACACIA_LADDER = ITEMS.registerSimpleBlockItem("acacia_ladder", BlockInit.ACACIA_LADDER);
    public static final DeferredHolder<Item, BlockItem> BIRCH_LADDER = ITEMS.registerSimpleBlockItem("birch_ladder", BlockInit.BIRCH_LADDER);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_LADDER = ITEMS.registerSimpleBlockItem("crimson_ladder", BlockInit.CRIMSON_LADDER);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_LADDER = ITEMS.registerSimpleBlockItem("dark_oak_ladder", BlockInit.DARK_OAK_LADDER);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_LADDER = ITEMS.registerSimpleBlockItem("jungle_ladder", BlockInit.JUNGLE_LADDER);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_LADDER = ITEMS.registerSimpleBlockItem("mangrove_ladder", BlockInit.MANGROVE_LADDER);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_LADDER = ITEMS.registerSimpleBlockItem("spruce_ladder", BlockInit.SPRUCE_LADDER);
    public static final DeferredHolder<Item, BlockItem> WARPED_LADDER = ITEMS.registerSimpleBlockItem("warped_ladder", BlockInit.WARPED_LADDER);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_LADDER = ITEMS.registerSimpleBlockItem("scrapwood_ladder", BlockInit.SCRAPWOOD_LADDER);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_LADDER = ITEMS.registerSimpleBlockItem("whispur_ladder", BlockInit.WHISPUR_LADDER);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_LADDER = ITEMS.registerSimpleBlockItem("petrified_ladder", BlockInit.PETRIFIED_LADDER);
    public static final DeferredHolder<Item, BlockItem> SHADE_LADDER = ITEMS.registerSimpleBlockItem("shade_ladder", BlockInit.SHADE_LADDER);
    public static final DeferredHolder<Item, BlockItem> CHAIN_LADDER = ITEMS.registerItem("chain_ladder", properties -> new HangingLadderItem(BlockInit.CHAIN_LADDER.get(), properties.useBlockDescriptionPrefix()));
    public static final DeferredHolder<Item, BlockItem> BAMBOO_LADDER = ITEMS.registerItem("bamboo_ladder", properties -> new HangingLadderItem(BlockInit.BAMBOO_LADDER.get(), properties.useBlockDescriptionPrefix()));

    public static final DeferredHolder<Item, BlockItem> ACACIA_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("acacia_smithing_table", BlockInit.ACACIA_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("birch_smithing_table", BlockInit.BIRCH_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("crimson_smithing_table", BlockInit.CRIMSON_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("dark_oak_smithing_table", BlockInit.DARK_OAK_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("jungle_smithing_table", BlockInit.JUNGLE_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("mangrove_smithing_table", BlockInit.MANGROVE_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("spruce_smithing_table", BlockInit.SPRUCE_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> WARPED_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("warped_smithing_table", BlockInit.WARPED_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("scrapwood_smithing_table", BlockInit.SCRAPWOOD_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("whispur_smithing_table", BlockInit.WHISPUR_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("petrified_smithing_table", BlockInit.PETRIFIED_SMITHING_TABLE);
    public static final DeferredHolder<Item, BlockItem> SHADE_SMITHING_TABLE = ITEMS.registerSimpleBlockItem("shade_smithing_table", BlockInit.SHADE_SMITHING_TABLE);

    public static final DeferredHolder<Item, BlockItem> ACACIA_CAMPFIRE = ITEMS.registerSimpleBlockItem("acacia_campfire", BlockInit.ACACIA_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("acacia_soul_campfire", BlockInit.ACACIA_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_CAMPFIRE = ITEMS.registerSimpleBlockItem("birch_campfire", BlockInit.BIRCH_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("birch_soul_campfire", BlockInit.BIRCH_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_CAMPFIRE = ITEMS.registerSimpleBlockItem("crimson_campfire", BlockInit.CRIMSON_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("crimson_soul_campfire", BlockInit.CRIMSON_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_CAMPFIRE = ITEMS.registerSimpleBlockItem("dark_oak_campfire", BlockInit.DARK_OAK_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("dark_oak_soul_campfire", BlockInit.DARK_OAK_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_CAMPFIRE = ITEMS.registerSimpleBlockItem("jungle_campfire", BlockInit.JUNGLE_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("jungle_soul_campfire", BlockInit.JUNGLE_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_CAMPFIRE = ITEMS.registerSimpleBlockItem("mangrove_campfire", BlockInit.MANGROVE_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("mangrove_soul_campfire", BlockInit.MANGROVE_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_CAMPFIRE = ITEMS.registerSimpleBlockItem("spruce_campfire", BlockInit.SPRUCE_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("spruce_soul_campfire", BlockInit.SPRUCE_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> WARPED_CAMPFIRE = ITEMS.registerSimpleBlockItem("warped_campfire", BlockInit.WARPED_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> WARPED_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("warped_soul_campfire", BlockInit.WARPED_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_CAMPFIRE = ITEMS.registerSimpleBlockItem("scrapwood_campfire", BlockInit.SCRAPWOOD_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("scrapwood_soul_campfire", BlockInit.SCRAPWOOD_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> BONE_CAMPFIRE = ITEMS.registerSimpleBlockItem("bone_campfire", BlockInit.BONE_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> BONE_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("bone_soul_campfire", BlockInit.BONE_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_CAMPFIRE = ITEMS.registerSimpleBlockItem("petrified_campfire", BlockInit.PETRIFIED_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("petrified_soul_campfire", BlockInit.PETRIFIED_SOUL_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> SHADE_CAMPFIRE = ITEMS.registerSimpleBlockItem("shade_campfire", BlockInit.SHADE_CAMPFIRE);
    public static final DeferredHolder<Item, BlockItem> SHADE_SOUL_CAMPFIRE = ITEMS.registerSimpleBlockItem("shade_soul_campfire", BlockInit.SHADE_SOUL_CAMPFIRE);

    public static final DeferredHolder<Item, BlockItem> ACACIA_RAIL = ITEMS.registerSimpleBlockItem("acacia_rail", BlockInit.ACACIA_RAIL);
    public static final DeferredHolder<Item, BlockItem> BIRCH_RAIL = ITEMS.registerSimpleBlockItem("birch_rail", BlockInit.BIRCH_RAIL);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_RAIL = ITEMS.registerSimpleBlockItem("crimson_rail", BlockInit.CRIMSON_RAIL);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_RAIL = ITEMS.registerSimpleBlockItem("dark_oak_rail", BlockInit.DARK_OAK_RAIL);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_RAIL = ITEMS.registerSimpleBlockItem("jungle_rail", BlockInit.JUNGLE_RAIL);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_RAIL = ITEMS.registerSimpleBlockItem("mangrove_rail", BlockInit.MANGROVE_RAIL);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_RAIL = ITEMS.registerSimpleBlockItem("spruce_rail", BlockInit.SPRUCE_RAIL);
    public static final DeferredHolder<Item, BlockItem> WARPED_RAIL = ITEMS.registerSimpleBlockItem("warped_rail", BlockInit.WARPED_RAIL);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_RAIL = ITEMS.registerSimpleBlockItem("scrapwood_rail", BlockInit.SCRAPWOOD_RAIL);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_RAIL = ITEMS.registerSimpleBlockItem("whispur_rail", BlockInit.WHISPUR_RAIL);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_RAIL = ITEMS.registerSimpleBlockItem("petrified_rail", BlockInit.PETRIFIED_RAIL);
    public static final DeferredHolder<Item, BlockItem> SHADE_RAIL = ITEMS.registerSimpleBlockItem("shade_rail", BlockInit.SHADE_RAIL);

    public static final DeferredHolder<Item, BlockItem> ACACIA_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("acacia_detector_rail", BlockInit.ACACIA_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> BIRCH_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("birch_detector_rail", BlockInit.BIRCH_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("crimson_detector_rail", BlockInit.CRIMSON_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("dark_oak_detector_rail", BlockInit.DARK_OAK_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("jungle_detector_rail", BlockInit.JUNGLE_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("mangrove_detector_rail", BlockInit.MANGROVE_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("spruce_detector_rail", BlockInit.SPRUCE_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> WARPED_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("warped_detector_rail", BlockInit.WARPED_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("scrapwood_detector_rail", BlockInit.SCRAPWOOD_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("whispur_detector_rail", BlockInit.WHISPUR_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("petrified_detector_rail", BlockInit.PETRIFIED_DETECTOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> SHADE_DETECTOR_RAIL = ITEMS.registerSimpleBlockItem("shade_detector_rail", BlockInit.SHADE_DETECTOR_RAIL);

    public static final DeferredHolder<Item, BlockItem> ACACIA_POWERED_RAIL = ITEMS.registerSimpleBlockItem("acacia_powered_rail", BlockInit.ACACIA_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> BIRCH_POWERED_RAIL = ITEMS.registerSimpleBlockItem("birch_powered_rail", BlockInit.BIRCH_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_POWERED_RAIL = ITEMS.registerSimpleBlockItem("crimson_powered_rail", BlockInit.CRIMSON_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_POWERED_RAIL = ITEMS.registerSimpleBlockItem("dark_oak_powered_rail", BlockInit.DARK_OAK_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_POWERED_RAIL = ITEMS.registerSimpleBlockItem("jungle_powered_rail", BlockInit.JUNGLE_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_POWERED_RAIL = ITEMS.registerSimpleBlockItem("mangrove_powered_rail", BlockInit.MANGROVE_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_POWERED_RAIL = ITEMS.registerSimpleBlockItem("spruce_powered_rail", BlockInit.SPRUCE_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> WARPED_POWERED_RAIL = ITEMS.registerSimpleBlockItem("warped_powered_rail", BlockInit.WARPED_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_POWERED_RAIL = ITEMS.registerSimpleBlockItem("scrapwood_powered_rail", BlockInit.SCRAPWOOD_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_POWERED_RAIL = ITEMS.registerSimpleBlockItem("whispur_powered_rail", BlockInit.WHISPUR_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_POWERED_RAIL = ITEMS.registerSimpleBlockItem("petrified_powered_rail", BlockInit.PETRIFIED_POWERED_RAIL);
    public static final DeferredHolder<Item, BlockItem> SHADE_POWERED_RAIL = ITEMS.registerSimpleBlockItem("shade_powered_rail", BlockInit.SHADE_POWERED_RAIL);

    public static final DeferredHolder<Item, BlockItem> ACACIA_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("acacia_activator_rail", BlockInit.ACACIA_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> BIRCH_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("birch_activator_rail", BlockInit.BIRCH_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("crimson_activator_rail", BlockInit.CRIMSON_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("dark_oak_activator_rail", BlockInit.DARK_OAK_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("jungle_activator_rail", BlockInit.JUNGLE_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("mangrove_activator_rail", BlockInit.MANGROVE_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("spruce_activator_rail", BlockInit.SPRUCE_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> WARPED_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("warped_activator_rail", BlockInit.WARPED_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("scrapwood_activator_rail", BlockInit.SCRAPWOOD_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("whispur_activator_rail", BlockInit.WHISPUR_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("petrified_activator_rail", BlockInit.PETRIFIED_ACTIVATOR_RAIL);
    public static final DeferredHolder<Item, BlockItem> SHADE_ACTIVATOR_RAIL = ITEMS.registerSimpleBlockItem("shade_activator_rail", BlockInit.SHADE_ACTIVATOR_RAIL);

    public static final DeferredHolder<Item, BlockItem> ACACIA_HEDGE = ITEMS.registerSimpleBlockItem("acacia_hedge", BlockInit.ACACIA_HEDGE);
    public static final DeferredHolder<Item, BlockItem> AZALEA_HEDGE = ITEMS.registerSimpleBlockItem("azalea_hedge", BlockInit.AZALEA_HEDGE);
    public static final DeferredHolder<Item, BlockItem> FLOWERING_AZALEA_HEDGE = ITEMS.registerSimpleBlockItem("flowering_azalea_hedge", BlockInit.FLOWERING_AZALEA_HEDGE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_HEDGE = ITEMS.registerSimpleBlockItem("birch_hedge", BlockInit.BIRCH_HEDGE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_HEDGE = ITEMS.registerSimpleBlockItem("dark_oak_hedge", BlockInit.DARK_OAK_HEDGE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_HEDGE = ITEMS.registerSimpleBlockItem("jungle_hedge", BlockInit.JUNGLE_HEDGE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_HEDGE = ITEMS.registerSimpleBlockItem("mangrove_hedge", BlockInit.MANGROVE_HEDGE);
    public static final DeferredHolder<Item, BlockItem> OAK_HEDGE = ITEMS.registerSimpleBlockItem("oak_hedge", BlockInit.OAK_HEDGE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_HEDGE = ITEMS.registerSimpleBlockItem("spruce_hedge", BlockInit.SPRUCE_HEDGE);

    public static final DeferredHolder<Item, BlockItem> ACACIA_HEDGE_WALL = ITEMS.registerSimpleBlockItem("acacia_hedge_wall", BlockInit.ACACIA_HEDGE_WALL);
    public static final DeferredHolder<Item, BlockItem> AZALEA_HEDGE_WALL = ITEMS.registerSimpleBlockItem("azalea_hedge_wall", BlockInit.AZALEA_HEDGE_WALL);
    public static final DeferredHolder<Item, BlockItem> FLOWERING_AZALEA_HEDGE_WALL = ITEMS.registerSimpleBlockItem("flowering_azalea_hedge_wall", BlockInit.FLOWERING_AZALEA_HEDGE_WALL);
    public static final DeferredHolder<Item, BlockItem> BIRCH_HEDGE_WALL = ITEMS.registerSimpleBlockItem("birch_hedge_wall", BlockInit.BIRCH_HEDGE_WALL);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_HEDGE_WALL = ITEMS.registerSimpleBlockItem("dark_oak_hedge_wall", BlockInit.DARK_OAK_HEDGE_WALL);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_HEDGE_WALL = ITEMS.registerSimpleBlockItem("jungle_hedge_wall", BlockInit.JUNGLE_HEDGE_WALL);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_HEDGE_WALL = ITEMS.registerSimpleBlockItem("mangrove_hedge_wall", BlockInit.MANGROVE_HEDGE_WALL);
    public static final DeferredHolder<Item, BlockItem> OAK_HEDGE_WALL = ITEMS.registerSimpleBlockItem("oak_hedge_wall", BlockInit.OAK_HEDGE_WALL);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_HEDGE_WALL = ITEMS.registerSimpleBlockItem("spruce_hedge_wall", BlockInit.SPRUCE_HEDGE_WALL);

    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_FURNACE = ITEMS.registerSimpleBlockItem("blackstone_furnace", BlockInit.BLACKSTONE_FURNACE);
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_FURNACE = ITEMS.registerSimpleBlockItem("deepslate_furnace", BlockInit.DEEPSLATE_FURNACE);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_FURNACE = ITEMS.registerSimpleBlockItem("andesite_furnace", BlockInit.ANDESITE_FURNACE);
    public static final DeferredHolder<Item, BlockItem> DIORITE_FURNACE = ITEMS.registerSimpleBlockItem("diorite_furnace", BlockInit.DIORITE_FURNACE);
    public static final DeferredHolder<Item, BlockItem> GRANITE_FURNACE = ITEMS.registerSimpleBlockItem("granite_furnace", BlockInit.GRANITE_FURNACE);

    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_DISPENSER = ITEMS.registerSimpleBlockItem("blackstone_dispenser", BlockInit.BLACKSTONE_DISPENSER);
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_DISPENSER = ITEMS.registerSimpleBlockItem("deepslate_dispenser", BlockInit.DEEPSLATE_DISPENSER);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_DISPENSER = ITEMS.registerSimpleBlockItem("andesite_dispenser", BlockInit.ANDESITE_DISPENSER);
    public static final DeferredHolder<Item, BlockItem> DIORITE_DISPENSER = ITEMS.registerSimpleBlockItem("diorite_dispenser", BlockInit.DIORITE_DISPENSER);
    public static final DeferredHolder<Item, BlockItem> GRANITE_DISPENSER = ITEMS.registerSimpleBlockItem("granite_dispenser", BlockInit.GRANITE_DISPENSER);

    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_DROPPER = ITEMS.registerSimpleBlockItem("blackstone_dropper", BlockInit.BLACKSTONE_DROPPER);
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_DROPPER = ITEMS.registerSimpleBlockItem("deepslate_dropper", BlockInit.DEEPSLATE_DROPPER);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_DROPPER = ITEMS.registerSimpleBlockItem("andesite_dropper", BlockInit.ANDESITE_DROPPER);
    public static final DeferredHolder<Item, BlockItem> DIORITE_DROPPER = ITEMS.registerSimpleBlockItem("diorite_dropper", BlockInit.DIORITE_DROPPER);
    public static final DeferredHolder<Item, BlockItem> GRANITE_DROPPER = ITEMS.registerSimpleBlockItem("granite_dropper", BlockInit.GRANITE_DROPPER);

    public static final DeferredHolder<Item, BlockItem> AURUM_BLOCK = ITEMS.registerSimpleBlockItem("aurum_block", BlockInit.AURUM_BLOCK);
    public static final DeferredHolder<Item, BlockItem> AURUM_ORE = ITEMS.registerSimpleBlockItem("aurum_ore", BlockInit.AURUM_ORE);
    public static final DeferredHolder<Item, BlockItem> NETHER_DIAMOND_ORE = ITEMS.registerSimpleBlockItem("nether_diamond_ore", BlockInit.NETHER_DIAMOND_ORE);
    public static final DeferredHolder<Item, BlockItem> BASALT_DIAMOND_ORE = ITEMS.registerSimpleBlockItem("basalt_diamond_ore", BlockInit.BASALT_DIAMOND_ORE);

    public static final DeferredHolder<Item, BlockItem> WITHERED_BLOCK = ITEMS.registerSimpleBlockItem("withered_block", BlockInit.WITHERED_BLOCK);

    public static final DeferredHolder<Item, BlockItem> NETHER_BRISTLE = ITEMS.registerSimpleBlockItem("nether_bristle", BlockInit.NETHER_BRISTLE);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_ROOT = ITEMS.registerSimpleBlockItem("whispur_root", BlockInit.WHISPUR_ROOT);

    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_PLANKS = ITEMS.registerSimpleBlockItem("scrapwood_planks", BlockInit.SCRAPWOOD_PLANKS);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_HEAP = ITEMS.registerSimpleBlockItem("scrapwood_heap", BlockInit.SCRAPWOOD_HEAP);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_SLAB = ITEMS.registerSimpleBlockItem("scrapwood_slab", BlockInit.SCRAPWOOD_SLAB);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_STAIRS = ITEMS.registerSimpleBlockItem("scrapwood_stairs", BlockInit.SCRAPWOOD_STAIRS);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_FENCE = ITEMS.registerSimpleBlockItem("scrapwood_fence", BlockInit.SCRAPWOOD_FENCE);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_FENCE_GATE = ITEMS.registerSimpleBlockItem("scrapwood_fence_gate", BlockInit.SCRAPWOOD_FENCE_GATE);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_BUTTON = ITEMS.registerSimpleBlockItem("scrapwood_button", BlockInit.SCRAPWOOD_BUTTON);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_PRESSURE_PLATE = ITEMS.registerSimpleBlockItem("scrapwood_pressure_plate", BlockInit.SCRAPWOOD_PRESSURE_PLATE);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_DOOR = ITEMS.registerSimpleBlockItem("scrapwood_door", BlockInit.SCRAPWOOD_DOOR);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_TRAPDOOR = ITEMS.registerSimpleBlockItem("scrapwood_trapdoor", BlockInit.SCRAPWOOD_TRAPDOOR);
    public static final DeferredHolder<Item, BlockItem> SCRAPWOOD_SIGN = ITEMS.registerItem("scrapwood_sign", props -> new SignItem(BlockInit.SCRAPWOOD_SIGN.get(), BlockInit.SCRAPWOOD_WALL_SIGN.get(), props), new Item.Properties().stacksTo(16));

    public static final DeferredHolder<Item, BlockItem> WHISPUR_PLANKS = ITEMS.registerSimpleBlockItem("whispur_planks", BlockInit.WHISPUR_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_SLAB = ITEMS.registerSimpleBlockItem("whispur_slab", BlockInit.WHISPUR_SLAB);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_STAIRS = ITEMS.registerSimpleBlockItem("whispur_stairs", BlockInit.WHISPUR_STAIRS);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_FENCE = ITEMS.registerSimpleBlockItem("whispur_fence", BlockInit.WHISPUR_FENCE);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_FENCE_GATE = ITEMS.registerSimpleBlockItem("whispur_fence_gate", BlockInit.WHISPUR_FENCE_GATE);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_BUTTON = ITEMS.registerSimpleBlockItem("whispur_button", BlockInit.WHISPUR_BUTTON);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_PRESSURE_PLATE = ITEMS.registerSimpleBlockItem("whispur_pressure_plate", BlockInit.WHISPUR_PRESSURE_PLATE);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_DOOR = ITEMS.registerSimpleBlockItem("whispur_door", BlockInit.WHISPUR_DOOR);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_TRAPDOOR = ITEMS.registerSimpleBlockItem("whispur_trapdoor", BlockInit.WHISPUR_TRAPDOOR);
    public static final DeferredHolder<Item, BlockItem> WHISPUR_SIGN = ITEMS.registerItem("whispur_sign", props -> new SignItem(BlockInit.WHISPUR_SIGN.get(), BlockInit.WHISPUR_WALL_SIGN.get(), props), new Item.Properties().stacksTo(16));

    public static final DeferredHolder<Item, BlockItem> PETRIFIED_LOG = ITEMS.registerSimpleBlockItem("petrified_log", BlockInit.PETRIFIED_LOG);
    public static final DeferredHolder<Item, BlockItem> STRIPPED_PETRIFIED_LOG = ITEMS.registerSimpleBlockItem("stripped_petrified_log", BlockInit.STRIPPED_PETRIFIED_LOG);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_WOOD = ITEMS.registerSimpleBlockItem("petrified_wood", BlockInit.PETRIFIED_WOOD);
    public static final DeferredHolder<Item, BlockItem> STRIPPED_PETRIFIED_WOOD = ITEMS.registerSimpleBlockItem("stripped_petrified_wood", BlockInit.STRIPPED_PETRIFIED_WOOD);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_PLANKS = ITEMS.registerSimpleBlockItem("petrified_planks", BlockInit.PETRIFIED_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_SLAB = ITEMS.registerSimpleBlockItem("petrified_slab", BlockInit.PETRIFIED_SLAB);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_STAIRS = ITEMS.registerSimpleBlockItem("petrified_stairs", BlockInit.PETRIFIED_STAIRS);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_FENCE = ITEMS.registerSimpleBlockItem("petrified_fence", BlockInit.PETRIFIED_FENCE);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_FENCE_GATE = ITEMS.registerSimpleBlockItem("petrified_fence_gate", BlockInit.PETRIFIED_FENCE_GATE);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_BUTTON = ITEMS.registerSimpleBlockItem("petrified_button", BlockInit.PETRIFIED_BUTTON);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_PRESSURE_PLATE = ITEMS.registerSimpleBlockItem("petrified_pressure_plate", BlockInit.PETRIFIED_PRESSURE_PLATE);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_DOOR = ITEMS.registerSimpleBlockItem("petrified_door", BlockInit.PETRIFIED_DOOR);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_TRAPDOOR = ITEMS.registerSimpleBlockItem("petrified_trapdoor", BlockInit.PETRIFIED_TRAPDOOR);
    public static final DeferredHolder<Item, BlockItem> PETRIFIED_SIGN = ITEMS.registerItem("petrified_sign", props -> new SignItem(BlockInit.PETRIFIED_SIGN.get(), BlockInit.PETRIFIED_WALL_SIGN.get(), props), new Item.Properties().stacksTo(16));

    public static final DeferredHolder<Item, BlockItem> SHADE_LOG = ITEMS.registerSimpleBlockItem("shade_log", BlockInit.SHADE_LOG);
    public static final DeferredHolder<Item, BlockItem> STRIPPED_SHADE_LOG = ITEMS.registerSimpleBlockItem("stripped_shade_log", BlockInit.STRIPPED_SHADE_LOG);
    public static final DeferredHolder<Item, BlockItem> SHADE_WOOD = ITEMS.registerSimpleBlockItem("shade_wood", BlockInit.SHADE_WOOD);
    public static final DeferredHolder<Item, BlockItem> STRIPPED_SHADE_WOOD = ITEMS.registerSimpleBlockItem("stripped_shade_wood", BlockInit.STRIPPED_SHADE_WOOD);
    public static final DeferredHolder<Item, BlockItem> SHADE_PLANKS = ITEMS.registerSimpleBlockItem("shade_planks", BlockInit.SHADE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> SHADE_SLAB = ITEMS.registerSimpleBlockItem("shade_slab", BlockInit.SHADE_SLAB);
    public static final DeferredHolder<Item, BlockItem> SHADE_STAIRS = ITEMS.registerSimpleBlockItem("shade_stairs", BlockInit.SHADE_STAIRS);
    public static final DeferredHolder<Item, BlockItem> SHADE_FENCE = ITEMS.registerSimpleBlockItem("shade_fence", BlockInit.SHADE_FENCE);
    public static final DeferredHolder<Item, BlockItem> SHADE_FENCE_GATE = ITEMS.registerSimpleBlockItem("shade_fence_gate", BlockInit.SHADE_FENCE_GATE);
    public static final DeferredHolder<Item, BlockItem> SHADE_BUTTON = ITEMS.registerSimpleBlockItem("shade_button", BlockInit.SHADE_BUTTON);
    public static final DeferredHolder<Item, BlockItem> SHADE_PRESSURE_PLATE = ITEMS.registerSimpleBlockItem("shade_pressure_plate", BlockInit.SHADE_PRESSURE_PLATE);
    public static final DeferredHolder<Item, BlockItem> SHADE_DOOR = ITEMS.registerSimpleBlockItem("shade_door", BlockInit.SHADE_DOOR);
    public static final DeferredHolder<Item, BlockItem> SHADE_TRAPDOOR = ITEMS.registerSimpleBlockItem("shade_trapdoor", BlockInit.SHADE_TRAPDOOR);
    public static final DeferredHolder<Item, BlockItem> SHADE_SIGN = ITEMS.registerItem("shade_sign", props -> new SignItem(BlockInit.SHADE_SIGN.get(), BlockInit.SHADE_WALL_SIGN.get(), props), new Item.Properties().stacksTo(16));

    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN = registerBlockItem("carved_pumpkin", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 0, false));
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_CREEPY = registerBlockItem("carved_pumpkin_creepy", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 1, false));
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_HORRIFIED = registerBlockItem("carved_pumpkin_horrified", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 2, false));
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_CREEPER = registerBlockItem("carved_pumpkin_creeper", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 3, false));
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_SCOWLING = registerBlockItem("carved_pumpkin_scowling", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 4, false));
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_TWISTED = registerBlockItem("carved_pumpkin_twisted", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 5, false));
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_FURIOUS = registerBlockItem("carved_pumpkin_furious", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 6, false));
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_ZOMBIE = registerBlockItem("carved_pumpkin_zombie", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 7, false));
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_LIT = registerBlockItem("carved_pumpkin_lit", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 1, true), new Item.Properties());
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_CREEPY_LIT = registerBlockItem("carved_pumpkin_creepy_lit", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 1, true), new Item.Properties());
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_HORRIFIED_LIT = registerBlockItem("carved_pumpkin_horrified_lit", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 2, true), new Item.Properties());
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_CREEPER_LIT = registerBlockItem("carved_pumpkin_creeper_lit", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 3, true), new Item.Properties());
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_SCOWLING_LIT = registerBlockItem("carved_pumpkin_scowling_lit", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 4, true), new Item.Properties());
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_TWISTED_LIT = registerBlockItem("carved_pumpkin_twisted_lit", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 5, true), new Item.Properties());
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_FURIOUS_LIT = registerBlockItem("carved_pumpkin_furious_lit", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 6, true), new Item.Properties());
    public static final DeferredHolder<Item, BlockItem> CARVED_PUMPKIN_ZOMBIE_LIT = registerBlockItem("carved_pumpkin_zombie_lit", BlockInit.CARVED_PUMPKIN, (block, props) -> new CarvedPumpkinItem(block, props, 7, true), new Item.Properties());

    public static final DeferredHolder<Item, BlockItem> SHADE_LEAVES = ITEMS.registerSimpleBlockItem("shade_leaves", BlockInit.SHADE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> TEAL_SHADE_LEAVES = ITEMS.registerSimpleBlockItem("teal_shade_leaves", BlockInit.TEAL_SHADE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> RED_SHADE_LEAVES = ITEMS.registerSimpleBlockItem("red_shade_leaves", BlockInit.RED_SHADE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> PURPLE_SHADE_LEAVES = ITEMS.registerSimpleBlockItem("purple_shade_leaves", BlockInit.PURPLE_SHADE_LEAVES);

    public static final DeferredHolder<Item, BlockItem> SHADE_SAPLING = ITEMS.registerSimpleBlockItem("shade_sapling", BlockInit.SHADE_SAPLING);
    public static final DeferredHolder<Item, BlockItem> TEAL_SHADE_SAPLING = ITEMS.registerSimpleBlockItem("teal_shade_sapling", BlockInit.TEAL_SHADE_SAPLING);
    public static final DeferredHolder<Item, BlockItem> RED_SHADE_SAPLING = ITEMS.registerSimpleBlockItem("red_shade_sapling", BlockInit.RED_SHADE_SAPLING);
    public static final DeferredHolder<Item, BlockItem> PURPLE_SHADE_SAPLING = ITEMS.registerSimpleBlockItem("purple_shade_sapling", BlockInit.PURPLE_SHADE_SAPLING);

    public static final DeferredHolder<Item, BlockItem> DURIAN = ITEMS.registerSimpleBlockItem("durian", BlockInit.DURIAN);

    public static final DeferredHolder<Item, BlockItem> HADALITE = ITEMS.registerSimpleBlockItem("hadalite", BlockInit.HADALITE);

    public static final DeferredHolder<Item, BlockItem> PATINA_GOLD_BLOCK = ITEMS.registerSimpleBlockItem("patina_gold_block", BlockInit.PATINA_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> PATINA_AURUM_BLOCK = ITEMS.registerSimpleBlockItem("patina_aurum_block", BlockInit.PATINA_AURUM_BLOCK);

    public static final DeferredHolder<Item, BlockItem> BASALT_SLAB = ITEMS.registerSimpleBlockItem("basalt_slab", BlockInit.BASALT_SLAB);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BASALT_SLAB = ITEMS.registerSimpleBlockItem("smooth_basalt_slab", BlockInit.SMOOTH_BASALT_SLAB);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BASALT_SLAB = ITEMS.registerSimpleBlockItem("polished_basalt_slab", BlockInit.POLISHED_BASALT_SLAB);

    public static final DeferredHolder<Item, BlockItem> BASALT_STAIRS = ITEMS.registerSimpleBlockItem("basalt_stairs", BlockInit.BASALT_STAIRS);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BASALT_STAIRS = ITEMS.registerSimpleBlockItem("smooth_basalt_stairs", BlockInit.SMOOTH_BASALT_STAIRS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BASALT_STAIRS = ITEMS.registerSimpleBlockItem("polished_basalt_stairs", BlockInit.POLISHED_BASALT_STAIRS);

    public static final DeferredHolder<Item, BlockItem> BASALT_WALL = ITEMS.registerSimpleBlockItem("basalt_wall", BlockInit.BASALT_WALL);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BASALT_WALL = ITEMS.registerSimpleBlockItem("smooth_basalt_wall", BlockInit.SMOOTH_BASALT_WALL);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BASALT_WALL = ITEMS.registerSimpleBlockItem("polished_basalt_wall", BlockInit.POLISHED_BASALT_WALL);

    private static <T extends BlockItem> DeferredHolder<Item, T> registerBlockItem(String name, Supplier<? extends Block> block, BiFunction<Block, Item.Properties, T> item, Item.Properties properties)
    {   return ITEMS.register(name, key -> item.apply(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, key)).useBlockDescriptionPrefix()));
    }

    private static <T extends BlockItem> DeferredHolder<Item, T> registerBlockItem(String name, Supplier<? extends Block> block, BiFunction<Block, Item.Properties, T> item)
    {   return ITEMS.registerItem(name, properties -> item.apply(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, name))).useBlockDescriptionPrefix()));
    }
}
