package com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.blockbase.*;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.particle.ModParticles;
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

public class BlocksTreeDiaphorodendron {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PrehistoricNature.MODID);

    public static final DeferredBlock<PNTreeLogBlock> DIAPHORODENDRON_LOG = registerBlock("diaphorodendron_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_log")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return DIAPHORODENDRON_LOG.get();
                }
            });

    public static final DeferredBlock<PNTreeLogBlock> DIAPHORODENDRON_WOOD = registerBlock("diaphorodendron_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_wood")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return DIAPHORODENDRON_WOOD.get();
                }
            });

    public static final DeferredBlock<SaplingBlock> DIAPHORODENDRON_SAPLING = registerBlock("diaphorodendron_sapling",
            () -> new SaplingBlock(PNTreeGrower.DIAPHORODENDRON_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_sapling")))));

    public static final DeferredBlock<PNTreeLogBlock> DIAPHORODENDRON_PLANKS = registerBlock("diaphorodendron_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_planks")))));

    public static final DeferredBlock<PNTreeLeavesBlock> DIAPHORODENDRON_LEAVES = registerBlock("diaphorodendron_leaves",
            () -> new PNTreeLeavesBlock(0.01F, ModParticles.DIAPHORODENDRON_PARTICLE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_leaves")))));

    public static final DeferredBlock<SlabBlock> DIAPHORODENDRON_SLAB = registerBlock("diaphorodendron_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_slab")))));

    public static final DeferredBlock<StairBlock> DIAPHORODENDRON_STAIRS = registerBlock("diaphorodendron_stairs",
            () -> new StairBlock(DIAPHORODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_stairs")))));

    public static final DeferredBlock<FenceBlock> DIAPHORODENDRON_FENCE = registerBlock("diaphorodendron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_fence")))));

    public static final DeferredBlock<FenceGateBlock> DIAPHORODENDRON_FENCE_GATE = registerBlock("diaphorodendron_fence_gate",
            () -> new FenceGateBlock(PNWoodTypes.DIAPHORODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_fence_gate")))));

    public static final DeferredBlock<DoorBlock> DIAPHORODENDRON_DOOR = registerBlock("diaphorodendron_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_door")))));

    public static final DeferredBlock<TrapDoorBlock> DIAPHORODENDRON_TRAPDOOR = registerBlock("diaphorodendron_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_trapdoor")))));

    public static final DeferredBlock<PressurePlateBlock> DIAPHORODENDRON_PRESSURE_PLATE = registerBlock("diaphorodendron_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_pressure_plate")))));

    public static final DeferredBlock<ButtonBlock> DIAPHORODENDRON_BUTTON = registerBlock("diaphorodendron_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_button")))));

    public static final DeferredBlock<PNStandingSignBlock> DIAPHORODENDRON_SIGN = registerBlockNoItem("diaphorodendron_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.DIAPHORODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/diaphorodendron_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNHangingSignBlock> DIAPHORODENDRON_SIGN_HANGING = registerBlockNoItem("diaphorodendron_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.DIAPHORODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/diaphorodendron_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallSignBlock> DIAPHORODENDRON_WALL_SIGN = registerBlockNoItem("diaphorodendron_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.DIAPHORODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_wall_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/diaphorodendron_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallHangingSignBlock> DIAPHORODENDRON_WALL_SIGN_HANGING = registerBlockNoItem("diaphorodendron_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.DIAPHORODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_wall_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/diaphorodendron_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<LadderBlock> DIAPHORODENDRON_LADDER = registerBlock("diaphorodendron_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_ladder")))));


    public static final DeferredBlock<PNBenchBlock> DIAPHORODENDRON_BENCH = registerBlock("diaphorodendron_bench",
            () -> new PNBenchBlock(DIAPHORODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_bench")))));

    public static final DeferredBlock<PNLitterbinBlock> DIAPHORODENDRON_LITTERBIN = registerBlock("diaphorodendron_litterbin",
            () -> new PNLitterbinBlock(DIAPHORODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_litterbin")))));

    public static final DeferredBlock<PNBridgeBlock> DIAPHORODENDRON_BRIDGE = registerBlock("diaphorodendron_bridge",
            () -> new PNBridgeBlock(DIAPHORODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never) //Not Khazad-Dum
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_bridge")))));

    public static final DeferredBlock<PNPlanterBlock> DIAPHORODENDRON_PLANTER_1 = registerBlock("diaphorodendron_planter1",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_planter1")))));

    public static final DeferredBlock<PNPlanterBlock> DIAPHORODENDRON_PLANTER_2 = registerBlock("diaphorodendron_planter2",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_planter2")))));


    //Other tree-specific stuff:
    public static final DeferredBlock<Block> DIAPHORODENDRON_STROBILUS = registerBlock("diaphorodendron_strobilus",
            () -> new DiaphorodendronStrobilus(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).offsetType(BlockBehaviour.OffsetType.NONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "diaphorodendron_strobilus")))));


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
