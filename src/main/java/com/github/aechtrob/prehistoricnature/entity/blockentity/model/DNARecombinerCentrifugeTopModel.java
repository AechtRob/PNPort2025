package com.github.aechtrob.prehistoricnature.entity.blockentity.model;


import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.entity.blockentity.renderer.renderstate.BlockEntityDNARecombinerCentrifugeRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DNARecombinerCentrifugeTopModel<T extends BlockEntityDNARecombinerCentrifugeRenderState> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "dna_recombiner_centrifuge_top"), "main");

	public final ModelPart lid;

	public DNARecombinerCentrifugeTopModel(ModelPart root) {
        super(root);
        this.lid = root.getChild("lid");
	}

	public static LayerDefinition createBodyLayer() {
		var meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition lid = partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(6, 9).addBox(-9.0F, -7.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(7, 19).addBox(-4.0F, -7.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 19).addBox(-5.0F, -7.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-9.0F, -7.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -7.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-6.0F, -7.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(17, 18).addBox(-11.0F, -7.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 10).addBox(-4.0F, -7.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 8).addBox(-10.0F, -7.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 6).addBox(-12.0F, -6.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 4).addBox(-3.0F, -6.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-12.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 16).addBox(-3.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 14).addBox(-10.0F, -7.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 17).addBox(-11.0F, -7.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(7, 17).addBox(-5.0F, -7.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 17).addBox(-13.0F, -5.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 15).addBox(-2.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 15).addBox(-13.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 13).addBox(-2.0F, -5.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 2).addBox(-13.0F, -1.0F, 6.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 0).addBox(-13.0F, -1.0F, -7.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-14.0F, -1.0F, -6.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-14.0F, -4.0F, -7.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 4).addBox(-14.0F, -4.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 13).addBox(-13.5F, -4.0F, 1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 4).addBox(-1.0F, -4.0F, 6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-1.0F, -4.0F, -7.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 10).addBox(-6.0F, -4.0F, 6.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(4, 11).addBox(-0.5F, -4.0F, -3.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(14, 6).addBox(-10.0F, -4.0F, -6.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 15.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 48, 32);
	}

	@Override
	public void setupAnim(T renderState) {
		super.setupAnim(renderState);
		//this.root().getAllParts().forEach(ModelPart::resetPose);
	}

}