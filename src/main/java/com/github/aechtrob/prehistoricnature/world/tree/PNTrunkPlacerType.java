package com.github.aechtrob.prehistoricnature.world.tree;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PNTrunkPlacerType {

    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, PrehistoricNature.MODID);

    public static DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> LEPIDODENDRON_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("lepidodendron_trunk_placer", () -> new TrunkPlacerType<>(LepidodendronTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER_TYPES.register(eventBus);
    }
}