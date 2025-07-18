package com.github.aechtrob.prehistoricnature.entity.blockentity;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.ModBlocks;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModHangingSignBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModPlanterBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModSignBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModTrimmableBlockEntity;
import com.github.aechtrob.prehistoricnature.world.tree.bothrodendron.BlocksTreeBothrodendron;
import com.github.aechtrob.prehistoricnature.world.tree.diaphorodendron.BlocksTreeDiaphorodendron;
import com.github.aechtrob.prehistoricnature.world.tree.gangamopteris.BlocksTreeGangamopteris;
import com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia.BlocksTreeGlossopterisA;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.BlocksTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.world.tree.lepidophloios.BlocksTreeLepidophloios;
import com.github.aechtrob.prehistoricnature.world.tree.leptophloeum.BlocksTreeLeptophloeum;
import com.github.aechtrob.prehistoricnature.world.tree.pitys.BlocksTreePitys;
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.BlocksTreeSciadopitys;
import com.github.aechtrob.prehistoricnature.world.tree.synchysidendron.BlocksTreeSynchysidendron;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PrehistoricNature.MODID);

    public static final Supplier<BlockEntityType<ModSignBlockEntity>> PN_SIGN = BLOCK_ENTITIES.register(
            "pn_sign",
            () -> new BlockEntityType<>(
                    ModSignBlockEntity::new,
                    BlocksTreeBothrodendron.BOTHRODENDRON_SIGN.get(), BlocksTreeBothrodendron.BOTHRODENDRON_WALL_SIGN.get(),
                    BlocksTreeDiaphorodendron.DIAPHORODENDRON_SIGN.get(), BlocksTreeDiaphorodendron.DIAPHORODENDRON_WALL_SIGN.get(),
                    BlocksTreeGangamopteris.GANGAMOPTERIS_SIGN.get(), BlocksTreeGangamopteris.GANGAMOPTERIS_WALL_SIGN.get(),
                    BlocksTreeGlossopterisA.GLOSSOPTERISA_SIGN.get(), BlocksTreeGlossopterisA.GLOSSOPTERISA_WALL_SIGN.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_SIGN.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN.get(),
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_SIGN.get(), BlocksTreeLepidophloios.LEPIDOPHLOIOS_WALL_SIGN.get(),
                    BlocksTreeLeptophloeum.LEPTOPHLOEUM_SIGN.get(), BlocksTreeLeptophloeum.LEPTOPHLOEUM_WALL_SIGN.get(),
                    BlocksTreePitys.PITYS_SIGN.get(), BlocksTreePitys.PITYS_WALL_SIGN.get(),
                    BlocksTreeSciadopitys.SCIADOPITYS_SIGN.get(), BlocksTreeSciadopitys.SCIADOPITYS_WALL_SIGN.get(),
                    BlocksTreeSynchysidendron.SYNCHYSIDENDRON_SIGN.get(), BlocksTreeSynchysidendron.SYNCHYSIDENDRON_WALL_SIGN.get()

                    )
    );

    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> PN_HANGING_SIGN = BLOCK_ENTITIES.register(
            "pn_hanging_sign",
            () -> new BlockEntityType<>(
                    ModHangingSignBlockEntity::new,
                    BlocksTreeBothrodendron.BOTHRODENDRON_SIGN_HANGING.get(), BlocksTreeBothrodendron.BOTHRODENDRON_WALL_SIGN_HANGING.get(),
                    BlocksTreeDiaphorodendron.DIAPHORODENDRON_SIGN_HANGING.get(), BlocksTreeDiaphorodendron.DIAPHORODENDRON_WALL_SIGN_HANGING.get(),
                    BlocksTreeGangamopteris.GANGAMOPTERIS_SIGN_HANGING.get(), BlocksTreeGangamopteris.GANGAMOPTERIS_WALL_SIGN_HANGING.get(),
                    BlocksTreeGlossopterisA.GLOSSOPTERISA_SIGN_HANGING.get(), BlocksTreeGlossopterisA.GLOSSOPTERISA_WALL_SIGN_HANGING.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_SIGN_HANGING.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN_HANGING.get(),
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_SIGN_HANGING.get(), BlocksTreeLepidophloios.LEPIDOPHLOIOS_WALL_SIGN_HANGING.get(),
                    BlocksTreeLeptophloeum.LEPTOPHLOEUM_SIGN_HANGING.get(), BlocksTreeLeptophloeum.LEPTOPHLOEUM_WALL_SIGN_HANGING.get(),
                    BlocksTreePitys.PITYS_SIGN_HANGING.get(), BlocksTreePitys.PITYS_WALL_SIGN_HANGING.get(),
                    BlocksTreeSciadopitys.SCIADOPITYS_SIGN_HANGING.get(), BlocksTreeSciadopitys.SCIADOPITYS_WALL_SIGN_HANGING.get(),
                    BlocksTreeSynchysidendron.SYNCHYSIDENDRON_SIGN_HANGING.get(), BlocksTreeSynchysidendron.SYNCHYSIDENDRON_WALL_SIGN_HANGING.get()

                    )
    );

    public static final Supplier<BlockEntityType<ModTrimmableBlockEntity>> PN_TRIMMABLE = BLOCK_ENTITIES.register(
            "pn_trimmable",
            () -> new BlockEntityType<>(
                    ModTrimmableBlockEntity::new,
                    BlocksTreeBothrodendron.BOTHRODENDRON_BENCH.get(),
                    BlocksTreeBothrodendron.BOTHRODENDRON_BRIDGE.get(),
                    BlocksTreeBothrodendron.BOTHRODENDRON_LITTERBIN.get(),
                    BlocksTreeDiaphorodendron.DIAPHORODENDRON_BENCH.get(),
                    BlocksTreeDiaphorodendron.DIAPHORODENDRON_BRIDGE.get(),
                    BlocksTreeDiaphorodendron.DIAPHORODENDRON_LITTERBIN.get(),
                    BlocksTreeGangamopteris.GANGAMOPTERIS_BENCH.get(),
                    BlocksTreeGangamopteris.GANGAMOPTERIS_BRIDGE.get(),
                    BlocksTreeGangamopteris.GANGAMOPTERIS_LITTERBIN.get(),
                    BlocksTreeGlossopterisA.GLOSSOPTERISA_BENCH.get(),
                    BlocksTreeGlossopterisA.GLOSSOPTERISA_BRIDGE.get(),
                    BlocksTreeGlossopterisA.GLOSSOPTERISA_LITTERBIN.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_BENCH.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_BRIDGE.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_LITTERBIN.get(),
                    BlocksTreeSciadopitys.SCIADOPITYS_BENCH.get(),
                    BlocksTreeSciadopitys.SCIADOPITYS_BRIDGE.get(),
                    BlocksTreeSciadopitys.SCIADOPITYS_LITTERBIN.get(),
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_BENCH.get(),
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_BRIDGE.get(),
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_LITTERBIN.get(),
                    BlocksTreeLeptophloeum.LEPTOPHLOEUM_BENCH.get(),
                    BlocksTreeLeptophloeum.LEPTOPHLOEUM_BRIDGE.get(),
                    BlocksTreeLeptophloeum.LEPTOPHLOEUM_LITTERBIN.get(),
                    BlocksTreePitys.PITYS_BENCH.get(),
                    BlocksTreePitys.PITYS_BRIDGE.get(),
                    BlocksTreePitys.PITYS_LITTERBIN.get(),
                    BlocksTreeSynchysidendron.SYNCHYSIDENDRON_BENCH.get(),
                    BlocksTreeSynchysidendron.SYNCHYSIDENDRON_BRIDGE.get(),
                    BlocksTreeSynchysidendron.SYNCHYSIDENDRON_LITTERBIN.get()


            )
    );

    public static final Supplier<BlockEntityType<ModPlanterBlockEntity>> PN_PLANTER = BLOCK_ENTITIES.register(
            "pn_planter",
            () -> new BlockEntityType<>(
                    ModPlanterBlockEntity::new,
                    BlocksTreeBothrodendron.BOTHRODENDRON_PLANTER_1.get(),
                    BlocksTreeBothrodendron.BOTHRODENDRON_PLANTER_2.get(),
                    BlocksTreeDiaphorodendron.DIAPHORODENDRON_PLANTER_1.get(),
                    BlocksTreeDiaphorodendron.DIAPHORODENDRON_PLANTER_2.get(),
                    BlocksTreeGangamopteris.GANGAMOPTERIS_PLANTER_1.get(),
                    BlocksTreeGangamopteris.GANGAMOPTERIS_PLANTER_2.get(),
                    BlocksTreeGlossopterisA.GLOSSOPTERISA_PLANTER_1.get(),
                    BlocksTreeGlossopterisA.GLOSSOPTERISA_PLANTER_2.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_PLANTER_1.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_PLANTER_2.get(),
                    BlocksTreeSciadopitys.SCIADOPITYS_PLANTER_1.get(),
                    BlocksTreeSciadopitys.SCIADOPITYS_PLANTER_2.get(),
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_PLANTER_1.get(),
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_PLANTER_2.get(),
                    BlocksTreeLeptophloeum.LEPTOPHLOEUM_PLANTER_1.get(),
                    BlocksTreeLeptophloeum.LEPTOPHLOEUM_PLANTER_2.get(),
                    BlocksTreePitys.PITYS_PLANTER_1.get(),
                    BlocksTreePitys.PITYS_PLANTER_2.get(),
                    BlocksTreeSynchysidendron.SYNCHYSIDENDRON_PLANTER_1.get(),
                    BlocksTreeSynchysidendron.SYNCHYSIDENDRON_PLANTER_2.get()
            )
    );

    public static final Supplier<BlockEntityType<BlockEntityDNARecombinerCentrifuge>> CENTRIFUGE = BLOCK_ENTITIES.register(
            "dna_recombiner_centrifuge",
            () -> new BlockEntityType<>(
                    BlockEntityDNARecombinerCentrifuge::new,
                    ModBlocks.CENTRIFUGE.get()
            )
    );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}