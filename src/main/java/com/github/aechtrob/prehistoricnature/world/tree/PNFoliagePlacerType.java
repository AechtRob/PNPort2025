package com.github.aechtrob.prehistoricnature.world.tree;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.tree.Bothrodendron.BothrodendronFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.GangamopterisFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.GlossopterisAFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.SciadopitysFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PNFoliagePlacerType {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, PrehistoricNature.MODID);

    public static DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> BOTHRODENDRON_FOLIAGE_PLACER_HOLDER = FOLIAGE_PLACER_TYPES.register("bothrodendron_foliage_placer", () -> new FoliagePlacerType<>(BothrodendronFoliagePlacer.CODEC));
    public static DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> GANGAMOPTERIS_FOLIAGE_PLACER_HOLDER = FOLIAGE_PLACER_TYPES.register("gangamopteris_foliage_placer", () -> new FoliagePlacerType<>(GangamopterisFoliagePlacer.CODEC));
    public static DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> GLOSSOPTERISA_FOLIAGE_PLACER_HOLDER = FOLIAGE_PLACER_TYPES.register("glossopteris_angustifolia_foliage_placer", () -> new FoliagePlacerType<>(GlossopterisAFoliagePlacer.CODEC));
    public static DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> LEPIDODENDRON_FOLIAGE_PLACER_HOLDER = FOLIAGE_PLACER_TYPES.register("lepidodendron_foliage_placer", () -> new FoliagePlacerType<>(LepidodendronFoliagePlacer.CODEC));
    public static DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> SCIADOPITYS_FOLIAGE_PLACER_HOLDER = FOLIAGE_PLACER_TYPES.register("sciadopitys_foliage_placer", () -> new FoliagePlacerType<>(SciadopitysFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACER_TYPES.register(eventBus);
    }
}