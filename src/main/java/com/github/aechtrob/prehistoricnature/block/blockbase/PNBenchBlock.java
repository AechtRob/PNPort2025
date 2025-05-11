package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModTrimmableBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.entity.BenchSittableEntity;
import com.github.aechtrob.prehistoricnature.entity.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class PNBenchBlock extends PNBaseTrimmableBlock {
    public static final EnumProperty<Direction> FACING;
    public static final BooleanProperty LEFT;
    public static final BooleanProperty RIGHT;
    private final Block base;
    protected final BlockState baseState;

    public PNBenchBlock(BlockState baseState, Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(LEFT, true)).setValue(RIGHT, true)).setValue(VARIANT, 0));
        this.base = baseState.getBlock();
        this.baseState = baseState;
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        InteractionResult res = super.use(state, level, pos, player, hand, hitResult);
        if (res == InteractionResult.SUCCESS) {
            return res;
        }
        if (!level.isClientSide()) {
            Entity entity = null;
            List<BenchSittableEntity> entities = level.getEntities(ModEntities.BENCH_ENTITY.get(), new AABB(pos), chair -> true);
            if (entities.isEmpty()) {
                entity = ModEntities.BENCH_ENTITY.get().spawn(((ServerLevel) level), pos, MobSpawnType.TRIGGERED);
            } else {
                entity = entities.get(0);
            }
            player.startRiding(entity);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModTrimmableBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getBlockSupportShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return Shapes.empty();
    }

    private static final VoxelShape BENCH_SHAPE_SOUTH =
            Shapes.or(Block.box(0.0D, 0.0D, 1.0D, 16.0D, 16.0D, 2.0D),
                    Block.box(0.0D, 0.0D, 2.0D, 16.0D, 6.0D, 10.0D));
    private static final VoxelShape BENCH_SHAPE_EAST =
            Shapes.or(Block.box(1.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D),
                    Block.box(2.0D, 0.0D, 0.0D, 10.0D, 6.0D, 16.0D));
    private static final VoxelShape BENCH_SHAPE_NORTH =
            Shapes.or(Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 15.0D),
                    Block.box(0.0D, 0.0D, 6.0D, 16.0D, 6.0D, 14.0D));
    private static final VoxelShape BENCH_SHAPE_WEST =
            Shapes.or(Block.box(14.0D, 0.0D, 0.0D, 15.0D, 16.0D, 16.0D),
                    Block.box(6.0D, 0.0D, 0.0D, 14.0D, 6.0D, 16.0D));

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.getValue(FACING) == Direction.NORTH) {
            return BENCH_SHAPE_NORTH;
        }
        if (state.getValue(FACING) == Direction.EAST) {
            return BENCH_SHAPE_EAST;
        }
        if (state.getValue(FACING) == Direction.SOUTH) {
            return BENCH_SHAPE_SOUTH;
        }
        if (state.getValue(FACING) == Direction.WEST) {
            return BENCH_SHAPE_WEST;
        }
        return Shapes.empty();
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState p_60578_, BlockGetter p_60579_, BlockPos p_60580_) {
        return Shapes.empty();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockpos);
        BlockState blockstate = (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        return (BlockState)blockstate;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, LEFT, RIGHT, VARIANT});
    }

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return false;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        state = updateBlockState(state, level, pos);
        super.onPlace(state, level, pos, oldState, movedByPiston);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState p_60543_, LevelAccessor level, BlockPos pos, BlockPos p_60546_) {
        return updateBlockState(state, level, pos);
    }

    public static BlockState updateBlockState(BlockState state, LevelReader level, BlockPos pos) {
        int variant = 0;
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity != null) {
            if (blockEntity instanceof ModTrimmableBlockEntity) {
                variant = ((ModTrimmableBlockEntity) blockEntity).getVariant();
            }
        }

        Direction facing = state.getValue(FACING);
        if (facing == Direction.UP || facing == Direction.DOWN) {
            facing = Direction.NORTH;
        }

        boolean left = false;
        boolean right = false;
        if (facing == Direction.NORTH) {
            if (level.getBlockState(pos.east()).getBlock() instanceof PNBenchBlock) {
                right = level.getBlockState(pos.east()).getValue(FACING) == Direction.NORTH;
            }
            if (level.getBlockState(pos.west()).getBlock() instanceof PNBenchBlock) {
                left = level.getBlockState(pos.west()).getValue(FACING) == Direction.NORTH;
            }
        } else if (facing == Direction.SOUTH) {
            if (level.getBlockState(pos.east()).getBlock() instanceof PNBenchBlock) {
                left = level.getBlockState(pos.east()).getValue(FACING) == Direction.SOUTH;
            }
            if (level.getBlockState(pos.west()).getBlock() instanceof PNBenchBlock) {
                right = level.getBlockState(pos.west()).getValue(FACING) == Direction.SOUTH;
            }
        } else if (facing == Direction.WEST) {
            if (level.getBlockState(pos.north()).getBlock() instanceof PNBenchBlock) {
                right = level.getBlockState(pos.north()).getValue(FACING) == Direction.WEST;
            }
            if (level.getBlockState(pos.south()).getBlock() instanceof PNBenchBlock) {
                left = level.getBlockState(pos.south()).getValue(FACING) == Direction.WEST;
            }
        } else if (facing == Direction.EAST) {
            if (level.getBlockState(pos.north()).getBlock() instanceof PNBenchBlock) {
                left = level.getBlockState(pos.north()).getValue(FACING) == Direction.EAST;
            }
            if (level.getBlockState(pos.south()).getBlock() instanceof PNBenchBlock) {
                right = level.getBlockState(pos.south()).getValue(FACING) == Direction.EAST;
            }
        }

        return ((BlockState)((BlockState)(BlockState)state.setValue(LEFT, !left)).setValue(RIGHT, !right)).setValue(VARIANT, variant);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_49928_, BlockGetter p_49929_, BlockPos p_49930_) {
        return true;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        LEFT = BooleanProperty.create("left");
        RIGHT = BooleanProperty.create("right");
    }

}
