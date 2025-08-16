package com.github.aechtrob.prehistoricnature.world.tree.sciadopitys;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.PrehistoricNatureConfig;
import com.github.aechtrob.prehistoricnature.block.blockbase.*;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.particle.ModParticles;
import com.github.aechtrob.prehistoricnature.util.PNWoodTypes;
import com.github.aechtrob.prehistoricnature.world.tree.PNTreeGrower;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class BlocksTreeSciadopitys {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PrehistoricNature.MODID);

    public static final DeferredBlock<PNTreeLogBlock> SCIADOPITYS_STRIPPED_LOG = registerBlock("stripped_sciadopitys_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_sciadopitys_log")))));

    public static final DeferredBlock<PNTreeLogBlock> SCIADOPITYS_LOG = registerBlock("sciadopitys_log",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_log")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return SCIADOPITYS_STRIPPED_LOG.get();
                }
            });

    public static final DeferredBlock<PNTreeLogBlock> SCIADOPITYS_STRIPPED_WOOD = registerBlock("stripped_sciadopitys_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "stripped_sciadopitys_wood")))));

    public static final DeferredBlock<PNTreeLogBlock> SCIADOPITYS_WOOD = registerBlock("sciadopitys_wood",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_wood")))){
                @Override
                public @Nullable Block getStrippedBlock() {
                    return SCIADOPITYS_STRIPPED_WOOD.get();
                }
            });

    public static final DeferredBlock<SaplingBlock> SCIADOPITYS_SAPLING = registerBlock("sciadopitys_sapling",
            () -> new SaplingBlock(PNTreeGrower.SCIADOPITYS_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_sapling")))));

    public static final DeferredBlock<PNTreeLogBlock> SCIADOPITYS_PLANKS = registerBlock("sciadopitys_planks",
            () -> new PNTreeLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_planks")))));

    public static final DeferredBlock<PNTreeLeavesBlock> SCIADOPITYS_LEAVES = registerBlock("sciadopitys_leaves",
            () -> new PNTreeLeavesBlock(0.01F, ModParticles.SCIADOPITYS_PARTICLE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_leaves")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    List<ItemStack> returnList = super.getDrops(state, params);
                    if ((Math.random() >= 0.96) && (PrehistoricNatureConfig.doPropagation)) {
                        BlockState fruitState = SCIADOPITYS_FRUIT.get().defaultBlockState();
                        Vec3 vec3 = params.getParameter(LootContextParams.ORIGIN);
                        BlockPos pos = new BlockPos((int)vec3.x, (int)vec3.y, (int)vec3.z);
                        params.getLevel().setBlock(pos, fruitState, 3);
                    }
                    return returnList;
                }
            });

    public static final DeferredBlock<SlabBlock> SCIADOPITYS_SLAB = registerBlock("sciadopitys_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_slab")))));

    public static final DeferredBlock<StairBlock> SCIADOPITYS_STAIRS = registerBlock("sciadopitys_stairs",
            () -> new StairBlock(SCIADOPITYS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_stairs")))));

    public static final DeferredBlock<FenceBlock> SCIADOPITYS_FENCE = registerBlock("sciadopitys_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_fence")))));

    public static final DeferredBlock<FenceGateBlock> SCIADOPITYS_FENCE_GATE = registerBlock("sciadopitys_fence_gate",
            () -> new FenceGateBlock(PNWoodTypes.SCIADOPITYS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_fence_gate")))));

    public static final DeferredBlock<DoorBlock> SCIADOPITYS_DOOR = registerBlock("sciadopitys_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_door")))));

    public static final DeferredBlock<TrapDoorBlock> SCIADOPITYS_TRAPDOOR = registerBlock("sciadopitys_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_trapdoor")))));

    public static final DeferredBlock<PressurePlateBlock> SCIADOPITYS_PRESSURE_PLATE = registerBlock("sciadopitys_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_pressure_plate")))));

    public static final DeferredBlock<ButtonBlock> SCIADOPITYS_BUTTON = registerBlock("sciadopitys_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_button")))));

    public static final DeferredBlock<PNStandingSignBlock> SCIADOPITYS_SIGN = registerBlockNoItem("sciadopitys_sign",
            () -> new PNStandingSignBlock(PNWoodTypes.SCIADOPITYS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/sciadopitys_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNHangingSignBlock> SCIADOPITYS_SIGN_HANGING = registerBlockNoItem("sciadopitys_hanging_sign",
            () -> new PNHangingSignBlock(PNWoodTypes.SCIADOPITYS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/sciadopitys_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallSignBlock> SCIADOPITYS_WALL_SIGN = registerBlockNoItem("sciadopitys_wall_sign",
            () -> new PNWallSignBlock(PNWoodTypes.SCIADOPITYS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_wall_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/sciadopitys_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<PNWallHangingSignBlock> SCIADOPITYS_WALL_SIGN_HANGING = registerBlockNoItem("sciadopitys_wall_hanging_sign",
            () -> new PNWallHangingSignBlock(PNWoodTypes.SCIADOPITYS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_wall_hanging_sign")))){
                @Override
                protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
                    LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    ServerLevel serverlevel = lootparams.getLevel();
                    ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/sciadopitys_hanging_sign"));
                    LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
                    return loottable.getRandomItems(lootparams);
                }
            });

    public static final DeferredBlock<LadderBlock> SCIADOPITYS_LADDER = registerBlock("sciadopitys_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_ladder")))));


    public static final DeferredBlock<PNBenchBlock> SCIADOPITYS_BENCH = registerBlock("sciadopitys_bench",
            () -> new PNBenchBlock(SCIADOPITYS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_bench")))));

    public static final DeferredBlock<PNLitterbinBlock> SCIADOPITYS_LITTERBIN = registerBlock("sciadopitys_litterbin",
            () -> new PNLitterbinBlock(SCIADOPITYS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_litterbin")))));

    public static final DeferredBlock<PNBridgeBlock> SCIADOPITYS_BRIDGE = registerBlock("sciadopitys_bridge",
            () -> new PNBridgeBlock(SCIADOPITYS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isValidSpawn(Blocks::never) //Not Khazad-Dum
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_bridge")))));

    public static final DeferredBlock<PNPlanterBlock> SCIADOPITYS_PLANTER_1 = registerBlock("sciadopitys_planter1",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_planter1")))));

    public static final DeferredBlock<PNPlanterBlock> SCIADOPITYS_PLANTER_2 = registerBlock("sciadopitys_planter2",
            () -> new PNPlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_planter2")))));


    //Other tree-specific stuff:
    public static final DeferredBlock<Block> SCIADOPITYS_FRUIT = registerBlock("sciadopitys_fruit",
            () -> new PNPineConeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_fruit")))));


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
