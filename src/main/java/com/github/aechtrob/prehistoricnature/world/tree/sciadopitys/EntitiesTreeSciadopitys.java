package com.github.aechtrob.prehistoricnature.world.tree.sciadopitys;

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

public class EntitiesTreeSciadopitys {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, PrehistoricNature.MODID);

    public static final Supplier<EntityType<BoatSciadopitysEntity>> SCIADOPITYS_BOAT = ENTITY_TYPES.register(
            "sciadopitys_boat",
            // The entity type, created using a builder.
            () -> (EntityType.Builder.of(boatFactory(() -> ItemsTreeSciadopitys.SCIADOPITYS_BOAT.get()), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_boat")
                    ))
            )
    );

    public static final Supplier<EntityType<BoatChestSciadopitysEntity>> SCIADOPITYS_CHEST_BOAT = ENTITY_TYPES.register(
            "sciadopitys_chest_boat",
            // The entity type, created using a builder.
            () -> (EntityType.Builder.of(chestBoatFactory(() -> ItemsTreeSciadopitys.SCIADOPITYS_CHEST_BOAT.get()), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "sciadopitys_chest_boat")
                    ))
            )
    );

    private static EntityType.EntityFactory<BoatSciadopitysEntity> boatFactory(Supplier<Item> boatItemGetter) {
        return (p_375558_, p_375559_) -> new BoatSciadopitysEntity(p_375558_, p_375559_, boatItemGetter);
    }

    private static EntityType.EntityFactory<BoatChestSciadopitysEntity> chestBoatFactory(Supplier<Item> boatItemGetter) {
        return (p_375555_, p_375556_) -> new BoatChestSciadopitysEntity(p_375555_, p_375556_, boatItemGetter);
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
