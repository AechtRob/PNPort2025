package com.github.aechtrob.prehistoricnature.world.tree.synchysidendron;

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

public class EntitiesTreeSynchysidendron {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, PrehistoricNature.MODID);

    public static final Supplier<EntityType<BoatSynchysidendronEntity>> SYNCHYSIDENDRON_BOAT = ENTITY_TYPES.register(
            "synchysidendron_boat",
            // The entity type, created using a builder. SynchysidendronTrunkPlacer
            () -> (EntityType.Builder.of(boatFactory(() -> ItemsTreeSynchysidendron.SYNCHYSIDENDRON_BOAT.get()), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "synchysidendron_boat")
                    ))
            )
    );

    public static final Supplier<EntityType<BoatChestSynchysidendronEntity>> SYNCHYSIDENDRON_CHEST_BOAT = ENTITY_TYPES.register(
            "synchysidendron_chest_boat",
            // The entity type, created using a builder.
            () -> (EntityType.Builder.of(chestBoatFactory(() -> ItemsTreeSynchysidendron.SYNCHYSIDENDRON_CHEST_BOAT.get()), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "synchysidendron_chest_boat")
                    ))
            )
    );

    private static EntityType.EntityFactory<BoatSynchysidendronEntity> boatFactory(Supplier<Item> boatItemGetter) {
        return (p_375558_, p_375559_) -> new BoatSynchysidendronEntity(p_375558_, p_375559_, boatItemGetter);
    }

    private static EntityType.EntityFactory<BoatChestSynchysidendronEntity> chestBoatFactory(Supplier<Item> boatItemGetter) {
        return (p_375555_, p_375556_) -> new BoatChestSynchysidendronEntity(p_375555_, p_375556_, boatItemGetter);
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
