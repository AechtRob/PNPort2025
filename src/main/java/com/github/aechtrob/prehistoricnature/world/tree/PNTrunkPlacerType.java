package com.github.aechtrob.prehistoricnature.world.tree;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.DiaphorodendronTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.GangamopterisTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.GlossopterisATrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTrunkPlacer;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.SciadopitysTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PNTrunkPlacerType {

    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, PrehistoricNature.MODID);

    public static DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> DIAPHORODENDRON_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("diaphorodendron_trunk_placer", () -> new TrunkPlacerType<>(DiaphorodendronTrunkPlacer.CODEC));
    public static DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> GANGAMOPTERIS_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("gangamopteris_trunk_placer", () -> new TrunkPlacerType<>(GangamopterisTrunkPlacer.CODEC));
    public static DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> GLOSSOPTERISA_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("glossopteris_angustifolia_trunk_placer", () -> new TrunkPlacerType<>(GlossopterisATrunkPlacer.CODEC));
    public static DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> LEPIDODENDRON_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("lepidodendron_trunk_placer", () -> new TrunkPlacerType<>(LepidodendronTrunkPlacer.CODEC));
    public static DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> SCIADOPITYS_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("sciadopitys_trunk_placer", () -> new TrunkPlacerType<>(SciadopitysTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER_TYPES.register(eventBus);
    }
}