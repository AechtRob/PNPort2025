package com.github.aechtrob.prehistoricnature;

import com.github.aechtrob.prehistoricnature.block.ModBlocks;
import com.github.aechtrob.prehistoricnature.creativetabs.ModCreativeTabs;
import com.github.aechtrob.prehistoricnature.entity.blockentity.ModBlockEntities;
import com.github.aechtrob.prehistoricnature.entity.entity.ModEntities;
import com.github.aechtrob.prehistoricnature.entity.entity.render.PNBenchEntityRenderer;
import com.github.aechtrob.prehistoricnature.entity.entity.render.PNBoatChestRenderer;
import com.github.aechtrob.prehistoricnature.entity.entity.render.PNBoatRenderer;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.util.PNWoodTypes;
import com.github.aechtrob.prehistoricnature.world.ModConfiguredFeatures;
import com.github.aechtrob.prehistoricnature.world.ModFeatures;
import com.github.aechtrob.prehistoricnature.world.tree.PNFoliagePlacerType;
import com.github.aechtrob.prehistoricnature.world.tree.PNTrunkPlacerType;
import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.BlocksTreeBothrodendron;
import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.EntitiesTreeBothrodendron;
import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.ItemsTreeBothrodendron;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.BlocksTreeDiaphorodendron;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.EntitiesTreeDiaphorodendron;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.ItemsTreeDiaphorodendron;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.BlocksTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.EntitiesTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.ItemsTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.BlocksTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.EntitiesTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.ItemsTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.BlocksTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.EntitiesTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.ItemsTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.BlocksTreeLepidophloios;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.EntitiesTreeLepidophloios;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.ItemsTreeLepidophloios;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.BlocksTreeSciadopitys;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.EntitiesTreeSciadopitys;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.ItemsTreeSciadopitys;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.BlocksTreeSynchysidendron;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.EntitiesTreeSynchysidendron;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.ItemsTreeSynchysidendron;
import com.mojang.logging.LogUtils;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(PrehistoricNature.MODID)
public class PrehistoricNature
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "prehistoricnature";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

//    // Create a Deferred Register to hold Blocks which will all be registered under the "prehistoricnature" namespace
//    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
//    // Create a Deferred Register to hold Items which will all be registered under the "prehistoricnature" namespace
//    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
//    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "prehistoricnature" namespace
//    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

//    // Creates a new Block with the id "prehistoricnature:example_block", combining the namespace and path
//    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
//
//    // Creates a new BlockItem with the id "prehistoricnature:example_block", combining the namespace and path
//    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);
//
//    // Creates a new food item with the id "prehistoricnature:example_id", nutrition 1 and saturation 2
//    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
//            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));
//
//    // Creates a creative tab with the id "prehistoricnature:example_tab" for the example item, that is placed after the combat tab
//    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
//            .title(Component.translatable("itemGroup.prehistoricnature")) //The language key for the title of your CreativeModeTab
//            .withTabsBefore(CreativeModeTabs.COMBAT)
//            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
//            .displayItems((parameters, output) -> {
//                output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
//            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public PrehistoricNature(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

//        // Register the Deferred Register to the mod event bus so blocks get registered
//        BLOCKS.register(modEventBus);
//        // Register the Deferred Register to the mod event bus so items get registered
//        ITEMS.register(modEventBus);
//        // Register the Deferred Register to the mod event bus so tabs get registered
//        CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (PrehistoricNature) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.

        ModCreativeTabs.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ItemsTreeBothrodendron.register(modEventBus);
        BlocksTreeBothrodendron.register(modEventBus);
        EntitiesTreeBothrodendron.register(modEventBus);

        ItemsTreeDiaphorodendron.register(modEventBus);
        BlocksTreeDiaphorodendron.register(modEventBus);
        EntitiesTreeDiaphorodendron.register(modEventBus);

        ItemsTreeGangamopteris.register(modEventBus);
        BlocksTreeGangamopteris.register(modEventBus);
        EntitiesTreeGangamopteris.register(modEventBus);
        
        ItemsTreeGlossopterisA.register(modEventBus);
        BlocksTreeGlossopterisA.register(modEventBus);
        EntitiesTreeGlossopterisA.register(modEventBus);

        ItemsTreeLepidodendron.register(modEventBus);
        BlocksTreeLepidodendron.register(modEventBus);
        EntitiesTreeLepidodendron.register(modEventBus);

        ItemsTreeLepidophloios.register(modEventBus);
        BlocksTreeLepidophloios.register(modEventBus);
        EntitiesTreeLepidophloios.register(modEventBus);

        ItemsTreeSciadopitys.register(modEventBus);
        BlocksTreeSciadopitys.register(modEventBus);
        EntitiesTreeSciadopitys.register(modEventBus);

        ItemsTreeSynchysidendron.register(modEventBus);
        BlocksTreeSynchysidendron.register(modEventBus);
        EntitiesTreeSynchysidendron.register(modEventBus);

        PNTrunkPlacerType.register(modEventBus);
        PNFoliagePlacerType.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModFeatures.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, PrehistoricNatureConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
