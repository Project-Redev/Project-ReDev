package net.roadkill.redev.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.roadkill.redev.ReDev;
import java.util.*;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CreativeTabInit
{
    public static final DeferredRegister<CreativeModeTab> ITEM_GROUPS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ReDev.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WOODEN_ITEMS = ITEM_GROUPS.register("wooden_items", () -> CreativeModeTab.builder()
                .title(Component.translatable("item_group." + ReDev.MOD_ID + ".wooden_items"))
                .icon(ItemInit.SPRUCE_BOOKSHELF.value()::getDefaultInstance)
                .displayItems((params, list) ->
                {
                     list.acceptAll(List.of(
                     ItemInit.ACACIA_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.BIRCH_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.CRIMSON_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.DARK_OAK_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.JUNGLE_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.MANGROVE_BOOKSHELF.value().getDefaultInstance(),
                     Items.BOOKSHELF.getDefaultInstance(),
                     ItemInit.PETRIFIED_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.SCRAPWOOD_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.SPRUCE_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.WARPED_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.WHISPUR_BOOKSHELF.value().getDefaultInstance(),
                     ItemInit.SHADE_BOOKSHELF.value().getDefaultInstance(),

                     ItemInit.ACACIA_LADDER.value().getDefaultInstance(),
                     ItemInit.BIRCH_LADDER.value().getDefaultInstance(),
                     ItemInit.CRIMSON_LADDER.value().getDefaultInstance(),
                     ItemInit.DARK_OAK_LADDER.value().getDefaultInstance(),
                     ItemInit.JUNGLE_LADDER.value().getDefaultInstance(),
                     ItemInit.MANGROVE_LADDER.value().getDefaultInstance(),
                     Items.LADDER.getDefaultInstance(),
                     ItemInit.SPRUCE_LADDER.value().getDefaultInstance(),
                     ItemInit.WARPED_LADDER.value().getDefaultInstance(),
                     ItemInit.SCRAPWOOD_LADDER.value().getDefaultInstance(),
                     ItemInit.WHISPUR_LADDER.value().getDefaultInstance(),
                     ItemInit.PETRIFIED_LADDER.value().getDefaultInstance(),
                     ItemInit.SHADE_LADDER.value().getDefaultInstance(),

                     ItemInit.ACACIA_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.BIRCH_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.CRIMSON_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.DARK_OAK_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.JUNGLE_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.MANGROVE_CAMPFIRE.value().getDefaultInstance(),
                     Items.CAMPFIRE.getDefaultInstance(),
                     ItemInit.SPRUCE_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.WARPED_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.SCRAPWOOD_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.BONE_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.PETRIFIED_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.SHADE_CAMPFIRE.value().getDefaultInstance(),

                     ItemInit.ACACIA_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.BIRCH_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.CRIMSON_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.DARK_OAK_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.JUNGLE_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.MANGROVE_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     Items.SOUL_CAMPFIRE.getDefaultInstance(),
                     ItemInit.SPRUCE_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.WARPED_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.SCRAPWOOD_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.BONE_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.PETRIFIED_SOUL_CAMPFIRE.value().getDefaultInstance(),
                     ItemInit.SHADE_SOUL_CAMPFIRE.value().getDefaultInstance(),

                     ItemInit.ACACIA_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.BIRCH_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.CRIMSON_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.DARK_OAK_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.JUNGLE_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.MANGROVE_SMITHING_TABLE.value().getDefaultInstance(),
                     Items.SMITHING_TABLE.getDefaultInstance(),
                     ItemInit.SPRUCE_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.WARPED_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.SCRAPWOOD_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.WHISPUR_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.PETRIFIED_SMITHING_TABLE.value().getDefaultInstance(),
                     ItemInit.SHADE_SMITHING_TABLE.value().getDefaultInstance(),

                     ItemInit.ACACIA_RAIL.value().getDefaultInstance(),
                     ItemInit.BIRCH_RAIL.value().getDefaultInstance(),
                     ItemInit.CRIMSON_RAIL.value().getDefaultInstance(),
                     ItemInit.DARK_OAK_RAIL.value().getDefaultInstance(),
                     ItemInit.JUNGLE_RAIL.value().getDefaultInstance(),
                     ItemInit.MANGROVE_RAIL.value().getDefaultInstance(),
                     Items.RAIL.getDefaultInstance(),
                     ItemInit.SPRUCE_RAIL.value().getDefaultInstance(),
                     ItemInit.WARPED_RAIL.value().getDefaultInstance(),
                     ItemInit.SCRAPWOOD_RAIL.value().getDefaultInstance(),
                     ItemInit.WHISPUR_RAIL.value().getDefaultInstance(),
                     ItemInit.PETRIFIED_RAIL.value().getDefaultInstance(),
                     ItemInit.SHADE_RAIL.value().getDefaultInstance(),

                     ItemInit.ACACIA_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.BIRCH_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.CRIMSON_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.DARK_OAK_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.JUNGLE_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.MANGROVE_DETECTOR_RAIL.value().getDefaultInstance(),
                     Items.DETECTOR_RAIL.getDefaultInstance(),
                     ItemInit.SPRUCE_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.WARPED_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.SCRAPWOOD_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.WHISPUR_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.PETRIFIED_DETECTOR_RAIL.value().getDefaultInstance(),
                     ItemInit.SHADE_DETECTOR_RAIL.value().getDefaultInstance(),

                     ItemInit.ACACIA_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.BIRCH_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.CRIMSON_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.DARK_OAK_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.JUNGLE_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.MANGROVE_POWERED_RAIL.value().getDefaultInstance(),
                     Items.POWERED_RAIL.getDefaultInstance(),
                     ItemInit.SPRUCE_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.WARPED_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.SCRAPWOOD_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.WHISPUR_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.PETRIFIED_POWERED_RAIL.value().getDefaultInstance(),
                     ItemInit.SHADE_POWERED_RAIL.value().getDefaultInstance(),

                     ItemInit.ACACIA_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.BIRCH_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.CRIMSON_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.DARK_OAK_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.JUNGLE_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.MANGROVE_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     Items.ACTIVATOR_RAIL.getDefaultInstance(),
                     ItemInit.SPRUCE_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.WARPED_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.SCRAPWOOD_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.WHISPUR_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.PETRIFIED_ACTIVATOR_RAIL.value().getDefaultInstance(),
                     ItemInit.SHADE_ACTIVATOR_RAIL.value().getDefaultInstance()));
                }).build());

    @SubscribeEvent
    public static void injectIntoVanillaTabs(BuildCreativeModeTabContentsEvent event)
    {
        /*
         Spawn Eggs
         */
        if (event.getTabKey().equals(CreativeModeTabs.SPAWN_EGGS))
        {
            insertAlphabetical(event,
                               List.of(ItemInit.LITHICAN_SPAWN_EGG.value(), ItemInit.HOVERING_INFERNO_SPAWN_EGG.value(), ItemInit.REVENANT_SPAWN_EGG.value()),
                               CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        /*
         Natural Blocks
         */
        if (event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS))
        {
            injectItemsAfter(Items.BEDROCK.getDefaultInstance(), event, List.of(
                    ItemInit.HADALITE.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.FLOWERING_AZALEA_LEAVES.getDefaultInstance(), event, List.of(
                    ItemInit.SHADE_LEAVES.value(),
                    ItemInit.TEAL_SHADE_LEAVES.value(),
                    ItemInit.RED_SHADE_LEAVES.value(),
                    ItemInit.PURPLE_SHADE_LEAVES.value(),
                    ItemInit.ACACIA_HEDGE.value(),
                    ItemInit.AZALEA_HEDGE.value(),
                    ItemInit.FLOWERING_AZALEA_HEDGE.value(),
                    ItemInit.BIRCH_HEDGE.value(),
                    ItemInit.DARK_OAK_HEDGE.value(),
                    ItemInit.JUNGLE_HEDGE.value(),
                    ItemInit.MANGROVE_HEDGE.value(),
                    ItemInit.OAK_HEDGE.value(),
                    ItemInit.SPRUCE_HEDGE.value(),

                    ItemInit.ACACIA_HEDGE_WALL.value(),
                    ItemInit.AZALEA_HEDGE_WALL.value(),
                    ItemInit.FLOWERING_AZALEA_HEDGE_WALL.value(),
                    ItemInit.BIRCH_HEDGE_WALL.value(),
                    ItemInit.DARK_OAK_HEDGE_WALL.value(),
                    ItemInit.JUNGLE_HEDGE_WALL.value(),
                    ItemInit.MANGROVE_HEDGE_WALL.value(),
                    ItemInit.OAK_HEDGE_WALL.value(),
                    ItemInit.SPRUCE_HEDGE_WALL.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.MANGROVE_PROPAGULE.getDefaultInstance(), event, List.of(
                    ItemInit.SHADE_SAPLING.value(),
                    ItemInit.TEAL_SHADE_SAPLING.value(),
                    ItemInit.RED_SHADE_SAPLING.value(),
                    ItemInit.PURPLE_SHADE_SAPLING.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.WARPED_FUNGUS.getDefaultInstance(), event, List.of(
                    ItemInit.NETHER_BRISTLE.value(),
                    ItemInit.WHISPUR_ROOT.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.NETHER_GOLD_ORE.getDefaultInstance(), event, List.of(
                    ItemInit.AURUM_ORE.value(),
                    ItemInit.NETHER_DIAMOND_ORE.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.DEEPSLATE_DIAMOND_ORE.getDefaultInstance(), event, List.of(
                    ItemInit.BASALT_DIAMOND_ORE.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.CARVED_PUMPKIN.getDefaultInstance(), event, List.of(
                    ItemInit.CARVED_PUMPKIN.get(),
                    ItemInit.CARVED_PUMPKIN_CREEPY.get(),
                    ItemInit.CARVED_PUMPKIN_SCOWLING.get(),
                    ItemInit.CARVED_PUMPKIN_CREEPER.get(),
                    ItemInit.CARVED_PUMPKIN_TWISTED.get(),
                    ItemInit.CARVED_PUMPKIN_HORRIFIED.get(),
                    ItemInit.CARVED_PUMPKIN_FURIOUS.get(),
                    ItemInit.CARVED_PUMPKIN_ZOMBIE.get(),
                    ItemInit.CARVED_PUMPKIN_LIT.get(),
                    ItemInit.CARVED_PUMPKIN_CREEPY_LIT.get(),
                    ItemInit.CARVED_PUMPKIN_SCOWLING_LIT.get(),
                    ItemInit.CARVED_PUMPKIN_CREEPER_LIT.get(),
                    ItemInit.CARVED_PUMPKIN_TWISTED_LIT.get(),
                    ItemInit.CARVED_PUMPKIN_HORRIFIED_LIT.get(),
                    ItemInit.CARVED_PUMPKIN_FURIOUS_LIT.get(),
                    ItemInit.CARVED_PUMPKIN_ZOMBIE_LIT.get()),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Items.CARVED_PUMPKIN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Items.JACK_O_LANTERN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(ItemInit.CARVED_PUMPKIN_ZOMBIE_LIT.get().getDefaultInstance(), event, List.of(
                    ItemInit.DURIAN.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        /*
         Functional Blocks
         */
        else if (event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS))
        {
            injectItemsAfter(Items.FURNACE.getDefaultInstance(), event, List.of(
                    ItemInit.BLACKSTONE_FURNACE.value(),
                    ItemInit.DEEPSLATE_FURNACE.value(),
                    ItemInit.ANDESITE_FURNACE.value(),
                    ItemInit.DIORITE_FURNACE.value(),
                    ItemInit.GRANITE_FURNACE.value()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.WARPED_HANGING_SIGN.getDefaultInstance(), event, List.of(
                    ItemInit.SCRAPWOOD_SIGN.value(),
                    ItemInit.WHISPUR_SIGN.value(),
                    ItemInit.PETRIFIED_SIGN.value(),
                    ItemInit.SHADE_SIGN.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.LADDER.getDefaultInstance(), event, List.of(
                    ItemInit.CHAIN_LADDER.value(),
                    ItemInit.BAMBOO_LADDER.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        /*
         Redstone Blocks
         */
        else if (event.getTabKey().equals(CreativeModeTabs.REDSTONE_BLOCKS))
        {
            injectItemsAfter(Items.DISPENSER.getDefaultInstance(), event, List.of(
                    ItemInit.BLACKSTONE_DISPENSER.value(),
                    ItemInit.DEEPSLATE_DISPENSER.value(),
                    ItemInit.ANDESITE_DISPENSER.value(),
                    ItemInit.DIORITE_DISPENSER.value(),
                    ItemInit.GRANITE_DISPENSER.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.DROPPER.getDefaultInstance(), event, List.of(
                    ItemInit.BLACKSTONE_DROPPER.value(),
                    ItemInit.DEEPSLATE_DROPPER.value(),
                    ItemInit.ANDESITE_DROPPER.value(),
                    ItemInit.DIORITE_DROPPER.value(),
                    ItemInit.GRANITE_DROPPER.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.FURNACE.getDefaultInstance(), event, List.of(
                    ItemInit.BLACKSTONE_FURNACE.value(),
                    ItemInit.DEEPSLATE_FURNACE.value(),
                    ItemInit.ANDESITE_FURNACE.value(),
                    ItemInit.DIORITE_FURNACE.value(),
                    ItemInit.GRANITE_FURNACE.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        /*
         Ingredients
         */
        else if (event.getTabKey().equals(CreativeModeTabs.INGREDIENTS))
        {
            event.insertAfter(Items.RABBIT_HIDE.getDefaultInstance(), ItemInit.HOGLIN_HIDE.value().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.GOLD_NUGGET.getDefaultInstance(), ItemInit.AURUM_NUGGET.value().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.STICK.getDefaultInstance(), ItemInit.WOOD_SCRAP.value().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.BONE_MEAL.getDefaultInstance(), ItemInit.CHARRED_BONE.value().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.GOLD_INGOT.getDefaultInstance(), event, List.of(
                    ItemInit.AURUM_INGOT.value(),
                    ItemInit.WITHERED_INGOT.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.WHEAT.getDefaultInstance(), event, List.of(
                    ItemInit.CARAMINE_RYE.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        /*
         Combat
         */
        else if (event.getTabKey().equals(CreativeModeTabs.COMBAT))
        {
            injectItemsAfter(Items.NETHERITE_BOOTS.getDefaultInstance(), event, List.of(
                    ItemInit.AURUM_HELMET.value(),
                    ItemInit.AURUM_CHESTPLATE.value(),
                    ItemInit.AURUM_LEGGINGS.value(),
                    ItemInit.AURUM_BOOTS.value(),
                    ItemInit.WITHERED_HELMET.value(),
                    ItemInit.WITHERED_CHESTPLATE.value(),
                    ItemInit.WITHERED_LEGGINGS.value(),
                    ItemInit.WITHERED_BOOTS.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.NETHERITE_SWORD.getDefaultInstance(), event, List.of(
                    ItemInit.AURUM_SWORD.value(),
                    ItemInit.WITHERED_SWORD.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.NETHERITE_AXE.getDefaultInstance(), event, List.of(
                    ItemInit.AURUM_AXE.value(),
                    ItemInit.WITHERED_AXE.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.DIAMOND_HORSE_ARMOR.getDefaultInstance(), event, List.of(
                    ItemInit.NETHERITE_HORSE_ARMOR.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.SHIELD.getDefaultInstance(), event, List.of(
                    ItemInit.NETHERITE_SHIELD.value(),
                    ItemInit.INFERNAL_PLATE.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            injectItemsAfter(Items.ARROW.getDefaultInstance(), event, List.of(
                    ItemInit.BOUNCING_ARROW.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            injectItemsAfter(Items.ARROW.getDefaultInstance(), event, List.of(
                    ItemInit.EXPLOSIVE_ARROW.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            injectItemsAfter(Items.ARROW.getDefaultInstance(), event, List.of(
                    ItemInit.QUARTZ_ARROW.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            injectItemsAfter(Items.ARROW.getDefaultInstance(), event, List.of(
                    ItemInit.HOMING_ARROW.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            injectItemsAfter(Items.ARROW.getDefaultInstance(), event, List.of(
                    ItemInit.DRIPSTONE_ARROW.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            injectItemsAfter(Items.ARROW.getDefaultInstance(), event, List.of(
                    ItemInit.AMETHYST_ARROW.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        /*
         Building Blocks
         */
        else if (event.getTabKey().equals(CreativeModeTabs.BUILDING_BLOCKS))
        {
            injectItemsAfter(Items.GOLD_BLOCK.getDefaultInstance(), event, List.of(
                    ItemInit.AURUM_BLOCK.value(), ItemInit.PATINA_GOLD_BLOCK.value(), ItemInit.PATINA_AURUM_BLOCK.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.WARPED_BUTTON.getDefaultInstance(), event, List.of(
                    ItemInit.SCRAPWOOD_HEAP.value(),
                    ItemInit.SCRAPWOOD_PLANKS.value(),
                    ItemInit.SCRAPWOOD_STAIRS.value(),
                    ItemInit.SCRAPWOOD_SLAB.value(),
                    ItemInit.SCRAPWOOD_FENCE.value(),
                    ItemInit.SCRAPWOOD_FENCE_GATE.value(),
                    ItemInit.SCRAPWOOD_DOOR.value(),
                    ItemInit.SCRAPWOOD_TRAPDOOR.value(),
                    ItemInit.SCRAPWOOD_PRESSURE_PLATE.value(),
                    ItemInit.SCRAPWOOD_BUTTON.value(),

                    Items.BONE_BLOCK,
                    ItemInit.WHISPUR_PLANKS.value(),
                    ItemInit.WHISPUR_STAIRS.value(),
                    ItemInit.WHISPUR_SLAB.value(),
                    ItemInit.WHISPUR_FENCE.value(),
                    ItemInit.WHISPUR_FENCE_GATE.value(),
                    ItemInit.WHISPUR_DOOR.value(),
                    ItemInit.WHISPUR_TRAPDOOR.value(),
                    ItemInit.WHISPUR_PRESSURE_PLATE.value(),
                    ItemInit.WHISPUR_BUTTON.value(),

                    ItemInit.PETRIFIED_LOG.value(),
                    ItemInit.PETRIFIED_WOOD.value(),
                    ItemInit.STRIPPED_PETRIFIED_LOG.value(),
                    ItemInit.STRIPPED_PETRIFIED_WOOD.value(),
                    ItemInit.PETRIFIED_PLANKS.value(),
                    ItemInit.PETRIFIED_STAIRS.value(),
                    ItemInit.PETRIFIED_SLAB.value(),
                    ItemInit.PETRIFIED_FENCE.value(),
                    ItemInit.PETRIFIED_FENCE_GATE.value(),
                    ItemInit.PETRIFIED_DOOR.value(),
                    ItemInit.PETRIFIED_TRAPDOOR.value(),
                    ItemInit.PETRIFIED_PRESSURE_PLATE.value(),
                    ItemInit.PETRIFIED_BUTTON.value(),

                    ItemInit.SHADE_LOG.value(),
                    ItemInit.SHADE_WOOD.value(),
                    ItemInit.STRIPPED_SHADE_LOG.value(),
                    ItemInit.STRIPPED_SHADE_WOOD.value(),
                    ItemInit.SHADE_PLANKS.value(),
                    ItemInit.SHADE_STAIRS.value(),
                    ItemInit.SHADE_SLAB.value(),
                    ItemInit.SHADE_FENCE.value(),
                    ItemInit.SHADE_FENCE_GATE.value(),
                    ItemInit.SHADE_DOOR.value(),
                    ItemInit.SHADE_TRAPDOOR.value(),
                    ItemInit.SHADE_PRESSURE_PLATE.value(),
                    ItemInit.SHADE_BUTTON.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.REINFORCED_DEEPSLATE.getDefaultInstance(), event, List.of(
                    ItemInit.BASALT_SLAB.value(),
                    ItemInit.BASALT_STAIRS.value(),
                    ItemInit.BASALT_WALL.value(),

                    ItemInit.SMOOTH_BASALT_SLAB.value(),
                    ItemInit.SMOOTH_BASALT_STAIRS.value(),
                    ItemInit.SMOOTH_BASALT_WALL.value(),

                    ItemInit.POLISHED_BASALT_SLAB.value(),
                    ItemInit.POLISHED_BASALT_STAIRS.value(),
                    ItemInit.POLISHED_BASALT_WALL.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        /*
         Tools & Utilities
         */
        else if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES))
        {
            injectItemsAfter(Items.NETHERITE_HOE.getDefaultInstance(), event, List.of(
                    ItemInit.AURUM_SHOVEL.value(),
                    ItemInit.AURUM_PICKAXE.value(),
                    ItemInit.AURUM_AXE.value(),
                    ItemInit.AURUM_HOE.value(),
                    ItemInit.WITHERED_SHOVEL.value(),
                    ItemInit.WITHERED_PICKAXE.value(),
                    ItemInit.WITHERED_AXE.value(),
                    ItemInit.WITHERED_HOE.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        else if (event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS))
        {
            injectItemsAfter(Items.MELON_SLICE.getDefaultInstance(), event, List.of(
                    ItemInit.DURIAN_SLICE.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.APPLE.getDefaultInstance(), event, List.of(
                    ItemInit.WARPED_DRUPEL.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            injectItemsAfter(Items.BREAD.getDefaultInstance(), event, List.of(
                    ItemInit.CHURK.value()
            ), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    static void injectItemsAfter(ItemStack injectPoint, BuildCreativeModeTabContentsEvent event, Collection<Item> list, CreativeModeTab.TabVisibility visibility)
    {
        List<Item> reverseList = new ArrayList<>(list);
        Collections.reverse(reverseList);
        for (Item item : reverseList)
        {   event.insertAfter(injectPoint, item.getDefaultInstance(), visibility);
        }
    }

    static void injectItemsBefore(ItemStack injectPoint, BuildCreativeModeTabContentsEvent event, Collection<Item> list, CreativeModeTab.TabVisibility visibility)
    {
        for (Item item : list)
        {   event.insertBefore(injectPoint, item.getDefaultInstance(), visibility);
        }
    }

    static void insertAlphabetical(BuildCreativeModeTabContentsEvent event, Collection<Item> list, CreativeModeTab.TabVisibility visibility)
    {
        // Assuming the tab is sorted by name, insert the items into the tab so that the tab remains sorted
        List<ItemStack> tabItems = new ArrayList<>(event.getParentEntries());

        for (Item item : list)
        {
            ItemStack itemStack = item.getDefaultInstance();
            ItemStack anchor = ItemStack.EMPTY;
            for (int i = 0; i < tabItems.size(); i++)
            {
                ItemStack tabItem = tabItems.get(i);
                if (tabItem.getItem() instanceof SpawnEggItem && tabItem.getDisplayName().getString().compareTo(itemStack.getDisplayName().getString()) > 0)
                {   anchor = tabItem;
                    break;
                }
            }
            if (anchor.isEmpty())
            {   event.accept(itemStack, visibility);
            }
            else event.insertBefore(anchor, itemStack, visibility);
        }
    }
}
