package com.github.aechtrob.prehistoricnature.entity.entity;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, PrehistoricNature.MODID);

    public static final RegistryObject<EntityType<BenchSittableEntity>> BENCH_ENTITY =
            ENTITY_TYPES.register("bench_entity",
                () -> EntityType.Builder.of(BenchSittableEntity::new, MobCategory.MISC)
                .sized(0.5F, 0.5F)
                .build("bench_entity")
            );

    public static final RegistryObject<EntityType<ModBoatEntity>> BOAT_ENTITY =
            ENTITY_TYPES.register("boat",
                    () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .build("boat")
            );

    public static final RegistryObject<EntityType<ModChestBoatEntity>> CHEST_BOAT_ENTITY =
            ENTITY_TYPES.register("chestboat",
                    () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .build("chest_boat")
            );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
