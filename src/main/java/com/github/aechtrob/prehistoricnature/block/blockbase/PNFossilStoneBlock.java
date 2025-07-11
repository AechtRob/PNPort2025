package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.block.interfaces.IResearchable;
import net.minecraft.world.level.block.Block;

public class PNFossilStoneBlock extends Block implements IResearchable {

    public final int level;

    public PNFossilStoneBlock(Properties properties, int level) {
        super(properties);
        this.level = level;
    }

    @Override
    public int reserchLevel() {
        return this.level;
    }
}
