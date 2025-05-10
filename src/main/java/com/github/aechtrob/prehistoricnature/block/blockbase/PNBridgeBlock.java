package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModTrimmableBlockEntity;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.SignalGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.extensions.IBlockStateExtension;

public class PNBridgeBlock extends PNBaseTrimmableBlock implements IBlockStateExtension {
    public static final MapCodec<PNBridgeBlock> CODEC = RecordCodecBuilder.mapCodec((p_368439_) -> p_368439_.group(BlockState.CODEC.fieldOf("base_state").forGetter((p_304378_) -> p_304378_.baseState), propertiesCodec()).apply(p_368439_, PNBridgeBlock::new));
    public static final EnumProperty<Direction> FACING;
    public static final BooleanProperty LEFT;
    public static final BooleanProperty RIGHT;
    public static final BooleanProperty FRONT;
    public static final BooleanProperty BACK;
    public static final BooleanProperty FENCE;
    private final Block base;
    protected final BlockState baseState;

    public MapCodec<? extends PNBridgeBlock> codec() {
        return CODEC;
    }

    public PNBridgeBlock(BlockState baseState, Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(LEFT, true)).setValue(RIGHT, true)).setValue(FRONT, true)).setValue(BACK, true)).setValue(FENCE, false)).setValue(VARIANT, 0));
        this.base = baseState.getBlock();
        this.baseState = baseState;
    }

    @Override
    protected int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        if (level instanceof ServerLevel) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            int variant = 0;
            if (blockEntity instanceof ModTrimmableBlockEntity) {
                variant = ((ModTrimmableBlockEntity) blockEntity).getVariant();
            }
            if (direction == Direction.DOWN && variant == 12) {
                return 15;
            }
        }
        return 0;
    }

    private static final VoxelShape BRIDGE_NORTH = Block.box(0,16,0, 16, 32, 1);
    private static final VoxelShape BRIDGE_EAST = Block.box(15,16,0, 16, 32, 16);
    private static final VoxelShape BRIDGE_SOUTH = Block.box(0,16,15, 16, 32, 16);
    private static final VoxelShape BRIDGE_WEST = Block.box(0,16,0, 1, 32, 16);

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = Block.box(0,10,0, 16, 16, 16);
        if (state.getValue(FACING) == Direction.NORTH) {
            if (state.getValue(FRONT)) {
                shape = Shapes.or(shape, BRIDGE_NORTH);
            }
            if (state.getValue(BACK)) {
                shape = Shapes.or(shape, BRIDGE_SOUTH);
            }
            if (state.getValue(LEFT)) {
                shape = Shapes.or(shape, BRIDGE_WEST);
            }
            if (state.getValue(RIGHT)) {
                shape = Shapes.or(shape, BRIDGE_EAST);
            }
        }
        if (state.getValue(FACING) == Direction.EAST) {
            if (state.getValue(FRONT)) {
                shape = Shapes.or(shape, BRIDGE_EAST);
            }
            if (state.getValue(BACK)) {
                shape = Shapes.or(shape, BRIDGE_WEST);
            }
            if (state.getValue(LEFT)) {
                shape = Shapes.or(shape, BRIDGE_NORTH);
            }
            if (state.getValue(RIGHT)) {
                shape = Shapes.or(shape, BRIDGE_SOUTH);
            }
        }
        if (state.getValue(FACING) == Direction.SOUTH) {
            if (state.getValue(FRONT)) {
                shape = Shapes.or(shape, BRIDGE_SOUTH);
            }
            if (state.getValue(BACK)) {
                shape = Shapes.or(shape, BRIDGE_NORTH);
            }
            if (state.getValue(LEFT)) {
                shape = Shapes.or(shape, BRIDGE_EAST);
            }
            if (state.getValue(RIGHT)) {
                shape = Shapes.or(shape, BRIDGE_WEST);
            }
        }
        if (state.getValue(FACING) == Direction.WEST) {
            if (state.getValue(FRONT)) {
                shape = Shapes.or(shape, BRIDGE_WEST);
            }
            if (state.getValue(BACK)) {
                shape = Shapes.or(shape, BRIDGE_EAST);
            }
            if (state.getValue(LEFT)) {
                shape = Shapes.or(shape, BRIDGE_SOUTH);
            }
            if (state.getValue(RIGHT)) {
                shape = Shapes.or(shape, BRIDGE_NORTH);
            }
        }
        return shape;
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public boolean shouldCheckWeakPower(BlockState state, SignalGetter level, BlockPos pos, Direction side) {
        return true;
    }

    @Override
    public boolean getWeakChanges(BlockState state, LevelReader level, BlockPos pos) {
        return true;
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState state) {
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
        builder.add(new Property[]{FACING, FENCE, LEFT, RIGHT, FRONT, BACK, VARIANT});
    }

    @Override
    protected boolean isPathfindable(BlockState p_56891_, PathComputationType p_56894_) {
        return false;
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess p_374352_, BlockPos pos, Direction direction, BlockPos p_56930_, BlockState p_56927_, RandomSource p_374581_) {

        BlockState oldState = state;

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
        boolean front = false;
        boolean back = false;

        boolean fence = (level.getBlockState(pos.below()).getBlock() instanceof FenceBlock)
                || (level.getBlockState(pos.below()).getBlock() instanceof WallBlock)
                || SupportType.FULL.isSupporting(level.getBlockState(pos.below()), level, pos.below(), Direction.UP)
                || SupportType.CENTER.isSupporting(level.getBlockState(pos.below()), level, pos.below(), Direction.UP);
//                || (level.getBlockState(pos.below()).isFaceSturdy(Direction.UP) .getBlockFaceShape(level, pos.below(), Direction.UP) == BlockFaceShape.CENTER)
//                || (level.getBlockState(pos.below()).getBlockFaceShape(level, pos.below(), Direction.UP) == BlockFaceShape.CENTER_BIG)
//        );

        if (facing == Direction.NORTH) {
            if (level.getBlockState(pos.east()).getBlock() instanceof PNBridgeBlock) {
                right = true;
            }
            if (level.getBlockState(pos.west()).getBlock() instanceof PNBridgeBlock) {
                left = true;
            }

            if ((!level.getBlockState(pos.north().above()).isCollisionShapeFullBlock(level, pos.north().above())) && (!(level.getBlockState(pos.north()).getBlock() instanceof PNBridgeBlock))) {
                if (!SupportType.FULL.isSupporting(level.getBlockState(pos.north()), level, pos.north(), Direction.UP)
                        && (!(level.getBlockState(pos.north()).getBlock() instanceof StairBlock))) {
                    front = true;
                }
            }
            if ((!level.getBlockState(pos.south().above()).isCollisionShapeFullBlock(level, pos.south().above())) && (!(level.getBlockState(pos.south()).getBlock() instanceof PNBridgeBlock))) {
                if (!SupportType.FULL.isSupporting(level.getBlockState(pos.south()), level, pos.south(), Direction.UP)
                        && (!(level.getBlockState(pos.south()).getBlock() instanceof StairBlock))) {
                    back = true;
                }
            }
        } else if (facing == Direction.SOUTH) {
            if (level.getBlockState(pos.east()).getBlock() instanceof PNBridgeBlock) {
                left = true;
            }
            if (level.getBlockState(pos.west()).getBlock() instanceof PNBridgeBlock) {
                right = true;
            }
            if ((!level.getBlockState(pos.south().above()).isCollisionShapeFullBlock(level, pos.south().above())) && (!(level.getBlockState(pos.south()).getBlock() instanceof PNBridgeBlock))) {
                if (!SupportType.FULL.isSupporting(level.getBlockState(pos.south()), level, pos.south(), Direction.UP)
                        && (!(level.getBlockState(pos.south()).getBlock() instanceof StairBlock))) {
                    front = true;
                }
            }
            if ((!level.getBlockState(pos.north().above()).isCollisionShapeFullBlock(level, pos.north().above())) && (!(level.getBlockState(pos.north()).getBlock() instanceof PNBridgeBlock))) {
                if (!SupportType.FULL.isSupporting(level.getBlockState(pos.north()), level, pos.north(), Direction.UP)
                        && (!(level.getBlockState(pos.north()).getBlock() instanceof StairBlock))) {
                    back = true;
                }
            }
        } else if (facing == Direction.WEST) {
            if (level.getBlockState(pos.north()).getBlock() instanceof PNBridgeBlock) {
                right = true;
            }
            if (level.getBlockState(pos.south()).getBlock() instanceof PNBridgeBlock) {
                left = true;
            }
            if ((!level.getBlockState(pos.west().above()).isCollisionShapeFullBlock(level, pos.west().above())) && (!(level.getBlockState(pos.west()).getBlock() instanceof PNBridgeBlock))) {
                if (!SupportType.FULL.isSupporting(level.getBlockState(pos.west()), level, pos.west(), Direction.UP)
                        && (!(level.getBlockState(pos.west()).getBlock() instanceof StairBlock))) {
                    front = true;
                }
            }
            if ((!level.getBlockState(pos.east().above()).isCollisionShapeFullBlock(level, pos.east().above())) && (!(level.getBlockState(pos.east()).getBlock() instanceof PNBridgeBlock))) {
                if (!SupportType.FULL.isSupporting(level.getBlockState(pos.east()), level, pos.east(), Direction.UP)
                        && (!(level.getBlockState(pos.east()).getBlock() instanceof StairBlock))) {
                    back = true;
                }
            }
        } else if (facing == Direction.EAST) {
            if (level.getBlockState(pos.north()).getBlock() instanceof PNBridgeBlock) {
                left = true;
            }
            if (level.getBlockState(pos.south()).getBlock() instanceof PNBridgeBlock) {
                right = true;
            }
            if ((!level.getBlockState(pos.east().above()).isCollisionShapeFullBlock(level, pos.east().above())) && (!(level.getBlockState(pos.east()).getBlock() instanceof PNBridgeBlock))) {
                if (!SupportType.FULL.isSupporting(level.getBlockState(pos.east()), level, pos.east(), Direction.UP)
                        && (!(level.getBlockState(pos.east()).getBlock() instanceof StairBlock))) {
                    front = true;
                }
            }
            if ((!level.getBlockState(pos.west().above()).isCollisionShapeFullBlock(level, pos.west().above())) && (!(level.getBlockState(pos.west()).getBlock() instanceof PNBridgeBlock))) {
                if (!SupportType.FULL.isSupporting(level.getBlockState(pos.west()), level, pos.west(), Direction.UP)
                        && (!(level.getBlockState(pos.west()).getBlock() instanceof StairBlock))) {
                    back = true;
                }
            }
        }
        state = ((BlockState)((BlockState) ((BlockState) ((BlockState)((BlockState)((BlockState)(BlockState)state.setValue(LEFT, !left)).setValue(RIGHT, !right)).setValue(RIGHT, !right)).setValue(FRONT, front)).setValue(BACK, back)).setValue(FENCE, fence)).setValue(VARIANT, variant);
        if (oldState == state) {
            return oldState;
        }

        return ((BlockState)((BlockState) ((BlockState) ((BlockState)((BlockState)((BlockState)(BlockState)state.setValue(LEFT, !left)).setValue(RIGHT, !right)).setValue(RIGHT, !right)).setValue(FRONT, front)).setValue(BACK, back)).setValue(FENCE, fence)).setValue(VARIANT, variant);
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state) {
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
        FRONT = BooleanProperty.create("front");
        BACK = BooleanProperty.create("back");
        FENCE = BooleanProperty.create("fence");
    }

}
