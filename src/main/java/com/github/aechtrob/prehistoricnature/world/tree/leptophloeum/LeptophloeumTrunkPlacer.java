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
        int dir = random.nextInt(4);
        int counter = 0;
        BlockState logState = BlocksTreeLeptophloeum.LEPTOPHLOEUM_LOG.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS, Direction.Axis.Y);
        BlockState woodState = BlocksTreeLeptophloeum.LEPTOPHLOEUM_WOOD.get().defaultBlockState().setValue(PNTreeLogBlock.AXIS, Direction.Axis.Y);

        placeLog(pos, logState);

        height = placeTrunk(pos, logState, height);
        LeafHeight = random.nextInt(2) + 3;
        height = 15 + random.nextInt(7);

        counter = counter + 1;
//        if (counter == height - LeafHeight) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter - 1, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + counter, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + counter, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + counter, 0), 0, true));

      //  }

//        if (counter == height - LeafHeight - 2) {
//            dir = random.nextInt(4);
//        }
        placeLog(pos.offset(0, height + counter, 0), logState);


        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter - 1, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + counter, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + counter, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter, 2), 0, true));


//        if (counter == height - LeafHeight - 4) {
//            dir = random.nextInt(4);
//
//        }
        placeLog(pos.offset(0, height + counter, 0), logState);


        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter - 1, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + counter, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + counter, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + counter, 2), 0, true));




        int y = pos.getY();
        int yy = pos.getY();
        yy = counter + height;

        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , 0), 0, true));


        yy = counter + 1 + height;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , 0), 0, true));

        yy = counter + 2 + height;
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy , 0), 0, true));





//        for (int n = 0; n < LeafHeight; n++) {
//            yy = (int) counter + y - n;
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, yy, 0), 0, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 0), 1, true));
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, yy, 0), -1, true));




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
        int counter = 0;
        while (counter <= height - 1) {
            placeLog(pos.above(1 + counter), logState);
            counter += 1;
        }
        return height;
    }
}