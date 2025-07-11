package com.github.aechtrob.prehistoricnature.item.itembase;

import com.github.aechtrob.prehistoricnature.block.interfaces.IResearchable;
import net.minecraft.world.item.Item;

public class PNFossilRaw extends Item implements IResearchable {

    public final int level;
    public final int period;

    public PNFossilRaw(Properties properties, int level, int period) {
        super(properties);
        this.level = level;
        this.period = period;
    }

    @Override
    public int getResearchLevel() {
        return this.level;
    }

    @Override
    public int getPeriod() {
        return this.level;
    }

}
