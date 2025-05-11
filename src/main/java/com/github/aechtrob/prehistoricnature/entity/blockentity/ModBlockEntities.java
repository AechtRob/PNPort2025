package com.github.aechtrob.prehistoricnature.entity.blockentity;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModHangingSignBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModPlanterBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModSignBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModTrimmableBlockEntity;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.BlocksTreeLepidodendron;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PrehistoricNature.MODID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> PN_SIGN = BLOCK_ENTITIES.register(
            "pn_sign",
            // The block entity type.
            () -> BlockEntityType.Builder.of(
                    ModSignBlockEntity::new,
                    BlocksTreeLepidodendron.LEPIDODENDRON_SIGN.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN.get()
            ).build(null)
    );

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> PN_HANGING_SIGN = BLOCK_ENTITIES.register(
            "pn_hanging_sign",
            // The block entity type.
            () -> BlockEntityType.Builder.of(
                    ModHangingSignBlockEntity::new,
                    BlocksTreeLepidodendron.LEPIDODENDRON_SIGN_HANGING.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN_HANGING.get()
            ).build(null)
    );

    public static final RegistryObject<BlockEntityType<ModTrimmableBlockEntity>> PN_TRIMMABLE = BLOCK_ENTITIES.register(
            "pn_trimmable",
            // The block entity type.
            () -> BlockEntityType.Builder.of(
                    ModTrimmableBlockEntity::new,
                    BlocksTreeLepidodendron.LEPIDODENDRON_BENCH.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_BRIDGE.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_LITTERBIN.get()
            ).build(null)
    );

    public static final RegistryObject<BlockEntityType<ModPlanterBlockEntity>> PN_PLANTER = BLOCK_ENTITIES.register(
            "pn_planter",
            // The block entity type.
            () -> BlockEntityType.Builder.of(
                    ModPlanterBlockEntity::new,
                    BlocksTreeLepidodendron.LEPIDODENDRON_PLANTER_1.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_PLANTER_2.get()
            ).build(null)
    );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}