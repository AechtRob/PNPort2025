package com.github.aechtrob.prehistoricnature.world.tree.gangamopteris;

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

public class BlocksTreeGangamopteris {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricNature.MODID);

    public static final RegistryObject<PNTreeLogBlock> GANGAMOPTERIS_STRIPPED_LOG = registerBlock("stripped_gangamopteris_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<PNTreeLogBlock> GANGAMOPTERIS_LOG = registerBlock("gangamopteris_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return GANGAMOPTERIS_STRIPPED_LOG.get();
                }
            });

    public static final RegistryObject<PNTreeLogBlock> GANGAMOPTERIS_STRIPPED_WOOD = registerBlock("stripped_gangamopteris_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<PNTreeLogBlock> GANGAMOPTERIS_WOOD = registerBlock("gangamopteris_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return GANGAMOPTERIS_STRIPPED_WOOD.get();
                }
            });

    public static final RegistryObject<Block> GANGAMOPTERIS_SAPLING = registerBlock("gangamopteris_sapling",
            () -> new SaplingBlock(new GangamopterisTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<PNTreeLogBlock> GANGAMOPTERIS_PLANKS = registerBlock("gangamopteris_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNTreeLeavesBlock> GANGAMOPTERIS_LEAVES = registerBlock("gangamopteris_leaves",
            () -> new PNTreeLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<SlabBlock> GANGAMOPTERIS_SLAB = registerBlock("gangamopteris_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<StairBlock> GANGAMOPTERIS_STAIRS = registerBlock("gangamopteris_stairs",
            () -> new StairBlock(GANGAMOPTERIS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<FenceBlock> GANGAMOPTERIS_FENCE = registerBlock("gangamopteris_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<FenceGateBlock> GANGAMOPTERIS_FENCE_GATE = registerBlock("gangamopteris_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), PNWoodTypes.GANGAMOPTERIS));

    public static final RegistryObject<DoorBlock> GANGAMOPTERIS_DOOR = registerBlock("gangamopteris_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));

    public static final RegistryObject<TrapDoorBlock> GANGAMOPTERIS_TRAPDOOR = registerBlock("gangamopteris_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final RegistryObject<PressurePlateBlock> GANGAMOPTERIS_PRESSURE_PLATE = registerBlock("gangamopteris_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<ButtonBlock> GANGAMOPTERIS_BUTTON = registerBlock("gangamopteris_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));

    public static final RegistryObject<PNStandingSignBlock> GANGAMOPTERIS_SIGN = registerBlockNoItem("gangamopteris_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.GANGAMOPTERIS, BlockBehaviour.Properties.copy(Blocks.OAK_SIGN)) {
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/gangamopteris_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<PNHangingSignBlock> GANGAMOPTERIS_SIGN_HANGING = registerBlockNoItem("gangamopteris_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.GANGAMOPTERIS, BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN)){
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/gangamopteris_hanging_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<PNWallSignBlock> GANGAMOPTERIS_WALL_SIGN = registerBlockNoItem("gangamopteris_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.GANGAMOPTERIS, BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN)){
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/gangamopteris_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<PNWallHangingSignBlock> GANGAMOPTERIS_WALL_SIGN_HANGING = registerBlockNoItem("gangamopteris_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.GANGAMOPTERIS, BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN)){
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/gangamopteris_hanging_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<LadderBlock> GANGAMOPTERIS_LADDER = registerBlock("gangamopteris_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));


    public static final RegistryObject<PNBenchBlock> GANGAMOPTERIS_BENCH = registerBlock("gangamopteris_bench",
            () -> new PNBenchBlock(GANGAMOPTERIS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNLitterbinBlock> GANGAMOPTERIS_LITTERBIN = registerBlock("gangamopteris_litterbin",
            () -> new PNLitterbinBlock(GANGAMOPTERIS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNBridgeBlock> GANGAMOPTERIS_BRIDGE = registerBlock("gangamopteris_bridge",
            () -> new PNBridgeBlock(GANGAMOPTERIS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNPlanterBlock> GANGAMOPTERIS_PLANTER_1 = registerBlock("gangamopteris_planter1",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<PNPlanterBlock> GANGAMOPTERIS_PLANTER_2 = registerBlock("gangamopteris_planter2",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));


    //Other tree-specific stuff:
    public static final RegistryObject<Block> GANGAMOPTERIS_STROBILUS = registerBlock("gangamopteris_strobilus",
            () -> new GangamopterisStrobilus(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).offsetType(BlockBehaviour.OffsetType.NONE)));


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
