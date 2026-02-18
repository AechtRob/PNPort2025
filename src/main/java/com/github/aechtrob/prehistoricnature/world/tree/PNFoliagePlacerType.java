package com.github.aechtrob.prehistoricnature.world.tree;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.BothrodendronFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.DiaphorodendronFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.GangamopterisFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.GlossopterisAFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.LepidophloiosFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.leptophloeum.LeptophloeumFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.pitys.PitysFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.SciadopitysFoliagePlacer;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.SynchysidendronFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PNFoliagePlacerType {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, PrehistoricNature.MODID);

    public static RegistryObject<FoliagePlacerType<BothrodendronFoliagePlacer>> BOTHRODENDRON_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("bothrodendron_foliage_placer", () -> new FoliagePlacerType<>(BothrodendronFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<DiaphorodendronFoliagePlacer>> DIAPHORODENDRON_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("diaphorodendron_foliage_placer", () -> new FoliagePlacerType<>(DiaphorodendronFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<GangamopterisFoliagePlacer>> GANGAMOPTERIS_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("gangamopteris_foliage_placer", () -> new FoliagePlacerType<>(GangamopterisFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<GlossopterisAFoliagePlacer>> GLOSSOPTERISA_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("glossopteris_angustifolia_foliage_placer", () -> new FoliagePlacerType<>(GlossopterisAFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<LepidodendronFoliagePlacer>> LEPIDODENDRON_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("lepidodendron_foliage_placer", () -> new FoliagePlacerType<>(LepidodendronFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<LepidophloiosFoliagePlacer>> LEPIDOPHLOIOS_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("lepidophloios_foliage_placer", () -> new FoliagePlacerType<>(LepidophloiosFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<LeptophloeumFoliagePlacer>> LEPTOPHLOEUM_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("leptophloeum_foliage_placer", () -> new FoliagePlacerType<>(LeptophloeumFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<PitysFoliagePlacer>> PITYS_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("pitys_foliage_placer", () -> new FoliagePlacerType<>(PitysFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<SciadopitysFoliagePlacer>> SCIADOPITYS_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("sciadopitys_foliage_placer", () -> new FoliagePlacerType<>(SciadopitysFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<SynchysidendronFoliagePlacer>> SYNCHYSIDENDRON_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("synchysidendron_foliage_placer", () -> new FoliagePlacerType<>(SynchysidendronFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACER_TYPES.register(eventBus);
    }
}