package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.IShearable;

import java.util.List;
import java.util.Objects;

import static com.github.aechtrob.prehistoricnature.util.Functions.isWater;

public class PNPineConeBlock extends FallingBlock implements SimpleWaterloggedBlock, IShearable {

    public static final MapCodec<PNPineConeBlock> CODEC = simpleCodec(PNPineConeBlock::new);

    public PNPineConeBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {

        Level world = params.getLevel();

        Vec3 vec3 = params.getParameter(LootContextParams.ORIGIN);
        BlockPos pos = new BlockPos((int)vec3.x, (int)vec3.y, (int)vec3.z);

        if (isWater(world, pos.north())
                || isWater(world, pos.south())
                || isWater(world, pos.east())
                || isWater(world, pos.west())
                || isWater(world, pos.above())
        )
        {
            ObjectArrayList<ItemStack> objectarraylist = new ObjectArrayList();
            Objects.requireNonNull(objectarraylist);
            objectarraylist.add(new ItemStack(this));
            return objectarraylist;
        }
        return super.getDrops(state, params);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (level.getBlockState(pos.below()).getPistonPushReaction() == PushReaction.DESTROY
                && (level.getBlockState(pos.below()).getBlock() != this)) {
            level.destroyBlock(pos.below(), false);
        }
        else {
            if ((level.getBlockState(pos.below())).getBlock() == this) {
                level.destroyBlock(pos.below(), true);
            }
        }
    }



    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }

    @Override
    public int getDustColor(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return 0;
    }
}
