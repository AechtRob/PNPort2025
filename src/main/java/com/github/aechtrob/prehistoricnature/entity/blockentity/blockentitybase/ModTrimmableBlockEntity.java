package com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ModTrimmableBlockEntity extends BlockEntity {
    private int variant;

    public ModTrimmableBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.PN_TRIMMABLE.get(), pos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.PN_TRIMMABLE.get();
    }

    // Read values from the passed CompoundTag here.
    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        // Will default to 0 if absent. See the NBT article for more information.
        this.variant = tag.getInt("variant").get();
    }

    // Save values into the passed CompoundTag here.
    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("variant", this.variant);
    }

    public int getVariant() {
        return this.variant;
    }

    public void setVariant(int var) {
        this.variant = var;
    }


}
