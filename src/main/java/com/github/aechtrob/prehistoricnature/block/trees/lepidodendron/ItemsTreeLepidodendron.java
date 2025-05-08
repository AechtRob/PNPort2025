package com.github.aechtrob.prehistoricnature.block.trees.lepidodendron;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsTreeLepidodendron {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<Item> LEPIDODENDRON_SIGN = ITEMS.register("lepidodendron_sign",
            () -> new SignItem(BlocksTreeLepidodendron.LEPIDODENDRON_SIGN.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_sign")))));

    public static final DeferredItem<Item> LEPIDODENDRON_HANGING_SIGN = ITEMS.register("lepidodendron_hanging_sign",
            () -> new HangingSignItem(BlocksTreeLepidodendron.LEPIDODENDRON_SIGN_HANGING.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_hanging_sign")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
