package com.github.aechtrob.prehistoricnature.block;

import com.github.aechtrob.prehistoricnature.entity.blockentity.BlockEntityDNARecombinerCentrifuge;
import com.github.aechtrob.prehistoricnature.entity.blockentity.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BlockDNARecombinerCentrifuge extends Block implements EntityBlock {

    @SuppressWarnings("unchecked") // Due to generics, an unchecked cast is necessary here.
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == ModBlockEntities.CENTRIFUGE.get() ? (BlockEntityTicker<T>) BlockEntityDNARecombinerCentrifuge::tick : null;
    }

    public static final MapCodec<BlockDNARecombinerCentrifuge> CODEC = simpleCodec(BlockDNARecombinerCentrifuge::new);
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);
    public static EnumProperty<Direction> FACING;

    public BlockDNARecombinerCentrifuge(Properties properties) {
        super(properties);
        this.registerDefaultState(((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, net.minecraft.world.level.block.Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    //-------------------

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BlockEntityDNARecombinerCentrifuge(blockPos, blockState);
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
    }


}
