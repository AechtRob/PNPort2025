package com.github.aechtrob.prehistoricnature.entity.blockentity;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModHangingSignBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModSignBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.blockentity.blockentitybase.ModTrimmableBlockEntity;
import com.github.aechtrob.prehistoricnature.world.tree.lepidodendron.BlocksTreeLepidodendron;
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
                    BlocksTreeLepidodendron.LEPIDODENDRON_SIGN.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN.get()
            )
    );

    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> PN_HANGING_SIGN = BLOCK_ENTITIES.register(
            "pn_hanging_sign",
            // The block entity type.
            () -> new BlockEntityType<>(
                    ModHangingSignBlockEntity::new,
                    BlocksTreeLepidodendron.LEPIDODENDRON_SIGN_HANGING.get(), BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN_HANGING.get()
            )
    );

    public static final Supplier<BlockEntityType<ModTrimmableBlockEntity>> PN_TRIMMABLE = BLOCK_ENTITIES.register(
            "pn_trimmable",
            // The block entity type.
            () -> new BlockEntityType<>(
                    ModTrimmableBlockEntity::new,
                    BlocksTreeLepidodendron.LEPIDODENDRON_BENCH.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_BRIDGE.get(),
                    BlocksTreeLepidodendron.LEPIDODENDRON_LITTERBIN.get()
            )
    );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}