package com.github.aechtrob.prehistoricnature.world.tree.sciadopitys;

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

import static com.github.aechtrob.prehistoricnature.world.tree.PNTreeFeature.placeRandomFoliage;
import static com.github.aechtrob.prehistoricnature.world.tree.PNTreeFeature.placeRandomFoliageAroundLog;

public class SciadopitysTrunkPlacer extends TrunkPlacer {

    private LevelSimulatedReader levelSimulatedReader;
    private BiConsumer<BlockPos, BlockState> biConsumer;
    private RandomSource randomSource;
    private BlockPos pos;
    private TreeConfiguration treeConfiguration;


    public SciadopitysTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
        super(p_70268_, p_70269_, p_70270_);
    }

    public static final MapCodec<TrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec((instance) ->
                    trunkPlacerParts(instance).apply(instance, SciadopitysTrunkPlacer::new));

    protected void setFoliage(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliagePlacer.FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        BlockPos pos = foliageAttachment.pos();
        if (PNTreeFeature.canLeavesReplaceBlock(treeConfiguration, random, levelSimulatedReader, pos)) {
            biConsumer.accept(pos, treeConfiguration.foliageProvider.getState(random, pos));
        }
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return PNTrunkPlacerType.SCIADOPITYS_TRUNK_PLACER.get();
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
        BlockState logState = BlocksTreeSciadopitys.SCIADOPITYS_LOG.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS,Direction.Axis.Y);
        BlockState woodState = BlocksTreeSciadopitys.SCIADOPITYS_WOOD.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS,Direction.Axis.Y);

        placeLog(pos, logState);

        height = placeTrunk(pos, logState, height);

        int counterbase = 0;
        if (Math.random() > 0.3) counterbase = 1;

        placeLog(pos.offset(0, counterbase, 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, counterbase, -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(1, counterbase, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-1, counterbase, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(0, (int) (counterbase + 2), 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, (int) (counterbase + 2), -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(1, (int) (counterbase + 2), 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-1, (int) (counterbase + 2), 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(0, (int) (counterbase + 4), 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, (int) (counterbase + 4), -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(1, (int) (counterbase + 4), 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-1, (int) (counterbase + 4), 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));

        placeLog(pos.offset(0, counterbase, 2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, counterbase, -2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(2, counterbase, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-2, counterbase, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(0, (int) (counterbase + 2), 2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, (int) (counterbase + 2), -2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(2, (int) (counterbase + 2), 0),  logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-2, (int) (counterbase + 2), 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(0, (int) (counterbase + 4), 2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, (int) (counterbase + 4), -2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(2, (int) (counterbase + 4), 0),  logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-2, (int) (counterbase + 4), 0),  logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));


        if (height > 14) {
            placeLog(pos.offset(0, (int) (counterbase + 6), 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(0, (int) (counterbase + 6), - 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(1, (int) (counterbase + 6), 0),  logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.offset(- 1, (int) (counterbase + 6), 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        }
        if (height > 16) {
            placeLog(pos.offset(0, (int) (counterbase + 8), 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(0, (int) (counterbase + 8), - 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(1, (int) (counterbase + 8), 0),  logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.offset(- 1, (int) (counterbase + 8), 0),  logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        }
        if (height > 18) {
            placeLog(pos.offset(0, (int) (counterbase + 10), 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(0, (int) (counterbase + 10), -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(1, (int) (counterbase + 10), 0),  logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.offset(- 1, (int) (counterbase + 10), 0),  logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        }

        
        //Leaves:
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, 0), 0, true));

        int counter = 0;
        //Easy, neat and tidy design in 5 variant layers:
        while (counter <= (double) ((height - counterbase) * 0.2)) {
            int yy = pos.getY() + (int) counter + (int) counterbase;
            int xct = -3;
            while (xct <=3) {
                int zct = -3;
                while (zct <=3) {
                    if ((Math.abs(xct) + Math.abs(zct)) <= 5) {
                        placeRandomFoliageAroundLog(new BlockPos(pos.getX() + xct, yy + 1, pos.getZ() + zct), 1, 0.1, 0, list);
                    }
                    zct = zct + 1;
                }
                xct = xct + 1;
            }
            counter = counter + 1;
        }
        while (counter <= (double) ((height - counterbase) * 0.4)) {
            int yy = pos.getY() + (int) counter + (int) counterbase;
            int xct = -3;
            while (xct <=3) {
                int zct = -3;
                while (zct <=3) {
                    if ((Math.abs(xct) + Math.abs(zct)) <= 4) {
                        placeRandomFoliageAroundLog(new BlockPos(pos.getX() + xct, yy + 1, pos.getZ() + zct), 1, 0.1, 0, list);
                    }
                    zct = zct + 1;
                }
                xct = xct + 1;
            }
            counter = counter + 1;
        }
        while (counter <= (double) ((height - counterbase) * 0.6)) {
            int yy = pos.getY() + (int) counter + (int) counterbase;
            int xct = -3;
            while (xct <=3) {
                int zct = -3;
                while (zct <=3) {
                    if ((Math.abs(xct) + Math.abs(zct)) <= 3) {
                        placeRandomFoliageAroundLog(new BlockPos(pos.getX() + xct, yy + 1, pos.getZ() + zct), 1, 0.1, 0, list);
                    }
                    zct = zct + 1;
                }
                xct = xct + 1;
            }
            counter = counter + 1;
        }
        while (counter <= (double) ((height - counterbase) * 0.8)) {
            int yy = pos.getY() + (int) counter + (int) counterbase;
            int xct = -3;
            while (xct <=3) {
                int zct = -3;
                while (zct <=3) {
                    if ((Math.abs(xct) + Math.abs(zct)) <= 2) {
                        placeRandomFoliageAroundLog(new BlockPos(pos.getX() + xct, yy + 1, pos.getZ() + zct), 1, 0.1, 0, list);
                    }
                    zct = zct + 1;
                }
                xct = xct + 1;
            }
            counter = counter + 1;
        }
        while (counter <= (double) (height - counterbase)) {
            int yy = pos.getY() + (int) counter + (int) counterbase;
            int xct = -3;
            while (xct <=3) {
                int zct = -3;
                while (zct <=3) {
                    if ((Math.abs(xct) + Math.abs(zct)) <= 1) {
                        placeRandomFoliageAroundLog(new BlockPos(pos.getX() + xct, yy + 1, pos.getZ() + zct), 1, 0.1, 0, list);
                    }
                    zct = zct + 1;
                }
                xct = xct + 1;
            }
            counter = counter + 1;
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
        height = 8;
        if (Math.random() > 0.4) {
            height = height + (int)(Math.random() * 5);
        }
        if (Math.random() > 0.4) {
            height = height + (int)(Math.random() * 5);
        }
        int counter = 0;
        while (counter <= height) {
            placeLog(pos.above(1 + counter), logState);
            counter += 1;
        }
        return height;
    }
}