package com.github.aechtrob.prehistoricnature.world.tree.GlossopterisA;

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

public class ItemsTreeGlossopterisA {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<BoatItem> GLOSSOPTERISA_BOAT = ITEMS.register("glossopteris_angustifolia_boat",
            () -> new BoatItem(EntitiesTreeGlossopterisA.GLOSSOPTERISA_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_boat")))));

    public static final DeferredItem<BoatItem> GLOSSOPTERISA_CHEST_BOAT = ITEMS.register("glossopteris_angustifolia_chest_boat",
            () -> new BoatItem(EntitiesTreeGlossopterisA.GLOSSOPTERISA_CHEST_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_chest_boat")))));

    public static final DeferredItem<SignItem> GLOSSOPTERISA_SIGN = ITEMS.register("glossopteris_angustifolia_sign",
            () -> new SignItem(BlocksTreeGlossopterisA.GLOSSOPTERISA_SIGN.get(), BlocksTreeGlossopterisA.GLOSSOPTERISA_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_sign")))));

    public static final DeferredItem<HangingSignItem> GLOSSOPTERISA_HANGING_SIGN = ITEMS.register("glossopteris_angustifolia_hanging_sign",
            () -> new HangingSignItem(BlocksTreeGlossopterisA.GLOSSOPTERISA_SIGN_HANGING.get(), BlocksTreeGlossopterisA.GLOSSOPTERISA_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_hanging_sign")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
