package net.roadkill.redev.common.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class RotatableExperienceBlock extends RotatedPillarBlock {
    public static final MapCodec<RotatableExperienceBlock> CODEC = RecordCodecBuilder.mapCodec((codec) -> codec.group(IntProvider.codec(0, 10).fieldOf("experience").forGetter((p_304879_) -> p_304879_.xpRange), propertiesCodec()).apply(codec, RotatableExperienceBlock::new));

    private final IntProvider xpRange;

    public MapCodec<? extends RotatableExperienceBlock> codec() {
        return CODEC;
    }

    public RotatableExperienceBlock(IntProvider xpRange, BlockBehaviour.Properties properties) {
        super(properties);
        this.xpRange = xpRange;
    }

    protected void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
        super.spawnAfterBreak(state, level, pos, stack, dropExperience);
    }

    public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity breaker, ItemStack tool) {
        return this.xpRange.sample(level.getRandom());
    }
}
