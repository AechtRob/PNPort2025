package com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class ModPlanterBlockEntity extends ModTrimmableBlockEntity {
    private int soil;

    public ModPlanterBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.PN_PLANTER.get(), pos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.PN_PLANTER.get();
    }

    // Read values from the passed CompoundTag here.
    @Override
    public void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.soil = input.getInt("soil").get();
    }

    // Save values into the passed CompoundTag here.
    @Override
    public void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("soil", this.soil);
    }

    public int getSoil() {
        return this.soil;
    }

    public void setSoil(int var) {
        this.soil = var;
    }

}
