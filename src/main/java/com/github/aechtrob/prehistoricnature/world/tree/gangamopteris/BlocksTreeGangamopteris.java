package com.github.aechtrob.prehistoricnature.world.tree.gangamopteris;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.blockbase.*;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.util.PNWoodTypes;
import com.github.aechtrob.prehistoricnature.world.tree.PNTreeGrower;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
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
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class BlocksTreeGangamopteris {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PrehistoricNature.MODID);

    public static final DeferredBlock<PNTreeLogBlock> GANGAMOPTERIS_STRIPPED_LOG = registerBlock("stripped_gangamopteris_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_gangamopteris_log")))));

    public static final DeferredBlock<PNTreeLogBlock> GANGAMOPTERIS_LOG = registerBlock("gangamopteris_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_log")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return GANGAMOPTERIS_STRIPPED_LOG.get();
                }
            });

    public static final DeferredBlock<PNTreeLogBlock> GANGAMOPTERIS_STRIPPED_WOOD = registerBlock("stripped_gangamopteris_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_gangamopteris_wood")))));

    public static final DeferredBlock<PNTreeLogBlock> GANGAMOPTERIS_WOOD = registerBlock("gangamopteris_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_wood")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return GANGAMOPTERIS_STRIPPED_WOOD.get();
                }
            });

    public static final DeferredBlock<SaplingBlock> GANGAMOPTERIS_SAPLING = registerBlock("gangamopteris_sapling",
            () -> new SaplingBlock(PNTreeGrower.GANGAMOPTERIS_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_sapling")))));

    public static final DeferredBlock<PNTreeLogBlock> GANGAMOPTERIS_PLANKS = registerBlock("gangamopteris_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_planks")))));

    public static final DeferredBlock<PNTreeLeavesBlock> GANGAMOPTERIS_LEAVES = registerBlock("gangamopteris_leaves",
            () -> new PNTreeLeavesBlock(0, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_leaves")))));

    public static final DeferredBlock<SlabBlock> GANGAMOPTERIS_SLAB = registerBlock("gangamopteris_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_slab")))));

    public static final DeferredBlock<StairBlock> GANGAMOPTERIS_STAIRS = registerBlock("gangamopteris_stairs",
            () -> new StairBlock(GANGAMOPTERIS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_stairs")))));

    public static final DeferredBlock<FenceBlock> GANGAMOPTERIS_FENCE = registerBlock("gangamopteris_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_fence")))));

    public static final DeferredBlock<FenceGateBlock> GANGAMOPTERIS_FENCE_GATE = registerBlock("gangamopteris_fence_gate",
            () -> new FenceGateBlock(PNWoodTypes.GANGAMOPTERIS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_fence_gate")))));

    public static final DeferredBlock<DoorBlock> GANGAMOPTERIS_DOOR = registerBlock("gangamopteris_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_door")))));

    public static final DeferredBlock<TrapDoorBlock> GANGAMOPTERIS_TRAPDOOR = registerBlock("gangamopteris_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_trapdoor")))));

    public static final DeferredBlock<PressurePlateBlock> GANGAMOPTERIS_PRESSURE_PLATE = registerBlock("gangamopteris_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_pressure_plate")))));

    public static final DeferredBlock<ButtonBlock> GANGAMOPTERIS_BUTTON = registerBlock("gangamopteris_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_button")))));

    public static final DeferredBlock<PNStandingSignBlock> GANGAMOPTERIS_SIGN = registerBlockNoItem("gangamopteris_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.GANGAMOPTERIS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/gangamopteris_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNHangingSignBlock> GANGAMOPTERIS_SIGN_HANGING = registerBlockNoItem("gangamopteris_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.GANGAMOPTERIS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/gangamopteris_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallSignBlock> GANGAMOPTERIS_WALL_SIGN = registerBlockNoItem("gangamopteris_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.GANGAMOPTERIS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_wall_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/gangamopteris_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallHangingSignBlock> GANGAMOPTERIS_WALL_SIGN_HANGING = registerBlockNoItem("gangamopteris_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.GANGAMOPTERIS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_wall_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/gangamopteris_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<LadderBlock> GANGAMOPTERIS_LADDER = registerBlock("gangamopteris_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_ladder")))));


    public static final DeferredBlock<PNBenchBlock> GANGAMOPTERIS_BENCH = registerBlock("gangamopteris_bench",
            () -> new PNBenchBlock(GANGAMOPTERIS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_bench")))));

    public static final DeferredBlock<PNLitterbinBlock> GANGAMOPTERIS_LITTERBIN = registerBlock("gangamopteris_litterbin",
            () -> new PNLitterbinBlock(GANGAMOPTERIS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_litterbin")))));

    public static final DeferredBlock<PNBridgeBlock> GANGAMOPTERIS_BRIDGE = registerBlock("gangamopteris_bridge",
            () -> new PNBridgeBlock(GANGAMOPTERIS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never) //Not Khazad-Dum
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_bridge")))));

    public static final DeferredBlock<PNPlanterBlock> GANGAMOPTERIS_PLANTER_1 = registerBlock("gangamopteris_planter1",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_planter1")))));

    public static final DeferredBlock<PNPlanterBlock> GANGAMOPTERIS_PLANTER_2 = registerBlock("gangamopteris_planter2",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_planter2")))));


    //Other tree-specific stuff:
    public static final DeferredBlock<Block> GANGAMOPTERIS_STROBILUS = registerBlock("gangamopteris_strobilus",
            () -> new GangamopterisStrobilus(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).offsetType(BlockBehaviour.OffsetType.NONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "gangamopteris_strobilus")))));


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
