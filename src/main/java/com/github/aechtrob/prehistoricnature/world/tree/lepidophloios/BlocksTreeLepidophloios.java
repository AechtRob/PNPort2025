package com.github.aechtrob.prehistoricnature.world.tree.lepidophloios;

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

public class BlocksTreeLepidophloios {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PrehistoricNature.MODID);

    public static final DeferredBlock<PNTreeLogBlock> LEPIDOPHLOIOS_STRIPPED_LOG = registerBlock("stripped_lepidophloios_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_lepidophloios_log")))));

    public static final DeferredBlock<PNTreeLogBlock> LEPIDOPHLOIOS_LOG = registerBlock("lepidophloios_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_log")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPIDOPHLOIOS_STRIPPED_LOG.get();
                }
            });

    public static final DeferredBlock<PNTreeLogBlock> LEPIDOPHLOIOS_STRIPPED_WOOD = registerBlock("stripped_lepidophloios_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_lepidophloios_wood")))));

    public static final DeferredBlock<PNTreeLogBlock> LEPIDOPHLOIOS_WOOD = registerBlock("lepidophloios_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_wood")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPIDOPHLOIOS_STRIPPED_WOOD.get();
                }
            });

    public static final DeferredBlock<SaplingBlock> LEPIDOPHLOIOS_SAPLING = registerBlock("lepidophloios_sapling",
            () -> new SaplingBlock(PNTreeGrower.LEPIDOPHLOIOS_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_sapling")))));

    public static final DeferredBlock<PNTreeLogBlock> LEPIDOPHLOIOS_PLANKS = registerBlock("lepidophloios_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_planks")))));

    public static final DeferredBlock<PNTreeLeavesBlock> LEPIDOPHLOIOS_LEAVES = registerBlock("lepidophloios_leaves",
            () -> new PNTreeLeavesBlock(0, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_leaves")))));

    public static final DeferredBlock<SlabBlock> LEPIDOPHLOIOS_SLAB = registerBlock("lepidophloios_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_slab")))));

    public static final DeferredBlock<StairBlock> LEPIDOPHLOIOS_STAIRS = registerBlock("lepidophloios_stairs",
            () -> new StairBlock(LEPIDOPHLOIOS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_stairs")))));

    public static final DeferredBlock<FenceBlock> LEPIDOPHLOIOS_FENCE = registerBlock("lepidophloios_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_fence")))));

    public static final DeferredBlock<FenceGateBlock> LEPIDOPHLOIOS_FENCE_GATE = registerBlock("lepidophloios_fence_gate",
            () -> new FenceGateBlock(PNWoodTypes.LEPIDOPHLOIOS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_fence_gate")))));

    public static final DeferredBlock<DoorBlock> LEPIDOPHLOIOS_DOOR = registerBlock("lepidophloios_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_door")))));

    public static final DeferredBlock<TrapDoorBlock> LEPIDOPHLOIOS_TRAPDOOR = registerBlock("lepidophloios_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_trapdoor")))));

    public static final DeferredBlock<PressurePlateBlock> LEPIDOPHLOIOS_PRESSURE_PLATE = registerBlock("lepidophloios_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_pressure_plate")))));

    public static final DeferredBlock<ButtonBlock> LEPIDOPHLOIOS_BUTTON = registerBlock("lepidophloios_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_button")))));

    public static final DeferredBlock<PNStandingSignBlock> LEPIDOPHLOIOS_SIGN = registerBlockNoItem("lepidophloios_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.LEPIDOPHLOIOS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/lepidophloios_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNHangingSignBlock> LEPIDOPHLOIOS_SIGN_HANGING = registerBlockNoItem("lepidophloios_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.LEPIDOPHLOIOS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/lepidophloios_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallSignBlock> LEPIDOPHLOIOS_WALL_SIGN = registerBlockNoItem("lepidophloios_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.LEPIDOPHLOIOS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_wall_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/lepidophloios_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallHangingSignBlock> LEPIDOPHLOIOS_WALL_SIGN_HANGING = registerBlockNoItem("lepidophloios_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.LEPIDOPHLOIOS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_wall_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/lepidophloios_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<LadderBlock> LEPIDOPHLOIOS_LADDER = registerBlock("lepidophloios_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_ladder")))));


    public static final DeferredBlock<PNBenchBlock> LEPIDOPHLOIOS_BENCH = registerBlock("lepidophloios_bench",
            () -> new PNBenchBlock(LEPIDOPHLOIOS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_bench")))));

    public static final DeferredBlock<PNLitterbinBlock> LEPIDOPHLOIOS_LITTERBIN = registerBlock("lepidophloios_litterbin",
            () -> new PNLitterbinBlock(LEPIDOPHLOIOS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_litterbin")))));

    public static final DeferredBlock<PNBridgeBlock> LEPIDOPHLOIOS_BRIDGE = registerBlock("lepidophloios_bridge",
            () -> new PNBridgeBlock(LEPIDOPHLOIOS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never) //Not Khazad-Dum
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_bridge")))));

    public static final DeferredBlock<PNPlanterBlock> LEPIDOPHLOIOS_PLANTER_1 = registerBlock("lepidophloios_planter1",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_planter1")))));

    public static final DeferredBlock<PNPlanterBlock> LEPIDOPHLOIOS_PLANTER_2 = registerBlock("lepidophloios_planter2",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_planter2")))));


    //Other tree-specific stuff:
    public static final DeferredBlock<Block> LEPIDOPHLOIOS_STROBILUS = registerBlock("lepidophloios_strobilus",
            () -> new LepidophloiosStrobilus(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).offsetType(BlockBehaviour.OffsetType.NONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidophloios_strobilus")))));


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
