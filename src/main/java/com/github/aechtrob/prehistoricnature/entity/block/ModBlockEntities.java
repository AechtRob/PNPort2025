package com.github.aechtrob.prehistoricnature.entity.block;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.block.trees.lepidodendron.BlocksTreeLepidodendron;
import com.github.aechtrob.prehistoricnature.entity.block.blockentitybase.ModHangingSignBlockEntity;
import com.github.aechtrob.prehistoricnature.entity.block.blockentitybase.ModSignBlockEntity;
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

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}