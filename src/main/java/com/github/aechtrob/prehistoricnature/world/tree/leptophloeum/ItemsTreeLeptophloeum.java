package com.github.aechtrob.prehistoricnature.world.tree.leptophloeum;

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

public class ItemsTreeLeptophloeum {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<BoatItem> LEPTOPHLOEUM_BOAT = ITEMS.register("leptophloeum_boat",
            () -> new BoatItem(EntitiesTreeLeptophloeum.LEPTOPHLOEUM_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_boat")))));

    public static final DeferredItem<BoatItem> LEPTOPHLOEUM_CHEST_BOAT = ITEMS.register("leptophloeum_chest_boat",
            () -> new BoatItem(EntitiesTreeLeptophloeum.LEPTOPHLOEUM_CHEST_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_chest_boat")))));

    public static final DeferredItem<SignItem> LEPTOPHLOEUM_SIGN = ITEMS.register("leptophloeum_sign",
            () -> new SignItem(BlocksTreeLeptophloeum.LEPTOPHLOEUM_SIGN.get(), BlocksTreeLeptophloeum.LEPTOPHLOEUM_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_sign")))));

    public static final DeferredItem<HangingSignItem> LEPTOPHLOEUM_HANGING_SIGN = ITEMS.register("leptophloeum_hanging_sign",
            () -> new HangingSignItem(BlocksTreeLeptophloeum.LEPTOPHLOEUM_SIGN_HANGING.get(), BlocksTreeLeptophloeum.LEPTOPHLOEUM_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_hanging_sign")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
