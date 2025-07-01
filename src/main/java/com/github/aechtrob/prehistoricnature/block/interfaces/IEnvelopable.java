package com.github.aechtrob.prehistoricnature.block.interfaces;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;

public interface IEnvelopable {

    BlockState planted();

    int offsetY();

    Item blockItem();
}
