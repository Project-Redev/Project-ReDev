package net.roadkill.redev.mixin;


import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.model.WitherBossModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.WitherBossRenderer;
import net.minecraft.client.renderer.entity.state.WitherRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(WitherBossRenderer.class)
public class MixinWitherBossRenderer extends MobRenderer<WitherBoss, WitherRenderState, WitherBossModel> {
    @Unique
    private static final ResourceLocation WITHER_INVULNERABLE_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_invulnerable.png");
    @Unique
    private static final ResourceLocation WITHER_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither.png");
    @Unique
    private static final ResourceLocation WITHER_INVULNERABLE_LOCATION_STAGE_2 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_invulnerable_stage_2.png");
    @Unique
    private static final ResourceLocation WITHER_LOCATION_STAGE_2 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_stage_2.png");
    @Unique
    private static final ResourceLocation WITHER_INVULNERABLE_LOCATION_STAGE_3 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_invulnerable_stage_3.png");
    @Unique
    private static final ResourceLocation WITHER_LOCATION_STAGE_3 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_stage_3.png");

    @Unique
    private static final ResourceLocation WITHER_INVULNERABLE_LOCATION2 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_invulnerable.png");
    @Unique
    private static final ResourceLocation WITHER_LOCATION2 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither.png");
    @Unique
    private static final ResourceLocation WITHER_INVULNERABLE_LOCATION_STAGE_22 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_invulnerable_stage_2.png");
    @Unique
    private static final ResourceLocation WITHER_LOCATION_STAGE_22 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_stage_2.png");
    @Unique
    private static final ResourceLocation WITHER_INVULNERABLE_LOCATION_STAGE_32 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_invulnerable_stage_3.png");
    @Unique
    private static final ResourceLocation WITHER_LOCATION_STAGE_32 = ResourceLocation.withDefaultNamespace("textures/entity/wither/wither_stage_3.png");


    @Unique
    private float HEALTH_BOSS;
    @Unique
    private float MAX_HEALTH_BOSS;


    public MixinWitherBossRenderer(EntityRendererProvider.Context context, WitherBossModel model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    public ResourceLocation getTextureLocation(WitherRenderState renderState) {
        int h = Mth.floor(HEALTH_BOSS);
        int i = Mth.floor(renderState.invulnerableTicks);
        if (h <= MAX_HEALTH_BOSS/2) {
            return i <= 0 || i <= 80 && i / 5 % 2 == 1 ? WITHER_LOCATION_STAGE_3 : WITHER_INVULNERABLE_LOCATION_STAGE_3;
        } else if (h <= (MAX_HEALTH_BOSS - MAX_HEALTH_BOSS/6)) {
            return i <= 0 || i <= 80 && i / 5 % 2 == 1 ? WITHER_LOCATION_STAGE_2 : WITHER_INVULNERABLE_LOCATION_STAGE_2;
        } else {
            return i <= 0 || i <= 80 && i / 5 % 2 == 1 ? WITHER_LOCATION : WITHER_INVULNERABLE_LOCATION;
        }
    }

    public WitherRenderState createRenderState() {
        return new WitherRenderState();
    }

    public void extractRenderState(WitherBoss wither, WitherRenderState renderState, float f) {
        super.extractRenderState(wither, renderState, f);
        int i = wither.getInvulnerableTicks();
        renderState.invulnerableTicks = i > 0 ? (float)i - f : 0.0F;
        HEALTH_BOSS = wither.getHealth();
        MAX_HEALTH_BOSS = wither.getMaxHealth();
        System.arraycopy(wither.getHeadXRots(), 0, renderState.xHeadRots, 0, renderState.xHeadRots.length);
        System.arraycopy(wither.getHeadYRots(), 0, renderState.yHeadRots, 0, renderState.yHeadRots.length);
        renderState.isPowered = wither.isPowered();
    }
}
