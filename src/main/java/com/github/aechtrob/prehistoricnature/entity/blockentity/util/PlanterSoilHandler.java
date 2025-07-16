package com.github.aechtrob.prehistoricnature.entity.blockentity.util;

import com.github.aechtrob.prehistoricnature.block.blockbase.PNPlanterBlock;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModPlanterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PlanterSoilHandler {
    //Soil values:
    //0. Dirt base
    //1. Sand

    public static int getSoilID(ItemStack itemStack) {
        int enumUsed = 0;
        if (itemStack.getItem() == Items.SAND) {
            enumUsed = 1;
        }
        return enumUsed;
    }

    public static ItemStack getItemToDrop(int soil) {
        ItemEntity entityToSpawn = null;
        if (soil == 1) {
            return new ItemStack(Blocks.SAND, (int) (1));
        } 
        return ItemStack.EMPTY;
    }

    public static InteractionResult applySoil(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (hand == InteractionHand.MAIN_HAND) {
                int enumUsed = PlanterSoilHandler.getSoilID(player.getItemInHand(hand));
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity != null) {
                    if (blockEntity instanceof ModPlanterBlockEntity) {
                        if (enumUsed > 0) {
                            if (((ModPlanterBlockEntity) blockEntity).getSoil() != enumUsed) {
                                ItemStack itemstack = player.getItemInHand(hand);
                                if (!player.isCreative()) {
                                    itemstack.shrink(1);
                                }
                                level.setBlock(pos, (BlockState) state.setValue(PNPlanterBlock.SOIL, enumUsed), 3);
                                ((ModPlanterBlockEntity) blockEntity).setSoil(enumUsed);
                                level.markAndNotifyBlock(pos, level.getChunkAt(pos), state, state, 3, 512);
                                return InteractionResult.SUCCESS;
                            }
                        }
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }
}

