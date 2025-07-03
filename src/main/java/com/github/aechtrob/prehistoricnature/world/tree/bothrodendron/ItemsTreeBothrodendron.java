package com.github.aechtrob.prehistoricnature.world.tree.bothrodendron;

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

public class ItemsTreeBothrodendron {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<BoatItem> BOTHRODENDRON_BOAT = ITEMS.register("bothrodendron_boat",
            () -> new BoatItem(EntitiesTreeBothrodendron.BOTHRODENDRON_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "bothrodendron_boat")))));

    public static final DeferredItem<BoatItem> BOTHRODENDRON_CHEST_BOAT = ITEMS.register("bothrodendron_chest_boat",
            () -> new BoatItem(EntitiesTreeBothrodendron.BOTHRODENDRON_CHEST_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "bothrodendron_chest_boat")))));

    public static final DeferredItem<SignItem> BOTHRODENDRON_SIGN = ITEMS.register("bothrodendron_sign",
            () -> new SignItem(BlocksTreeBothrodendron.BOTHRODENDRON_SIGN.get(), BlocksTreeBothrodendron.BOTHRODENDRON_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "bothrodendron_sign")))));

    public static final DeferredItem<HangingSignItem> BOTHRODENDRON_HANGING_SIGN = ITEMS.register("bothrodendron_hanging_sign",
            () -> new HangingSignItem(BlocksTreeBothrodendron.BOTHRODENDRON_SIGN_HANGING.get(), BlocksTreeBothrodendron.BOTHRODENDRON_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "bothrodendron_hanging_sign")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
