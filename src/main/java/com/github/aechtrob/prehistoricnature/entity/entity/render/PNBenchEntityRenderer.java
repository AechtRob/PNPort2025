package com.github.aechtrob.prehistoricnature.entity.entity.render;

import com.github.aechtrob.prehistoricnature.entity.entity.BenchSittableEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class PNBenchEntityRenderer extends EntityRenderer<BenchSittableEntity> {
    public PNBenchEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public boolean shouldRender(BenchSittableEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public ResourceLocation getTextureLocation(BenchSittableEntity p_114482_) {
        return null;
    }
}
