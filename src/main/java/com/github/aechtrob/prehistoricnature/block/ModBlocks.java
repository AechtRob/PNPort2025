package com.github.aechtrob.prehistoricnature.block;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.blockbase.PNFossilStoneBlock;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PrehistoricNature.MODID);

    //Blocks:
    //-------
    public static final DeferredBlock<PNFossilStoneBlock> PRECAMBRIAN_FOSSIL_STONE = registerBlock("fossil_stone_precambrian",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_precambrian"))), 14, 1){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> CAMBRIAN_FOSSIL_STONE = registerBlock("fossil_stone_cambrian",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_cambrian"))), 13, 2){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> ORDOVICIAN_FOSSIL_STONE = registerBlock("fossil_stone_ordovician",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_ordovician"))), 12, 3){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> SILURIAN_FOSSIL_STONE = registerBlock("fossil_stone_silurian",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_silurian"))), 11, 4){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> DEVONIAN_FOSSIL_STONE = registerBlock("fossil_stone_devonian",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_devonian"))), 10, 5){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> CARBONIFEROUS_FOSSIL_STONE = registerBlock("fossil_stone_carboniferous",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_carboniferous"))), 9, 6){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> PERMIAN_FOSSIL_STONE = registerBlock("fossil_stone_permian",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_permian"))), 8, 7){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> TRIASSIC_FOSSIL_STONE = registerBlock("fossil_stone_triassic",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_triassic"))), 7, 8){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> JURASSIC_FOSSIL_STONE = registerBlock("fossil_stone_jurassic",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_jurassic"))), 6, 9){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> CRETACEOUS_EARLY_FOSSIL_STONE = registerBlock("fossil_stone_cretaceous_early",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_cretaceous_early"))), 5, 10){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> CRETACEOUS_LATE_FOSSIL_STONE = registerBlock("fossil_stone_cretaceous_late",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_cretaceous_late"))), 4, 11){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> PALEOGENE_FOSSIL_STONE = registerBlock("fossil_stone_paleogene",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_paleogene"))), 3, 12){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> NEOGENE_FOSSIL_STONE = registerBlock("fossil_stone_neogene",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_neogene"))), 2, 13){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> PLEISTOCENE_FOSSIL_STONE = registerBlock("fossil_stone_pleistocene",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_pleistocene"))), 1, 14){}
    );

    public static final DeferredBlock<PNFossilStoneBlock> PRECAMBRIAN_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_precambrian_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_precambrian_deepslate"))), 14, 1){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> CAMBRIAN_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_cambrian_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_cambrian_deepslate"))), 13, 2){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> ORDOVICIAN_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_ordovician_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_ordovician_deepslate"))), 12, 3){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> SILURIAN_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_silurian_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_silurian_deepslate"))), 11, 4){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> DEVONIAN_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_devonian_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_devonian_deepslate"))), 10, 5){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> CARBONIFEROUS_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_carboniferous_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_carboniferous_deepslate"))), 9, 6){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> PERMIAN_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_permian_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_permian_deepslate"))), 8, 7){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> TRIASSIC_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_triassic_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_triassic_deepslate"))), 7, 8){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> JURASSIC_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_jurassic_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_jurassic_deepslate"))), 6, 9){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> CRETACEOUS_EARLY_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_cretaceous_early_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_cretaceous_early_deepslate"))), 5, 10){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> CRETACEOUS_LATE_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_cretaceous_late_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_cretaceous_late_deepslate"))), 4, 11){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> PALEOGENE_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_paleogene_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_paleogene_deepslate"))), 3, 12){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> NEOGENE_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_neogene_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_neogene_deepslate"))), 2, 13){}
    );
    public static final DeferredBlock<PNFossilStoneBlock> PLEISTOCENE_FOSSIL_STONE_DEEPSLATE = registerBlock("fossil_stone_pleistocene_deepslate",
            () -> new PNFossilStoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_stone_pleistocene_deepslate"))), 1, 14){}
    );


    //Plants:
    //-------
    public static final DeferredBlock<KelpBlock> MACROCYSTIS = registerBlock("macrocystis",
            () -> new KelpBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "macrocystis")))){
                @Override
                protected Block getBodyBlock() {
                    return MACROCYSTIS_PLANT.get();
                }
            }
    );
    public static final DeferredBlock<KelpPlantBlock> MACROCYSTIS_PLANT = registerBlockNoItem("macrocystis_plant",
            () -> new KelpPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP_PLANT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "macrocystis_plant")))){
                @Override
                protected GrowingPlantHeadBlock getHeadBlock() {
                    return (GrowingPlantHeadBlock)MACROCYSTIS.get();
                }
            });

    public static final DeferredBlock<KelpBlock> NEREOCYSTIS = registerBlock("nereocystis",
            () -> new KelpBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "nereocystis")))){
                @Override
                protected Block getBodyBlock() {
                    return NEREOCYSTIS_PLANT.get();
                }

                @Override
                protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource p_221353_) {
                    if (state.getValue(AGE) < 25 && net.neoforged.neoforge.common.CommonHooks.canCropGrow(level, pos.relative(this.growthDirection), state, p_221353_.nextDouble() < 0.14D)) {
                        BlockPos blockpos = pos.relative(this.growthDirection);
                        if (this.canGrowInto(level.getBlockState(blockpos)) && this.canGrowInto(level.getBlockState(blockpos.above()))) {
                            level.setBlockAndUpdate(blockpos, this.getGrowIntoState(state, level.random));
                            net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(level, blockpos, level.getBlockState(blockpos));
                        }
                    }
                }

                @Override
                public boolean isValidBonemealTarget(LevelReader p_255931_, BlockPos pos, BlockState p_256550_) {
                    return this.canGrowInto(p_255931_.getBlockState(pos.relative(this.growthDirection)))
                        && this.canGrowInto(p_255931_.getBlockState(pos.relative(this.growthDirection).above()));
                }

                @Override
                public void performBonemeal(ServerLevel p_221337_, RandomSource p_221338_, BlockPos p_221339_, BlockState p_221340_) {
                    BlockPos blockpos = p_221339_.relative(this.growthDirection);
                    int i = Math.min(p_221340_.getValue(AGE) + 1, 25);
                    int j = this.getBlocksToGrowWhenBonemealed(p_221338_);

                    for (int k = 0; k < j && this.canGrowInto(p_221337_.getBlockState(blockpos)) && this.canGrowInto(p_221337_.getBlockState(blockpos.above())); k++) {
                        p_221337_.setBlockAndUpdate(blockpos, p_221340_.setValue(AGE, i));
                        blockpos = blockpos.relative(this.growthDirection);
                        i = Math.min(i + 1, 25);
                    }
                }
            });
    public static final DeferredBlock<KelpPlantBlock> NEREOCYSTIS_PLANT = registerBlockNoItem("nereocystis_plant",
            () -> new KelpPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP_PLANT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "nereocystis_plant")))){
                @Override
                protected GrowingPlantHeadBlock getHeadBlock() {
                    return (GrowingPlantHeadBlock)NEREOCYSTIS.get();
                }
            });

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlockNoItem(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
