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
import net.velalii.overworld_reforged.entity.custom.OverthiumLaserProjectile;
import net.velalii.overworld_reforged.particle.ModParticles;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class OverthiumLaserParticle extends TextureSheetParticle {
    public float xRot;
    public float yRot;
    private final Level level;

    protected OverthiumLaserParticle(ClientLevel pLevel, double pX, double pY, double pZ,
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
            this.level.addParticle(ModParticles.OVERTHIUM_TRAIL.get(), this.x, this.y, this.z, this.xRot, this.yRot, 0);
            this.remove();
        }
    }

    public void setRot(float xRot, float yRot) {
        this.xRot = xRot;
        this.yRot = yRot;
    }

    @Override
    public void render(VertexConsumer pBuffer, Camera pRenderInfo, float pPartialTicks) {
        Vec3 vec3 = pRenderInfo.getPosition();
        float f = (float)(Mth.lerp((double)pPartialTicks, this.xo, this.x) - vec3.x());
        float f1 = (float)(Mth.lerp((double)pPartialTicks, this.yo, this.y) - vec3.y());
        float f2 = (float)(Mth.lerp((double)pPartialTicks, this.zo, this.z) - vec3.z());

        float f6 = this.getU0();
        float f7 = this.getU1();
        float f4 = this.getV0();
        float f5 = this.getV1();
        float f3 = this.getQuadSize(pPartialTicks);
        int j = this.getLightColor(pPartialTicks);

        Quaternionf quaternionf = Axis.YP.rotationDegrees(this.yRot + 90);
        quaternionf.mul(Axis.ZN.rotationDegrees(this.xRot));
        quaternionf.mul(Axis.XN.rotationDegrees(30));

        Vector3f[] bvector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};

        for(int i = 0; i < 4; ++i) {
            Vector3f vector3f = bvector3f[i];
            vector3f.rotate(quaternionf);
            vector3f.mul(f3);
            vector3f.add(f, f1, f2);
        }

        pBuffer.vertex((double)bvector3f[0].x(), (double)bvector3f[0].y(), (double)bvector3f[0].z()).uv(f7, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        pBuffer.vertex((double)bvector3f[1].x(), (double)bvector3f[1].y(), (double)bvector3f[1].z()).uv(f7, f4).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        pBuffer.vertex((double)bvector3f[2].x(), (double)bvector3f[2].y(), (double)bvector3f[2].z()).uv(f6, f4).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        pBuffer.vertex((double)bvector3f[3].x(), (double)bvector3f[3].y(), (double)bvector3f[3].z()).uv(f6, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();

        quaternionf = Axis.YP.rotationDegrees(this.yRot + 270);
        quaternionf.mul(Axis.ZP.rotationDegrees(this.xRot + 180));
        quaternionf.mul(Axis.XN.rotationDegrees(30));

        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};

        for(int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            vector3f.rotate(quaternionf);
            vector3f.mul(f3);
            vector3f.add(f, f1, f2);
        }

        pBuffer.vertex((double)avector3f[0].x(), (double)avector3f[0].y(), (double)avector3f[0].z()).uv(f7, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        pBuffer.vertex((double)avector3f[1].x(), (double)avector3f[1].y(), (double)avector3f[1].z()).uv(f7, f4).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        pBuffer.vertex((double)avector3f[2].x(), (double)avector3f[2].y(), (double)avector3f[2].z()).uv(f6, f4).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        pBuffer.vertex((double)avector3f[3].x(), (double)avector3f[3].y(), (double)avector3f[3].z()).uv(f6, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
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
            OverthiumLaserParticle particle = new OverthiumLaserParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
