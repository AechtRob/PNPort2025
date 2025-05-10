package com.github.aechtrob.prehistoricnature.world.tree.lepidodendron;

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

public class BlocksTreeLepidodendron {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PrehistoricNature.MODID);

    public static final DeferredBlock<PNTreeLogBlock> LEPIDODENDRON_STRIPPED_LOG = registerBlock("stripped_lepidodendron_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_lepidodendron_log")))));

    public static final DeferredBlock<PNTreeLogBlock> LEPIDODENDRON_LOG = registerBlock("lepidodendron_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_log")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPIDODENDRON_STRIPPED_LOG.get();
                }
            });

    public static final DeferredBlock<PNTreeLogBlock> LEPIDODENDRON_STRIPPED_WOOD = registerBlock("stripped_lepidodendron_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_lepidodendron_wood")))));

    public static final DeferredBlock<PNTreeLogBlock> LEPIDODENDRON_WOOD = registerBlock("lepidodendron_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_wood")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return LEPIDODENDRON_STRIPPED_WOOD.get();
                }
            });

    public static final DeferredBlock<SaplingBlock> LEPIDODENDRON_SAPLING = registerBlock("lepidodendron_sapling",
            () -> new SaplingBlock(PNTreeGrower.LEPIDODENDRON_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_sapling")))));

    public static final DeferredBlock<PNTreeLogBlock> LEPIDODENDRON_PLANKS = registerBlock("lepidodendron_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_planks")))));

    public static final DeferredBlock<PNTreeLeavesBlock> LEPIDODENDRON_LEAVES = registerBlock("lepidodendron_leaves",
            () -> new PNTreeLeavesBlock(0, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_leaves")))));

    public static final DeferredBlock<SlabBlock> LEPIDODENDRON_SLAB = registerBlock("lepidodendron_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_slab")))));

    public static final DeferredBlock<StairBlock> LEPIDODENDRON_STAIRS = registerBlock("lepidodendron_stairs",
            () -> new StairBlock(LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_stairs")))));

    public static final DeferredBlock<FenceBlock> LEPIDODENDRON_FENCE = registerBlock("lepidodendron_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_fence")))));

    public static final DeferredBlock<FenceGateBlock> LEPIDODENDRON_FENCE_GATE = registerBlock("lepidodendron_fence_gate",
            () -> new FenceGateBlock(PNWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_fence_gate")))));

    public static final DeferredBlock<DoorBlock> LEPIDODENDRON_DOOR = registerBlock("lepidodendron_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_door")))));

    public static final DeferredBlock<TrapDoorBlock> LEPIDODENDRON_TRAPDOOR = registerBlock("lepidodendron_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_trapdoor")))));

    public static final DeferredBlock<PressurePlateBlock> LEPIDODENDRON_PRESSURE_PLATE = registerBlock("lepidodendron_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_pressure_plate")))));

    public static final DeferredBlock<ButtonBlock> LEPIDODENDRON_BUTTON = registerBlock("lepidodendron_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_button")))));

    public static final DeferredBlock<PNStandingSignBlock> LEPIDODENDRON_SIGN = registerBlockNoItem("lepidodendron_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/lepidodendron_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNHangingSignBlock> LEPIDODENDRON_SIGN_HANGING = registerBlockNoItem("lepidodendron_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/lepidodendron_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallSignBlock> LEPIDODENDRON_WALL_SIGN = registerBlockNoItem("lepidodendron_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_wall_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/lepidodendron_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallHangingSignBlock> LEPIDODENDRON_WALL_SIGN_HANGING = registerBlockNoItem("lepidodendron_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_wall_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/lepidodendron_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<LadderBlock> LEPIDODENDRON_LADDER = registerBlock("lepidodendron_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_ladder")))));


    public static final DeferredBlock<PNBenchBlock> LEPIDODENDRON_BENCH = registerBlock("lepidodendron_bench",
            () -> new PNBenchBlock(LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_bench")))));

    public static final DeferredBlock<PNLitterbinBlock> LEPIDODENDRON_LITTERBIN = registerBlock("lepidodendron_litterbin",
            () -> new PNLitterbinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_litterbin")))));

    public static final DeferredBlock<PNBridgeBlock> LEPIDODENDRON_BRIDGE = registerBlock("lepidodendron_bridge",
            () -> new PNBridgeBlock(LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never) //Not Khazad-Dum
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_bridge")))));


    //Other tree-specific stuff:
    public static final DeferredBlock<Block> LEPIDODENDRON_STROBILUS = registerBlock("lepidodendron_strobilus",
            () -> new LepidodendronStrobilus(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "lepidodendron_strobilus")))));


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
