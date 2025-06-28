package com.github.aechtrob.prehistoricnature.world.tree.lepidodendron;

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

public class BlocksTreeLepidodendron {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricNature.MODID);

    public static final RegistryObject<PNTreeLogBlock> LEPIDODENDRON_STRIPPED_LOG = registerBlock("stripped_lepidodendron_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<PNTreeLogBlock> LEPIDODENDRON_LOG = registerBlock("lepidodendron_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPIDODENDRON_STRIPPED_LOG.get();
                }
            });

    public static final RegistryObject<PNTreeLogBlock> LEPIDODENDRON_STRIPPED_WOOD = registerBlock("stripped_lepidodendron_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<PNTreeLogBlock> LEPIDODENDRON_WOOD = registerBlock("lepidodendron_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPIDODENDRON_STRIPPED_WOOD.get();
                }
            });

    public static final RegistryObject<Block> LEPIDODENDRON_SAPLING = registerBlock("lepidodendron_sapling",
            () -> new SaplingBlock(new LepidodendronTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<PNTreeLogBlock> LEPIDODENDRON_PLANKS = registerBlock("lepidodendron_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNTreeLeavesBlock> LEPIDODENDRON_LEAVES = registerBlock("lepidodendron_leaves",
            () -> new PNTreeLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<SlabBlock> LEPIDODENDRON_SLAB = registerBlock("lepidodendron_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<StairBlock> LEPIDODENDRON_STAIRS = registerBlock("lepidodendron_stairs",
            () -> new StairBlock(LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<FenceBlock> LEPIDODENDRON_FENCE = registerBlock("lepidodendron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<FenceGateBlock> LEPIDODENDRON_FENCE_GATE = registerBlock("lepidodendron_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), PNWoodTypes.LEPIDODENDRON));

    public static final RegistryObject<DoorBlock> LEPIDODENDRON_DOOR = registerBlock("lepidodendron_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));

    public static final RegistryObject<TrapDoorBlock> LEPIDODENDRON_TRAPDOOR = registerBlock("lepidodendron_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final RegistryObject<PressurePlateBlock> LEPIDODENDRON_PRESSURE_PLATE = registerBlock("lepidodendron_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<ButtonBlock> LEPIDODENDRON_BUTTON = registerBlock("lepidodendron_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));

    public static final RegistryObject<PNStandingSignBlock> LEPIDODENDRON_SIGN = registerBlockNoItem("lepidodendron_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.copy(Blocks.OAK_SIGN)) {
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/lepidodendron_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<PNHangingSignBlock> LEPIDODENDRON_SIGN_HANGING = registerBlockNoItem("lepidodendron_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN)){
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/lepidodendron_hanging_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<PNWallSignBlock> LEPIDODENDRON_WALL_SIGN = registerBlockNoItem("lepidodendron_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN)){
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/lepidodendron_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<PNWallHangingSignBlock> LEPIDODENDRON_WALL_SIGN_HANGING = registerBlockNoItem("lepidodendron_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN)){
                @Override
                public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    LootTable loottable = serverlevel.getServer().getLootData().getLootTable(new ResourceLocation(PrehistoricNature.MODID, "blocks/lepidodendron_hanging_sign"));
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final RegistryObject<LadderBlock> LEPIDODENDRON_LADDER = registerBlock("lepidodendron_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));


    public static final RegistryObject<PNBenchBlock> LEPIDODENDRON_BENCH = registerBlock("lepidodendron_bench",
            () -> new PNBenchBlock(LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNLitterbinBlock> LEPIDODENDRON_LITTERBIN = registerBlock("lepidodendron_litterbin",
            () -> new PNLitterbinBlock(LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNBridgeBlock> LEPIDODENDRON_BRIDGE = registerBlock("lepidodendron_bridge",
            () -> new PNBridgeBlock(LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<PNPlanterBlock> LEPIDODENDRON_PLANTER_1 = registerBlock("lepidodendron_planter1",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<PNPlanterBlock> LEPIDODENDRON_PLANTER_2 = registerBlock("lepidodendron_planter2",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));


    //Other tree-specific stuff:
    public static final RegistryObject<Block> LEPIDODENDRON_STROBILUS = registerBlock("lepidodendron_strobilus",
            () -> new LepidodendronStrobilus(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).offsetType(BlockBehaviour.OffsetType.NONE)));


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