//        // Some common setup code
//        LOGGER.info("HELLO FROM COMMON SETUP");
//
//        if (PrehistoricNatureConfig.logDirtBlock)
//            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
//
//        LOGGER.info(PrehistoricNatureConfig.magicNumberIntroduction + PrehistoricNatureConfig.magicNumber);
//
//        PrehistoricNatureConfig.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept(EXAMPLE_BLOCK_ITEM);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(PNWoodTypes.BOTHRODENDRON);
            Sheets.addWoodType(PNWoodTypes.DIAPHORODENDRON);
            Sheets.addWoodType(PNWoodTypes.GANGAMOPTERIS);
            Sheets.addWoodType(PNWoodTypes.GLOSSOPTERISA);
            Sheets.addWoodType(PNWoodTypes.LEPIDODENDRON);
            Sheets.addWoodType(PNWoodTypes.LEPIDOPHLOIOS);
            Sheets.addWoodType(PNWoodTypes.SCIADOPITYS);
            Sheets.addWoodType(PNWoodTypes.SYNCHYSIDENDRON);
        }

        @SubscribeEvent
        public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event)
        {
            event.registerBlockEntityRenderer(ModBlockEntities.PN_SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.PN_HANGING_SIGN.get(), HangingSignRenderer::new);
            event.registerEntityRenderer(ModEntities.BENCH_ENTITY.get(), PNBenchEntityRenderer::new);

            event.registerEntityRenderer(EntitiesTreeBothrodendron.BOTHRODENDRON_BOAT.get(), context -> new PNBoatRenderer(context, ModelLayers.OAK_BOAT, "bothrodendron"));
            event.registerEntityRenderer(EntitiesTreeBothrodendron.BOTHRODENDRON_CHEST_BOAT.get(), context -> new PNBoatChestRenderer(context, ModelLayers.OAK_CHEST_BOAT, "bothrodendron"));
            event.registerEntityRenderer(EntitiesTreeDiaphorodendron.DIAPHORODENDRON_BOAT.get(), context -> new PNBoatRenderer(context, ModelLayers.OAK_BOAT, "diaphorodendron"));
            event.registerEntityRenderer(EntitiesTreeDiaphorodendron.DIAPHORODENDRON_CHEST_BOAT.get(), context -> new PNBoatChestRenderer(context, ModelLayers.OAK_CHEST_BOAT, "diaphorodendron"));
            event.registerEntityRenderer(EntitiesTreeGangamopteris.GANGAMOPTERIS_BOAT.get(), context -> new PNBoatRenderer(context, ModelLayers.OAK_BOAT, "gangamopteris"));
            event.registerEntityRenderer(EntitiesTreeGangamopteris.GANGAMOPTERIS_CHEST_BOAT.get(), context -> new PNBoatChestRenderer(context, ModelLayers.OAK_CHEST_BOAT, "gangamopteris"));
            event.registerEntityRenderer(EntitiesTreeGlossopterisA.GLOSSOPTERISA_BOAT.get(), context -> new PNBoatRenderer(context, ModelLayers.OAK_BOAT, "glossopteris_angustifolia"));
            event.registerEntityRenderer(EntitiesTreeGlossopterisA.GLOSSOPTERISA_CHEST_BOAT.get(), context -> new PNBoatChestRenderer(context, ModelLayers.OAK_CHEST_BOAT, "glossopteris_angustifolia"));
            event.registerEntityRenderer(EntitiesTreeLepidodendron.LEPIDODENDRON_BOAT.get(), context -> new PNBoatRenderer(context, ModelLayers.OAK_BOAT, "lepidodendron"));
            event.registerEntityRenderer(EntitiesTreeLepidodendron.LEPIDODENDRON_CHEST_BOAT.get(), context -> new PNBoatChestRenderer(context, ModelLayers.OAK_CHEST_BOAT, "lepidodendron"));
            event.registerEntityRenderer(EntitiesTreeLepidophloios.LEPIDOPHLOIOS_BOAT.get(), context -> new PNBoatRenderer(context, ModelLayers.OAK_BOAT, "lepidophloios"));
            event.registerEntityRenderer(EntitiesTreeLepidophloios.LEPIDOPHLOIOS_CHEST_BOAT.get(), context -> new PNBoatChestRenderer(context, ModelLayers.OAK_CHEST_BOAT, "lepidophloios"));
            event.registerEntityRenderer(EntitiesTreeSciadopitys.SCIADOPITYS_BOAT.get(), context -> new PNBoatRenderer(context, ModelLayers.OAK_BOAT, "sciadopitys"));
            event.registerEntityRenderer(EntitiesTreeSciadopitys.SCIADOPITYS_CHEST_BOAT.get(), context -> new PNBoatChestRenderer(context, ModelLayers.OAK_CHEST_BOAT, "sciadopitys"));
            event.registerEntityRenderer(EntitiesTreeSynchysidendron.SYNCHYSIDENDRON_BOAT.get(), context -> new PNBoatRenderer(context, ModelLayers.OAK_BOAT, "synchysidendron"));
            event.registerEntityRenderer(EntitiesTreeSynchysidendron.SYNCHYSIDENDRON_CHEST_BOAT.get(), context -> new PNBoatChestRenderer(context, ModelLayers.OAK_CHEST_BOAT, "synchysidendron"));

        }

        @SubscribeEvent
        public static void onClientSetup(EntityRenderersEvent.RegisterLayerDefinitions event)
        {
            //PNEntities.registerEntityLayers(event);
        }
    }
}
