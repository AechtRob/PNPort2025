package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.PrehistoricNatureConfig;
import com.github.aechtrob.prehistoricnature.block.interfaces.IEnvelopable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.UntintedParticleLeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;

import java.util.Collections;
import java.util.List;

public class PNTreeLeavesBlock extends UntintedParticleLeavesBlock implements IEnvelopable {

    public PNTreeLeavesBlock(float leafParticleChance, ParticleOptions leafParticle, Properties properties) {
        super(leafParticleChance, leafParticle, properties);
    }

    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        if (PrehistoricNatureConfig.doPropagation) {
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

    @Override
    public ItemStack envelopeMimicsItemPlacement() {
        return ItemStack.EMPTY;
    }
}
