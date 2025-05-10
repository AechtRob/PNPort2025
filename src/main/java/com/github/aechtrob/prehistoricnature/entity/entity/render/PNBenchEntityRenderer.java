package com.github.aechtrob.prehistoricnature.entity.entity.render;

import com.github.aechtrob.prehistoricnature.entity.entity.BenchSittableEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class PNBenchEntityRenderer extends EntityRenderer<BenchSittableEntity, EntityRenderState> {
    public PNBenchEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

    @Override
    public boolean shouldRender(BenchSittableEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
