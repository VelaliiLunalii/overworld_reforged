package net.velalii.overworld_reforged.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.velalii.overworld_reforged.OverworldReforged;
import net.velalii.overworld_reforged.entity.custom.DeerEntity;

public class DeerRenderer extends MobRenderer<DeerEntity, DeerModel<DeerEntity>>{
    public DeerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DeerModel<>(pContext.bakeLayer(ModModelLayers.DEER_LAYER)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(DeerEntity pEntity) {
        return new ResourceLocation(OverworldReforged.MOD_ID, "textures/entity/deer.png");
    }

    @Override
    public void render(DeerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
