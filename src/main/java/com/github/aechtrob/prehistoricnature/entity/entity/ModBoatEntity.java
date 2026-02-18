package com.github.aechtrob.prehistoricnature.entity.entity;

import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.BlocksTreeBothrodendron;
import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.ItemsTreeBothrodendron;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.BlocksTreeDiaphorodendron;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.ItemsTreeDiaphorodendron;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.BlocksTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.ItemsTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.BlocksTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.ItemsTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.BlocksTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.ItemsTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.BlocksTreeLepidophloios;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.ItemsTreeLepidophloios;
import com.github.aechtrob.prehistoricnature.world.tree.leptophloeum.BlocksTreeLeptophloeum;
import com.github.aechtrob.prehistoricnature.world.tree.leptophloeum.ItemsTreeLeptophloeum;
import com.github.aechtrob.prehistoricnature.world.tree.pitys.BlocksTreePitys;
import com.github.aechtrob.prehistoricnature.world.tree.pitys.ItemsTreePitys;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.BlocksTreeSciadopitys;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.ItemsTreeSciadopitys;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.BlocksTreeSynchysidendron;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.ItemsTreeSynchysidendron;
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
            case BOTHRODENDRON -> ItemsTreeBothrodendron.BOTHRODENDRON_BOAT.get();
            case DIAPHORODENDRON -> ItemsTreeDiaphorodendron.DIAPHORODENDRON_BOAT.get();
            case GANGAMOPTERIS -> ItemsTreeGangamopteris.GANGAMOPTERIS_BOAT.get();
            case GLOSSOPTERISA -> ItemsTreeGlossopterisA.GLOSSOPTERISA_BOAT.get();
            case LEPIDODENDRON -> ItemsTreeLepidodendron.LEPIDODENDRON_BOAT.get();
            case LEPIDOPHLOIOS -> ItemsTreeLepidophloios.LEPIDOPHLOIOS_BOAT.get();
            case LEPTOPHLOEUM -> ItemsTreeLeptophloeum.LEPTOPHLOEUM_BOAT.get();
            case PITYS -> ItemsTreePitys.PITYS_BOAT.get();
            case SCIADOPITYS -> ItemsTreeSciadopitys.SCIADOPITYS_BOAT.get();
            case SYNCHYSIDENDRON -> ItemsTreeSynchysidendron.SYNCHYSIDENDRON_BOAT.get();
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
        this.entityData.define(DATA_ID_TYPE, Type.BOTHRODENDRON.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.DIAPHORODENDRON.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.GANGAMOPTERIS.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.GLOSSOPTERISA.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.LEPIDODENDRON.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.LEPIDOPHLOIOS.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.LEPTOPHLOEUM.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.PITYS.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.SCIADOPITYS.ordinal());
        this.entityData.define(DATA_ID_TYPE, Type.SYNCHYSIDENDRON.ordinal());
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
        BOTHRODENDRON(BlocksTreeBothrodendron.BOTHRODENDRON_PLANKS.get(), "bothrodendron"),
        DIAPHORODENDRON(BlocksTreeDiaphorodendron.DIAPHORODENDRON_PLANKS.get(), "diaphorodendron"),
        GANGAMOPTERIS(BlocksTreeGangamopteris.GANGAMOPTERIS_PLANKS.get(), "gangamopteris"),
        GLOSSOPTERISA(BlocksTreeGlossopterisA.GLOSSOPTERISA_PLANKS.get(), "glossopteris_angustifolia"),
        LEPIDODENDRON(BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get(), "lepidodendron"),
        LEPIDOPHLOIOS(BlocksTreeLepidophloios.LEPIDOPHLOIOS_PLANKS.get(), "lepidophoios"),
        LEPTOPHLOEUM(BlocksTreeLeptophloeum.LEPTOPHLOEUM_PLANKS.get(), "leptophloeum"),
        PITYS(BlocksTreePitys.PITYS_PLANKS.get(), "pitys"),
        SCIADOPITYS(BlocksTreeSciadopitys.SCIADOPITYS_PLANKS.get(), "sciadopitys"),
        SYNCHYSIDENDRON(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_PLANKS.get(), "synchysidendron");

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
             return  CODEC.byName(pName, LEPIDODENDRON); //LEPIDODENDRON is a fallback: should never happen!

        }
    }
}