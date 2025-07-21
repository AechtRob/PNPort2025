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

public class DNARecombinerCentrifugePhialModel<T extends BlockEntityDNARecombinerCentrifugeRenderState> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "dna_recombiner_centrifuge_phial"), "main");

	public final ModelPart phial1centre;
	public final ModelPart phial1pivot;

	public DNARecombinerCentrifugePhialModel(ModelPart root) {
		super(root);
		this.phial1centre = root.getChild("phial1centre");
		this.phial1pivot = this.phial1centre.getChild("phial1pivot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition phial1centre = partdefinition.addOrReplaceChild("phial1centre", CubeListBuilder.create(), PartPose.offset(0.0F, 14.5F, 0.0F));

		PartDefinition phial1pivot = phial1centre.addOrReplaceChild("phial1pivot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -5.5F));

		PartDefinition phial1b_r1 = phial1pivot.addOrReplaceChild("phial1b_r1", CubeListBuilder.create().texOffs(0, -4).addBox(0.0F, -4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition phial1a_r1 = phial1pivot.addOrReplaceChild("phial1a_r1", CubeListBuilder.create().texOffs(0, -4).addBox(0.0F, -4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 8, 8);
	}

	@Override
	public void setupAnim(T renderState) {
		super.setupAnim(renderState);
		//this.root().getAllParts().forEach(ModelPart::resetPose);
	}

}