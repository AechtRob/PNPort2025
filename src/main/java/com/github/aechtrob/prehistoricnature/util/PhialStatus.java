//package com.github.aechtrob.prehistoricnature.util;
//
//import com.github.aechtrob.prehistoricnature.item.ModItems;
//import com.github.aechtrob.prehistoricnature.item.PNPhial;
//import com.mojang.serialization.MapCodec;
//import net.minecraft.client.multiplayer.ClientLevel;
//import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
//import net.minecraft.world.entity.ItemOwner;
//import net.minecraft.world.item.ItemStack;
//
//public record PhialStatus() implements RangeSelectItemModelProperty {
//
//    public static final MapCodec<PhialStatus> MAP_CODEC = MapCodec.unit(new PhialStatus());
//
//    @Override
//    public float get(ItemStack itemStack, @org.jspecify.annotations.Nullable ClientLevel clientLevel, @org.jspecify.annotations.Nullable ItemOwner itemOwner, int i) {
//        if (itemStack.getItem() != ModItems.PHIAL.get()) {
//            return 0;
//        }
//        if (!PNPhial.getProperties(itemStack).isEmpty()) {
//            if (PNPhial.getProperties(itemStack).is(PNTags.Items.REVIVABLE)) {
//                return 1;
//            }
//        }
//        return 0;
//    }
//
//    @Override
//    public MapCodec<PhialStatus> type() {
//        return MAP_CODEC;
//    }
//}