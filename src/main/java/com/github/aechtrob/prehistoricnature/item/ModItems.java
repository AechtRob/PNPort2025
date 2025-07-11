package com.github.aechtrob.prehistoricnature.item;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
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
