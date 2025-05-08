package com.github.aechtrob.prehistoricnature.world.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class PNTreeFeature extends TreeFeature {
    public PNTreeFeature(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }

    public static boolean canLogReplaceBlock(LevelSimulatedReader level, BlockPos pos) {
        return level.isStateAtPosition(pos, (state) -> state.isAir() || state.is(BlockTags.REPLACEABLE_BY_TREES));
    }

    public static boolean canLeavesReplaceBlock(LevelSimulatedReader level, BlockPos pos) {
        return level.isStateAtPosition(pos, (state) -> state.isAir() || state.is(BlockTags.REPLACEABLE_BY_TREES));
    }
}
