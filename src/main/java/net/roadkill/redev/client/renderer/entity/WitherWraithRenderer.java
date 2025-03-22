package net.roadkill.redev.client.renderer.entity;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.roadkill.redev.client.renderer.render_sate.WitherWraithRenderState;
import net.roadkill.redev.common.entity.WitherWraith;
import org.jetbrains.annotations.NotNull;

public class WitherWraithRenderer <T extends AbstractSkeleton, S extends WitherWraithRenderState> extends AbstractSkeletonRenderer<T, S> {
    private static final ResourceLocation WITHER_SKELETON_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/skeleton/wither_skeleton.png");

    public WitherWraithRenderer(EntityRendererProvider.Context context) {
        super(context, ModelLayers.WITHER_SKELETON, ModelLayers.WITHER_SKELETON_INNER_ARMOR, ModelLayers.WITHER_SKELETON_OUTER_ARMOR);
    }

    @Override
    public S createRenderState() {
        return (S) new WitherWraithRenderState();
    }

    public ResourceLocation getTextureLocation(WitherWraithRenderState p_362316_) {
        return WITHER_SKELETON_LOCATION;
    }

}