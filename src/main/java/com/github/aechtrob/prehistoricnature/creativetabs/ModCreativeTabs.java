package com.github.aechtrob.prehistoricnature.creativetabs;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.ModBlocks;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.BlocksTreeBothrodendron;
import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.ItemsTreeBothrodendron;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.BlocksTreeDiaphorodendron;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.ItemsTreeDiaphorodendron;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.BlocksTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.ItemsTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.BlocksTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.ItemsTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.BlocksTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.ItemsTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.BlocksTreeLepidophloios;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.ItemsTreeLepidophloios;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.BlocksTreeSciadopitys;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.ItemsTreeSciadopitys;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.BlocksTreeSynchysidendron;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.ItemsTreeSynchysidendron;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PrehistoricNature.MODID);

    public static final Supplier<CreativeModeTab> BUILDING_TAB = CREATIVE_MODE_TAB.register("building_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get()))
                    .title(Component.translatable("itemGroup.prehistoricnature.building_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.PRECAMBRIAN_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.CAMBRIAN_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.ORDOVICIAN_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.SILURIAN_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.DEVONIAN_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.CARBONIFEROUS_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.PERMIAN_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.TRIASSIC_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.JURASSIC_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.CRETACEOUS_EARLY_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.CRETACEOUS_LATE_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.PALEOGENE_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.NEOGENE_FOSSIL_STONE.get().asItem());
                        output.accept(ModBlocks.PLEISTOCENE_FOSSIL_STONE.get().asItem());

                        output.accept(ModItems.PRECAMBRIAN_RAW_FOSSIL.get());
                        output.accept(ModItems.CAMBRIAN_RAW_FOSSIL.get());
                        output.accept(ModItems.ORDOVICIAN_RAW_FOSSIL.get());
                        output.accept(ModItems.SILURIAN_RAW_FOSSIL.get());
                        output.accept(ModItems.DEVONIAN_RAW_FOSSIL.get());
                        output.accept(ModItems.CARBONIFEROUS_RAW_FOSSIL.get());
                        output.accept(ModItems.PERMIAN_RAW_FOSSIL.get());
                        output.accept(ModItems.TRIASSIC_RAW_FOSSIL.get());
                        output.accept(ModItems.JURASSIC_RAW_FOSSIL.get());
                        output.accept(ModItems.CRETACEOUS_EARLY_RAW_FOSSIL.get());
                        output.accept(ModItems.CRETACEOUS_LATE_RAW_FOSSIL.get());
                        output.accept(ModItems.PALEOGENE_RAW_FOSSIL.get());
                        output.accept(ModItems.NEOGENE_RAW_FOSSIL.get());
                        output.accept(ModItems.PLEISTOCENE_RAW_FOSSIL.get());

                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_LOG.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_WOOD.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_STRIPPED_LOG.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_STRIPPED_WOOD.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_PLANKS.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_STAIRS.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_SLAB.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_FENCE.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_FENCE_GATE.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_DOOR.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_TRAPDOOR.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_PRESSURE_PLATE.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_BUTTON.get().asItem());

                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_LOG.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_WOOD.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_STRIPPED_LOG.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_STRIPPED_WOOD.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_PLANKS.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_STAIRS.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_SLAB.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_FENCE.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_FENCE_GATE.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_DOOR.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_TRAPDOOR.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_PRESSURE_PLATE.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_BUTTON.get().asItem());
                        
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_LOG.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_WOOD.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_STRIPPED_LOG.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_STRIPPED_WOOD.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_PLANKS.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_STAIRS.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_SLAB.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_FENCE.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_FENCE_GATE.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_DOOR.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_TRAPDOOR.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_PRESSURE_PLATE.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_BUTTON.get().asItem());

                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_LOG.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_WOOD.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_STRIPPED_LOG.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_STRIPPED_WOOD.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_PLANKS.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_STAIRS.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_SLAB.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_FENCE.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_FENCE_GATE.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_DOOR.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_TRAPDOOR.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_PRESSURE_PLATE.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_BUTTON.get().asItem());

                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_LOG.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_WOOD.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_STRIPPED_LOG.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_STRIPPED_WOOD.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_STAIRS.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_SLAB.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_FENCE.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_FENCE_GATE.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_DOOR.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_TRAPDOOR.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_PRESSURE_PLATE.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_BUTTON.get().asItem());

                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_LOG.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_WOOD.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_STRIPPED_LOG.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_STRIPPED_WOOD.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_PLANKS.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_STAIRS.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_SLAB.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_FENCE.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_FENCE_GATE.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_DOOR.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_TRAPDOOR.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_PRESSURE_PLATE.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_BUTTON.get().asItem());

                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_LOG.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_WOOD.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_STRIPPED_LOG.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_STRIPPED_WOOD.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_PLANKS.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_STAIRS.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_SLAB.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_FENCE.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_FENCE_GATE.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_DOOR.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_TRAPDOOR.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_PRESSURE_PLATE.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_BUTTON.get().asItem());

                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_LOG.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_WOOD.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_STRIPPED_LOG.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_STRIPPED_WOOD.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_PLANKS.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_STAIRS.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_SLAB.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_FENCE.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_FENCE_GATE.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_DOOR.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_TRAPDOOR.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_PRESSURE_PLATE.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_BUTTON.get().asItem());
                    }).build());

    public static final Supplier<CreativeModeTab> PLANTS_TAB = CREATIVE_MODE_TAB.register("plants_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlocksTreeLepidodendron.LEPIDODENDRON_SAPLING.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "building_tab"))
                    .title(Component.translatable("itemGroup.prehistoricnature.plants_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_LEAVES.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_SAPLING.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_STROBILUS.get().asItem());
                        
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_LEAVES.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_SAPLING.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_STROBILUS.get().asItem());
                        
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_LEAVES.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_SAPLING.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_STROBILUS.get().asItem());

                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_LEAVES.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_SAPLING.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_STROBILUS.get().asItem());

                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_LEAVES.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_SAPLING.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_STROBILUS.get().asItem());

                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_LEAVES.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_SAPLING.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_STROBILUS.get().asItem());

                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_LEAVES.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_SAPLING.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_FRUIT.get().asItem());
                        output.accept(ItemsTreeSciadopitys.SCIADOPITYS_SEEDS.get());

                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_LEAVES.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_SAPLING.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_STROBILUS.get().asItem());

                        output.accept(ModBlocks.MACROCYSTIS.get().asItem());
                        output.accept(ModBlocks.NEREOCYSTIS.get().asItem());
                    }).build());

    public static final Supplier<CreativeModeTab> DECO_TAB = CREATIVE_MODE_TAB.register("deco_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlocksTreeLepidodendron.LEPIDODENDRON_BENCH.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "plants_tab"))
                    .title(Component.translatable("itemGroup.prehistoricnature.deco_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_BENCH.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_LITTERBIN.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_BRIDGE.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_LADDER.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_PLANTER_1.get().asItem());
                        output.accept(BlocksTreeBothrodendron.BOTHRODENDRON_PLANTER_2.get().asItem());
                        output.accept(ItemsTreeBothrodendron.BOTHRODENDRON_SIGN.get().asItem());
                        output.accept(ItemsTreeBothrodendron.BOTHRODENDRON_HANGING_SIGN.get().asItem());
                        
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_BENCH.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_LITTERBIN.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_BRIDGE.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_LADDER.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_PLANTER_1.get().asItem());
                        output.accept(BlocksTreeDiaphorodendron.DIAPHORODENDRON_PLANTER_2.get().asItem());
                        output.accept(ItemsTreeDiaphorodendron.DIAPHORODENDRON_SIGN.get().asItem());
                        output.accept(ItemsTreeDiaphorodendron.DIAPHORODENDRON_HANGING_SIGN.get().asItem());
                        
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_BENCH.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_LITTERBIN.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_BRIDGE.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_LADDER.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_PLANTER_1.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_PLANTER_2.get().asItem());
                        output.accept(ItemsTreeGangamopteris.GANGAMOPTERIS_SIGN.get().asItem());
                        output.accept(ItemsTreeGangamopteris.GANGAMOPTERIS_HANGING_SIGN.get().asItem());

                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_BENCH.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_LITTERBIN.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_BRIDGE.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_LADDER.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_PLANTER_1.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_PLANTER_2.get().asItem());
                        output.accept(ItemsTreeGlossopterisA.GLOSSOPTERISA_SIGN.get().asItem());
                        output.accept(ItemsTreeGlossopterisA.GLOSSOPTERISA_HANGING_SIGN.get().asItem());

                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_BENCH.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_LITTERBIN.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_BRIDGE.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_LADDER.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_PLANTER_1.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_PLANTER_2.get().asItem());
                        output.accept(ItemsTreeLepidodendron.LEPIDODENDRON_SIGN.get().asItem());
                        output.accept(ItemsTreeLepidodendron.LEPIDODENDRON_HANGING_SIGN.get().asItem());

                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_BENCH.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_LITTERBIN.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_BRIDGE.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_LADDER.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_PLANTER_1.get().asItem());
                        output.accept(BlocksTreeLepidophloios.LEPIDOPHLOIOS_PLANTER_2.get().asItem());
                        output.accept(ItemsTreeLepidophloios.LEPIDOPHLOIOS_SIGN.get().asItem());
                        output.accept(ItemsTreeLepidophloios.LEPIDOPHLOIOS_HANGING_SIGN.get().asItem());

                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_BENCH.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_LITTERBIN.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_BRIDGE.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_LADDER.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_PLANTER_1.get().asItem());
                        output.accept(BlocksTreeSciadopitys.SCIADOPITYS_PLANTER_2.get().asItem());
                        output.accept(ItemsTreeSciadopitys.SCIADOPITYS_SIGN.get().asItem());
                        output.accept(ItemsTreeSciadopitys.SCIADOPITYS_HANGING_SIGN.get().asItem());

                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_BENCH.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_LITTERBIN.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_BRIDGE.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_LADDER.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_PLANTER_1.get().asItem());
                        output.accept(BlocksTreeSynchysidendron.SYNCHYSIDENDRON_PLANTER_2.get().asItem());
                        output.accept(ItemsTreeSynchysidendron.SYNCHYSIDENDRON_SIGN.get().asItem());
                        output.accept(ItemsTreeSynchysidendron.SYNCHYSIDENDRON_HANGING_SIGN.get().asItem());
                    }).build());

    public static final Supplier<CreativeModeTab> MISC_TAB = CREATIVE_MODE_TAB.register("misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlocksTreeLepidodendron.LEPIDODENDRON_LEAVES.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "deco_tab"))
                    .title(Component.translatable("itemGroup.prehistoricnature.misc_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GEOLOGIC_PICK.get().asItem());
                        output.accept(ModItems.COLLECTION_ENVELOPE.get().asItem());

                        output.accept(ItemsTreeBothrodendron.BOTHRODENDRON_BOAT.get().asItem());
                        output.accept(ItemsTreeBothrodendron.BOTHRODENDRON_CHEST_BOAT.get().asItem());

                        output.accept(ItemsTreeDiaphorodendron.DIAPHORODENDRON_BOAT.get().asItem());
                        output.accept(ItemsTreeDiaphorodendron.DIAPHORODENDRON_CHEST_BOAT.get().asItem());

                        output.accept(ItemsTreeGangamopteris.GANGAMOPTERIS_BOAT.get().asItem());
                        output.accept(ItemsTreeGangamopteris.GANGAMOPTERIS_CHEST_BOAT.get().asItem());
                        
                        output.accept(ItemsTreeGlossopterisA.GLOSSOPTERISA_BOAT.get().asItem());
                        output.accept(ItemsTreeGlossopterisA.GLOSSOPTERISA_CHEST_BOAT.get().asItem());

                        output.accept(ItemsTreeLepidodendron.LEPIDODENDRON_BOAT.get().asItem());
                        output.accept(ItemsTreeLepidodendron.LEPIDODENDRON_CHEST_BOAT.get().asItem());

                        output.accept(ItemsTreeLepidophloios.LEPIDOPHLOIOS_BOAT.get().asItem());
                        output.accept(ItemsTreeLepidophloios.LEPIDOPHLOIOS_CHEST_BOAT.get().asItem());

                        output.accept(ItemsTreeSciadopitys.SCIADOPITYS_BOAT.get().asItem());
                        output.accept(ItemsTreeSciadopitys.SCIADOPITYS_CHEST_BOAT.get().asItem());

                        output.accept(ItemsTreeSynchysidendron.SYNCHYSIDENDRON_BOAT.get().asItem());
                        output.accept(ItemsTreeSynchysidendron.SYNCHYSIDENDRON_CHEST_BOAT.get().asItem());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
