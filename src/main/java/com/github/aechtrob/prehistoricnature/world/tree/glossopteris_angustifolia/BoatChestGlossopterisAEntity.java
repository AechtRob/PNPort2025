package com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class BoatChestGlossopterisAEntity extends ChestBoat {
    public BoatChestGlossopterisAEntity(EntityType<? extends ChestBoat> type, Level level, Supplier<Item> p_376917_) {
        super(EntitiesTreeGlossopterisA.GLOSSOPTERISA_CHEST_BOAT.get(), level, p_376917_);
    }

    @Override
    public EntityType<?> getType() {
        return EntitiesTreeGlossopterisA.GLOSSOPTERISA_CHEST_BOAT.get();
    }


}
