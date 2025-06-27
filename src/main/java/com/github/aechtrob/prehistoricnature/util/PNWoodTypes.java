package com.github.aechtrob.prehistoricnature.util;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class PNWoodTypes {
    public static final WoodType GANGAMOPTERIS = WoodType.register(new WoodType(PrehistoricNature.MODID + "gangamopteris", BlockSetType.OAK));
    public static final WoodType GLOSSOPTERISA = WoodType.register(new WoodType(PrehistoricNature.MODID + "glossopteris_angustifolia", BlockSetType.OAK));
    public static final WoodType LEPIDODENDRON = WoodType.register(new WoodType(PrehistoricNature.MODID + "lepidodendron", BlockSetType.OAK));
    
}
