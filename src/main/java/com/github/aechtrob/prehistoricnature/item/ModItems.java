package com.github.aechtrob.prehistoricnature.item;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
