package com.github.aechtrob.prehistoricnature.world.tree.pitys;

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

public class PitysTrunkPlacer extends TrunkPlacer {

    private LevelSimulatedReader levelSimulatedReader;
    private BiConsumer<BlockPos, BlockState> biConsumer;
    private RandomSource randomSource;
    private BlockPos pos;
    private TreeConfiguration treeConfiguration;


    public PitysTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
        super(p_70268_, p_70269_, p_70270_);
    }

    public static final MapCodec<TrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec((instance) ->
                    trunkPlacerParts(instance).apply(instance, PitysTrunkPlacer::new));

    protected void setFoliage(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliagePlacer.FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        BlockPos pos = foliageAttachment.pos();
        if (PNTreeFeature.canLeavesReplaceBlock(treeConfiguration, random, levelSimulatedReader, pos)) {
            biConsumer.accept(pos, treeConfiguration.foliageProvider.getState(random, pos));
        }
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return PNTrunkPlacerType.PITYS_TRUNK_PLACER.get();
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
        int counter = 0;
        int yy;
        int height = 0;
        BlockState logState = BlocksTreePitys.PITYS_LOG.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS, Direction.Axis.Y);
        BlockState woodState = BlocksTreePitys.PITYS_WOOD.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS, Direction.Axis.Y);

        placeLog(pos, logState);

        height = placeTrunk(pos, logState, height);

        yy = height + counter ;


        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy + 1, 0), 0, true));


        yy = yy -1 ;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, yy, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -2), 0, true));


        yy = yy - 1;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, yy, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -2), 0, true));
        placeRandomFoliage(pos.offset(2, yy -  1, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, yy - 1, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, yy - 1, 2),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, yy - 1, -2),0.4, 1, list);


        yy = yy - 1;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 0), 0, true));

        yy = yy - 1;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 0), 0, true));

        yy = yy - 1;
        placeLog(pos.offset(0, yy, 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        //setShootSouth
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , + 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , + 2), 0, true));
        placeRandomFoliage(pos.offset(+1, yy -1, + 2),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , + 2), 0, true));
        placeRandomFoliage(pos.offset(-1, yy -1, + 2),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy  , +3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy -1 , +3), 0, true));
        placeRandomFoliage(pos.offset(0, yy -2, +3),0.4, 1, list);


        yy = yy - 1;
        placeLog(pos.offset(-1, yy, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy +1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy - 1, 0), 0, true));
//setShootWest
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(- 2, yy , 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(- 2, yy , +1), 0, true));
        placeRandomFoliage(pos.offset(- 2, yy -1, +1),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(- 2, yy , -1), 0, true));
        placeRandomFoliage(pos.offset(- 2, yy -1, -1),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, yy  , 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, yy -1 , 0), 0, true));
        placeRandomFoliage(pos.offset(-3, yy -2, 0),0.4, 1, list);


        yy = yy - 1;
        placeLog(pos.offset(0, yy, -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy -1, -1), 0, true));
        //setShootNorth
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , - 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , - 2), 0, true));
        placeRandomFoliage(pos.offset(+1, yy -1, - 2),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , - 2), 0, true));
        placeRandomFoliage(pos.offset(-1, yy -1, - 2),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy  , -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy -1 , -3), 0, true));
        placeRandomFoliage(pos.offset(0, yy -2, -3),0.4, 1, list);


        yy = yy - 1;
        placeLog(pos.offset(+1, yy, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy -1, 0), 0, true));
        //setShootEast
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy , 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy , +1), 0, true));
        placeRandomFoliage(pos.offset(2, yy -1, +1),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy , -1), 0, true));
        placeRandomFoliage(pos.offset(2, yy -1, -1),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+3, yy  , 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+3, yy -1 , 0), 0, true));
        placeRandomFoliage(pos.offset(+3, yy -2, 0),0.4, 1, list);


        yy = yy - 1;
        placeLog(pos.offset(0, yy, + 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy -1, + 1), 0, true));
        //setShootSouth
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , + 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , + 2), 0, true));
        placeRandomFoliage(pos.offset(+1, yy -1, + 2),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , + 2), 0, true));
        placeRandomFoliage(pos.offset(-1, yy -1, + 2),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy  , +3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy -1 , +3), 0, true));
        placeRandomFoliage(pos.offset(0, yy -2, +3),0.4, 1, list);


        yy = yy - 1;
        placeLog(pos.offset(-1, yy, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-2, yy, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, yy , 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy +1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy -1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , +1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , -1), 0, true));
