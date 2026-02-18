//package com.github.aechtrob.prehistoricnature.item.itembase;
//
//import net.minecraft.core.Holder;
//import net.minecraft.resources.Identifier;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.enchantment.Enchantment;
//
//public class PNGeologicPick extends Item {
//
//    public PNGeologicPick(Properties properties) {
//        super(properties);
//    }
//
//    @Override
//    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
//        if (enchantment.is(ResourceLocation.fromNamespaceAndPath("minecraft","fortune"))
//                || enchantment.is(ResourceLocation.fromNamespaceAndPath("minecraft","mending"))
//                || enchantment.is(ResourceLocation.fromNamespaceAndPath("minecraft","efficiency"))
//                || enchantment.is(ResourceLocation.fromNamespaceAndPath("minecraft","durability"))
//                || enchantment.is(ResourceLocation.fromNamespaceAndPath("minecraft","unbreaking"))
//                || enchantment.is(ResourceLocation.fromNamespaceAndPath("minecraft","binding_curse"))
//                || enchantment.is(ResourceLocation.fromNamespaceAndPath("minecraft","vanishing_curse"))
//        ) {
//            return true;
//        }
//        return false;
//    }
//}