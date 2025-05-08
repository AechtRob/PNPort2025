package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.PrehistoricNatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;

import java.util.Collections;
import java.util.List;

public class PNTreeLeavesBlock extends TintedParticleLeavesBlock {

    public PNTreeLeavesBlock(float leafParticleChance, Properties properties) {
        super(leafParticleChance, properties);
    }

    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        if (PrehistoricNatureConfig.doPropagation.getAsBoolean()) {
            return getPNModdedDrops();
        }
        return super.getDrops(state, params);
    }

    /**
    * Override this in various trees to provide modded seed or fruit drops etc.
    */
    public static List<ItemStack> getPNModdedDrops() {
        return Collections.emptyList();
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos blockPos, RandomSource randomSource) {

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
