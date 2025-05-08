package com.github.aechtrob.prehistoricnature.block.trees.lepidodendron;//package com.github.aechtrob.prehistoricnature.block.trees.lepidodendron;
//
//import com.github.aechtrob.prehistoricnature.block.BlockRegistration;
//import com.github.aechtrob.prehistoricnature.entity.entities.PNBoat;
//import com.github.aechtrob.prehistoricnature.item.ItemHandler;
//import com.github.aechtrob.prehistoricnature.item.items.PNBoatItem;
//import com.ibm.icu.impl.Pair;
//import net.minecraft.core.RegistryAccess;
//import net.minecraft.tags.ItemTags;
//import net.minecraft.world.item.Item;
//
//import java.util.List;
//
//import static com.github.aechtrob.prehistoricnature.creativetabs.CreativeTabHelper.transportTabBoatTier;
//
//public class ItemsTreeLepidodendron {
//    public static void register(){}
//    public static final RegistryAccess.RegistryEntry<Item> LEPIDODENDRON_SIGN_ITEM = BlockRegistration.signItem(BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS,BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN,BlocksTreeLepidodendron.LEPIDODENDRON_SIGN,
//            List.of(ItemTags.SIGNS),BlocksTreeLepidodendron.treeName,BlocksTreeLepidodendron.treeId);
//
//
//    public static final RegistryAccess.RegistryEntry<Item> LEPIDODENDRON_BOAT_ITEM = ItemHandler.addItem("lepidodendron_boat",
//            () -> new PNBoatItem(false, PNBoat.Type.LEPIDODENDRON, new Item.Properties().stacksTo(1)),
//            (provider, item) -> {provider.basicItem(item);},
//            List.of(Pair.of("prehistoricnature_transport_tab",Pair.of(transportTabBoatTier,BlocksTreeLepidodendron.treeId))),
//            "Lepidodendron Boat");
//
//    public static final RegistryAccess.RegistryEntry<Item> LEPIDODENDRON_CHEST_BOAT_ITEM = ItemHandler.addItem("lepidodendron_chest_boat",
//            () -> new PNBoatItem(true, PNBoat.Type.LEPIDODENDRON, new Item.Properties().stacksTo(1)),
//            (provider, item) -> {provider.basicItem(item);},
//            List.of(Pair.of("prehistoricnature_transport_tab",Pair.of(transportTabBoatTier,BlocksTreeLepidodendron.treeId))),
//            "Lepidodendron Chest Boat");
//
//
//            //regular item creation applies
//
//
//
//}
