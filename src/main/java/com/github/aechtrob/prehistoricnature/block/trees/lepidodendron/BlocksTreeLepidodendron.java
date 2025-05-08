package com.github.aechtrob.prehistoricnature.block.trees.lepidodendron;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.blockbase.PNTreeLeavesBlock;
import com.github.aechtrob.prehistoricnature.block.blockbase.PNTreeLogBlock;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTreeGrower;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class BlocksTreeLepidodendron {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricNature.MODID);

    public static final RegistryObject<Block> LEPIDODENDRON_STRIPPED_LOG = registerBlock("lepidodendron_log_stripped",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> LEPIDODENDRON_LOG = registerBlock("lepidodendron_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPIDODENDRON_STRIPPED_LOG.get();
                }
            });

    public static final RegistryObject<Block> LEPIDODENDRON_STRIPPED_WOOD = registerBlock("lepidodendron_wood_stripped",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> LEPIDODENDRON_WOOD = registerBlock("lepidodendron_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPIDODENDRON_STRIPPED_WOOD.get();
                }
            });

    public static final RegistryObject<Block> LEPIDODENDRON_SAPLING = registerBlock("lepidodendron_sapling",
            () -> new SaplingBlock(new LepidodendronTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> LEPIDODENDRON_PLANKS = registerBlock("lepidodendron_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> LEPIDODENDRON_LEAVES = registerBlock("lepidodendron_leaves",
            () -> new PNTreeLeavesBlock(0, BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));


//    public static final RegistryObject<Block> LEPIDODENDRON_SLAB = BlockRegistration.slabBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_SLABS),
//                                                                            List.of(ItemTags.WOODEN_SLABS),treeName,treeId);
//    public static final RegistryObject<Block> LEPIDODENDRON_STAIRS = BlockRegistration.stairsBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_STAIRS),
//                                                                            List.of(ItemTags.WOODEN_STAIRS),treeName,treeId);
//    public static final RegistryObject<Block> LEPIDODENDRON_FENCE = BlockRegistration.fenceBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_FENCES),
//                                                                            List.of(ItemTags.WOODEN_FENCES),treeName,treeId);
//    public static final RegistryObject<Block> LEPIDODENDRON_FENCE_GATE = BlockRegistration.fenceGateBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.FENCE_GATES),
//                                                                            List.of(ItemTags.FENCE_GATES), treeName, treeId);
//    public static final RegistryObject<Block> LEPIDODENDRON_DOOR = BlockRegistration.doorBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_DOORS),
//                                                                            List.of(ItemTags.WOODEN_DOORS), treeName, treeId);
//    //Needs manual json file.
//    public static final RegistryObject<Block> LEPIDODENDRON_TRAPDOOR = BlockRegistration.trapdoorBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_TRAPDOORS),
//                                                                            List.of(ItemTags.WOODEN_TRAPDOORS), treeName, treeId);
//    public static final RegistryObject<Block> LEPIDODENDRON_PRESSURE_PLATE = BlockRegistration.pressurePlateBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_PRESSURE_PLATES),
//                                                                            List.of(ItemTags.WOODEN_PRESSURE_PLATES), treeName, treeId);
//    public static final RegistryObject<Block> LEPIDODENDRON_BUTTON = BlockRegistration.buttonBlock(LEPIDODENDRON_PLANKS ,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_BUTTONS),
//                                                                            List.of(ItemTags.WOODEN_BUTTONS), treeName, treeId);
//    public static final RegistryObject<Block> LEPIDODENDRON_WALL_SIGN = BlockRegistration.wallSignBlock(LEPIDODENDRON,List.of(BlockTags.WALL_SIGNS),treeName);
//    public static final RegistryObject<Block> LEPIDODENDRON_SIGN = BlockRegistration.standingSignBlock(LEPIDODENDRON_WALL_SIGN,LEPIDODENDRON,List.of(BlockTags.STANDING_SIGNS),treeName);
//
//    public static final RegistryObject<Block> LEPIDODENDRON_LADDER = BlockRegistration.ladderBlock(
//            LEPIDODENDRON_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),treeName,treeId);


//    public static final RegistryObject<Block> LEPIDODENDRON_BENCH = BlockHandler.registerBlock("lepidodendron_bench",
//            () -> new PNBenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
//                    , 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));

    //Other tree-specific stuff:

    public static final RegistryObject<Block> LEPIDODENDRON_STROBILUS = registerBlock("lepidodendron_strobilus",
            () -> new LepidodendronStrobilus(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
