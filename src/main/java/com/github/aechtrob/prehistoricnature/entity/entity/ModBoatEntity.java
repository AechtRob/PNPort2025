package com.github.aechtrob.prehistoricnature.entity.entity;

import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.BlocksTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.ItemsTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.BlocksTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.ItemsTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.BlocksTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.ItemsTreeLepidodendron;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.IntFunction;

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public ModBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ModBoatEntity(Level level, double pX, double pY, double pZ) {
        this(ModEntities.BOAT_ENTITY.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case LEPIDODENDRON -> ItemsTreeLepidodendron.LEPIDODENDRON_BOAT.get();
            case GLOSSOPTERISA -> ItemsTreeGlossopterisA.GLOSSOPTERISA_BOAT.get();
            case GANGAMOPTERIS -> ItemsTreeGangamopteris.GANGAMOPTERIS_BOAT.get();
        };
    }

    public void setVariant(Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, Type.LEPIDODENDRON.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.GLOSSOPTERISA.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.GANGAMOPTERIS.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(Type.byName(pCompound.getString("Type")));
        }
    }

    public static enum Type implements StringRepresentable {
        LEPIDODENDRON(BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get(), "lepidodendron"),
        GLOSSOPTERISA(BlocksTreeGlossopterisA.GLOSSOPTERISA_PLANKS.get(), "glossopteris_angustifolia"),
        GANGAMOPTERIS(BlocksTreeGangamopteris.GANGAMOPTERIS_PLANKS.get(), "gangamopteris");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<ModBoatEntity.Type> CODEC = StringRepresentable.fromEnum(ModBoatEntity.Type::values);
        private static final IntFunction<ModBoatEntity.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        private Type(Block pPlanks, String pName) {
            this.name = pName;
            this.planks = pPlanks;
        }

        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        /**
         * Get a boat type by its enum ordinal
         */
        public static ModBoatEntity.Type byId(int pId) {
            return BY_ID.apply(pId);
        }

        public static ModBoatEntity.Type byName(String pName) {
             CODEC.byName(pName, LEPIDODENDRON);
             CODEC.byName(pName, GLOSSOPTERISA);
            return  CODEC.byName(pName, GANGAMOPTERIS);

        }
    }
}