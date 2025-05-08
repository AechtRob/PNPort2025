package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.PrehistoricNatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class PNTreeLeavesBlock extends LeavesBlock {

    public PNTreeLeavesBlock(float leafParticleChance, Properties properties) {
        super(properties);
    }

    public static List<ItemStack> getDrops(BlockState state, ServerLevel levek, BlockPos pos, @Nullable BlockEntity blockEntity) {
        if (PrehistoricNatureConfig.doPropagation.get()) {
            return getPNModdedDrops();
        }
        LootParams.Builder lootparams$builder = (new LootParams.Builder(levek)).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).withParameter(LootContextParams.TOOL, ItemStack.EMPTY).withOptionalParameter(LootContextParams.BLOCK_ENTITY, blockEntity);
        return state.getDrops(lootparams$builder);
    }

    /**
    * Override this in various trees to provide modded seed or fruit drops etc.
    */
    public static List<ItemStack> getPNModdedDrops() {
        return Collections.emptyList();
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 20;
    }
}
