package com.github.aechtrob.prehistoricnature.world.tree.bothrodendron;

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

public class BothrodendronTrunkPlacer extends TrunkPlacer {

    private LevelSimulatedReader levelSimulatedReader;
    private BiConsumer<BlockPos, BlockState> biConsumer;
    private RandomSource randomSource;
    private BlockPos pos;
    private TreeConfiguration treeConfiguration;


    public BothrodendronTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
        super(p_70268_, p_70269_, p_70270_);
    }

    public static final MapCodec<TrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec((instance) ->
                    trunkPlacerParts(instance).apply(instance, BothrodendronTrunkPlacer::new));

    protected void setFoliage(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliagePlacer.FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        BlockPos pos = foliageAttachment.pos();
        if (PNTreeFeature.canLeavesReplaceBlock(treeConfiguration, random, levelSimulatedReader, pos)) {
            biConsumer.accept(pos, treeConfiguration.foliageProvider.getState(random, pos));
        }
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return PNTrunkPlacerType.BOTHRODENDRON_TRUNK_PLACER.get();
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
        BlockState logState = BlocksTreeBothrodendron.BOTHRODENDRON_LOG.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS,Direction.Axis.Y);
        BlockState woodState = BlocksTreeBothrodendron.BOTHRODENDRON_WOOD.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS,Direction.Axis.Y);

        placeLog(pos, logState);
        placeLog(pos.south(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.south(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.north(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.north(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.east(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.east(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.west(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.west(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));

        height = placeTrunk(pos, logState, height);
        height = height + 1;

        int LeafHeight = 6;
        LeafHeight = LeafHeight + (int) Math.round((Math.random() * 100) / 20);
        if (LeafHeight >= height - 5) {
            LeafHeight = height / 3;
        }

        //crown
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 0), 0, true));
        if (Math.random() >= 0.5) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height, 0), 0, true));
        }
        if (Math.random() >= 0.5) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height, 0), 0, true));
        }
        if (Math.random() >= 0.5) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, 1), 0, true));
        }
        if (Math.random() >= 0.5) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, -1), 0, true));
        }


        int counter = height - 1;
        while (counter > (height - LeafHeight)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, counter, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, counter, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, counter, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, counter, -1), 0, true));
            counter = counter - 1;
        }

        if (Math.random() > 0.5) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, counter, 0), 0, true));
            placeRandomFoliage(pos.offset(1, counter - 1, 0),0.4, 1, list);
        }
        else {
            placeRandomFoliage(pos.offset(1, counter, 1),0.4, 1, list);
        }

        if (Math.random() > 0.5) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, counter, 0), 0, true));
            placeRandomFoliage(pos.offset(-1, counter - 1, 0),0.4, 1, list);
        }
        else {
            placeRandomFoliage(pos.offset(-1, counter, 0),0.4, 1, list);
        }

        if (Math.random() > 0.5) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, counter, 1), 0, true));
            placeRandomFoliage(pos.offset(0, counter - 1, 1),0.4, 1, list);
        }
        else {
            placeRandomFoliage(pos.offset(0, counter, 1),0.4, 1, list);
        }

        if (Math.random() > 0.5) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, counter, -1), 0, true));
            placeRandomFoliage(pos.offset(0, counter - 1, 1),0.4, -1, list);
        }
        else {
            placeRandomFoliage(pos.offset(0, counter, 1),0.4, -1, list);
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
        height = 15;
        height = height + (int) Math.round((Math.random() * 100) / 10);
        int counter = 0;
        while (counter <= height - 1) {
            placeLog(pos.above(1 + counter), logState);
            counter += 1;
        }
        return height;
    }
}