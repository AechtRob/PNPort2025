package com.github.aechtrob.prehistoricnature.world;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, PrehistoricNature.MODID);


    //Blocks:
    //-------
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_PRECAMBRIAN = createKey("fossil_stone_precambrian_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_CAMBRIAN = createKey("fossil_stone_cambrian_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_ORDOVICIAN = createKey("fossil_stone_ordovician_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_SILURIAN = createKey("fossil_stone_silurian_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_DEVONIAN = createKey("fossil_stone_devonian_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_CARBONIFEROUS = createKey("fossil_stone_carboniferous_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_PERMIAN = createKey("fossil_stone_permian_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_TRIASSIC = createKey("fossil_stone_triassic_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_JURASSIC = createKey("fossil_stone_jurassic_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_CRETACEOUS_EARLY = createKey("fossil_stone_cretaceous_early_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_CRETACEOUS_LATE = createKey("fossil_stone_cretaceous_late_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_PALEOGENE = createKey("fossil_stone_paleogene_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_NEOGENE = createKey("fossil_stone_neogene_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_STONE_PLEISTOCENE = createKey("fossil_stone_plaistocene_overworld");


    //Plants:
    //-------
    public static final ResourceKey<ConfiguredFeature<?, ?>> MACROCYSTIS = createKey("macrocystis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NEREOCYSTIS = createKey("nereocuystis");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOTHRODENDRON_TREE = createKey("bothrodendron_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIAPHORODENDRON_TREE = createKey("diaphorodendron_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GANGAMOPTERIS_TREE = createKey("gangamopteris_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOSSOPTERISA_TREE = createKey("glossopteris_angustifolia_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEPIDODENDRON_TREE = createKey("lepidodendron_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEPIDOPHLOIOS_TREE = createKey("lepidophloios_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCIADOPITYS_TREE = createKey("sciadopitys_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SYNCHYSIDENDRON_TREE = createKey("synchysidendron_tree");

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(CONFIGURED_FEATURES.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, name));
    }

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }

}
