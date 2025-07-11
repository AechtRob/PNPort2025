package com.github.aechtrob.prehistoricnature.item;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.item.itembase.PNFossilRaw;
import com.github.aechtrob.prehistoricnature.item.itembase.PNGeologicPick;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<Item> PRECAMBRIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_precambrian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_precambrian"))), 28, 1));

    public static final DeferredItem<Item> CAMBRIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_cambrian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_cambrian"))), 26, 2));

    public static final DeferredItem<Item> ORDOVICIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_ordovician",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_ordovician"))), 24, 3));

    public static final DeferredItem<Item> SILURIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_silurian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_silurian"))), 22, 4));

    public static final DeferredItem<Item> DEVONIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_devonian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_devonian"))), 20, 5));

    public static final DeferredItem<Item> CARBONIFEROUS_RAW_FOSSIL = ITEMS.register("fossil_drop_carboniferous",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_carboniferous"))), 18, 6));

    public static final DeferredItem<Item> PERMIAN_RAW_FOSSIL = ITEMS.register("fossil_drop_permian",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_permian"))), 16, 7));

    public static final DeferredItem<Item> TRIASSIC_RAW_FOSSIL = ITEMS.register("fossil_drop_triassic",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_triassic"))), 14, 8));

    public static final DeferredItem<Item> JURASSIC_RAW_FOSSIL = ITEMS.register("fossil_drop_jurassic",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_jurassic"))), 12, 9));

    public static final DeferredItem<Item> CRETACEOUS_EARLY_RAW_FOSSIL = ITEMS.register("fossil_drop_cretaceous_early",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_cretaceous_early"))), 10, 10));

    public static final DeferredItem<Item> CRETACEOUS_LATE_RAW_FOSSIL = ITEMS.register("fossil_drop_cretaceous_late",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_cretaceous_late"))), 8, 11));

    public static final DeferredItem<Item> PALEOGENE_RAW_FOSSIL = ITEMS.register("fossil_drop_paleogene",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_paleogene"))), 6, 12));

    public static final DeferredItem<Item> NEOGENE_RAW_FOSSIL = ITEMS.register("fossil_drop_neogene",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_neogene"))), 4, 13));

    public static final DeferredItem<Item> PLEISTOCENE_RAW_FOSSIL = ITEMS.register("fossil_drop_pleistocene",
            () -> new PNFossilRaw(new Item.Properties().stacksTo(64)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_drop_pleistocene"))), 2, 14));

    public static final DeferredItem<Item> COLLECTION_ENVELOPE = ITEMS.register("collection_envelope",
            () -> new PNCollectionEnvelope(new Item.Properties().stacksTo(64)
                    .component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "collection_envelope")))));

    public static final DeferredItem<Item> GEOLOGIC_PICK = ITEMS.register("geologic_pick",
            () -> new PNGeologicPick(new Item.Properties().pickaxe(ToolMaterial.IRON, 1.0F, -2.8F)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "geologic_pick")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
