package com.github.aechtrob.prehistoricnature.entity.block.blockentitybase;

import com.github.aechtrob.prehistoricnature.entity.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ModBenchEntity extends BlockEntity {
    public ModBenchEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.PN_BENCH.get(), pos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.PN_BENCH.get();
    }

}
