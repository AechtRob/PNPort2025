package com.github.aechtrob.prehistoricnature.entity.blockentity.renderer;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.BlockDNARecombinerCentrifuge;
import com.github.aechtrob.prehistoricnature.entity.blockentity.BlockEntityDNARecombinerCentrifuge;
import com.github.aechtrob.prehistoricnature.entity.blockentity.model.DNARecombinerCentrifugeHatchModel;
import com.github.aechtrob.prehistoricnature.entity.blockentity.model.DNARecombinerCentrifugePhialModel;
import com.github.aechtrob.prehistoricnature.entity.blockentity.model.DNARecombinerCentrifugeSpindleModel;
import com.github.aechtrob.prehistoricnature.entity.blockentity.model.DNARecombinerCentrifugeTopModel;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BlockEntityDNARecombinerCentrifugeRenderer implements BlockEntityRenderer<BlockEntityDNARecombinerCentrifuge> {

    RenderType TEXTURE_CENTRIFUGE_LID = RenderType.entityCutoutNoCullZOffset(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "textures/entity/blockentity/dna_recombiner_centrifuge_top.png"));
    RenderType TEXTURE_CENTRIFUGE_PHIAL_DNA = RenderType.entityCutoutNoCullZOffset(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "textures/entity/blockentity/centrifuge_phial.png"));
    RenderType TEXTURE_CENTRIFUGE_PHIAL_EMPTY = RenderType.entityCutoutNoCullZOffset(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "textures/entity/blockentity/centrifuge_phial_empty.png"));
    RenderType TEXTURE_IRON_BLOCK = RenderType.entityCutout(ResourceLocation.parse("minecraft:textures/block/iron_block.png"));

    private final DNARecombinerCentrifugeTopModel modelDNARecombinerCentrifugeLid;
    private final DNARecombinerCentrifugeHatchModel modelDNARecombinerCentrifugeHatch;
    private final DNARecombinerCentrifugePhialModel modelDNARecombinerCentrifugePhial;
    private final DNARecombinerCentrifugeSpindleModel modelDNARecombinerCentrifugeSpindle;

    public BlockEntityDNARecombinerCentrifugeRenderer(BlockEntityRendererProvider.Context context) {
        this.modelDNARecombinerCentrifugeLid = new DNARecombinerCentrifugeTopModel(context.bakeLayer(DNARecombinerCentrifugeTopModel.LAYER_LOCATION));
        this.modelDNARecombinerCentrifugeHatch = new DNARecombinerCentrifugeHatchModel(context.bakeLayer(DNARecombinerCentrifugeHatchModel.LAYER_LOCATION));
        this.modelDNARecombinerCentrifugePhial = new DNARecombinerCentrifugePhialModel(context.bakeLayer(DNARecombinerCentrifugePhialModel.LAYER_LOCATION));
        this.modelDNARecombinerCentrifugeSpindle = new DNARecombinerCentrifugeSpindleModel(context.bakeLayer(DNARecombinerCentrifugeSpindleModel.LAYER_LOCATION));

    }

    @Override
    public void render(BlockEntityDNARecombinerCentrifuge blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, Vec3 cameraPos) {

        Direction direction = blockEntity.getBlockState().getValueOrElse(BlockDNARecombinerCentrifuge.FACING, Direction.NORTH);

        //Centrifuge lid:
        VertexConsumer vertexconsumer = bufferSource.getBuffer(TEXTURE_CENTRIFUGE_LID);
        float rotateAngleInitial = 0F;
        float rotateAngle = 0F;
        float flareAngle = 0F;
        if (blockEntity.isProcessing()) {
            modelDNARecombinerCentrifugeLid.lid.zRot = 0;
            try {
                rotateAngleInitial = blockEntity.getRotationAngle(blockEntity.getLevel().getGameTime() - blockEntity.startTick + partialTick);
                rotateAngle = (float) blockEntity.floorAngle(rotateAngleInitial);
                flareAngle = (float) blockEntity.getFlareAngle(blockEntity.getLevel().getGameTime() - blockEntity.startTick + partialTick);
            } catch (RuntimeException exception) {
            }
        }
        else if (!blockEntity.isLocked()){
            float f = blockEntity.prevLidAngle + (blockEntity.lidAngle - blockEntity.prevLidAngle) * partialTick;
            f = 1.0F - f;
            f = 1.0F - f * f * f;
            modelDNARecombinerCentrifugeLid.lid.zRot = (f * ((float)Math.PI / 2F));
        }
        poseStack.pushPose();
            float f = direction.getCounterClockWise().toYRot();
            poseStack.translate(1.0F, 1.0F, 1.0F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(180F));
            if (direction == Direction.NORTH) {
                poseStack.mulPose(Axis.YP.rotationDegrees(-f));
            }
            if (direction == Direction.SOUTH) {
                poseStack.translate(1.0F, 0.0F, -1.0F);
                poseStack.mulPose(Axis.YP.rotationDegrees( - f));
            }
            if (direction == Direction.EAST) {
                poseStack.translate(1.0F, 0.0F, 0.0F);
                poseStack.mulPose(Axis.YP.rotationDegrees(180 - f));
            }
            if (direction == Direction.WEST) {
                poseStack.translate(0.0F, 0.0F, -1.0F);
                poseStack.mulPose(Axis.YP.rotationDegrees(180 - f));
            }
            poseStack.translate(-0.5F, -0.5F, -0.5F);
            this.modelDNARecombinerCentrifugeLid.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();

        //Centrifuge lid hatch:
        vertexconsumer = bufferSource.getBuffer(TEXTURE_IRON_BLOCK);
        if (blockEntity.isProcessing()) {
            modelDNARecombinerCentrifugeHatch.lid.zRot = 0;
        }
        else if (!blockEntity.isLocked()){
            f = blockEntity.prevLidAngle + (blockEntity.lidAngle - blockEntity.prevLidAngle) * partialTick;
            f = 1.0F - f;
            f = 1.0F - f * f * f;
            modelDNARecombinerCentrifugeHatch.lid.zRot = (f * ((float)Math.PI / 2F));
        }
        modelDNARecombinerCentrifugeHatch.left.z = 1.25F * (float) blockEntity.getHatchVal();
        modelDNARecombinerCentrifugeHatch.right.z = -1.25F * (float) blockEntity.getHatchVal();
        GlStateManager._enableCull();
        poseStack.pushPose();
            poseStack.translate(1.0F, 1.0F, 1.0F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(180F));
            if (direction == Direction.NORTH) {
                poseStack.mulPose(Axis.YP.rotationDegrees(270 - f));
            }
            if (direction == Direction.SOUTH) {
                poseStack.mulPose(Axis.YP.rotationDegrees(90 - f));
                poseStack.translate(1.0F, 0.0F, 1.0F);
            }
            if (direction == Direction.EAST) {
                poseStack.mulPose(Axis.YP.rotationDegrees( - f));
                poseStack.translate(1.0F, 0.0F, 0.0F);
            }
            if (direction == Direction.WEST) {
                poseStack.mulPose(Axis.YP.rotationDegrees(180 - f));
                poseStack.translate(0.0F, 0.0F, 1.0F);
            }
            poseStack.translate(-0.5F, -0.5F, -0.5F);
            this.modelDNARecombinerCentrifugeHatch.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();

        //Centrifuge Spindle:
        vertexconsumer = bufferSource.getBuffer(TEXTURE_IRON_BLOCK);
        poseStack.pushPose();
            poseStack.translate(0.0F, 1.0F, 1.0F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(180F));
            poseStack.mulPose(Axis.YP.rotationDegrees(rotateAngle));
            poseStack.translate(-0.5F, -0.5F, -0.5F);
            this.modelDNARecombinerCentrifugeSpindle.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        
        //Render phials if present
        double yy = 1.08; //1.525 change lower to lower it
        if (!blockEntity.getItem(0).isEmpty()) {
            //Render the model in position 0:
            if (blockEntity.getItem(0).getItem() == ModItems.PHIAL.get()) {
                vertexconsumer = bufferSource.getBuffer(TEXTURE_CENTRIFUGE_PHIAL_DNA);
            } else {
                vertexconsumer = bufferSource.getBuffer(TEXTURE_CENTRIFUGE_PHIAL_EMPTY);
            }
            DNARecombinerCentrifugePhialModel modelDNARecombinerCentrifugePhial = this.modelDNARecombinerCentrifugePhial;

            poseStack.pushPose();
                poseStack.translate(0.5, yy, 0.5);
                poseStack.mulPose(Axis.XP.rotationDegrees(180F));
                poseStack.mulPose(Axis.YP.rotationDegrees(270-f));
                modelDNARecombinerCentrifugePhial.phial1pivot.xRot = (float) -Math.toRadians(flareAngle);
                poseStack.scale(0.5F, 0.5F, 0.5F);
                this.modelDNARecombinerCentrifugePhial.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }

        if (!blockEntity.getItem(1).isEmpty()) {
            //Render the model in position 1:
            if (blockEntity.getItem(1).getItem() == ModItems.PHIAL.get()) {
                vertexconsumer = bufferSource.getBuffer(TEXTURE_CENTRIFUGE_PHIAL_DNA);
            } else {
                vertexconsumer = bufferSource.getBuffer(TEXTURE_CENTRIFUGE_PHIAL_EMPTY);
            }
            DNARecombinerCentrifugePhialModel modelDNARecombinerCentrifugePhial = this.modelDNARecombinerCentrifugePhial;

            poseStack.pushPose();
            poseStack.translate(0.5, yy, 0.5);
            poseStack.mulPose(Axis.XP.rotationDegrees(180F));
            poseStack.mulPose(Axis.YP.rotationDegrees(90-f));
            modelDNARecombinerCentrifugePhial.phial1pivot.xRot = (float) -Math.toRadians(flareAngle);
            poseStack.scale(0.5F, 0.5F, 0.5F);
            this.modelDNARecombinerCentrifugePhial.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }

        if (!blockEntity.getItem(2).isEmpty()) {
            //Render the model in position 2:
            if (blockEntity.getItem(2).getItem() == ModItems.PHIAL.get()) {
                vertexconsumer = bufferSource.getBuffer(TEXTURE_CENTRIFUGE_PHIAL_DNA);
            } else {
                vertexconsumer = bufferSource.getBuffer(TEXTURE_CENTRIFUGE_PHIAL_EMPTY);
            }
            DNARecombinerCentrifugePhialModel modelDNARecombinerCentrifugePhial = this.modelDNARecombinerCentrifugePhial;

            poseStack.pushPose();
            poseStack.translate(0.5, yy, 0.5);
            poseStack.mulPose(Axis.XP.rotationDegrees(180F));
            poseStack.mulPose(Axis.YP.rotationDegrees(-f));
            modelDNARecombinerCentrifugePhial.phial1pivot.xRot = (float) -Math.toRadians(flareAngle);
            poseStack.scale(0.5F, 0.5F, 0.5F);
            this.modelDNARecombinerCentrifugePhial.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }

        if (!blockEntity.getItem(3).isEmpty()) {
            //Render the model in position 3:
            if (blockEntity.getItem(3).getItem() == ModItems.PHIAL.get()) {
                vertexconsumer = bufferSource.getBuffer(TEXTURE_CENTRIFUGE_PHIAL_DNA);
            } else {
                vertexconsumer = bufferSource.getBuffer(TEXTURE_CENTRIFUGE_PHIAL_EMPTY);
            }
            DNARecombinerCentrifugePhialModel modelDNARecombinerCentrifugePhial = this.modelDNARecombinerCentrifugePhial;

            poseStack.pushPose();
            poseStack.translate(0.5, yy, 0.5);
            poseStack.mulPose(Axis.XP.rotationDegrees(180F));
            poseStack.mulPose(Axis.YP.rotationDegrees(180-f));
            modelDNARecombinerCentrifugePhial.phial1pivot.xRot = (float) -Math.toRadians(flareAngle);
            poseStack.scale(0.5F, 0.5F, 0.5F);
            this.modelDNARecombinerCentrifugePhial.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
        
    }

    @Override
    public AABB getRenderBoundingBox(BlockEntityDNARecombinerCentrifuge renderEntity) {
        net.minecraft.core.BlockPos pos = renderEntity.getBlockPos();
        return net.minecraft.world.phys.AABB.encapsulatingFullBlocks(pos.offset(-1, 0, -1), pos.offset(1, 1, 1));
    }

}
