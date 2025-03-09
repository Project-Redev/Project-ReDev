package net.roadkill.redev.common.event;

import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.roadkill.redev.common.entity.HoveringInfernoEntity;
import net.roadkill.redev.core.init.EffectInit;
import net.roadkill.redev.util.registries.ModEntityTypes;

@EventBusSubscriber
public class HandleMobSpawns
{
    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
    public static class ModEvents
    {

        @SubscribeEvent
        public static void mobSpawnPlacements(RegisterSpawnPlacementsEvent event)
        {
            event.register(ModEntityTypes.HOVERING_INFERNO, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, level, spawnType, pos, random) ->
            {   return level.getBlockState(pos.below()).is(Blocks.NETHER_BRICKS);
            },
            RegisterSpawnPlacementsEvent.Operation.REPLACE);

            event.register(ModEntityTypes.LITHICAN, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, level, spawnType, pos, random) ->
            {   return level.getBlockState(pos.below()).is(BlockTags.BASE_STONE_OVERWORLD) && Monster.isDarkEnoughToSpawn(level, pos, random);
            },
            RegisterSpawnPlacementsEvent.Operation.REPLACE);
        }
    }

    @SubscribeEvent
    public static void onLivingHeal(LivingHealEvent event) {
        LivingEntity entity = event.getEntity();
        var effects = entity.getActiveEffectsMap();
        if(effects.containsKey(EffectInit.BLEEDING))
        {
            event.setAmount(((float)event.getAmount()* 0.4f));

        }
    }
    @SubscribeEvent
    public static void replaceBlazeSpawn(FinalizeSpawnEvent event)
    {
        if (event.getEntity().getType() == EntityType.BLAZE && Math.random() < 0.1
        && event.getSpawnType() == EntitySpawnReason.NATURAL)
        {
            event.setSpawnCancelled(true);

            HoveringInfernoEntity hoveringInferno = new HoveringInfernoEntity((EntityType<? extends Blaze>) ModEntityTypes.HOVERING_INFERNO, event.getEntity().level());
            hoveringInferno.setPos(event.getEntity().position());
            event.getLevel().addFreshEntity(hoveringInferno);
        }
    }
}
