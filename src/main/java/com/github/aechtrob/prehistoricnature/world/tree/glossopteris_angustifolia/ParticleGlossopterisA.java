package com.github.aechtrob.prehistoricnature.world.tree.glossopteris_angustifolia;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

public class ParticleGlossopterisA extends FallingLeavesParticle {
    
    public ParticleGlossopterisA(ClientLevel level, double x, double y, double z, SpriteSet sprites, float gravityMultiplier, float windBig, boolean swirl, boolean flowAway, float size, float ySpeed) {
        super(level, x, y, z, sprites, gravityMultiplier, windBig, swirl, flowAway, size, ySpeed);
    }

    public static class GlossopterisAProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public GlossopterisAProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType p_383195_, ClientLevel level, double p_382840_, double p_382854_, double p_382910_, double p_382859_, double p_382947_, double p_383154_) {
            return new FallingLeavesParticle(level, p_382840_, p_382854_, p_382910_, this.spriteSet, 0.07F, 10.0F, true, false, 2.0F, 0.021F);
        }
    }
}
