package com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ModTrimmableBlockEntity extends BlockEntity {
    private int variant;

    public ModTrimmableBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.PN_TRIMMABLE.get(), pos, blockState);
    }

    public ModTrimmableBlockEntity(BlockEntityType<?> entity, BlockPos pos, BlockState blockState) {
        super(entity, pos, blockState);
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

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity) {
        if (level instanceof ServerLevel) {
            List<Entity> Entities = level.getEntities(null, new AABB(blockPos));
            for (Entity currentEntity : Entities) {
                //Check it's inside the bin, and if so, kill it:
                if (currentEntity instanceof ItemEntity) {
                    double xx = currentEntity.getX() - currentEntity.blockPosition().getX();
                    double yy = currentEntity.getY() - currentEntity.blockPosition().getY();
                    double zz = currentEntity.getZ() - currentEntity.blockPosition().getZ();
                    if (xx > 0.1 && xx < 0.9 && !((ItemEntity)currentEntity).hasPickUpDelay()) {
                        if (zz > 0.1 && zz < 0.9) {
                            if (yy <= 0.2) {
                                currentEntity.kill((ServerLevel)level);
                            }
                        }
                    }
                }
            }
        }
    }
}
