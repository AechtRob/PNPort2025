package com.github.aechtrob.prehistoricnature.world;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.features.MacrocystisFeature;
import com.github.aechtrob.prehistoricnature.world.features.NereocystisFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, PrehistoricNature.MODID);

    public static final Supplier<Feature<NoneFeatureConfiguration>> MACROCYSTIS = FEATURES.register("macrocystis",
            () -> new MacrocystisFeature(NoneFeatureConfiguration.CODEC));

    public static final Supplier<Feature<NoneFeatureConfiguration>> NEREOCYSTIS = FEATURES.register("nereocystis",
            () -> new NereocystisFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }

}
