package com.github.aechtrob.prehistoricnature.util;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PNTags {
    public static final TagKey<Block> MINALBE_WITH_GEOLOGIC_PICK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID,"minable_with_geologic_pick"));

}
