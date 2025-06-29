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
        int LeafHeight = 0;
        BlockState logState = BlocksTreeDiaphorodendron.DIAPHORODENDRON_LOG.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS, Direction.Axis.Y);
        BlockState woodState = BlocksTreeDiaphorodendron.DIAPHORODENDRON_WOOD.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS, Direction.Axis.Y);

        placeLog(pos, logState);
        placeLog(pos.above(), logState);
        placeLog(pos.south(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.north(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.east(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.west(), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.south(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.north(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
        placeLog(pos.east(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.west(2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
        placeLog(pos.south().above (1 ), logState);
        placeLog(pos.north().above(1 ), logState);
        placeLog(pos.east().above (1 ), logState);
        placeLog(pos.west().above ( 1 ), logState);
        placeLog(pos.east().above(2), woodState);
        placeLog(pos.west().above(2), woodState);
        placeLog(pos.south().above(2), woodState);
        placeLog(pos.north().above(2), woodState);
        height = placeTrunk(pos, logState, height);


        //crown






        //Leaves:
        int counter = -1;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter + 1, 0), 0,true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter, 0), 0,true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter, 0), 0,true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + counter, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + counter, 0), 0,true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter, 1), 0,true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter, 2), 0,true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter, 3), 0,true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter, -2), 0,true));;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter, -3), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + counter -1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + counter -1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -1 , 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -1, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -1, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -1, -3), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -2, -1), 0, true));

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter -3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter -3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter -3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter -3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter -3, 0), 0, true));

        //North
        if (Math.random() >= 0.75) {
            placeLog(pos.offset(0, height + counter - 4 , -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(0, height + counter - 4, -2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -4, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -4, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -4, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -4, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -4, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -4, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -4, -3), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -4, -4), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -4, -5), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -5, -5), 0, true));
            placeRandomFoliage(pos.offset(-3, height + counter -6, -5),0.4, 1, list);

        }
        else {

            placeLog(pos.offset(0, height + counter - 3 , -1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(0, height + counter - 3, -2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, -3), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, -4), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, -5), 0, true));

            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -4, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -4, -5), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -5, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -5, -2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -5, -3), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -6, -3), 0, true));
            placeRandomFoliage(pos.offset(0, height + counter -7, -3),0.4, 1, list);
        }

        //South
        if (Math.random() >= 0.75) {
            placeLog(pos.offset(0, height + counter - 4, 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            placeLog(pos.offset(0, height + counter - 4, 2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter - 4, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter - 4, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter - 4, 2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter - 4, 2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter - 4, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter - 4, 2), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter - 4, 3), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter - 4, 4), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter - 4, 5), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter - 5, 5), 0, true));
            placeRandomFoliage(pos.offset(0, height + counter -6, 5),0.4, 1, list);
        }

 else {

                placeLog(pos.offset(0, height + counter - 3 , 1), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
                placeLog(pos.offset(0, height + counter - 3, 2), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.Z));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, 1), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, 1), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, 2), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, 2), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, 1), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, 2), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, 3), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, 4), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -3, 5), 0, true));

                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -4, 1), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -4, 5), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -5, 1), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -5, 2), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -5, 3), 0, true));
                list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter -6, 3), 0, true));
                placeRandomFoliage(pos.offset(0, height + counter -7, 3),0.4, 1, list);
            }
//East
        if (Math.random() >= 0.75) {
            placeLog(pos.offset(1, height + counter - 4, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.offset(2, height + counter - 4, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter - 4, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter - 4, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter - 4, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter - 4, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + counter - 5, 0), 0, true));
            placeRandomFoliage(pos.offset(5, height + counter -6, 0),0.4, 1, list);
        }

        else {

            placeLog(pos.offset(1, height + counter - 3 , 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.offset(2, height + counter - 3, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter -3, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter -3, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -3, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter -3, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + counter -3, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + counter -3, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + counter -3, 0), 0, true));

            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + counter -4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + counter -5, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter -5, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + counter -5, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + counter -6, 0), 0, true));
            placeRandomFoliage(pos.offset(3, height + counter -7, 0),0.4, 1, list);
        }
//West
        if (Math.random() >= 0.75) {
            placeLog(pos.offset(-1, height + counter - 4, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.offset(-2, height + counter - 4, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter - 4, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter - 4, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter - 4, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter - 4, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + counter - 4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + counter - 5, 0), 0, true));
            placeRandomFoliage(pos.offset(-5, height + counter -6, 0),0.4, 1, list);

        }

        else {

            placeLog(pos.offset(-1, height + counter - 3 , 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            placeLog(pos.offset(-2, height + counter - 3, 0), logState.setValue(PNTreeLogBlock.AXIS, Direction.Axis.X));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter -3, 1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter -3, -1), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -3, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter -3, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + counter -3, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + counter -3, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + counter -3, 0), 0, true));

            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + counter -4, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + counter -5, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + counter -5, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + counter -5, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + counter -6, 0), 0, true));

            placeRandomFoliage(pos.offset(-3, height + counter -7, 0),0.4, 1, list);
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
            height += (18) + Math.round((Math.random() * 100) / 8);


            int counter = 0;
            while (counter <= height) {
                placeLog(pos.above( counter), logState);
                counter += 1;
            }
            return height;
        }
    }
