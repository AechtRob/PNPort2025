package com.github.aechtrob.prehistoricnature.world.tree.synchysidendron;

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

public class ItemsTreeSynchysidendron {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<BoatItem> SYNCHYSIDENDRON_BOAT = ITEMS.register("synchysidendron_boat",
            () -> new BoatItem(EntitiesTreeSynchysidendron.SYNCHYSIDENDRON_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "synchysidendron_boat")))));

    public static final DeferredItem<BoatItem> SYNCHYSIDENDRON_CHEST_BOAT = ITEMS.register("synchysidendron_chest_boat",
            () -> new BoatItem(EntitiesTreeSynchysidendron.SYNCHYSIDENDRON_CHEST_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "synchysidendron_chest_boat")))));

    public static final DeferredItem<SignItem> SYNCHYSIDENDRON_SIGN = ITEMS.register("synchysidendron_sign",
            () -> new SignItem(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_SIGN.get(), BlocksTreeSynchysidendron.SYNCHYSIDENDRON_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "synchysidendron_sign")))));

    public static final DeferredItem<HangingSignItem> SYNCHYSIDENDRON_HANGING_SIGN = ITEMS.register("synchysidendron_hanging_sign",
            () -> new HangingSignItem(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_SIGN_HANGING.get(), BlocksTreeSynchysidendron.SYNCHYSIDENDRON_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "synchysidendron_hanging_sign")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
