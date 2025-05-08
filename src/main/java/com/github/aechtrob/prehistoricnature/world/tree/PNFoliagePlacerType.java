package com.github.aechtrob.prehistoricnature.world.tree;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PNFoliagePlacerType {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, PrehistoricNature.MODID);

    public static DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> LEPIDODENDRON_FOLIAGE_PLACER_HOLDER = FOLIAGE_PLACER_TYPES.register("lepidodendron_foliage_placer", () -> new FoliagePlacerType<>(LepidodendronFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACER_TYPES.register(eventBus);
    }
}