package com.github.aechtrob.prehistoricnature.world.tree.sciadopitys;

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

public class SciadopitysFoliagePlacer extends BlobFoliagePlacer {
    public SciadopitysFoliagePlacer(IntProvider p_161356_, IntProvider p_161357_, int p_161358_) {
        super(p_161356_, p_161357_, p_161358_);
    }

    public static final MapCodec<BlobFoliagePlacer> CODEC =
            RecordCodecBuilder.mapCodec((p_68427_) ->
                    blobParts(p_68427_).apply(p_68427_, SciadopitysFoliagePlacer::new));

    @Override
    protected FoliagePlacerType<?> type() {
        return PNFoliagePlacerType.SCIADOPITYS_FOLIAGE_PLACER_HOLDER.get();
    }

    BlockState leafState = BlocksTreeSciadopitys.SCIADOPITYS_LEAVES.get().defaultBlockState();
    
    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        //This sets a single block of foliage only, and is detailed in the Trunk generator for where exactly it all has to go.
        //For trees with no flowers, strobili or variant leaf blocks, do not use this, use PNFoliagePlacer instead.
        BlockPos pos = foliageAttachment.pos();
        BlockState state = leafState;

        if (PNTreeFeature.canLeavesReplaceBlock(treeConfiguration, random, levelSimulatedReader, pos)) {
            foliageSetter.set(pos, state);
        }
    }
}
