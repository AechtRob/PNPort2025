package com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class BoatDiaphorodendronEntity extends Boat {
    public BoatDiaphorodendronEntity(EntityType<? extends Boat> type, Level level, Supplier<Item> p_376917_) {
        super(EntitiesTreeDiaphorodendron.DIAPHORODENDRON_BOAT.get(), level, p_376917_);
    }

    @Override
    public EntityType<?> getType() {
        return EntitiesTreeDiaphorodendron.DIAPHORODENDRON_BOAT.get();
    }


}
