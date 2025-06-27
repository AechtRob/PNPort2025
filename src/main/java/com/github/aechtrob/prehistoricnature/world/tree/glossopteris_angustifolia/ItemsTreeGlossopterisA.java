package com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.entity.entity.ModBoatEntity;
import com.github.aechtrob.prehistoricnature.item.itembase.PNBoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsTreeGlossopterisA {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PrehistoricNature.MODID);

    public static final RegistryObject<PNBoatItem> GLOSSOPTERISA_BOAT = ITEMS.register("glossopteris_angustifolia_boat",
            () -> new PNBoatItem(false, ModBoatEntity.Type.GLOSSOPTERISA,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<PNBoatItem> GLOSSOPTERISA_CHEST_BOAT = ITEMS.register("glossopteris_angustifolia_chest_boat",
            () -> new PNBoatItem(true, ModBoatEntity.Type.GLOSSOPTERISA,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<SignItem> GLOSSOPTERISA_SIGN = ITEMS.register("glossopteris_angustifolia_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), BlocksTreeGlossopterisA.GLOSSOPTERISA_SIGN.get(), BlocksTreeGlossopterisA.GLOSSOPTERISA_WALL_SIGN.get()));

    public static final RegistryObject<HangingSignItem> GLOSSOPTERISA_HANGING_SIGN = ITEMS.register("glossopteris_angustifolia_hanging_sign",
            () -> new HangingSignItem(BlocksTreeGlossopterisA.GLOSSOPTERISA_SIGN_HANGING.get(), BlocksTreeGlossopterisA.GLOSSOPTERISA_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
