package com.github.aechtrob.prehistoricnature.world.tree.lepidodendron;

import com.github.aechtrob.prehistoricnature.block.blockbase.PNDecayableDirectional;
import com.github.aechtrob.prehistoricnature.world.tree.PNFoliagePlacerType;
import com.github.aechtrob.prehistoricnature.world.tree.PNTreeFeature;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class LepidodendronFoliagePlacer extends BlobFoliagePlacer {
    public LepidodendronFoliagePlacer(IntProvider p_161356_, IntProvider p_161357_, int p_161358_) {
        super(p_161356_, p_161357_, p_161358_);
    }

    public static final MapCodec<BlobFoliagePlacer> CODEC =
            RecordCodecBuilder.mapCodec((p_68427_) ->
                    blobParts(p_68427_).apply(p_68427_, LepidodendronFoliagePlacer::new));

    @Override
    protected FoliagePlacerType<?> type() {
        return PNFoliagePlacerType.LEPIDODENDRON_FOLIAGE_PLACER_HOLDER.get();
    }

    BlockState leafState = BlocksTreeLepidodendron.LEPIDODENDRON_LEAVES.get().defaultBlockState();
    BlockState strobilusState = BlocksTreeLepidodendron.LEPIDODENDRON_STROBILUS.get().defaultBlockState().setValue(PNDecayableDirectional.PERSISTENT, false);

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        //This sets a single block of foliage only, and is detailed in the Trunk generator for where exactly it all has to go.
        //For trees with no flowers, strobili or variant leaf blocks, do not use this, use PNFoliagePlacer instead.
        BlockPos pos = foliageAttachment.pos();
        BlockState state = treeConfiguration.foliageProvider.getState(random, pos);
        switch (foliageAttachment.radiusOffset()) { //Co-opting the radius field as a block enumerator for varied blocks
            case 0:
                state = leafState;
                break;
            case 1:
                state = strobilusState;
                break;
            default:
                state = leafState;
                break;
        }

        if (PNTreeFeature.canLeavesReplaceBlock(levelSimulatedReader, pos)) {
            foliageSetter.set(pos, state);
        }
    }
}
