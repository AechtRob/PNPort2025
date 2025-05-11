package com.github.aechtrob.prehistoricnature.world.tree.lepidodendron;

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

public class ItemsTreeLepidodendron {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PrehistoricNature.MODID);

    public static final RegistryObject<PNBoatItem> LEPIDODENDRON_BOAT = ITEMS.register("lepidodendron_boat",
            () -> new PNBoatItem(false, ModBoatEntity.Type.LEPIDODENDRON,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<PNBoatItem> LEPIDODENDRON_CHEST_BOAT = ITEMS.register("lepidodendron_chest_boat",
            () -> new PNBoatItem(true, ModBoatEntity.Type.LEPIDODENDRON,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<SignItem> LEPIDODENDRON_SIGN = ITEMS.register("lepidodendron_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), BlocksTreeLepidodendron.LEPIDODENDRON_SIGN.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN.get()));

    public static final RegistryObject<HangingSignItem> LEPIDODENDRON_HANGING_SIGN = ITEMS.register("lepidodendron_hanging_sign",
            () -> new HangingSignItem(BlocksTreeLepidodendron.LEPIDODENDRON_SIGN_HANGING.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN_HANGING.get(),
                    new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
