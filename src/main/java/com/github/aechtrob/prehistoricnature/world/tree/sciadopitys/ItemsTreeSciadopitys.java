package com.github.aechtrob.prehistoricnature.world.tree.sciadopitys;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.item.itembase.PNPlantable;
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

public class ItemsTreeSciadopitys {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrehistoricNature.MODID);

    public static final DeferredItem<BoatItem> SCIADOPITYS_BOAT = ITEMS.register("sciadopitys_boat",
            () -> new BoatItem(EntitiesTreeSciadopitys.SCIADOPITYS_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_boat")))));

    public static final DeferredItem<BoatItem> SCIADOPITYS_CHEST_BOAT = ITEMS.register("sciadopitys_chest_boat",
            () -> new BoatItem(EntitiesTreeSciadopitys.SCIADOPITYS_CHEST_BOAT.get(),
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_chest_boat")))));

    public static final DeferredItem<SignItem> SCIADOPITYS_SIGN = ITEMS.register("sciadopitys_sign",
            () -> new SignItem(BlocksTreeSciadopitys.SCIADOPITYS_SIGN.get(), BlocksTreeSciadopitys.SCIADOPITYS_WALL_SIGN.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_sign")))));

    public static final DeferredItem<HangingSignItem> SCIADOPITYS_HANGING_SIGN = ITEMS.register("sciadopitys_hanging_sign",
            () -> new HangingSignItem(BlocksTreeSciadopitys.SCIADOPITYS_SIGN_HANGING.get(), BlocksTreeSciadopitys.SCIADOPITYS_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_hanging_sign")))));

    public static final DeferredItem<Item> SCIADOPITYS_SEEDS = ITEMS.register("sciadopitys_seeds",
            () -> new PNPlantable(new Item.Properties().stacksTo(64).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_seeds"))), BlocksTreeSciadopitys.SCIADOPITYS_SAPLING.get().defaultBlockState(), 1));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
