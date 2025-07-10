package com.github.aechtrob.prehistoricnature.block;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricNature.MODID);
    
    public static final RegistryObject<KelpBlock> MACROCYSTIS = registerBlock("macrocystis",
            () -> new KelpBlock(BlockBehaviour.Properties.copy(Blocks.KELP)){
                @Override
                protected Block getBodyBlock() {
                    return MACROCYSTIS_PLANT.get();
                }
            }
    );
    public static final RegistryObject<KelpPlantBlock> MACROCYSTIS_PLANT = registerBlockNoItem("macrocystis_plant",
            () -> new KelpPlantBlock(BlockBehaviour.Properties.copy(Blocks.KELP_PLANT)){
                @Override
                protected GrowingPlantHeadBlock getHeadBlock() {
                    return (GrowingPlantHeadBlock)MACROCYSTIS.get();
                }
            });

    public static final RegistryObject<KelpBlock> NEREOCYSTIS = registerBlock("nereocystis",
            () -> new KelpBlock(BlockBehaviour.Properties.copy(Blocks.KELP)){
                @Override
                protected Block getBodyBlock() {
                    return NEREOCYSTIS_PLANT.get();
                }

                @Override
                public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource p_221353_) {
                    if (state.getValue(AGE) < 25 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos.relative(this.growthDirection), level.getBlockState(pos.relative(this.growthDirection)),p_221353_.nextDouble() < 0.14D)) {
                        BlockPos blockpos = pos.relative(this.growthDirection);
                        if (this.canGrowInto(level.getBlockState(blockpos)) && this.canGrowInto(level.getBlockState(blockpos.above()))) {
                            level.setBlockAndUpdate(blockpos, this.getGrowIntoState(state, level.random));
                            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, blockpos, level.getBlockState(blockpos));
                        }
                    }
                }

                @Override
                public boolean isValidBonemealTarget(LevelReader p_255931_, BlockPos pos, BlockState state, boolean p_256181_) {
                    return this.canGrowInto(p_255931_.getBlockState(pos.relative(this.growthDirection)))
                            && this.canGrowInto(p_255931_.getBlockState(pos.relative(this.growthDirection).above()));
                }

                @Override
                public void performBonemeal(ServerLevel p_221337_, RandomSource p_221338_, BlockPos p_221339_, BlockState p_221340_) {
                    BlockPos blockpos = p_221339_.relative(this.growthDirection);
                    int i = Math.min(p_221340_.getValue(AGE) + 1, 25);
                    int j = this.getBlocksToGrowWhenBonemealed(p_221338_);

                    for (int k = 0; k < j && this.canGrowInto(p_221337_.getBlockState(blockpos))
                            && this.canGrowInto(p_221337_.getBlockState(blockpos.above())); k++) {
                        p_221337_.setBlockAndUpdate(blockpos, p_221340_.setValue(AGE, i));
                        blockpos = blockpos.relative(this.growthDirection);
                        i = Math.min(i + 1, 25);
                    }
                }
            });
    public static final RegistryObject<KelpPlantBlock> NEREOCYSTIS_PLANT = registerBlockNoItem("nereocystis_plant",
            () -> new KelpPlantBlock(BlockBehaviour.Properties.copy(Blocks.KELP_PLANT)){
                @Override
                protected GrowingPlantHeadBlock getHeadBlock() {
                    return (GrowingPlantHeadBlock)NEREOCYSTIS.get();
                }
            });

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockNoItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
