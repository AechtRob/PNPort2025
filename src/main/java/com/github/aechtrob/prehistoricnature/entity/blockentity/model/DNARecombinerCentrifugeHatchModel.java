package com.github.aechtrob.prehistoricnature.entity.blockentity.model;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.entity.blockentity.renderer.renderstate.BlockEntityDNARecombinerCentrifugeRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DNARecombinerCentrifugeHatchModel<T extends BlockEntityDNARecombinerCentrifugeRenderState> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "dna_recombiner_centrifuge_hatch"), "main");

	public final ModelPart lid;
	public final ModelPart right;
	public final ModelPart left;

	public DNARecombinerCentrifugeHatchModel(ModelPart root) {
		super(root);
		this.lid = root.getChild("lid");
		this.right = this.lid.getChild("right");
		this.left = this.lid.getChild("left");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition lid = partdefinition.addOrReplaceChild("lid", CubeListBuilder.create(), PartPose.offset(7.0F, 15.0F, 0.0F));

		PartDefinition right = lid.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -7.0F, -1.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(-0.5F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left = lid.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -7.0F, -0.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(-0.5F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 48, 32);
	}

	@Override
	public void setupAnim(T renderState) {
		super.setupAnim(renderState);
		//this.root().getAllParts().forEach(ModelPart::resetPose);
	}

}