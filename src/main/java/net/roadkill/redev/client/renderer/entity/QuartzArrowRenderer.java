package net.roadkill.redev.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.ResourceLocation;
import net.roadkill.redev.ReDev;
import net.roadkill.redev.common.entity.arrows.QuartzArrowEntity;

public class QuartzArrowRenderer extends ArrowRenderer<QuartzArrowEntity, ArrowRenderState> {

    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "textures/entity/quartz_arrow.png");

    public QuartzArrowRenderer(EntityRendererProvider.Context context)
    {   super(context);
    }

    @Override
    public ArrowRenderState createRenderState()
    {   return new ArrowRenderState();
    }

    @Override
    protected ResourceLocation getTextureLocation(ArrowRenderState p_368566_)
    {   return TEXTURE;
    }
}
