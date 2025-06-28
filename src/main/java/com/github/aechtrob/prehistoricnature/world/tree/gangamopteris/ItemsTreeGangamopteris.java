package com.github.aechtrob.prehistoricnature.world.tree.gangamopteris;

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

public class ItemsTreeGangamopteris {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PrehistoricNature.MODID);

    public static final RegistryObject<PNBoatItem> GANGAMOPTERIS_BOAT = ITEMS.register("gangamopteris_boat",
            () -> new PNBoatItem(false, ModBoatEntity.Type.GANGAMOPTERIS,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<PNBoatItem> GANGAMOPTERIS_CHEST_BOAT = ITEMS.register("gangamopteris_chest_boat",
            () -> new PNBoatItem(true, ModBoatEntity.Type.GANGAMOPTERIS,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<SignItem> GANGAMOPTERIS_SIGN = ITEMS.register("gangamopteris_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), BlocksTreeGangamopteris.GANGAMOPTERIS_SIGN.get(), BlocksTreeGangamopteris.GANGAMOPTERIS_WALL_SIGN.get()));

    public static final RegistryObject<HangingSignItem> GANGAMOPTERIS_HANGING_SIGN = ITEMS.register("gangamopteris_hanging_sign",
            () -> new HangingSignItem(BlocksTreeGangamopteris.GANGAMOPTERIS_SIGN_HANGING.get(), BlocksTreeGangamopteris.GANGAMOPTERIS_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
