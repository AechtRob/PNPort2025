package com.github.aechtrob.prehistoricnature.entity.entity;

import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.ItemsTreeBothrodendron;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.ItemsTreeDiaphorodendron;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.ItemsTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.ItemsTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.ItemsTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.ItemsTreeLepidophloios;
import com.github.aechtrob.prehistoricnature.world.tree.leptophloeum.ItemsTreeLeptophloeum;
import com.github.aechtrob.prehistoricnature.world.tree.pitys.ItemsTreePitys;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.ItemsTreeSciadopitys;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.ItemsTreeSynchysidendron;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ModChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModChestBoatEntity.class, EntityDataSerializers.INT);

    public ModChestBoatEntity(EntityType<? extends ChestBoat>entityType , Level level) {
        super(entityType, level);
    }

    public ModChestBoatEntity(Level level, double xx, double yy, double zz) {
        this(ModEntities.CHEST_BOAT_ENTITY.get(), level);
        this.setPos(xx, yy, zz);
        this.xo = xx;
        this.yo = yy;
        this.zo = zz;
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case BOTHRODENDRON -> ItemsTreeBothrodendron.BOTHRODENDRON_CHEST_BOAT.get();
            case DIAPHORODENDRON -> ItemsTreeDiaphorodendron.DIAPHORODENDRON_CHEST_BOAT.get();
            case GANGAMOPTERIS -> ItemsTreeGangamopteris.GANGAMOPTERIS_CHEST_BOAT.get();
            case GLOSSOPTERISA -> ItemsTreeGlossopterisA.GLOSSOPTERISA_CHEST_BOAT.get();
            case LEPIDODENDRON -> ItemsTreeLepidodendron.LEPIDODENDRON_CHEST_BOAT.get();
            case LEPIDOPHLOIOS -> ItemsTreeLepidophloios.LEPIDOPHLOIOS_CHEST_BOAT.get();
            case LEPTOPHLOEUM -> ItemsTreeLeptophloeum.LEPTOPHLOEUM_CHEST_BOAT.get();
            case PITYS -> ItemsTreePitys.PITYS_CHEST_BOAT.get();
            case SCIADOPITYS -> ItemsTreeSciadopitys.SCIADOPITYS_CHEST_BOAT.get();
            case SYNCHYSIDENDRON -> ItemsTreeSynchysidendron.SYNCHYSIDENDRON_CHEST_BOAT.get();

        };
    }

    public void setVariant(ModBoatEntity.Type type) {
        this.entityData.set(DATA_ID_TYPE, type.ordinal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.BOTHRODENDRON.ordinal());
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.DIAPHORODENDRON.ordinal());
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.GANGAMOPTERIS.ordinal());
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.GLOSSOPTERISA.ordinal());
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.LEPIDODENDRON.ordinal());
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.LEPIDOPHLOIOS.ordinal());
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.LEPTOPHLOEUM.ordinal());
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.PITYS.ordinal());
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.SCIADOPITYS.ordinal());
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.SYNCHYSIDENDRON.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("Type", 8)) {
            this.setVariant(ModBoatEntity.Type.byName(tag.getString("Type")));
        }
    }

    public ModBoatEntity.Type getModVariant() {
        return ModBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }
}
