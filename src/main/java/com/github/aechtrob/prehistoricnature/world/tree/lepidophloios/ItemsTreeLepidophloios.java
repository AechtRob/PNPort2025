package com.github.aechtrob.prehistoricnature.world.tree.lepidophloios;

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

public class ItemsTreeLepidophloios {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<BoatItem> LEPIDOPHLOIOS_BOAT = ITEMS.register("lepidophloios_boat",
            () -> new BoatItem(EntitiesTreeLepidophloios.LEPIDOPHLOIOS_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_boat")))));

    public static final DeferredItem<BoatItem> LEPIDOPHLOIOS_CHEST_BOAT = ITEMS.register("lepidophloios_chest_boat",
            () -> new BoatItem(EntitiesTreeLepidophloios.LEPIDOPHLOIOS_CHEST_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_chest_boat")))));

    public static final DeferredItem<SignItem> LEPIDOPHLOIOS_SIGN = ITEMS.register("lepidophloios_sign",
            () -> new SignItem(BlocksTreeLepidophloios.LEPIDOPHLOIOS_SIGN.get(), BlocksTreeLepidophloios.LEPIDOPHLOIOS_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_sign")))));

    public static final DeferredItem<HangingSignItem> LEPIDOPHLOIOS_HANGING_SIGN = ITEMS.register("lepidophloios_hanging_sign",
            () -> new HangingSignItem(BlocksTreeLepidophloios.LEPIDOPHLOIOS_SIGN_HANGING.get(), BlocksTreeLepidophloios.LEPIDOPHLOIOS_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_hanging_sign")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
