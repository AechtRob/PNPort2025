package com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron;

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

public class DiaphorodendronTrunkPlacer extends TrunkPlacer {

    private LevelSimulatedReader levelSimulatedReader;
    private BiConsumer<BlockPos, BlockState> biConsumer;
    private RandomSource randomSource;
    private BlockPos pos;
    private TreeConfiguration treeConfiguration;


    public DiaphorodendronTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
        super(p_70268_, p_70269_, p_70270_);
    }

    public static final MapCodec<TrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec((instance) ->
                    trunkPlacerParts(instance).apply(instance, DiaphorodendronTrunkPlacer::new));

    protected void setFoliage(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliagePlacer.FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        BlockPos pos = foliageAttachment.pos();
        if (PNTreeFeature.canLeavesReplaceBlock(treeConfiguration, random, levelSimulatedReader, pos)) {
            biConsumer.accept(pos, treeConfiguration.foliageProvider.getState(random, pos));
        }
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return PNTrunkPlacerType.DIAPHORODENDRON_TRUNK_PLACER.get();
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
        BlockState logState = BlocksTreeDiaphorodendron.DIAPHORODENDRON_LOG.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS,Direction.Axis.Y);
        BlockState woodState = BlocksTreeDiaphorodendron.DIAPHORODENDRON_WOOD.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS,Direction.Axis.Y);

        placeLog(pos, logState);
        placeLog(pos.south(), logState);
        placeLog(pos.south(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.north(), logState);
        placeLog(pos.north(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.east(), logState);
        placeLog(pos.east(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.west(), logState);
        placeLog(pos.west(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.east().above(), woodState);
        placeLog(pos.east().above(2), woodState);
        placeLog(pos.west().above(), woodState);
        placeLog(pos.west().above(2), woodState);
        placeLog(pos.south().above(), woodState);
        placeLog(pos.south().above(2), woodState);
        placeLog(pos.north().above(), woodState);
        placeLog(pos.north().above(2), woodState);

        height = placeTrunk(pos, logState, height);
        height = height + 1;

        //crown
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, -3), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height - 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height - 1, 0), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height - 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height - 1, 0), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height - 1, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height - 1, 3), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height - 1, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height - 1, -3), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height - 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height - 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height - 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height - 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height - 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height - 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height - 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height - 2, -1), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height - 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height - 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height - 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height - 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height - 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height - 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height - 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height - 3, -1), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height - 3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height - 3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height - 3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height - 3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height - 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height - 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height - 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height - 3, -1), 0, true));


        int yy;
        //North
        if (Math.random() >= 0.75) {
            //Drop the branch a row
            yy = (int) height - 4;
            placeLog(pos.north().above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.north(2).above(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));

            //Foliage:
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -3), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -4), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -5), 0, true));
            yy = (int) height - 5;
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -5), 0, true));

            //Strobili:
            placeRandomFoliage(pos.offset(0, height - 6, -5),0.4, 1, list);

        }
        else {
            yy = (int) height - 3;
            placeLog(pos.north().above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.north(2).above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));

            //Foliage:
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -3), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -4), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -5), 0, true));
            yy = (int) height - 4;
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, -5), 0, true));

            //Strobili:
            placeRandomFoliage(pos.offset(0, height - 5, -5),0.4, 1, list);

        }

        //South
        if (Math.random() >= 0.75) {
            //Drop the branch a row
            yy = (int) height - 4;
            placeLog(pos.south().above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.south(2).above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));

            //Foliage:
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 3), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 4), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 5), 0, true));
            yy = (int) height - 5;
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 5), 0, true));

            //Strobili:
            placeRandomFoliage(pos.offset(0, height - 6, 5),0.4, 1, list);

        }
        else {
            yy = (int) height - 3;
            placeLog(pos.south().above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.south(2).above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));

            //Foliage:
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 3), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 4), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 5), 0, true));
            yy = (int) height - 4;
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 5), 0, true));

            //Strobili:
            placeRandomFoliage(pos.offset(0, height - 5, 5),0.4, 1, list);

        }

        //East
        if (Math.random() >= 0.75) {
            //Drop the branch a row
            yy = (int) height - 4;
            placeLog(pos.east().above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.east(2).above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));

            //Foliage:
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, yy, 0), 0, true));
            yy = (int) height - 5;
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, yy, 0), 0, true));

            //Strobili:
            placeRandomFoliage(pos.offset(5, height - 6, 0),0.4, 1, list);

        }
        else {
            yy = (int) height - 3;
            placeLog(pos.east().above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.east(2).above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));

            //Foliage:
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, yy, 0), 0, true));
            yy = (int) height - 4;
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, yy, 0), 0, true));

            //Strobili:
            placeRandomFoliage(pos.offset(5, height - 5, 0),0.4, 1, list);

        }

        //West
        if (Math.random() >= 0.75) {
            //Drop the branch a row
            yy = (int) height - 4;
            placeLog(pos.west().above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.west(2).above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));

            //Foliage:
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, yy, 0), 0, true));
            yy = (int) height - 5;
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, yy, 0), 0, true));

            //Strobili:
            placeRandomFoliage(pos.offset(-5, height - 6, 0),0.4, 1, list);

        }
        else {
            yy = (int) height - 3;
            placeLog(pos.west().above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.west(2).above(yy), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));

            //Foliage:
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, yy, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, yy, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, yy, 0), 0, true));
            yy = (int) height - 4;
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, yy, 0), 0, true));

            //Strobili:
            placeRandomFoliage(pos.offset(-5, height - 5, 0),0.4, 1, list);

        }

        //Strobili:
        placeRandomFoliage(pos.offset(3, height - 2, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(-3, height - 2, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height - 2, 3),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height - 2, -3),0.4, 1, list);
        
        return list;
    }

    private void placeLog(BlockPos pos, BlockState logState) {
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos)) {
            biConsumer.accept(pos, logState);
            placeLog(levelSimulatedReader, biConsumer, randomSource, pos, treeConfiguration);
        }
    }

    public int placeTrunk(BlockPos pos, BlockState logState, int height){
        height = 18;
        height = height + (int) Math.round((Math.random() * 100D) / 8D);
        int counter = 0;
        while (counter <= height - 1) {
            placeLog(pos.above(1 + counter), logState);
            counter += 1;
        }
        return height;
    }
}