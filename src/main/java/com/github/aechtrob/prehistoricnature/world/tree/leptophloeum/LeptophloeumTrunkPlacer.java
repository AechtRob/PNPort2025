package com.github.aechtrob.prehistoricnature.world.tree.leptophloeum;

import com.github.aechtrob.prehistoricnature.block.blockbase.PNTreeLogBlock;
import com.github.aechtrob.prehistoricnature.world.tree.PNTreeFeature;
import com.github.aechtrob.prehistoricnature.world.tree.PNTrunkPlacerType;
import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;


public class LeptophloeumTrunkPlacer extends TrunkPlacer {

    private LevelSimulatedReader levelSimulatedReader;
    private BiConsumer<BlockPos, BlockState> biConsumer;
    private RandomSource randomSource;
    private BlockPos pos;
    private TreeConfiguration treeConfiguration;


    public LeptophloeumTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
        super(p_70268_, p_70269_, p_70270_);
    }

    public static final MapCodec<TrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec((instance) ->
                    trunkPlacerParts(instance).apply(instance, LeptophloeumTrunkPlacer::new));

    protected void setFoliage(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliagePlacer.FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        BlockPos pos = foliageAttachment.pos();
        if (PNTreeFeature.canLeavesReplaceBlock(treeConfiguration, random, levelSimulatedReader, pos)) {
            biConsumer.accept(pos, treeConfiguration.foliageProvider.getState(random, pos));
        }
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return PNTrunkPlacerType.LEPTOPHLOEUM_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer,
                                                            RandomSource random, int p_161871_, BlockPos pos, TreeConfiguration treeConfiguration) {
        this.levelSimulatedReader = levelSimulatedReader;
        this.biConsumer = biConsumer;
        this.randomSource = random;
        this.pos = pos;
        this.treeConfiguration = treeConfiguration;
        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
        int height = 0;
        int LeafHeight = 0;
        int counter = 0;
        BlockState logState = BlocksTreeLeptophloeum.LEPTOPHLOEUM_LOG.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS, Direction.Axis.Y);
        BlockState woodState = BlocksTreeLeptophloeum.LEPTOPHLOEUM_WOOD.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS, Direction.Axis.Y);

        placeLog(pos, logState);

        height = placeTrunk(pos, logState, height);
        LeafHeight = randomSource.nextInt(2) + 3;

        counter = 0;
        while (counter <= height) {
            if (counter > height * 0.65D) {
                int dir = randomSource.nextInt(4);
                BlockPos bp = pos.offset(0, counter, 0);
                if (counter == height - LeafHeight) {
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir)).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir)).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir)).getX(), pos.getY() + counter - 1, bp.relative(Direction.from2DDataValue(dir)).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir), 2).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir), 2).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir), 3).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir), 3).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir)).relative(Direction.from2DDataValue(dir).getClockWise()).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir)).relative(Direction.from2DDataValue(dir).getClockWise()).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir)).relative(Direction.from2DDataValue(dir).getCounterClockWise()).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir)).relative(Direction.from2DDataValue(dir).getCounterClockWise()).getZ()), 0, true));
                }
                if (counter == height - LeafHeight - 2 || counter == height - LeafHeight - 4) {
                    dir = randomSource.nextInt(4);
                    Direction.Axis logAxis = Direction.Axis.X;
                    if ((dir & 1) == 0) {
                        logAxis = Direction.Axis.Z;
                    }
                    placeLog(new BlockPos(bp.relative(Direction.from2DDataValue(dir)).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir)).getZ()), logState.setValue(PNTreeLogBlock.AXIS, logAxis));

                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir), 2).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir), 2).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir), 2).getX(), pos.getY() + counter - 1, bp.relative(Direction.from2DDataValue(dir), 2).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir), 3).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir), 3).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir), 4).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir), 4).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir), 2).relative(Direction.from2DDataValue(dir).getClockWise()).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir), 2).relative(Direction.from2DDataValue(dir).getClockWise()).getZ()), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(bp.relative(Direction.from2DDataValue(dir), 2).relative(Direction.from2DDataValue(dir).getCounterClockWise()).getX(), pos.getY() + counter, bp.relative(Direction.from2DDataValue(dir), 2).relative(Direction.from2DDataValue(dir).getCounterClockWise()).getZ()), 0, true));
                }
            }

            counter = counter + 1;
        }

        //Top of tree:
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, counter, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, counter + 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, counter + 1, 0), 0, true));

        for (int n = 0; n < LeafHeight; n++) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, counter - n, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, counter - n, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, counter +-n, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, counter - n, -1), 0, true));
        }

        return list;
    }

    private void placeLog(BlockPos pos, BlockState logState) {
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos)) {
            biConsumer.accept(pos, logState);
            placeLog(levelSimulatedReader, biConsumer, randomSource, pos, treeConfiguration);
        }
    }


    public int placeTrunk(BlockPos pos, BlockState logState, int height){
        height = 15 + randomSource.nextInt(7);
        int counter = 0;
        while (counter <= height - 1) {
            placeLog(pos.above(1 + counter), logState);
            counter += 1;
        }
        return height;
    }
}