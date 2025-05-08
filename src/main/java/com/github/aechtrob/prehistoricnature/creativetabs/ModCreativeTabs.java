package com.github.aechtrob.prehistoricnature.creativetabs;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.trees.lepidodendron.BlocksTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.block.trees.lepidodendron.ItemsTreeLepidodendron;
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
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_LEAVES.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_SAPLING.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_STROBILUS.get().asItem());
                    }).build());

    public static final Supplier<CreativeModeTab> DECO_TAB = CREATIVE_MODE_TAB.register("deco_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlocksTreeLepidodendron.LEPIDODENDRON_BENCH.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "plants_tab"))
                    .title(Component.translatable("itemGroup.prehistoricnature.deco_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_BENCH.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_LITTERBIN.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_BRIDGE.get().asItem());
                        output.accept(BlocksTreeLepidodendron.LEPIDODENDRON_LADDER.get().asItem());
                        output.accept(ItemsTreeLepidodendron.LEPIDODENDRON_SIGN.get().asItem());
                        output.accept(ItemsTreeLepidodendron.LEPIDODENDRON_HANGING_SIGN.get().asItem());

                    }).build());

    public static final Supplier<CreativeModeTab> MISC_TAB = CREATIVE_MODE_TAB.register("misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlocksTreeLepidodendron.LEPIDODENDRON_LEAVES.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "deco_tab"))
                    .title(Component.translatable("itemGroup.prehistoricnature.misc_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
