package com.github.aechtrob.prehistoricnature.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class Functions {

    public static boolean isWater(Level world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.is(Blocks.WATER)) {
            return true;
        }
        FluidState fluidState = world.getFluidState(pos);
        if (fluidState.is(Fluids.WATER)) {
            return true;
        }
        if (fluidState.getType() == Fluids.WATER) {
            return true;
        }
        if (fluidState.is(Fluids.FLOWING_WATER)) {
            return true;
        }
        if (fluidState.getType() == Fluids.FLOWING_WATER) {
            return true;
        }
        return false;
    }


}
