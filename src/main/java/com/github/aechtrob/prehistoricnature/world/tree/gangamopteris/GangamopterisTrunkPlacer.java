package com.github.aechtrob.prehistoricnature.world.tree.gangamopteris;

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

public class GangamopterisTrunkPlacer extends TrunkPlacer {

    private LevelSimulatedReader levelSimulatedReader;
    private BiConsumer<BlockPos, BlockState> biConsumer;
    private RandomSource randomSource;
    private BlockPos pos;
    private TreeConfiguration treeConfiguration;


    public GangamopterisTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
        super(p_70268_, p_70269_, p_70270_);
    }

    public static final MapCodec<TrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec((instance) ->
                    trunkPlacerParts(instance).apply(instance, GangamopterisTrunkPlacer::new));

    protected void setFoliage(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliagePlacer.FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        BlockPos pos = foliageAttachment.pos();
        if (PNTreeFeature.canLeavesReplaceBlock(treeConfiguration, random, levelSimulatedReader, pos)) {
            biConsumer.accept(pos, treeConfiguration.foliageProvider.getState(random, pos));
        }
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return PNTrunkPlacerType.GANGAMOPTERIS_TRUNK_PLACER.get();
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
        BlockState logState = BlocksTreeGangamopteris.GANGAMOPTERIS_LOG.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS,Direction.Axis.Y);
        BlockState woodState = BlocksTreeGangamopteris.GANGAMOPTERIS_WOOD.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS,Direction.Axis.Y);

        placeLog(pos, logState);
        placeLog(pos.above(), logState);
        placeLog(pos.south(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.north(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.east(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.west(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));

        height = placeTrunk(pos, logState, height);

        //crown
        placeLog(pos.offset(0, height + 2, 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 2, 2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 2, 3), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 2, 4), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 2, -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 2, -2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 2, -3), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 2, -4), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(1, height + 2, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(2, height + 2, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(3, height + 2, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(4, height + 2, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-1, height + 2, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-2, height + 2, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-3, height + 2, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-4, height + 2, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(0, height + 3, 0), logState);
        placeLog(pos.offset(0, height + 4, 0), logState);
        placeLog(pos.offset(0, height + 5, 0), logState);
        placeLog(pos.offset(0, height + 5, 0), logState);
        placeLog(pos.offset(0, height + 5, 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 5, 2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 5, 3), woodState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 5, -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 5, -2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 5, -3), woodState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(1, height + 5, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(2, height + 5, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(3, height + 5, 0), woodState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-1, height + 5, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-2, height + 5, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-3, height + 5, 0), woodState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(0, height + 6, 0), logState);
        placeLog(pos.offset(3, height + 6, 0), woodState);
        placeLog(pos.offset(-3, height + 6, 0), woodState);
        placeLog(pos.offset(0, height + 6, 3), woodState);
        placeLog(pos.offset(0, height + 6, -3), woodState);
        placeLog(pos.offset(4, height + 6, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-4, height + 6, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(0, height + 6, 4), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 6, -4), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 7, 0), logState);
        placeLog(pos.offset(0, height + 8, 0), logState);
        placeLog(pos.offset(0, height + 8, 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 8, 2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 8, -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 8, -2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(1, height + 8, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(2, height + 8, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-1, height + 8, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-2, height + 8, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(0, height + 9, 0), logState);
        placeLog(pos.offset(0, height + 10, 0), logState);
        placeLog(pos.offset(0, height + 11, 0), logState);
        placeLog(pos.offset(1, height + 11, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(-1, height + 11, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.offset(0, height + 11, 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 11, -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.offset(0, height + 12, 0), logState);
        placeLog(pos.offset(0, height + 13, 0), logState);
        placeLog(pos.offset(0, height + 14, 0), logState);
        placeLog(pos.offset(0, height + 15, 0), logState);






        //Leaves:
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, 5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, -5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, 5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, -5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 2, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 2, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 2, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 2, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 4, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 4, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 4, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 4, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(6, height + 4, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-6, height + 4, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, 6), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, -6), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(6, height + 5, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-6, height + 5, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, 6), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, -6), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 5, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 5, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 5, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 5, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 5, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 5, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 5, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 5, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 5, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 5, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 5, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 5, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, 5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, -5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 6, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 6, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 6, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 6, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 6, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 6, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, 5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, -5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 6, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height +6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 6, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 6, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 6, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 6, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 6, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 6, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 6, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 6, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 6, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 6, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 6, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 6, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 6, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 7, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 7, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 7, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 7, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 7, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 7, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 7, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 7, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 7, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 7, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 7, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 7, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 7, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 7, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 7, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 7, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 8, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 8, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 8, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 8, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 8, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 8, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 8, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 8, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 8, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 8, 2), 0, true));;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 8, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 8, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 8, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 8, 2), 0, true));;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 8, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 8, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 8, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 8, 1), 0, true));;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 8, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 8, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 9, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 9, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 9, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 9, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 9, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 9, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 9, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 9, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 9, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 9, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 9, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 9, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 10, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 10, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 10, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 10, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 10, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 10, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 10, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 10, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 11, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 11, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 11, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 11, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 11, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 11, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 11, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 11, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 11, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 11, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 11, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 11, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 11, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 11, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 11, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 11, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 11, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 11, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 11, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 11, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 11, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 11, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 11, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 12, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 12, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 12, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 12, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 13, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 13, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 13, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 13, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 13, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 13, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 13, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 13, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 13, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 13, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 13, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 13, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 14, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 14, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 14, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 14, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 15, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 15, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 15, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 15, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 16, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 17, 0), 0, true));





        //Strobili:
        placeRandomFoliage(pos.offset(0, height , -5),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height ,  5),0.4, 1, list);
        placeRandomFoliage(pos.offset(-5,height , 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(5, height , 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 1, -4),0.4, 1, list);
        placeRandomFoliage(pos.offset(-1, height + 1, -4),0.4, 1, list);
        placeRandomFoliage(pos.offset(-1, height + 1,  4),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 1,  4),0.4, 1, list);
        placeRandomFoliage(pos.offset(-4,height + 1, 1),0.4, 1, list);
        placeRandomFoliage(pos.offset(4, height + 1, -1),0.4, 1, list);
        placeRandomFoliage(pos.offset(-4,height + 1, -1),0.4, 1, list);
        placeRandomFoliage(pos.offset(4, height + 1, 1),0.4, 1, list);
        placeRandomFoliage(pos.offset(2, height + 1, -3),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, height + 1,  3),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, height + 1, -3),0.4, 1, list);
        placeRandomFoliage(pos.offset(2, height + 1,  3),0.4, 1, list);
        placeRandomFoliage(pos.offset(3, height + 1, -2),0.4, 1, list);
        placeRandomFoliage(pos.offset(-3, height + 1,  2),0.4, 1, list);
        placeRandomFoliage(pos.offset(-3, height + 1, -2),0.4, 1, list);
        placeRandomFoliage(pos.offset(3, height + 1,  2),0.4, 1, list);
        placeRandomFoliage(pos.offset(6, height + 3, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 3,  6),0.4, 1, list);
        placeRandomFoliage(pos.offset(-6, height + 3, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 3,  -6),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 4, 4),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 4,  5),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 4, -4),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 4,  -5),0.4, 1, list);
        placeRandomFoliage(pos.offset(4, height + 4, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(5, height + 4,  0),0.4, 1, list);
        placeRandomFoliage(pos.offset(-4, height + 4, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(-5, height + 4,  0),0.4, 1, list);
        placeRandomFoliage(pos.offset(2, height + 6,  2),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, height + 6,  2),0.4, 1, list);
        placeRandomFoliage(pos.offset(2, height + 6,  -2),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, height + 6,  2),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 7,  2),0.4, 1, list);
        placeRandomFoliage(pos.offset(-1, height + 7,  2),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 7,  -2),0.4, 1, list);
        placeRandomFoliage(pos.offset(-1, height + 7,  2),0.4, 1, list);
        placeRandomFoliage(pos.offset(2, height + 7,  1),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, height + 7,  1),0.4, 1, list);
        placeRandomFoliage(pos.offset(2, height + 7,  -1),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, height + 7,  1),0.4, 1, list);
        placeRandomFoliage(pos.offset(3, height + 9, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 9,  3),0.4, 1, list);
        placeRandomFoliage(pos.offset(-3, height + 9, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 9,  -3),0.4, 1, list);
        placeRandomFoliage(pos.offset(2, height + 10, 1),0.4, 1, list);
        placeRandomFoliage(pos.offset(2, height + 10,  -1),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, height + 10, 1),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, height + 10,  -1),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 10, 2),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 10,  -2),0.4, 1, list);
        placeRandomFoliage(pos.offset(-1, height + 10, 2),0.4, 1, list);
        placeRandomFoliage(pos.offset(-1, height + 10,  -2),0.4, 1, list);
        placeRandomFoliage(pos.offset(2, height + 12, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 12,  2),0.4, 1, list);
        placeRandomFoliage(pos.offset(-2, height + 12, 0),0.4, 1, list);
        placeRandomFoliage(pos.offset(0, height + 12,  -2),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 12, -1),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 12,  -1),0.4, 1, list);
        placeRandomFoliage(pos.offset(-1, height + 12, 1),0.4, 1, list);
        placeRandomFoliage(pos.offset(-1, height + 12,  1),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 12, 1),0.4, 1, list);
        placeRandomFoliage(pos.offset(1, height + 12,  1),0.4, 1, list);
        return list;
    }

    private void placeLog(BlockPos pos, BlockState logState) {
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos)) {
            biConsumer.accept(pos, logState);
            placeLog(levelSimulatedReader, biConsumer, randomSource, pos, treeConfiguration);
        }
    }

    public int placeTrunk(BlockPos pos, BlockState logState, int height){
        height += (double) (2) + Math.round((Math.random() * 12) / 6) + Math.round((Math.random() * 12) / 6)
                + Math.round((Math.random() * 6) / 3);
        int counter = 1;
        while (counter <= height) {
            placeLog(pos.above(1 + counter), logState);
            counter += 1;
        }
        return height;
    }

    public void placeRandomFoliage(BlockPos pos, double odds, int foliageId, List<FoliagePlacer.FoliageAttachment> list){
        if ((Math.random() > odds)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos, foliageId, true));
        }
    }
}