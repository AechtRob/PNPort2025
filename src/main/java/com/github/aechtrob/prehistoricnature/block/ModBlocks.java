package com.github.aechtrob.prehistoricnature.block;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
