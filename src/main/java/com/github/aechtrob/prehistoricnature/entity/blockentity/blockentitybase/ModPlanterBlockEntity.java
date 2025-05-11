package com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ModPlanterBlockEntity extends ModTrimmableBlockEntity {
    private int soil;

    public ModPlanterBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.PN_PLANTER.get(), pos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.PN_PLANTER.get();
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.soil = tag.getInt("soil");
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("soil", this.soil);
    }

    public int getSoil() {
        return this.soil;
    }

    public void setSoil(int var) {
        this.soil = var;
    }

}
