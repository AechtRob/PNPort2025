package com.github.aechtrob.prehistoricnature.world.tree;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.BothrodendronTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.DiaphorodendronTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.GangamopterisTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.GlossopterisATrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.LepidophloiosTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.leptophloeum.LeptophloeumTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.pitys.PitysTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.SciadopitysTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.SynchysidendronTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PNTrunkPlacerType {

    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, PrehistoricNature.MODID);

    public static RegistryObject<TrunkPlacerType<BothrodendronTrunkPlacer>> BOTHRODENDRON_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("bothrodendron_trunk_placer", () -> new TrunkPlacerType<>(BothrodendronTrunkPlacer.CODEC));
    public static RegistryObject<TrunkPlacerType<DiaphorodendronTrunkPlacer>> DIAPHORODENDRON_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("diaphorodendron_trunk_placer", () -> new TrunkPlacerType<>(DiaphorodendronTrunkPlacer.CODEC));
    public static RegistryObject<TrunkPlacerType<GangamopterisTrunkPlacer>> GANGAMOPTERIS_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("gangamopteris_trunk_placer", () -> new TrunkPlacerType<>(GangamopterisTrunkPlacer.CODEC));
    public static RegistryObject<TrunkPlacerType<GlossopterisATrunkPlacer>> GLOSSOPTERISA_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("glossopteris_angustifolia_trunk_placer", () -> new TrunkPlacerType<>(GlossopterisATrunkPlacer.CODEC));
    public static RegistryObject<TrunkPlacerType<LepidodendronTrunkPlacer>> LEPIDODENDRON_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("lepidodendron_trunk_placer", () -> new TrunkPlacerType<>(LepidodendronTrunkPlacer.CODEC));
    public static RegistryObject<TrunkPlacerType<LepidophloiosTrunkPlacer>> LEPIDOPHLOIOS_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("lepidophloios_trunk_placer", () -> new TrunkPlacerType<>(LepidophloiosTrunkPlacer.CODEC));
    public static RegistryObject<TrunkPlacerType<LeptophloeumTrunkPlacer>> LEPTOPHLOEUM_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("leptophloeum_trunk_placer", () -> new TrunkPlacerType<>(LeptophloeumTrunkPlacer.CODEC));
    public static RegistryObject<TrunkPlacerType<PitysTrunkPlacer>> PITYS_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("pitys_trunk_placer", () -> new TrunkPlacerType<>(PitysTrunkPlacer.CODEC));
    public static RegistryObject<TrunkPlacerType<SciadopitysTrunkPlacer>> SCIADOPITYS_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("sciadopitys_trunk_placer", () -> new TrunkPlacerType<>(SciadopitysTrunkPlacer.CODEC));
    public static RegistryObject<TrunkPlacerType<SynchysidendronTrunkPlacer>> SYNCHYSIDENDRON_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("synchysidendron_trunk_placer", () -> new TrunkPlacerType<>(SynchysidendronTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER_TYPES.register(eventBus);
    }
}