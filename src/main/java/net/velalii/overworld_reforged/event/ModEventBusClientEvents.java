package net.velalii.overworld_reforged.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.velalii.overworld_reforged.OverworldReforged;
import net.velalii.overworld_reforged.entity.client.DeerModel;
import net.velalii.overworld_reforged.entity.client.ModModelLayers;

@Mod.EventBusSubscriber(modid = OverworldReforged.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.DEER_LAYER, DeerModel::createBodyLayer);
    }
}
