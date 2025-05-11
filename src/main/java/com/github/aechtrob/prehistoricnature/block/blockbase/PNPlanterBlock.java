package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.PlanterSoilHandler;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModPlanterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import org.jetbrains.annotations.Nullable;

public class PNPlanterBlock extends PNBaseTrimmableBlock {
    public static final IntegerProperty SOIL;

    public PNPlanterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModPlanterBlockEntity(pos, state);
    }

    @Override
    public boolean hidesNeighborFace(BlockGetter level, BlockPos pos, BlockState state, BlockState neighborState, Direction dir) {
        return true;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        InteractionResult planterSoilResult = PlanterSoilHandler.applySoil(player.getItemInHand(hand), state, level, pos, player, hand, hitResult);
        if (planterSoilResult == InteractionResult.SUCCESS) {
            return planterSoilResult;
        }
        return super.use(state, level, pos, player, hand, hitResult);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        if (!level.isClientSide() && !player.isCreative()) {
            int soil = 0;
            if (blockEntity != null) {
                if (blockEntity instanceof ModPlanterBlockEntity) {
                    soil = ((ModPlanterBlockEntity) blockEntity).getSoil();
                }
            }
            if (soil > 0) {
                ItemEntity entityToSpawn = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), PlanterSoilHandler.getItemToDrop(soil));
                entityToSpawn.setDefaultPickUpDelay();
                level.addFreshEntity(entityToSpawn);
            }

            super.playerDestroy(level, player, pos, state, blockEntity, tool);
        }
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        if (facing == Direction.UP) {
            return true;
        }
        return super.canSustainPlant(state, world, pos, facing, plantable);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState p_60578_, BlockGetter p_60579_, BlockPos p_60580_) {
        return Shapes.empty();
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState p_60543_, LevelAccessor level, BlockPos pos, BlockPos p_60546_) {
        return updateBlockState(state, level, pos);
    }

    public static BlockState updateBlockState(BlockState state, LevelReader level, BlockPos pos) {
        int variant = 0;
        int soil = 0;
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity != null) {
            if (blockEntity instanceof ModPlanterBlockEntity) {
                variant = ((ModPlanterBlockEntity) blockEntity).getVariant();
                soil = ((ModPlanterBlockEntity) blockEntity).getSoil();
            }
        }

        return (BlockState)state.setValue(VARIANT, variant).setValue(SOIL, soil);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{VARIANT, SOIL});
    }

    static {
        SOIL = IntegerProperty.create("soil", 0, 1);
    }

}
