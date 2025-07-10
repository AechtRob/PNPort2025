package com.github.aechtrob.prehistoricnature;

import com.github.aechtrob.prehistoricnature.block.ModBlocks;
import com.github.aechtrob.prehistoricnature.creativetabs.ModCreativeTabs;
import com.github.aechtrob.prehistoricnature.entity.blockentity.ModBlockEntities;
import com.github.aechtrob.prehistoricnature.entity.entity.ModEntities;
import com.github.aechtrob.prehistoricnature.entity.entity.render.PNBenchEntityRenderer;
import com.github.aechtrob.prehistoricnature.entity.entity.render.PNBoatRenderer;
import com.github.aechtrob.prehistoricnature.item.ModItems;
import com.github.aechtrob.prehistoricnature.util.PNWoodTypes;
import com.github.aechtrob.prehistoricnature.world.ModConfiguredFeatures;
import com.github.aechtrob.prehistoricnature.world.ModFeatures;
import com.github.aechtrob.prehistoricnature.world.tree.PNFoliagePlacerType;
import com.github.aechtrob.prehistoricnature.world.tree.PNTrunkPlacerType;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.BlocksTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.ItemsTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.BlocksTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.ItemsTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.BlocksTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.ItemsTreeLepidodendron;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PrehistoricNature.MODID)
public class PrehistoricNature
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "prehistoricnature";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
//    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
//    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
//    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
//    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
//    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
//    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
//
//    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
//    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
//    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
//    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));
//
//    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
//    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//            .alwaysEat().nutrition(1).saturationMod(2f).build())));
//
//    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
//    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
//            .withTabsBefore(CreativeModeTabs.COMBAT)
//            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
//            .displayItems((parameters, output) -> {
//                output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
//            }).build());

    public PrehistoricNature(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

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

        ItemsTreeGangamopteris.register(modEventBus);
        BlocksTreeGangamopteris.register(modEventBus);
        
        ItemsTreeGlossopterisA.register(modEventBus);
        BlocksTreeGlossopterisA.register(modEventBus);
        
        ItemsTreeLepidodendron.register(modEventBus);
        BlocksTreeLepidodendron.register(modEventBus);

        PNTrunkPlacerType.register(modEventBus);
        PNFoliagePlacerType.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModFeatures.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, PrehistoricNatureConfig.SPEC);

//        // Register the item to a creative tab
//        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
//        // Some common setup code
//        LOGGER.info("HELLO FROM COMMON SETUP");
//
//        if (PrehistoricNatureConfig.logDirtBlock)
//            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
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
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(PNWoodTypes.GANGAMOPTERIS);
            Sheets.addWoodType(PNWoodTypes.GLOSSOPTERISA);
            Sheets.addWoodType(PNWoodTypes.LEPIDODENDRON);

            EntityRenderers.register(ModEntities.BOAT_ENTITY.get(), context -> new PNBoatRenderer(context, false));
            EntityRenderers.register(ModEntities.CHEST_BOAT_ENTITY.get(), context -> new PNBoatRenderer(context, true));
            EntityRenderers.register(ModEntities.BENCH_ENTITY.get(), PNBenchEntityRenderer::new);
        }

        @SubscribeEvent
        public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event)
        {
            event.registerBlockEntityRenderer(ModBlockEntities.PN_SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.PN_HANGING_SIGN.get(), HangingSignRenderer::new);

        }
    }
}
