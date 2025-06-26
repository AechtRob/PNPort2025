package com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia;

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

public class BlocksTreeGlossopterisA {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PrehistoricNature.MODID);

    public static final DeferredBlock<PNTreeLogBlock> GLOSSOPTERISA_STRIPPED_LOG = registerBlock("stripped_glossopteris_angustifolia_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_glossopteris_angustifolia_log")))));

    public static final DeferredBlock<PNTreeLogBlock> GLOSSOPTERISA_LOG = registerBlock("glossopteris_angustifolia_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_log")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return GLOSSOPTERISA_STRIPPED_LOG.get();
                }
            });

    public static final DeferredBlock<PNTreeLogBlock> GLOSSOPTERISA_STRIPPED_WOOD = registerBlock("stripped_glossopteris_angustifolia_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_glossopteris_angustifolia_wood")))));

    public static final DeferredBlock<PNTreeLogBlock> GLOSSOPTERISA_WOOD = registerBlock("glossopteris_angustifolia_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_wood")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return GLOSSOPTERISA_STRIPPED_WOOD.get();
                }
            });

    public static final DeferredBlock<SaplingBlock> GLOSSOPTERISA_SAPLING = registerBlock("glossopteris_angustifolia_sapling",
            () -> new SaplingBlock(PNTreeGrower.GLOSSOPTERISA_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_sapling")))));

    public static final DeferredBlock<PNTreeLogBlock> GLOSSOPTERISA_PLANKS = registerBlock("glossopteris_angustifolia_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_planks")))));

    public static final DeferredBlock<PNTreeLeavesBlock> GLOSSOPTERISA_LEAVES = registerBlock("glossopteris_angustifolia_leaves",
            () -> new PNTreeLeavesBlock(0, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_leaves")))));

    public static final DeferredBlock<SlabBlock> GLOSSOPTERISA_SLAB = registerBlock("glossopteris_angustifolia_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_slab")))));

    public static final DeferredBlock<StairBlock> GLOSSOPTERISA_STAIRS = registerBlock("glossopteris_angustifolia_stairs",
            () -> new StairBlock(GLOSSOPTERISA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_stairs")))));

    public static final DeferredBlock<FenceBlock> GLOSSOPTERISA_FENCE = registerBlock("glossopteris_angustifolia_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_fence")))));

    public static final DeferredBlock<FenceGateBlock> GLOSSOPTERISA_FENCE_GATE = registerBlock("glossopteris_angustifolia_fence_gate",
            () -> new FenceGateBlock(PNWoodTypes.GLOSSOPTERISA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_fence_gate")))));

    public static final DeferredBlock<DoorBlock> GLOSSOPTERISA_DOOR = registerBlock("glossopteris_angustifolia_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_door")))));

    public static final DeferredBlock<TrapDoorBlock> GLOSSOPTERISA_TRAPDOOR = registerBlock("glossopteris_angustifolia_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_trapdoor")))));

    public static final DeferredBlock<PressurePlateBlock> GLOSSOPTERISA_PRESSURE_PLATE = registerBlock("glossopteris_angustifolia_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_pressure_plate")))));

    public static final DeferredBlock<ButtonBlock> GLOSSOPTERISA_BUTTON = registerBlock("glossopteris_angustifolia_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_button")))));

    public static final DeferredBlock<PNStandingSignBlock> GLOSSOPTERISA_SIGN = registerBlockNoItem("glossopteris_angustifolia_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.GLOSSOPTERISA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/glossopteris_angustifolia_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNHangingSignBlock> GLOSSOPTERISA_SIGN_HANGING = registerBlockNoItem("glossopteris_angustifolia_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.GLOSSOPTERISA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/glossopteris_angustifolia_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallSignBlock> GLOSSOPTERISA_WALL_SIGN = registerBlockNoItem("glossopteris_angustifolia_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.GLOSSOPTERISA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_wall_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/glossopteris_angustifolia_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallHangingSignBlock> GLOSSOPTERISA_WALL_SIGN_HANGING = registerBlockNoItem("glossopteris_angustifolia_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.GLOSSOPTERISA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_wall_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/glossopteris_angustifolia_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<LadderBlock> GLOSSOPTERISA_LADDER = registerBlock("glossopteris_angustifolia_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_ladder")))));


    public static final DeferredBlock<PNBenchBlock> GLOSSOPTERISA_BENCH = registerBlock("glossopteris_angustifolia_bench",
            () -> new PNBenchBlock(GLOSSOPTERISA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_bench")))));

    public static final DeferredBlock<PNLitterbinBlock> GLOSSOPTERISA_LITTERBIN = registerBlock("glossopteris_angustifolia_litterbin",
            () -> new PNLitterbinBlock(GLOSSOPTERISA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_litterbin")))));

    public static final DeferredBlock<PNBridgeBlock> GLOSSOPTERISA_BRIDGE = registerBlock("glossopteris_angustifolia_bridge",
            () -> new PNBridgeBlock(GLOSSOPTERISA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never) //Not Khazad-Dum
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_bridge")))));

    public static final DeferredBlock<PNPlanterBlock> GLOSSOPTERISA_PLANTER_1 = registerBlock("glossopteris_angustifolia_planter1",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_planter1")))));

    public static final DeferredBlock<PNPlanterBlock> GLOSSOPTERISA_PLANTER_2 = registerBlock("glossopteris_angustifolia_planter2",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_planter2")))));


    //Other tree-specific stuff:
    public static final DeferredBlock<Block> GLOSSOPTERISA_STROBILUS = registerBlock("glossopteris_angustifolia_strobilus",
            () -> new GlossopterisAStrobilus(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).offsetType(BlockBehaviour.OffsetType.NONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_strobilus")))));


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
