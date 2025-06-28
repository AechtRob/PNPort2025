package com.github.aechtrob.prehistoricnature.world.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class PNTreeFeature extends TreeFeature {
    public PNTreeFeature(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }

    public static boolean canLogReplaceBlock(LevelSimulatedReader level, BlockPos pos) {
        return level.isStateAtPosition(pos, (state) -> {
            return state.isAir() || state.is(BlockTags.REPLACEABLE_BY_TREES);
        });
    }

    public static boolean canLeavesReplaceBlock(TreeConfiguration treeConfiguration, RandomSource random, LevelSimulatedReader level, BlockPos pos) {
        boolean flag = level.isStateAtPosition(pos, (p_372791_) -> {
            return (Boolean)p_372791_.getValueOrElse(BlockStateProperties.PERSISTENT, false);
        });
        if (!flag && TreeFeature.validTreePos(level, pos)) {
            BlockState blockstate = treeConfiguration.foliageProvider.getState(random, pos);
            if (blockstate.hasProperty(BlockStateProperties.WATERLOGGED)) {
                blockstate = (BlockState)blockstate.setValue(BlockStateProperties.WATERLOGGED, level.isFluidAtPosition(pos, (state) -> {
                    return state.isSourceOfType(Fluids.WATER);
                }));
            }
            return true;
        } else {
            return false;
        }
    }

    public static void placeRandomFoliage(BlockPos pos, double odds, int foliageId, List<FoliagePlacer.FoliageAttachment> list){
        if ((Math.random() > odds)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos, foliageId, true));
        }
    }

    public static void placeRandomFoliageAroundLog(BlockPos pos, int layers, double odds, int foliageId, List<FoliagePlacer.FoliageAttachment> list) {
        if (Math.random() > odds) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1,0,0), foliageId, true));
        }
        if (Math.random() > odds) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,0,0), foliageId, true));
        }
        if (Math.random() > odds) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1,0,0), foliageId, true));
        }

        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1,1,0), foliageId, true));
        }
        if (Math.random() > odds) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,1,0), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1,1,0), foliageId, true));
        }

        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1,-1,0), foliageId, true));
        }
        if (Math.random() > odds) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,-1,0), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1,-1,0), foliageId, true));
        }


        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1,0,-1), foliageId, true));
        }
        if (Math.random() > odds) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,0,-1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1,0,-1), foliageId, true));
        }

        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1,1,-1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,1,-1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1,1,-1), foliageId, true));
        }

        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1,-1,-1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,-1,-1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1,-1,-1), foliageId, true));
        }


        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1,0,1), foliageId, true));
        }
        if (Math.random() > odds) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,0,1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1,0,1), foliageId, true));
        }

        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1,1,1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,1,1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1,1,1), foliageId, true));
        }

        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1,-1,1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,-1,1), foliageId, true));
        }
        if ((Math.random() > odds) && (layers >= 2)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1,-1,1), foliageId, true));
        }

        //Second layer out, if needed:
        if (layers >= 2) {
            if (Math.random() > odds) {
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,0,20), foliageId, true));
            }
            if (Math.random() > odds) {
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,0,-2), foliageId, true));
            }
            if (Math.random() > odds) {
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2,0,0), foliageId, true));
            }
            if (Math.random() > odds) {
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2,0,0), foliageId, true));
            }
            if (Math.random() > odds) {
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,2,0), foliageId, true));
            }
            if (Math.random() > odds) {
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0,-2,0), foliageId, true));
            }
        }

    }
}
