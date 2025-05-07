package com.github.aechtrob.prehistoricnature.block.blockbase;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;

public class PNDecayableDirectional extends Block {
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;

    public PNDecayableDirectional(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockstate = this.defaultBlockState();
        LevelReader levelreader = blockPlaceContext.getLevel();
        BlockPos blockpos = blockPlaceContext.getClickedPos();
        Direction[] adirection = blockPlaceContext.getNearestLookingDirections();

        for(Direction direction : adirection) {
            Direction direction1 = direction.getOpposite();
            blockstate = blockstate.setValue(DirectionalBlock.FACING, direction1).setValue(PERSISTENT, Boolean.valueOf(true));
            if (blockstate.canSurvive(levelreader, blockpos)) {
                return blockstate;
            }
        }

        return null;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction direction = state.getValue(DirectionalBlock.FACING);
        BlockPos blockpos = pos.relative(direction.getOpposite());
        BlockState blockstate = world.getBlockState(blockpos);
        return blockstate.isFaceSturdy(world, blockpos, direction) || blockstate.getBlock() instanceof LeavesBlock;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(DirectionalBlock.FACING, rotation.rotate(state.getValue(DirectionalBlock.FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(DirectionalBlock.FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(DirectionalBlock.FACING, PERSISTENT);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        return direction.getOpposite() == state.getValue(DirectionalBlock.FACING) && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : state;
    }

}
