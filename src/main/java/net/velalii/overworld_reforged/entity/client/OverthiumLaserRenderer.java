package net.velalii.overworld_reforged.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.velalii.overworld_reforged.OverworldReforged;
import net.velalii.overworld_reforged.entity.custom.OverthiumLaserProjectile;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class OverthiumLaserRenderer extends EntityRenderer<OverthiumLaserProjectile> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(OverworldReforged.MOD_ID, "textures/entity/overthium_laser.png");
    private static final RenderType RENDER_TYPE = RenderType.entityCutoutNoCull(TEXTURE_LOCATION);
    public OverthiumLaserRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    public void render(OverthiumLaserProjectile pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();

        /*pMatrixStack.scale(1.0F, 1.0F, 1.0F);

        pMatrixStack.mulPose(Axis.YP.rotationDegrees(pEntity.getYRot()-90F +10F));    //degrees
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(pEntity.getXRot()));    //degrees

        PoseStack.Pose posestack$pose = pMatrixStack.last();
        Matrix4f matrix4f = posestack$pose.pose();
        Matrix3f matrix3f = posestack$pose.normal();
        VertexConsumer vertexconsumer = pBuffer.getBuffer(RENDER_TYPE);
        vertex(vertexconsumer, matrix4f, matrix3f, pPackedLight, 0.0F, 0, 0, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, pPackedLight, 1.0F, 0, 1, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, pPackedLight, 1.0F, 1, 1, 0);
        vertex(vertexconsumer, matrix4f, matrix3f, pPackedLight, 0.0F, 1, 0, 0);*/

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        pMatrixStack.popPose();
    }

    private static void vertex(VertexConsumer pConsumer, Matrix4f p_254477_, Matrix3f p_253948_, int pLightmapUV, float pX, int pY, int pU, int pV) {
        pConsumer.vertex(p_254477_, pX - 0.5F, (float)pY - 0.25F, 0.0F).color(255, 255, 255, 255).uv((float)pU, (float)pV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pLightmapUV).normal(p_253948_, 0.0F, 1.0F, 0.0F).endVertex();
    }

    /*public OverthiumLaserRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OverthiumLaserModel(pContext.bakeLayer(ModModelLayers.OVERTHIUM_LASER_LAYER)), 0.6f);
    }*/

    @Override
    public ResourceLocation getTextureLocation(OverthiumLaserProjectile pEntity) {
        return this.TEXTURE_LOCATION;
    }

}
