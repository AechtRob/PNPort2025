package com.github.aechtrob.prehistoricnature.world.tree;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class PNTreeGrower {
    public static final TreeGrower GANGAMOPTERIS_GROWER = new TreeGrower(PrehistoricNature.MODID + ":gangamopteris_grower",
            Optional.empty(), Optional.of(ModConfiguredFeatures.GANGAMOPTERIS_TREE), Optional.empty());
    public static final TreeGrower GLOSSOPTERISA_GROWER = new TreeGrower(PrehistoricNature.MODID + ":glossopteris_angustifolia_grower",
            Optional.empty(), Optional.of(ModConfiguredFeatures.GLOSSOPTERISA_TREE), Optional.empty());
    public static final TreeGrower LEPIDODENDRON_GROWER = new TreeGrower(PrehistoricNature.MODID + ":lepidodendron_grower",
            Optional.empty(), Optional.of(ModConfiguredFeatures.LEPIDODENDRON_TREE), Optional.empty());

}
