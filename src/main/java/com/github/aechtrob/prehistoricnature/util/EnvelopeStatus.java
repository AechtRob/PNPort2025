//package com.github.aechtrob.prehistoricnature.util;
//
//import com.github.aechtrob.prehistoricnature.item.ModItems;
//import com.github.aechtrob.prehistoricnature.item.PNCollectionEnvelope;
//import com.mojang.serialization.MapCodec;
//import net.minecraft.client.multiplayer.ClientLevel;
//import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
//import net.minecraft.world.entity.ItemOwner;
//import net.minecraft.world.item.ItemStack;
//
//public record EnvelopeStatus() implements RangeSelectItemModelProperty {
//
//    public static final MapCodec<EnvelopeStatus> MAP_CODEC = MapCodec.unit(new EnvelopeStatus());
//
//    @Override
//    public float get(ItemStack itemStack, @org.jspecify.annotations.Nullable ClientLevel clientLevel, @org.jspecify.annotations.Nullable ItemOwner itemOwner, int i) {
//        if (itemStack.getItem() != ModItems.COLLECTION_ENVELOPE.get()) {
//            return 0;
//        }
//        if (!PNCollectionEnvelope.getProperties(itemStack).isEmpty()) {
//            if (1==1) {
//                return 1;
//            }
//        }
//        return 0;
//    }
//
//    @Override
//    public MapCodec<EnvelopeStatus> type() {
//        return MAP_CODEC;
//    }
//}