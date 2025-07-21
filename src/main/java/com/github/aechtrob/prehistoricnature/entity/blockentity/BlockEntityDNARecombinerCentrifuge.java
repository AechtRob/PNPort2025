package com.github.aechtrob.prehistoricnature.entity.blockentity;

import com.github.aechtrob.prehistoricnature.PrehistoricNatureConfig;
import com.github.aechtrob.prehistoricnature.block.BlockDNARecombinerCentrifuge;
import com.github.aechtrob.prehistoricnature.block.ModBlocks;
import com.github.aechtrob.prehistoricnature.gui.modgui.CentrifugeGUI;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.util.PNTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

public class BlockEntityDNARecombinerCentrifuge extends BlockEntity implements Container, IEnergyStorage, MenuProvider {
    public NonNullList<ItemStack> centrifugeContents;
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(Level level, BlockPos pos, BlockState state) {
            BlockEntityDNARecombinerCentrifuge.playSound(level, pos, state, SoundEvents.CHEST_OPEN);
        }

        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state) {
            BlockEntityDNARecombinerCentrifuge.playSound(level, pos, state, SoundEvents.CHEST_CLOSE);
        }

        @Override
        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int p_155364_, int p_155365_) {
            BlockEntityDNARecombinerCentrifuge.this.signalOpenCount(level, pos, state, p_155364_, p_155365_);
        }

        @Override
        protected boolean isOwnContainer(Player player) {
            if (!(player.containerMenu instanceof CentrifugeGUI)) {
                return false;
            } else {
                Container container = ((CentrifugeGUI)player.containerMenu).getContainer();
                return container == BlockEntityDNARecombinerCentrifuge.this;
            }
        }
    };
    
    protected boolean isLocked;
    protected boolean isProcessing;
    public int processTick;
    public double centrifugeAngle;
    public double flareAngle;
    public double hatchVal;
    public long startTick;
    private int totalRevolutions = 16; //16 full revs for the process
    private int processCooldown = 200; //10 seconds to startup/slowdown
    private int processTickTime = 600; //30 seconds to spin (including startup/cooldown)
    public double cooldownDegrees = 360 * 7; //during warmup and cooldown we rotate this amount
    private int minEnergyNeeded = 500;

    public float lidAngle;
    public float prevLidAngle;
    public int numPlayersUsing;
    private int ticksSinceSync;

    public BlockEntityDNARecombinerCentrifuge(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.CENTRIFUGE.get(), pos, blockState);
        this.centrifugeContents = net.minecraft.core.NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    }

    @Override
    public int getContainerSize() {
        return 4;
    }
    
    @Override
    public void startOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void stopOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void updateOpeners() {
        this.numPlayersUsing = this.openersCounter.getOpenerCount();
    }
    
    static void playSound(Level level, BlockPos pos, BlockState state, SoundEvent sound) {
        level.playSound(null, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, sound, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
    }

    protected void signalOpenCount(Level level, BlockPos pos, BlockState state, int eventId, int eventParam) {
        Block block = state.getBlock();
        level.blockEvent(pos, block, 1, eventParam);
        this.numPlayersUsing = openersCounter.getOpenerCount();
    }
    
    public double getHatchVal() {
        return this.hatchVal;
    }

    public void setHatchVal(double val) {
        this.hatchVal = val;
    }

    @Override
    public boolean isEmpty() {
        Iterator var1 = this.centrifugeContents.iterator();

        ItemStack itemstack;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            itemstack = (ItemStack)var1.next();
        } while(itemstack.isEmpty());

        return false;
    }

    @Override
    public ItemStack getItem(int index) {
        return index >= 0 && index < this.centrifugeContents.size() ? (ItemStack)this.centrifugeContents.get(index) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        ItemStack itemstack = ContainerHelper.removeItem(this.centrifugeContents, index, count);
        if (!itemstack.isEmpty()) {
            this.setChanged();
        }

        return itemstack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        ItemStack itemstack = (ItemStack)this.centrifugeContents.get(index);
        if (itemstack.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            this.centrifugeContents.set(index, ItemStack.EMPTY);
            return itemstack;
        }
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.centrifugeContents.set(index, stack);
        stack.limitSize(this.getMaxStackSize(stack));
        this.setChanged();
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        if (stack.getItem() != ModItems.PHIAL.get()) {
            return false;
        }
        return Container.super.canPlaceItem(slot, stack);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        this.centrifugeContents.clear();
        this.setChanged();
    }

    // Create an update tag here. For block entities with only a few fields, this can just call #saveWithoutMetadata.
    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveWithoutMetadata(registries);
    }

    // Return our packet here. This method returning a non-null result tells the game to use this packet for syncing.
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        // The packet uses the CompoundTag returned by #getUpdateTag. An alternative overload of #create exists
        // that allows you to specify a custom update tag, including the ability to omit data the client might not need.
        return ClientboundBlockEntityDataPacket.create(this);
    }

    // Optionally: Run some custom logic when the packet is received.
    // The super/default implementation forwards to #loadWithComponents.
    @Override
    public void onDataPacket(Connection connection, ValueInput input) {
        super.onDataPacket(connection, input);
        // Do whatever you need to do here.
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.energy = input.getIntOr("energystored", 0);
        this.lidAngle = input.getFloatOr("lidAngle", 0.0F);
        this.prevLidAngle = input.getFloatOr("prevLidAngle", 0.0F);
        this.numPlayersUsing = input.getIntOr("numPlayersUsing", 0);
        this.ticksSinceSync = input.getIntOr("ticksSinceSync", 0);
        this.processTick = input.getIntOr("processTick", 0);
        this.isLocked = input.getBooleanOr("isLocked", false);
        this.hatchVal = input.getDoubleOr("hatchVal", 0.0D);
        this.isProcessing = input.getBooleanOr("isProcessing", false);
        this.startTick = input.getLongOr("startTick", 0L);
        this.centrifugeContents = net.minecraft.core.NonNullList.<ItemStack>withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(input, this.centrifugeContents);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("energystored", this.energy);
        output.putFloat("lidAngle", this.lidAngle);
        output.putFloat("prevLidAngle", this.prevLidAngle);
        output.putInt("numPlayersUsing", this.numPlayersUsing);
        output.putInt("ticksSinceSync", this.ticksSinceSync);
        output.putBoolean("isProcessing", this.isProcessing);
        output.putBoolean("isLocked", this.isLocked);
        output.putDouble("hatchVal", this.hatchVal);
        output.putInt("processTick", this.processTick);
        output.putLong("startTick", this.startTick);
        ContainerHelper.saveAllItems(output, this.centrifugeContents, true);
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState state, T t) {
        if (PrehistoricNatureConfig.machinesRF) {
            if (!state.getValue(BlockDNARecombinerCentrifuge.RF)) {
                level.setBlock(blockPos, state.setValue(BlockDNARecombinerCentrifuge.RF, true), 3);
            }
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof BlockEntityDNARecombinerCentrifuge) {
                BlockEntityDNARecombinerCentrifuge entity = (BlockEntityDNARecombinerCentrifuge) blockEntity;
                if (entity.getEnergyStored() < entity.getMaxEnergyStored()) {
                    //Is there a power-supplying block in the right place?
                    Direction facing = level.getBlockState(blockPos).getValue(BlockDNARecombinerCentrifuge.FACING);
                    if (facing != Direction.UP && facing != Direction.DOWN) {
                        BlockPos powerBlockPos = blockPos.relative(facing.getClockWise(Direction.Axis.Y));
                        BlockEntity teStorage = level.getBlockEntity(powerBlockPos);
                        if (teStorage != null) {
                            if (teStorage instanceof ICapabilityProvider) {
                                Object obj = ((ICapabilityProvider)teStorage).getCapability(Capabilities.EnergyStorage.ENTITY, facing.getCounterClockWise(Direction.Axis.Y));
                                if (obj != null) {
                                    IEnergyStorage powerBlockStorage = (IEnergyStorage) obj;
                                    //ICapabilityProvider powerBlockStorage = ((ICapabilityProvider)teStorage).getCapability(Capabilities.EnergyStorage.ENTITY, facing.getCounterClockWise(Direction.Axis.Y));
                                    //IEnergyStorage powerBlockStorage = teStorage.getCapability(CapabilityEnergy.ENERGY, facing.getCounterClockWise(Direction.Axis.Y));
                                    if (powerBlockStorage != null) {
                                        if (powerBlockStorage.canExtract()) {
                                            int energyTransferOut = powerBlockStorage.extractEnergy(entity.maxReceive, true);
                                            int energyTransferIn = entity.receiveEnergy(energyTransferOut, true);
                                            powerBlockStorage.extractEnergy(energyTransferIn, false);
                                            entity.receiveEnergy(energyTransferIn, false);
                                            level.sendBlockUpdated(blockPos, state, state, 3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            if (state.getValue(BlockDNARecombinerCentrifuge.RF)) {
                level.setBlock(blockPos, state.setValue(BlockDNARecombinerCentrifuge.RF, false), 3);
            }
        }

        boolean updated = false;
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof BlockEntityDNARecombinerCentrifuge) {
            BlockEntityDNARecombinerCentrifuge entity = (BlockEntityDNARecombinerCentrifuge) blockEntity;
            int i = blockPos.getX();
            int j = blockPos.getY();
            int k = blockPos.getZ();
            ++entity.ticksSinceSync;
            if (!entity.isLocked) {
//                if (!level.isClientSide && entity.numPlayersUsing != 0 && (entity.ticksSinceSync + i + j + k) % 200 == 0) {
//                    entity.numPlayersUsing = 0;
////                    float f = 5.0F;
////
////                    for (Entity entityOpener : level.getEntities((Entity)null, new AABB((double) ((float) i - 5.0F), (double) ((float) j - 5.0F), (double) ((float) k - 5.0F), (double) ((float) (i + 1) + 5.0F), (double) ((float) (j + 1) + 5.0F), (double) ((float) (k + 1) + 5.0F)),
////                            EntitySelector.CONTAINER_ENTITY_SELECTOR)) {
////                        if (entityOpener. .container .openContainer instanceof GUIDNACentrifuge.GUILepidodendronDNACentrifuge) {
////                            IInventory iinventory = ((GUIDNACentrifuge.GUILepidodendronDNACentrifuge) entityOpener.openContainer).getLowerChestInventory();
////
////                            if (iinventory == entity) {
////                                ++entity.numPlayersUsing;
////                            }
////                        }
////                    }
//
//                }

                entity.prevLidAngle = entity.lidAngle;
                float f1 = 0.1F;

                if (entity.numPlayersUsing > 0 && entity.lidAngle == 0.0F) {
                    double d1 = (double) i + 0.5D;
                    double d2 = (double) k + 0.5D;

                    level.playSound((Player) null, d1, (double) j + 0.5D, d2, SoundEvents.CHEST_OPEN, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
                }

                if (entity.numPlayersUsing == 0 && entity.lidAngle > 0.0F || entity.numPlayersUsing > 0 && entity.lidAngle < 1.0F) {
                    float f2 = entity.lidAngle;

                    if (entity.numPlayersUsing > 0) {
                        entity.lidAngle += 0.1F;
                    } else {
                        entity.lidAngle -= 0.1F;
                    }

                    if (entity.lidAngle > 1.0F) {
                        entity.lidAngle = 1.0F;
                    }

                    float f3 = 0.5F;

                    if (entity.lidAngle < 0.5F && f2 >= 0.5F) {
                        double d3 = (double) i + 0.5D;
                        double d0 = (double) k + 0.5D;

                        level.playSound((Player) null, d3, (double) j + 0.5D, d0, SoundEvents.CHEST_CLOSE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
                    }

                    if (entity.lidAngle < 0.0F) {
                        entity.lidAngle = 0.0F;
                    }
                    updated = true;
                }
            }

            if (level.isClientSide) {
                return;
            }

            //Do stuff
            if (canStartProcess(entity)) {
                entity.isProcessing = true;
                entity.isLocked = true;
                entity.processTick = 0;
                entity.startTick = level.getGameTime(); //Used for rendering
                updated = true;
            }

            if (entity.isProcessing && entity.processTick < entity.processTickTime) { //We will allow the centrifuge to run a ful cycle even if the power runs out :)
                entity.processTick++;
                entity.drainEnergy(100, entity);

                //Calculate the rotation needed:
                entity.centrifugeAngle = floorAngle(entity.getRotationAngle(entity.processTick));
                updated = true;
            } else {
                entity.flareAngle = 0;
                entity.centrifugeAngle = 0;
            }

            if (entity.processTick >= entity.processTickTime) {
                entity.processTick = 0;
                entity.isProcessing = false; //Not processing but should be left locked if it was locked before
            }

            if (updated) {
                level.sendBlockUpdated(blockPos, state, state, 3);
            }
        }
    }

    public static boolean canStartProcess(BlockEntityDNARecombinerCentrifuge entity) {

        if (PrehistoricNatureConfig.machinesRF) {
            if (!entity.hasEnergy(entity.minEnergyNeeded, entity)) {
                return false;
            }
        }

        if ((!entity.isProcessing)
                && (!isCentrifugePaused(entity))
                && (!entity.isLocked)
                && entity.lidAngle <= 0.0F
                && (
                (!entity.getItem(0).isEmpty()) && (!entity.getItem(2).isEmpty())
                        || (!entity.getItem(1).isEmpty()) && (!entity.getItem(3).isEmpty())
        )
                && (!((!entity.getItem(0).isEmpty()) && entity.getItem(2).isEmpty()))
                && (!((!entity.getItem(2).isEmpty()) && entity.getItem(0).isEmpty()))
                && (!((!entity.getItem(1).isEmpty()) && entity.getItem(3).isEmpty()))
                && (!((!entity.getItem(3).isEmpty()) && entity.getItem(1).isEmpty()))
        ) {
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            boolean flag4 = false;
            if (!entity.getItem(0).isEmpty()) {
                if (entity.getItem(0).is(PNTags.Items.REVIVABLE)) {
                    flag1 = true;
                }
            }
            if (!entity.getItem(1).isEmpty()) {
                if (entity.getItem(1).is(PNTags.Items.REVIVABLE)) {
                    flag2 = true;
                }
            }
            if (!entity.getItem(2).isEmpty()) {
                if (entity.getItem(2).is(PNTags.Items.REVIVABLE)) {
                    flag3 = true;
                }
            }
            if (!entity.getItem(3).isEmpty()) {
                if (entity.getItem(3).is(PNTags.Items.REVIVABLE)) {
                    flag4 = true;
                }
            }
            return (flag1 || flag2 || flag3 || flag4);
        }
        return false;
    }

    public double progressFraction() {
        if (this.isProcessing) {
            return (double)this.processTick / (double)this.processTickTime;
        }
        if (this.isLocked) {
            return 1;
        }
        return 0;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }

    public boolean isProcessing() {
        return this.isProcessing;
    }

    public static boolean isCentrifugePaused(BlockEntityDNARecombinerCentrifuge entity) {
        BlockState state = entity.level.getBlockState(entity.getBlockPos());
        Direction face = Direction.NORTH;
        if (state != null && state.getBlock() == ModBlocks.CENTRIFUGE.get()) {
            if (state.getValue(BlockDNARecombinerCentrifuge.FACING) == Direction.NORTH) {
                face = Direction.SOUTH;
            } else if (state.getValue(BlockDNARecombinerCentrifuge.FACING) == Direction.SOUTH) {
                face = Direction.NORTH;
            } else if (state.getValue(BlockDNARecombinerCentrifuge.FACING) == Direction.EAST) {
                face = Direction.WEST;
            } else if (state.getValue(BlockDNARecombinerCentrifuge.FACING) == Direction.WEST) {
                face = Direction.EAST;
            }
        }
        else {
            return false;
        }
        if (entity.level.hasNeighborSignal(entity.getBlockPos())
        ) {
            return true;
        }
//        if (entity.level.isSidePowered(entity.getBlockPos().relative(face), face.getOpposite())
//                ||
//                entity.level.isBlockPowered(entity.getBlockPos())
//        ) {
//            return true;
//        }
        return false;
    }

    public boolean isEmpty(BlockEntityDNARecombinerCentrifuge entity)
    {
        for (ItemStack itemstack : entity.centrifugeContents)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    public float getRotationAngle(double processticks) {
        double angle = 0D;
        if (processticks >= this.processTickTime || !this.isProcessing) {
            return 0;
        }
        if (processticks <= this.processCooldown) {
            //Is warming up:
            angle = (1D - Math.cos((processticks / (double)this.processCooldown) * (Math.PI / 2D))) * this.cooldownDegrees;
        }
        else if (processticks >= (this.processTickTime - this.processCooldown)) {
            //Is cooling down:
            angle = this.cooldownDegrees - (1D - Math.cos((((double)this.processTickTime - processticks - 1D) / (double)this.processCooldown) * (Math.PI / 2D))) * this.cooldownDegrees;
        }
        else {
            //is spinning
            angle = this.cooldownDegrees + (((processticks - this.processCooldown) / (this.processTickTime - (2 * this.processCooldown) - 1)) * (360 * this.totalRevolutions));
        }

        return (float) angle;
    }

    public float getFlareAngle(double processticks) {
        double angle = 0D;
        if (processticks >= this.processTickTime || !this.isProcessing) {
            return 0;
        }
        if (processticks <= this.processCooldown) {
            //Is warming up:
            angle = getRotationAngle(processticks);
            angle = (angle / this.cooldownDegrees) * 80;
        }
        else if (processticks >= (this.processTickTime - this.processCooldown)) {
            //Is cooling down:
            angle = getRotationAngle(processticks);
            angle = 80 - ((angle / this.cooldownDegrees) * 80);
        }
        else {
            //is spinning
            angle = 80;
        }

        return (float) angle;
    }

    public static double floorAngle(double angle) {
        if (angle >= 360) {
            return angle - (Math.floor(angle / 360D) * 360D);
        }
        return angle;
    }

    public void drainEnergy(int energy, BlockEntityDNARecombinerCentrifuge blockEntity) {
        blockEntity.extractEnergy(energy,false);
    }

    public static boolean hasEnergy(int minEnergy, BlockEntityDNARecombinerCentrifuge blockEntity) {
        if (!PrehistoricNatureConfig.machinesRF) {
            return true;
        }
        return blockEntity.getEnergyStored() > minEnergy;
    }

    //Energy addin:
    //-------------
    protected int energy;
    protected int capacity = 50000;
    protected int maxReceive = 500;
    protected int maxExtract = 250;

//    @Override
//    public boolean hasCapability(Capability<?> capability, @Nullable Direction facing) {
//        IBlockState blockstate = this.getWorld().getBlockState(this.getPos());
//        if (blockstate != null) {
//            if (blockstate.getBlock() == BlockDNARecombinerCentrifuge.block) {
//                Direction blockFacing = this.getWorld().getBlockState(this.getPos()).getValue(BlockDNARecombinerCentrifuge.FACING);
//                if (blockFacing == Direction.UP || blockFacing == Direction.DOWN) {
//                    return false;
//                }
//                blockFacing = blockFacing.rotateY();
//                if (capability == CapabilityEnergy.ENERGY && facing == blockFacing) {
//                    return true;
//                }
//            }
//        }
//        return super.hasCapability(capability, facing);
//    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate)
    {
        if (!canReceive())
            return 0;

        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
        if (!simulate) {
            energy += energyReceived;
            if (energyReceived > 0) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate)
    {
        if (!canExtract())
            return 0;

        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
        if (!simulate) {
            energy -= energyExtracted;
            if (energyExtracted > 0) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
        return energyExtracted;
    }

    @Override
    public int getEnergyStored()
    {
        return energy;
    }

    @Override
    public int getMaxEnergyStored()
    {
        return capacity;
    }

    @Override
    public boolean canExtract()
    {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canReceive()
    {
        return this.maxReceive > 0;
    }

    public double getEnergyFraction() {
        if (this.capacity > 0) {
            return ((double) this.energy) / ((double) this.capacity);
        }
        return 0;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("centrifuge");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new CentrifugeGUI(i, inventory, this);
    }
}
