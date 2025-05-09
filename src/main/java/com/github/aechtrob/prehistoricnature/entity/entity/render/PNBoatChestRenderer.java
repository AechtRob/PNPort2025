package com.github.aechtrob.prehistoricnature.entity.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.AbstractBoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class PNBoatChestRenderer extends AbstractBoatRenderer {
    private final Model waterPatchModel;
    private final ResourceLocation texture;
    private final EntityModel<BoatRenderState> model;

    public PNBoatChestRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayer, String boatName) {
        super(context);
        this.texture = modelLayer.model().withPath((p_375447_) -> "textures/entity/chest_boat/" + boatName + ".png");
        this.waterPatchModel = new Model.Simple(context.bakeLayer(ModelLayers.BOAT_WATER_PATCH), (p_359275_) -> RenderType.waterMask());
        this.model = new BoatModel(context.bakeLayer(modelLayer));
    }

    protected EntityModel<BoatRenderState> model() {
        return this.model;
    }

    protected RenderType renderType() {
        return this.model.renderType(this.texture);
    }

    protected void renderTypeAdditions(BoatRenderState p_376691_, PoseStack p_376523_, MultiBufferSource p_376756_, int p_376697_) {
        if (!p_376691_.isUnderWater) {
            this.waterPatchModel.renderToBuffer(p_376523_, p_376756_.getBuffer(this.waterPatchModel.renderType(this.texture)), p_376697_, OverlayTexture.NO_OVERLAY);
        }

    }
}
