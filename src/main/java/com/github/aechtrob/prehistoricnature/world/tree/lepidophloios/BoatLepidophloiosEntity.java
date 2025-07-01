package com.github.aechtrob.prehistoricnature.world.tree.lepidophloios;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class BoatLepidophloiosEntity extends Boat {
    public BoatLepidophloiosEntity(EntityType<? extends Boat> type, Level level, Supplier<Item> p_376917_) {
        super(EntitiesTreeLepidophloios.LEPIDOPHLOIOS_BOAT.get(), level, p_376917_);
    }

    @Override
    public EntityType<?> getType() {
        return EntitiesTreeLepidophloios.LEPIDOPHLOIOS_BOAT.get();
    }


}
