package com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EntitiesTreeGlossopterisA {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, PrehistoricNature.MODID);

    public static final Supplier<EntityType<BoatGlossopterisAEntity>> GLOSSOPTERISA_BOAT = ENTITY_TYPES.register(
            "glossopteris_angustifolia_boat",
            // The entity type, created using a builder.
            () -> (EntityType.Builder.of(boatFactory(() -> ItemsTreeGlossopterisA.GLOSSOPTERISA_BOAT.get()), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_boat")
                    ))
            )
    );

    public static final Supplier<EntityType<BoatChestGlossopterisAEntity>> GLOSSOPTERISA_CHEST_BOAT = ENTITY_TYPES.register(
            "glossopteris_angustifolia_chest_boat",
            // The entity type, created using a builder.
            () -> (EntityType.Builder.of(chestBoatFactory(() -> ItemsTreeGlossopterisA.GLOSSOPTERISA_CHEST_BOAT.get()), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "glossopteris_angustifolia_chest_boat")
                    ))
            )
    );

    private static EntityType.EntityFactory<BoatGlossopterisAEntity> boatFactory(Supplier<Item> boatItemGetter) {
        return (p_375558_, p_375559_) -> new BoatGlossopterisAEntity(p_375558_, p_375559_, boatItemGetter);
    }

    private static EntityType.EntityFactory<BoatChestGlossopterisAEntity> chestBoatFactory(Supplier<Item> boatItemGetter) {
        return (p_375555_, p_375556_) -> new BoatChestGlossopterisAEntity(p_375555_, p_375556_, boatItemGetter);
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
