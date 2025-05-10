package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.TrimHandler;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModTrimmableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public abstract class PNBaseTrimmableBlock extends BaseEntityBlock {

    public static final IntegerProperty VARIANT;

    public PNBaseTrimmableBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        InteractionResult trimResult  = TrimHandler.applyTrim(stack, state, level, pos, player, hand, hitResult);
        if (trimResult == InteractionResult.SUCCESS) {
            return trimResult;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModTrimmableBlockEntity(pos, state);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        if (!level.isClientSide() && !player.isCreative()) {
            int variant = 0;
            if (blockEntity != null) {
                if (blockEntity instanceof ModTrimmableBlockEntity) {
                    variant = ((ModTrimmableBlockEntity) blockEntity).getVariant();
                }
            }
            if (variant > 0) {
                ItemEntity entityToSpawn = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), TrimHandler.getItemToDrop(variant));
                entityToSpawn.setDefaultPickUpDelay();
                level.addFreshEntity(entityToSpawn);
            }

            super.playerDestroy(level, player, pos, state, blockEntity, tool);
        }
    }

    static {
        VARIANT = IntegerProperty.create("variant", 0, 15);
    }

}
