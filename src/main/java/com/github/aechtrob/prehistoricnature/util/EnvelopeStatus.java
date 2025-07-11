package com.github.aechtrob.prehistoricnature.util;

import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.item.PNCollectionEnvelope;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public record EnvelopeStatus() implements RangeSelectItemModelProperty {

    public static final MapCodec<EnvelopeStatus> MAP_CODEC = MapCodec.unit(new EnvelopeStatus());

    @Override
    public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed) {
        if (stack.getItem() != ModItems.COLLECTION_ENVELOPE.get()) {
            return 0;
        }
        if (!PNCollectionEnvelope.getProperties(stack).isEmpty()) {
            return 1;
        }
        return 0;
    }

    @Override
    public MapCodec<EnvelopeStatus> type() {
        return MAP_CODEC;
    }
}