package com.github.aechtrob.prehistoricnature.world.tree.gangamopteris;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class BoatGangamopterisEntity extends Boat {
    public BoatGangamopterisEntity(EntityType<? extends Boat> type, Level level, Supplier<Item> p_376917_) {
        super(EntitiesTreeGangamopteris.GANGAMOPTERIS_BOAT.get(), level, p_376917_);
    }

    @Override
    public EntityType<?> getType() {
        return EntitiesTreeGangamopteris.GANGAMOPTERIS_BOAT.get();
    }


}
