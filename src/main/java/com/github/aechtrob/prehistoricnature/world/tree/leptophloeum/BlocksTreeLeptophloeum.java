package com.github.aechtrob.prehistoricnature.world.tree.leptophloeum;

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

public class BlocksTreeLeptophloeum {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PrehistoricNature.MODID);

    public static final DeferredBlock<PNTreeLogBlock> LEPTOPHLOEUM_LOG = registerBlock("leptophloeum_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_log")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPTOPHLOEUM_LOG.get();
                }
            });

    public static final DeferredBlock<PNTreeLogBlock> LEPTOPHLOEUM_WOOD = registerBlock("leptophloeum_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_wood")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPTOPHLOEUM_WOOD.get();
                }
            });

    public static final DeferredBlock<SaplingBlock> LEPTOPHLOEUM_SAPLING = registerBlock("leptophloeum_sapling",
            () -> new SaplingBlock(PNTreeGrower.LEPTOPHLOEUM_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_sapling")))));

    public static final DeferredBlock<PNTreeLogBlock> LEPTOPHLOEUM_PLANKS = registerBlock("leptophloeum_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_planks")))));

    public static final DeferredBlock<PNTreeLeavesBlock> LEPTOPHLOEUM_LEAVES = registerBlock("leptophloeum_leaves",
            () -> new PNTreeLeavesBlock(0.01F, ModParticles.LEPTOPHLOEUM_PARTICLE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_leaves")))){
                @Override
                public ItemStack envelopeMimicsItemPlacement() {
                    return new ItemStack(BlocksTreeLeptophloeum.LEPTOPHLOEUM_SAPLING.get(), 1);
                }
            });

    public static final DeferredBlock<SlabBlock> LEPTOPHLOEUM_SLAB = registerBlock("leptophloeum_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_slab")))));

    public static final DeferredBlock<StairBlock> LEPTOPHLOEUM_STAIRS = registerBlock("leptophloeum_stairs",
            () -> new StairBlock(LEPTOPHLOEUM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_stairs")))));

    public static final DeferredBlock<FenceBlock> LEPTOPHLOEUM_FENCE = registerBlock("leptophloeum_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_fence")))));

    public static final DeferredBlock<FenceGateBlock> LEPTOPHLOEUM_FENCE_GATE = registerBlock("leptophloeum_fence_gate",
            () -> new FenceGateBlock(PNWoodTypes.LEPTOPHLOEUM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_fence_gate")))));

    public static final DeferredBlock<DoorBlock> LEPTOPHLOEUM_DOOR = registerBlock("leptophloeum_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_door")))));

    public static final DeferredBlock<TrapDoorBlock> LEPTOPHLOEUM_TRAPDOOR = registerBlock("leptophloeum_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_trapdoor")))));

    public static final DeferredBlock<PressurePlateBlock> LEPTOPHLOEUM_PRESSURE_PLATE = registerBlock("leptophloeum_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_pressure_plate")))));

    public static final DeferredBlock<ButtonBlock> LEPTOPHLOEUM_BUTTON = registerBlock("leptophloeum_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_button")))));

    public static final DeferredBlock<PNStandingSignBlock> LEPTOPHLOEUM_SIGN = registerBlockNoItem("leptophloeum_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.LEPTOPHLOEUM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/leptophloeum_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNHangingSignBlock> LEPTOPHLOEUM_SIGN_HANGING = registerBlockNoItem("leptophloeum_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.LEPTOPHLOEUM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/leptophloeum_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallSignBlock> LEPTOPHLOEUM_WALL_SIGN = registerBlockNoItem("leptophloeum_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.LEPTOPHLOEUM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_wall_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/leptophloeum_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallHangingSignBlock> LEPTOPHLOEUM_WALL_SIGN_HANGING = registerBlockNoItem("leptophloeum_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.LEPTOPHLOEUM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_wall_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/leptophloeum_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<LadderBlock> LEPTOPHLOEUM_LADDER = registerBlock("leptophloeum_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_ladder")))));


    public static final DeferredBlock<PNBenchBlock> LEPTOPHLOEUM_BENCH = registerBlock("leptophloeum_bench",
            () -> new PNBenchBlock(LEPTOPHLOEUM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_bench")))));

    public static final DeferredBlock<PNLitterbinBlock> LEPTOPHLOEUM_LITTERBIN = registerBlock("leptophloeum_litterbin",
            () -> new PNLitterbinBlock(LEPTOPHLOEUM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_litterbin")))));

    public static final DeferredBlock<PNBridgeBlock> LEPTOPHLOEUM_BRIDGE = registerBlock("leptophloeum_bridge",
            () -> new PNBridgeBlock(LEPTOPHLOEUM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never) //Not Khazad-Dum
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_bridge")))));

    public static final DeferredBlock<PNPlanterBlock> LEPTOPHLOEUM_PLANTER_1 = registerBlock("leptophloeum_planter1",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_planter1")))));

    public static final DeferredBlock<PNPlanterBlock> LEPTOPHLOEUM_PLANTER_2 = registerBlock("leptophloeum_planter2",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "leptophloeum_planter2")))));



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
