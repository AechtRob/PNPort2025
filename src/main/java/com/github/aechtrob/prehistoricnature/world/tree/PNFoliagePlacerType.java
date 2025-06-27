package com.github.aechtrob.prehistoricnature.world.tree;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.GangamopterisFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.GlossopterisAFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PNFoliagePlacerType {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, PrehistoricNature.MODID);

    public static RegistryObject<FoliagePlacerType<GangamopterisFoliagePlacer>> GANGAMOPTERIS_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("gangamopteris_foliage_placer", () -> new FoliagePlacerType<>(GangamopterisFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<GlossopterisAFoliagePlacer>> GLOSSOPTERISA_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("glossopteris_angustifolia_foliage_placer", () -> new FoliagePlacerType<>(GlossopterisAFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<LepidodendronFoliagePlacer>> LEPIDODENDRON_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("lepidodendron_foliage_placer", () -> new FoliagePlacerType<>(LepidodendronFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACER_TYPES.register(eventBus);
    }
}