package net.velalii.overworld_reforged.particle.custom;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.velalii.overworld_reforged.particle.ModParticles;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class OverthiumExplosionParticle extends TextureSheetParticle {
    public float xRot;
    public float yRot;
    private final Level level;

    protected OverthiumExplosionParticle(ClientLevel pLevel, double pX, double pY, double pZ,
                                         double xRot, double yRot, double zRot) {
        super(pLevel, pX, pY, pZ);
        this.level = pLevel;
        this.setSize(0.5F, 0.5F);
        this.quadSize = 1f;
        this.xd =0;
        this.yd =0;
        this.zd =0;
        this.lifetime = 0;
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
            this.level.addParticle(ModParticles.OVERTHIUM_SHOCKWAVE.get(), this.x, this.y, this.z, this.xRot, this.yRot, 0);
            this.remove();
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
            OverthiumExplosionParticle particle = new OverthiumExplosionParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
