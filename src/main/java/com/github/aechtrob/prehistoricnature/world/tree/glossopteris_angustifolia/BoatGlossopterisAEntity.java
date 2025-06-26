package com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class BoatGlossopterisAEntity extends Boat {
    public BoatGlossopterisAEntity(EntityType<? extends Boat> type, Level level, Supplier<Item> p_376917_) {
        super(EntitiesTreeGlossopterisA.GLOSSOPTERISA_BOAT.get(), level, p_376917_);
    }

    @Override
    public EntityType<?> getType() {
        return EntitiesTreeGlossopterisA.GLOSSOPTERISA_BOAT.get();
    }


}
