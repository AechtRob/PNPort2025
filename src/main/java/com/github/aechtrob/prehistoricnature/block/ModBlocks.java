package com.github.aechtrob.prehistoricnature.block;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PrehistoricNature.MODID);

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
