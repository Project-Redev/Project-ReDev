package net.roadkill.redev.client.model.entity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.WitherRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.roadkill.redev.ReDev;


@OnlyIn(Dist.CLIENT)
public class WitherBossModel extends EntityModel<WitherRenderState> {

    public static final ModelLayerLocation WITHER_NEW = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "hoglin_head"), "main");

    private final ModelPart head1_phase2;
    private final ModelPart body1_phase2;
    private final ModelPart body2_phase2;
    private final ModelPart body3;
    private final ModelPart head1_phase3;
    private final ModelPart body1_phase3;
    private final ModelPart body2_phase3;
    private final ModelPart body3_phase3;
    private final ModelPart head1;
    private final ModelPart head2;
    private final ModelPart head3;
    private final ModelPart body1;
    private final ModelPart body2;
    private final ModelPart body4;

    public WitherBossModel(ModelPart root) {
        super(root);
        this.head1_phase2 = root.getChild("head1_phase2");
        this.body1_phase2 = root.getChild("body1_phase2");
        this.body2_phase2 = root.getChild("body2_phase2");
        this.body3 = root.getChild("body3");
        this.head1_phase3 = root.getChild("head1_phase3");
        this.body1_phase3 = root.getChild("body1_phase3");
        this.body2_phase3 = root.getChild("body2_phase3");
        this.body3_phase3 = root.getChild("body3_phase3");
        this.head1 = root.getChild("head1");
        this.head2 = root.getChild("head2");
        this.head3 = root.getChild("head3");
        this.body1 = root.getChild("body1");
        this.body2 = root.getChild("body2");
        this.body4 = root.getChild("body4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head1_phase2 = partdefinition.addOrReplaceChild("head1_phase2", CubeListBuilder.create().texOffs(0, 65).addBox(2.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 65).addBox(-11.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body1_phase2 = partdefinition.addOrReplaceChild("body1_phase2", CubeListBuilder.create().texOffs(1, 80).addBox(-9.0F, 3.9F, -0.5F, 17.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body2_phase2 = partdefinition.addOrReplaceChild("body2_phase2", CubeListBuilder.create().texOffs(0, 86).addBox(0.0F, 0.0F, 0.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(24, 86).addBox(-4.0F, 1.5F, 0.5F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 86).addBox(-4.0F, 4.0F, 0.5F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 86).addBox(-4.0F, 6.5F, 0.5F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 6.9F, -0.5F));

        PartDefinition body3 = partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(12, 86).addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 16.9F, -0.5F));
        PartDefinition head1_phase3 = partdefinition.addOrReplaceChild("head1_phase3", CubeListBuilder.create().texOffs(64, 0).addBox(-4.5F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body1_phase3 = partdefinition.addOrReplaceChild("body1_phase3", CubeListBuilder.create().texOffs(67, 16).addBox(-7.0F, 3.9F, -0.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body2_phase3 = partdefinition.addOrReplaceChild("body2_phase3", CubeListBuilder.create().texOffs(64, 22).addBox(0.0F, 0.0F, 0.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(88, 22).addBox(-4.0F, 1.5F, 0.5F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(88, 22).addBox(-4.0F, 4.0F, 0.5F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(88, 22).addBox(-4.0F, 6.5F, 0.5F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 6.9F, -0.5F));
        PartDefinition body3_phase3 = partdefinition.addOrReplaceChild("body3_phase3", CubeListBuilder.create().texOffs(76, 22).addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 16.9F, -0.5F));
        PartDefinition head1 = partdefinition.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -4.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 4.0F, 0.0F));
        PartDefinition head3 = partdefinition.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -4.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 4.0F, 0.0F));
        PartDefinition body1 = partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 16).addBox(-10.0F, 3.9F, -0.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body2 = partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, 0.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(24, 22).addBox(-4.0F, 1.5F, 0.5F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 22).addBox(-4.0F, 4.0F, 0.5F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 22).addBox(-4.0F, 6.5F, 0.5F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 6.9F, -0.5F));

        PartDefinition body4 = partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(12, 22).addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 16.9F, -0.5F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void setupAnim(WitherRenderState p_365401_) {
        super.setupAnim(p_365401_);
        setupHeadRotation(p_365401_, this.head1, 0);
        setupHeadRotation(p_365401_, this.head3, 1);
        float f = Mth.cos(p_365401_.ageInTicks * 0.1F);
        this.body2.xRot = (0.065F + 0.05F * f) * 3.1415927F;
        this.body4.setPos(-2.0F, 6.9F + Mth.cos(this.body2.xRot) * 10.0F, -0.5F + Mth.sin(this.body2.xRot) * 10.0F);
        this.body4.xRot = (0.265F + 0.1F * f) * 3.1415927F;
        this.head2.yRot = p_365401_.yRot * 0.017453292F;
        this.head2.xRot = p_365401_.xRot * 0.017453292F;
    }

    private static void setupHeadRotation(WitherRenderState p_360725_, ModelPart p_171073_, int p_171074_) {
        p_171073_.yRot = (p_360725_.yHeadRots[p_171074_] - p_360725_.bodyRot) * 0.017453292F;
        p_171073_.xRot = p_360725_.xHeadRots[p_171074_] * 0.017453292F;
    }
}
