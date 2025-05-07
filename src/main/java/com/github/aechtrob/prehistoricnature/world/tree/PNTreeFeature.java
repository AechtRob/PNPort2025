package com.github.aechtrob.prehistoricnature.world.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class PNTreeFeature extends TreeFeature {
    public PNTreeFeature(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }

    public static boolean canLogReplaceBlock(LevelSimulatedReader level, BlockPos pos) {
        boolean flag = level.isStateAtPosition(pos, (p_372791_) -> (Boolean)p_372791_.getValueOrElse(BlockStateProperties.PERSISTENT, false));
        if (!flag) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean canLeavesReplaceBlock(LevelSimulatedReader level, BlockPos pos) {
        boolean flag = level.isStateAtPosition(pos, (p_372791_) -> (Boolean)p_372791_.getValueOrElse(BlockStateProperties.PERSISTENT, false));
        if (!flag) {
            return true;
        } else {
            return false;
        }
    }
}
