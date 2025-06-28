package com.github.aechtrob.prehistoricnature.item.itembase;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class PNPlantable extends Item {

    private BlockState plantBlock;
    private int offsetY;

    public PNPlantable(Properties properties, BlockState plantBlock, int offsetY) {
        super(properties);
        this.plantBlock = plantBlock;
        this.offsetY = offsetY;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        if (this.plantBlock.getBlock() instanceof VineBlock) {
            this.plantBlock = this.plantBlock.setValue(VineBlock.UP, false)
                    .setValue(VineBlock.NORTH, false)
                    .setValue(VineBlock.SOUTH, false)
                    .setValue(VineBlock.EAST, false)
                    .setValue(VineBlock.WEST, false);
            switch (direction.get3DDataValue()) {
                case 2:
                    this.plantBlock = this.plantBlock.setValue(VineBlock.SOUTH, true);
                    break;
                case 5:
                    this.plantBlock = this.plantBlock.setValue(VineBlock.WEST, true);
                    break;
                case 3:
                    this.plantBlock = this.plantBlock.setValue(VineBlock.NORTH, true);
                    break;
                case 4:
                    this.plantBlock = this.plantBlock.setValue(VineBlock.EAST, true);
                    break;
                default:
                    return super.useOn(context);
            }
            //Get the block clicked on:
            if (this.plantBlock != null) {
                if (level.isEmptyBlock(pos.relative(direction, this.offsetY)) &&
                        ((VineBlock)this.plantBlock.getBlock()).isAcceptableNeighbour(level, pos.relative(direction, this.offsetY), direction)
                ) {
                    //We can plant this vine here!
                    SoundEvent soundevent = SoundEvents.GRASS_PLACE;
                    level.playSound(player, player.blockPosition(), soundevent, SoundSource.NEUTRAL, 1.0F, 1.0F);
                    stack.shrink(1);
                    level.setBlock(pos.relative(direction, this.offsetY), this.plantBlock, 3);
                    this.plantBlock.getBlock().setPlacedBy(level, pos.relative(direction, this.offsetY), this.plantBlock, player, stack);
                    return InteractionResult.SUCCESS;
                }
            }
            return super.useOn(context);
        }
        //Get the block clicked on:
        if (this.plantBlock != null) {
            if (direction == Direction.UP && level.isEmptyBlock(pos.above(this.offsetY))
                    && this.plantBlock.canSurvive(level, pos.above(this.offsetY))
            ) {
                //We can plant this here!
                SoundEvent soundevent = SoundEvents.GRASS_PLACE;
                level.playSound(player, player.blockPosition(), soundevent, SoundSource.NEUTRAL, 1.0F, 1.0F);
                stack.shrink(1);
                level.setBlock(pos.above(this.offsetY), this.plantBlock, 3);
                this.plantBlock.getBlock().setPlacedBy(level, pos.relative(direction, this.offsetY), this.plantBlock, player, stack);
                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(context);
    }

//    public boolean isPlantableGround(Level world, BlockPos pos) {
//        return (Blocks.SAPLING.canPlaceBlockOnSide(world, pos.up(), EnumFacing.UP)
//                || (world.getBlockState(pos).getMaterial() == Material.SAND
//                && world.getBlockState(pos).getBlock().isFullCube(world.getBlockState(pos))));
//    }
//
//    public boolean isPrehistoricGround(Block blockGround) {
////        if (blockGround == BlockPrehistoricGroundBasic.block
////                || blockGround == BlockPrehistoricGroundLush.block
////                || blockGround == BlockPrehistoricGroundSand.block
////                || blockGround == BlockPrehistoricGroundSandPangaean.block
////                || blockGround == BlockPrehistoricGroundSandRed.block
////                || blockGround == BlockPrehistoricGroundFern.block
////                || blockGround == BlockPrehistoricGroundMossy.block
////        ) {
////            return true;
////        }
//        return false;
//    }
}