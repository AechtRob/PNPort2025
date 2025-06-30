package com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsTreeDiaphorodendron {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<BoatItem> DIAPHORODENDRON_BOAT = ITEMS.register("diaphorodendron_boat",
            () -> new BoatItem(EntitiesTreeDiaphorodendron.DIAPHORODENDRON_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_boat")))));

    public static final DeferredItem<BoatItem> DIAPHORODENDRON_CHEST_BOAT = ITEMS.register("diaphorodendron_chest_boat",
            () -> new BoatItem(EntitiesTreeDiaphorodendron.DIAPHORODENDRON_CHEST_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_chest_boat")))));

    public static final DeferredItem<SignItem> DIAPHORODENDRON_SIGN = ITEMS.register("diaphorodendron_sign",
            () -> new SignItem(BlocksTreeDiaphorodendron.DIAPHORODENDRON_SIGN.get(), BlocksTreeDiaphorodendron.DIAPHORODENDRON_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_sign")))));

    public static final DeferredItem<HangingSignItem> DIAPHORODENDRON_HANGING_SIGN = ITEMS.register("diaphorodendron_hanging_sign",
            () -> new HangingSignItem(BlocksTreeDiaphorodendron.DIAPHORODENDRON_SIGN_HANGING.get(), BlocksTreeDiaphorodendron.DIAPHORODENDRON_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_hanging_sign")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
