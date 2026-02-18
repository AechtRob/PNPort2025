package com.github.aechtrob.prehistoricnature.item;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.item.itembase.PNFossilRaw;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PrehistoricNature.MODID);

    public static final RegistryObject<PNFossilRaw> PRECAMBRIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_precambrian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 28, 1));

    public static final RegistryObject<PNFossilRaw> CAMBRIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_cambrian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 26, 2));

    public static final RegistryObject<PNFossilRaw> ORDOVICIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_ordovician",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 24, 3));

    public static final RegistryObject<PNFossilRaw> SILURIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_silurian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 22, 4));

    public static final RegistryObject<PNFossilRaw> DEVONIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_devonian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 20, 5));

    public static final RegistryObject<PNFossilRaw> CARBONIFEROUS_RAW_FOSSIL = ITEMS.register("fossil_drop_carboniferous",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 18, 6));

    public static final RegistryObject<PNFossilRaw> PERMIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_permian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 16, 7));

    public static final RegistryObject<PNFossilRaw> TRIASSIC_RAW_FOSSIL = ITEMS.register("fossil_drop_triassic",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 14, 8));

    public static final RegistryObject<PNFossilRaw> JURASSIC_RAW_FOSSIL = ITEMS.register("fossil_drop_jurassic",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 12, 9));

    public static final RegistryObject<PNFossilRaw> CRETACEOUS_EARLY_RAW_FOSSIL = ITEMS.register("fossil_drop_cretaceous_early",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 10, 10));

    public static final RegistryObject<PNFossilRaw> CRETACEOUS_LATE_RAW_FOSSIL = ITEMS.register("fossil_drop_cretaceous_late",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 8, 11));

    public static final RegistryObject<PNFossilRaw> PALEOGENE_RAW_FOSSIL = ITEMS.register("fossil_drop_paleogene",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 6, 12));

    public static final RegistryObject<PNFossilRaw> NEOGENE_RAW_FOSSIL = ITEMS.register("fossil_drop_neogene",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 4, 13));

    public static final RegistryObject<PNFossilRaw> PLEISTOCENE_RAW_FOSSIL = ITEMS.register("fossil_drop_pleistocene",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64), 2, 14));

//    public static final RegistryObject<PNCollectionEnvelope> COLLECTION_ENVELOPE = ITEMS.register("collection_envelope",
//            () -> new PNCollectionEnvelope(new Item.Properties().stacksTo(64)
//                    .component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
//                    .setId(ResourceKey.create(Registries.ITEM, ()))));
//
//    public static final RegistryObject<PNPhial> PHIAL = ITEMS.register("phial",
//            () -> new PNPhial(new Item.Properties().stacksTo(64)
//                    .component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
//                    .setId(ResourceKey.create(Registries.ITEM, ()))));
//
//    public static final RegistryObject<PNGeologicPick> GEOLOGIC_PICK = ITEMS.register("geologic_pick",
//            () -> new PNGeologicPick(new Item.Properties().pickaxe(ToolMaterial.IRON, 1.0F, -2.8F)
//                    .setId(ResourceKey.create(Registries.ITEM, ()))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
