package com.github.aechtrob.prehistoricnature.entity.entity;

import com.github.aechtrob.prehistoricnature.block.blockbase.PNBenchBlock;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class BenchSittableEntity extends Entity {
    public BenchSittableEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float v) {
        return false;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    public Vec3 getPassengerRidingPosition(Entity entity) {
        return super.getPassengerRidingPosition(entity).add(0,-0.1,0);
    }

    @Override
    public void tick() {
        //Dismount passengers and remove entity if there is no correct block here
        if (!this.level().isClientSide()) {
            if (!(this.level().getBlockState(this.blockPosition()).getBlock() instanceof PNBenchBlock)) {
                this.stopRiding();
                List<Entity> passengers = this.getPassengers();
                for (Entity e : passengers) {
                    this.gameEvent(GameEvent.ENTITY_DISMOUNT, e);
                }
                if (this.level() instanceof ServerLevel) {
                    this.kill((ServerLevel) this.level());
                }
            }
        }
        super.tick();
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (passenger.level() instanceof ServerLevel) {
            this.kill((ServerLevel) passenger.level());
        }
    }
}
