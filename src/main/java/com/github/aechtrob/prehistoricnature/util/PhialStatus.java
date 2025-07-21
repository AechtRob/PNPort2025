package com.github.aechtrob.prehistoricnature.util;

import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.item.PNPhial;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public record PhialStatus() implements RangeSelectItemModelProperty {

    public static final MapCodec<PhialStatus> MAP_CODEC = MapCodec.unit(new PhialStatus());

    @Override
    public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed) {
        if (stack.getItem() != ModItems.PHIAL.get()) {
            return 0;
        }
        if (!PNPhial.getProperties(stack).isEmpty()) {
            if (PNPhial.getProperties(stack).is(PNTags.Items.REVIVABLE)) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public MapCodec<PhialStatus> type() {
        return MAP_CODEC;
    }
}