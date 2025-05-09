package com.github.aechtrob.prehistoricnature.world.tree.lepidodendron;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class BoatLepidodendronEntity extends Boat {
    public BoatLepidodendronEntity(EntityType<? extends Boat> type, Level level, Supplier<Item> p_376917_) {
        super(EntitiesTreeLepidodendron.LEPIDODENDRON_BOAT.get(), level, p_376917_);
    }

    @Override
    public EntityType<?> getType() {
        return EntitiesTreeLepidodendron.LEPIDODENDRON_BOAT.get();
    }


}
