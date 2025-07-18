package com.github.aechtrob.prehistoricnature.world.tree.pitys;

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

public class ItemsTreePitys {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<BoatItem> PITYS_BOAT = ITEMS.register("pitys_boat",
            () -> new BoatItem(EntitiesTreePitys.PITYS_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "pitys_boat")))));

    public static final DeferredItem<BoatItem> PITYS_CHEST_BOAT = ITEMS.register("pitys_chest_boat",
            () -> new BoatItem(EntitiesTreePitys.PITYS_CHEST_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "pitys_chest_boat")))));

    public static final DeferredItem<SignItem> PITYS_SIGN = ITEMS.register("pitys_sign",
            () -> new SignItem(BlocksTreePitys.PITYS_SIGN.get(), BlocksTreePitys.PITYS_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "pitys_sign")))));

    public static final DeferredItem<HangingSignItem> PITYS_HANGING_SIGN = ITEMS.register("pitys_hanging_sign",
            () -> new HangingSignItem(BlocksTreePitys.PITYS_SIGN_HANGING.get(), BlocksTreePitys.PITYS_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "pitys_hanging_sign")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
