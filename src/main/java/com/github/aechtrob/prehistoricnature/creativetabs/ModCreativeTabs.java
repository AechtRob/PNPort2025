package com.github.aechtrob.prehistoricnature.creativetabs;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.BlocksTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.ItemsTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.BlocksTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.ItemsTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.BlocksTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.ItemsTreeLepidodendron;
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

                    }).build());

    public static final Supplier<CreativeModeTab> PLANTS_TAB = CREATIVE_MODE_TAB.register("plants_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlocksTreeLepidodendron.LEPIDODENDRON_SAPLING.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "building_tab"))
                    .title(Component.translatable("itemGroup.prehistoricnature.plants_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_LEAVES.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_SAPLING.get().asItem());
                        output.accept(BlocksTreeGangamopteris.GANGAMOPTERIS_STROBILUS.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_LEAVES.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_SAPLING.get().asItem());
                        output.accept(BlocksTreeGlossopterisA.GLOSSOPTERISA_STROBILUS.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_LEAVES.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_SAPLING.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_STROBILUS.get().asItem());
                    }).build());

    public static final Supplier<CreativeModeTab> DECO_TAB = CREATIVE_MODE_TAB.register("deco_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlocksTreeLepidodendron.LEPIDODENDRON_BENCH.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "plants_tab"))
                    .title(Component.translatable("itemGroup.prehistoricnature.deco_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
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

                    }).build());

    public static final Supplier<CreativeModeTab> MISC_TAB = CREATIVE_MODE_TAB.register("misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlocksTreeLepidodendron.LEPIDODENDRON_LEAVES.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "deco_tab"))
                    .title(Component.translatable("itemGroup.prehistoricnature.misc_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ItemsTreeGangamopteris.GANGAMOPTERIS_BOAT.get().asItem());
                        output.accept(ItemsTreeGangamopteris.GANGAMOPTERIS_CHEST_BOAT.get().asItem());
                        
                        output.accept(ItemsTreeGlossopterisA.GLOSSOPTERISA_BOAT.get().asItem());
                        output.accept(ItemsTreeGlossopterisA.GLOSSOPTERISA_CHEST_BOAT.get().asItem());
                        output.accept(ItemsTreeLepidodendron.LEPIDODENDRON_BOAT.get().asItem());
                        output.accept(ItemsTreeLepidodendron.LEPIDODENDRON_CHEST_BOAT.get().asItem());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
