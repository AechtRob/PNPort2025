package com.github.aechtrob.prehistoricnature.world.tree.gangamopteris;

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

public class ItemsTreeGangamopteris {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<BoatItem> GANGAMOPTERIS_BOAT = ITEMS.register("gangamopteris_boat",
            () -> new BoatItem(EntitiesTreeGangamopteris.GANGAMOPTERIS_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_boat")))));

    public static final DeferredItem<BoatItem> GANGAMOPTERIS_CHEST_BOAT = ITEMS.register("gangamopteris_chest_boat",
            () -> new BoatItem(EntitiesTreeGangamopteris.GANGAMOPTERIS_CHEST_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_chest_boat")))));

    public static final DeferredItem<SignItem> GANGAMOPTERIS_SIGN = ITEMS.register("gangamopteris_sign",
            () -> new SignItem(BlocksTreeGangamopteris.GANGAMOPTERIS_SIGN.get(), BlocksTreeGangamopteris.GANGAMOPTERIS_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_sign")))));

    public static final DeferredItem<HangingSignItem> GANGAMOPTERIS_HANGING_SIGN = ITEMS.register("gangamopteris_hanging_sign",
            () -> new HangingSignItem(BlocksTreeGangamopteris.GANGAMOPTERIS_SIGN_HANGING.get(), BlocksTreeGangamopteris.GANGAMOPTERIS_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_hanging_sign")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
