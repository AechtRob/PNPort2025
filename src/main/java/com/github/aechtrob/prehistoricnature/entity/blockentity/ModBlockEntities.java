package com.github.aechtrob.prehistoricnature.entity.blockentity;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
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
import com.github.aechtrob.prehistoricnature.world.tree.sciadopitys.BlocksTreeSciadopitys;
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
            // The block entity type.
            () -> new BlockEntityType<>(
                    ModSignBlockEntity::new,
                    BlocksTreeBothrodendron.BOTHRODENDRON_SIGN.get(), BlocksTreeBothrodendron.BOTHRODENDRON_WALL_SIGN.get(),
                    BlocksTreeDiaphorodendron.DIAPHORODENDRON_SIGN.get(), BlocksTreeDiaphorodendron.DIAPHORODENDRON_WALL_SIGN.get(),
                    BlocksTreeGangamopteris.GANGAMOPTERIS_SIGN.get(), BlocksTreeGangamopteris.GANGAMOPTERIS_WALL_SIGN.get(),
                    BlocksTreeGlossopterisA.GLOSSOPTERISA_SIGN.get(), BlocksTreeGlossopterisA.GLOSSOPTERISA_WALL_SIGN.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_SIGN.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN.get(),
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_SIGN.get(), BlocksTreeLepidophloios.LEPIDOPHLOIOS_WALL_SIGN.get(),
                    BlocksTreeSciadopitys.SCIADOPITYS_SIGN.get(), BlocksTreeSciadopitys.SCIADOPITYS_WALL_SIGN.get()
            )
    );

    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> PN_HANGING_SIGN = BLOCK_ENTITIES.register(
            "pn_hanging_sign",
            // The block entity type.
            () -> new BlockEntityType<>(
                    ModHangingSignBlockEntity::new,
                    BlocksTreeBothrodendron.BOTHRODENDRON_SIGN_HANGING.get(), BlocksTreeBothrodendron.BOTHRODENDRON_WALL_SIGN_HANGING.get(),
                    BlocksTreeDiaphorodendron.DIAPHORODENDRON_SIGN_HANGING.get(), BlocksTreeDiaphorodendron.DIAPHORODENDRON_WALL_SIGN_HANGING.get(),
                    BlocksTreeGangamopteris.GANGAMOPTERIS_SIGN_HANGING.get(), BlocksTreeGangamopteris.GANGAMOPTERIS_WALL_SIGN_HANGING.get(),
                    BlocksTreeGlossopterisA.GLOSSOPTERISA_SIGN_HANGING.get(), BlocksTreeGlossopterisA.GLOSSOPTERISA_WALL_SIGN_HANGING.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_SIGN_HANGING.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN_HANGING.get(),
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_SIGN_HANGING.get(), BlocksTreeLepidophloios.LEPIDOPHLOIOS_WALL_SIGN_HANGING.get(),
                    BlocksTreeSciadopitys.SCIADOPITYS_SIGN_HANGING.get(), BlocksTreeSciadopitys.SCIADOPITYS_WALL_SIGN_HANGING.get()

            )
    );

    public static final Supplier<BlockEntityType<ModTrimmableBlockEntity>> PN_TRIMMABLE = BLOCK_ENTITIES.register(
            "pn_trimmable",
            // The block entity type.
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
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_LITTERBIN.get()


            )
    );

    public static final Supplier<BlockEntityType<ModPlanterBlockEntity>> PN_PLANTER = BLOCK_ENTITIES.register(
            "pn_planter",
            // The block entity type.
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
                    BlocksTreeLepidophloios.LEPIDOPHLOIOS_PLANTER_2.get()
            )
    );



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}