//setShootWest
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(- 3, yy , 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(- 3, yy , +1), 0, true));
        placeRandomFoliage(pos.offset(- 3, yy -1, +1),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(- 3, yy , -1), 0, true));
        placeRandomFoliage(pos.offset(- 3, yy -1, -1),0.4, 1, list);
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, yy  , 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, yy -1 , 0), 0, true));
        placeRandomFoliage(pos.offset(-4, yy -2, 0),0.4, 1, list);

        if (Math.random() > 0.15) {
            yy = yy - 1;
            placeLog(pos.offset(0, yy, -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(0, yy, -2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy +1, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy -1, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , -1), 0, true));
            //setShootNorth
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , - 3), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , - 3), 0, true));
            placeRandomFoliage(pos.offset(+1, yy -1, - 3),0.4, 1, list);
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , - 3), 0, true));
            placeRandomFoliage(pos.offset(-1, yy -1, - 3),0.4, 1, list);
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy  , -4), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy -1 , -4), 0, true));
            placeRandomFoliage(pos.offset(0, yy -2, -4),0.4, 1, list);
            if (Math.random() > 0.15) {
                yy = yy - 1;
                placeLog(pos.offset(+1, yy, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
                placeLog(pos.offset(+2, yy, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , 0), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+2, yy , 0), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy +1, 0), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy -1, 0), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , +1), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , -1), 0, true));
                //setShootEast
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, yy , 0), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, yy , +1), 0, true));
                placeRandomFoliage(pos.offset(3, yy -1, +1),0.4, 1, list);
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, yy , -1), 0, true));
                placeRandomFoliage(pos.offset(3, yy -1, -1),0.4, 1, list);
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+4, yy  , 0), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+4, yy -1 , 0), 0, true));
                placeRandomFoliage(pos.offset(+4, yy -2, 0),0.4, 1, list);
                if (Math.random() > 0.15) {
                    yy = yy - 1;

                    placeLog(pos.offset(0, yy, +1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
                    placeLog(pos.offset(0, yy, +2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , -1), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , -2), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy +1, +1), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy -1, +1), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , +1), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , +1), 0, true));
                    //setShootSouth
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , + 3), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(+1, yy , + 3), 0, true));
                    placeRandomFoliage(pos.offset(+1, yy -1, + 3),0.4, 1, list);
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy , + 3), 0, true));
                    placeRandomFoliage(pos.offset(-1, yy -1, + 3),0.4, 1, list);
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy  , +4), 0, true));
                    list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy -1 , +4), 0, true));
                    placeRandomFoliage(pos.offset(0, yy -2, +4),0.4, 1, list);
                }
            }
        }

        return list;
    }

    private void placeLog(BlockPos pos, BlockState logState) {
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos)) {
            biConsumer.accept(pos, logState);
            placeLog(levelSimulatedReader, biConsumer, randomSource, pos, treeConfiguration);
        }
    }


        public int placeTrunk (BlockPos pos, BlockState logState,int height){
            height += (int) ((18D) + Math.round((Math.random() * 10D) / 2D) + Math.round((Math.random() * 10D) / 2D)
                    + Math.round((Math.random() * 10D) / 2D) + 6D);
            int counter = 0;
            while (counter <= height - 1) {
                placeLog(pos.above(1 + counter), logState);
                counter += 1;
            }
            return height;
        }
    }
