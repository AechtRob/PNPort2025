package com.github.aechtrob.prehistoricnature.particle;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, PrehistoricNature.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BOTHRODENDRON_PARTICLE =
            PARTICLE_TYPES.register("bothrodendron_leaves", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DIAPHORODENDRON_PARTICLE =
            PARTICLE_TYPES.register("diaphorodendron_leaves", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GANGAMOPTERIS_PARTICLE =
            PARTICLE_TYPES.register("gangamopteris_leaves", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GLOSSOPTERISA_PARTICLE =
            PARTICLE_TYPES.register("glossopteris_angustifolia_leaves", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LEPIDODENDRON_PARTICLE =
            PARTICLE_TYPES.register("lepidodendron_leaves", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LEPIDOPHLOIOS_PARTICLE =
            PARTICLE_TYPES.register("lepidophloios_leaves", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LEPTOPHLOEUM_PARTICLE =
            PARTICLE_TYPES.register("leptophloeum_leaves", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PITYS_PARTICLE =
            PARTICLE_TYPES.register("pitys_leaves", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SCIADOPITYS_PARTICLE =
            PARTICLE_TYPES.register("sciadopitys_leaves", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SYNCHYSIDENDRON_PARTICLE =
            PARTICLE_TYPES.register("synchisidendron_leaves", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

}
