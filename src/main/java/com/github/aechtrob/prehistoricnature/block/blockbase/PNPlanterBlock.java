package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.entity.blockentity.PlanterSoilHandler;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModPlanterBlockEntity;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TriState;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PNPlanterBlock extends PNBaseTrimmableBlock {
    public static final IntegerProperty SOIL;
    public static final MapCodec<PNBenchBlock> CODEC = RecordCodecBuilder.mapCodec((p_368439_) -> p_368439_.group(BlockState.CODEC.fieldOf("base_state").forGetter((p_304378_) -> p_304378_.baseState), propertiesCodec()).apply(p_368439_, PNBenchBlock::new));

    public MapCodec<? extends PNBenchBlock> codec() {
        return CODEC;
    }

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
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        InteractionResult planterSoilResult = PlanterSoilHandler.applySoil(stack, state, level, pos, player, hand, hitResult);
        if (planterSoilResult == InteractionResult.SUCCESS) {
            return planterSoilResult;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
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
    public TriState canSustainPlant(BlockState state, BlockGetter level, BlockPos soilPosition, Direction facing, BlockState plant) {
        if (facing == Direction.UP) {
            return TriState.TRUE;
        }
        return super.canSustainPlant(state, level, soilPosition, facing, plant);
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState state) {
        return Shapes.empty();
    }
    
    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess p_374352_, BlockPos pos, Direction direction, BlockPos p_56930_, BlockState p_56927_, RandomSource p_374581_) {
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
