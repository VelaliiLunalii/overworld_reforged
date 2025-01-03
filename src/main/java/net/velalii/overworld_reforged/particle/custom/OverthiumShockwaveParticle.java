package net.velalii.overworld_reforged.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.velalii.overworld_reforged.particle.ModParticles;

public class OverthiumShockwaveParticle extends TextureSheetParticle {
    public float xRot;
    public float yRot;
    private final Level level;

    protected OverthiumShockwaveParticle(ClientLevel pLevel, double pX, double pY, double pZ,
                                         double xRot, double yRot, double zRot) {
        super(pLevel, pX, pY, pZ);
        this.level = pLevel;
        this.setSize(0.5F, 0.5F);
        this.quadSize = 1f;
        this.xd =0;
        this.yd =0;
        this.zd =0;
        this.lifetime = 4;
        this.gravity = 0F;
        this.quadSize *= 1;
        this.friction = 0;
        this.rCol = 1;
        this.gCol = 1;
        this.bCol = 1;
        setRot((float)xRot, (float) yRot);
    }

    @Override
    public void tick() {
        if (this.age++ >= this.lifetime) {
            this.remove();
        }
        fadeOut();
    }

    private void fadeOut() {
        int factor = 2;
        float threshold = this.lifetime/(float)factor;
        if(this.age >= threshold) {
            this.alpha = 1 -((this.age - threshold) / threshold);
        }
    }

    public void setRot(float xRot, float yRot) {
        this.xRot = xRot;
        this.yRot = yRot;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet spriteSet) {
            this.sprite = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            OverthiumShockwaveParticle particle = new OverthiumShockwaveParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
