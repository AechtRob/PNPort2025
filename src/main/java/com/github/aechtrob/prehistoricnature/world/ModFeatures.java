package com.github.aechtrob.prehistoricnature.world;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.features.MacrocystisFeature;
import com.github.aechtrob.prehistoricnature.world.features.NereocystisFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(BuiltInRegistries.FEATURE, PrehistoricNature.MODID);

    //Blocks:
    //-------
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_PRECAMBRIAN_OVERWORLD = FEATURES.register("fossil_stone_precambrian_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_CAMBRIAN_OVERWORLD = FEATURES.register("fossil_stone_cambrian_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_ORDOVICIAN_OVERWORLD = FEATURES.register("fossil_stone_ordovician_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_SILURIAN_OVERWORLD = FEATURES.register("fossil_stone_silurian_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_DEVONIAN_OVERWORLD = FEATURES.register("fossil_stone_devonian_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_CARBONIFEROUS_OVERWORLD = FEATURES.register("fossil_stone_carboniferous_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_PERMIAN_OVERWORLD = FEATURES.register("fossil_stone_permian_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_TRIASSIC_OVERWORLD = FEATURES.register("fossil_stone_triassic_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_JURASSIC_OVERWORLD = FEATURES.register("fossil_stone_jurassic_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_CRETACEOUS_EARLY_OVERWORLD = FEATURES.register("fossil_stone_cretaceous_early_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_CRETACEOUS_LATE_OVERWORLD = FEATURES.register("fossil_stone_cretaceous_late_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_PALEOGENE_OVERWORLD = FEATURES.register("fossil_stone_paleogene_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_NEOGENE_OVERWORLD = FEATURES.register("fossil_stone_neogene_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));
    public static final Supplier<Feature<OreConfiguration>> FOSSIL_STONE_PLEISTOCENE_OVERWORLD = FEATURES.register("fossil_stone_pleistocene_overworld",
            () -> new OreFeature(OreConfiguration.CODEC));


    //Plants:
    //-------
    public static final Supplier<Feature<NoneFeatureConfiguration>> MACROCYSTIS = FEATURES.register("macrocystis",
            () -> new MacrocystisFeature(NoneFeatureConfiguration.CODEC));

    public static final Supplier<Feature<NoneFeatureConfiguration>> NEREOCYSTIS = FEATURES.register("nereocystis",
            () -> new NereocystisFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }

}
