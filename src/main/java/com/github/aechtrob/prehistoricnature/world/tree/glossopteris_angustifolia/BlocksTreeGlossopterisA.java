package com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.blockbase.*;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.util.PNWoodTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class BlocksTreeGlossopterisA {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricNature.MODID);

    public static final RegistryObject<PNTreeLogBlock> GLOSSOPTERISA_STRIPPED_LOG = registerBlock("stripped_glossopteris_angustifolia_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<PNTreeLogBlock> GLOSSOPTERISA_LOG = registerBlock("glossopteris_angustifolia_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return GLOSSOPTERISA_STRIPPED_LOG.get();
                }
            });

    public static final RegistryObject<PNTreeLogBlock> GLOSSOPTERISA_STRIPPED_WOOD = registerBlock("stripped_glossopteris_angustifolia_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<PNTreeLogBlock> GLOSSOPTERISA_WOOD = registerBlock("glossopteris_angustifolia_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return GLOSSOPTERISA_STRIPPED_WOOD.get();
                }
            });

    public static final RegistryObject<Block> GLOSSOPTERISA_SAPLING = registerBlock("glossopteris_angustifolia_sapling",
            () -> new SaplingBlock(new GlossopterisATreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<PNTreeLogBlock> GLOSSOPTERISA_PLANKS = registerBlock("glossopteris_angustifolia_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNTreeLeavesBlock> GLOSSOPTERISA_LEAVES = registerBlock("glossopteris_angustifolia_leaves",
            () -> new PNTreeLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<SlabBlock> GLOSSOPTERISA_SLAB = registerBlock("glossopteris_angustifolia_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<StairBlock> GLOSSOPTERISA_STAIRS = registerBlock("glossopteris_angustifolia_stairs",
            () -> new StairBlock(GLOSSOPTERISA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<FenceBlock> GLOSSOPTERISA_FENCE = registerBlock("glossopteris_angustifolia_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<FenceGateBlock> GLOSSOPTERISA_FENCE_GATE = registerBlock("glossopteris_angustifolia_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), PNWoodTypes.GLOSSOPTERISA));

    public static final RegistryObject<DoorBlock> GLOSSOPTERISA_DOOR = registerBlock("glossopteris_angustifolia_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));

    public static final RegistryObject<TrapDoorBlock> GLOSSOPTERISA_TRAPDOOR = registerBlock("glossopteris_angustifolia_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final RegistryObject<PressurePlateBlock> GLOSSOPTERISA_PRESSURE_PLATE = registerBlock("glossopteris_angustifolia_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<ButtonBlock> GLOSSOPTERISA_BUTTON = registerBlock("glossopteris_angustifolia_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));

    public static final RegistryObject<PNStandingSignBlock> GLOSSOPTERISA_SIGN = registerBlockNoItem("glossopteris_angustifolia_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.GLOSSOPTERISA, BlockBehaviour.Properties.copy(Blocks.OAK_SIGN)) {
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/glossopteris_angustifolia_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<PNHangingSignBlock> GLOSSOPTERISA_SIGN_HANGING = registerBlockNoItem("glossopteris_angustifolia_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.GLOSSOPTERISA, BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN)){
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/glossopteris_angustifolia_hanging_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<PNWallSignBlock> GLOSSOPTERISA_WALL_SIGN = registerBlockNoItem("glossopteris_angustifolia_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.GLOSSOPTERISA, BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN)){
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/glossopteris_angustifolia_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<PNWallHangingSignBlock> GLOSSOPTERISA_WALL_SIGN_HANGING = registerBlockNoItem("glossopteris_angustifolia_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.GLOSSOPTERISA, BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN)){
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/glossopteris_angustifolia_hanging_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<LadderBlock> GLOSSOPTERISA_LADDER = registerBlock("glossopteris_angustifolia_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));


    public static final RegistryObject<PNBenchBlock> GLOSSOPTERISA_BENCH = registerBlock("glossopteris_angustifolia_bench",
            () -> new PNBenchBlock(GLOSSOPTERISA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNLitterbinBlock> GLOSSOPTERISA_LITTERBIN = registerBlock("glossopteris_angustifolia_litterbin",
            () -> new PNLitterbinBlock(GLOSSOPTERISA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNBridgeBlock> GLOSSOPTERISA_BRIDGE = registerBlock("glossopteris_angustifolia_bridge",
            () -> new PNBridgeBlock(GLOSSOPTERISA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNPlanterBlock> GLOSSOPTERISA_PLANTER_1 = registerBlock("glossopteris_angustifolia_planter1",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<PNPlanterBlock> GLOSSOPTERISA_PLANTER_2 = registerBlock("glossopteris_angustifolia_planter2",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));


    //Other tree-specific stuff:
    public static final RegistryObject<Block> GLOSSOPTERISA_STROBILUS = registerBlock("glossopteris_angustifolia_strobilus",
            () -> new GlossopterisAStrobilus(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).offsetType(BlockBehaviour.OffsetType.NONE)));


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
