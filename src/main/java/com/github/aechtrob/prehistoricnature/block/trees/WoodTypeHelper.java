package com.github.aechtrob.prehistoricnature.block.trees;

import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.ArrayList;

public class WoodTypeHelper {
    private static ArrayList<WoodType> woodTypes = new ArrayList<>();

    public static WoodType putWoodType(WoodType woodType){
        woodTypes.add(woodType);
        return woodType;
    }

    public static ArrayList<WoodType> getWoodTypes(){
        return woodTypes;
    }
}
