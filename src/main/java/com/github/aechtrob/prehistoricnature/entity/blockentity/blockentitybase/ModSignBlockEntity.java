package com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.PN_SIGN.get(), pos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.PN_SIGN.get();
    }
}
