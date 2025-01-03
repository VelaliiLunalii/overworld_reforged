package net.velalii.overworld_reforged.event;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.velalii.overworld_reforged.OverworldReforged;
import net.velalii.overworld_reforged.entity.ModEntities;
import net.velalii.overworld_reforged.entity.custom.DeerEntity;
import net.velalii.overworld_reforged.particle.ModParticles;
import net.velalii.overworld_reforged.particle.custom.OverthiumExplosionParticle;
import net.velalii.overworld_reforged.particle.custom.OverthiumLaserParticle;
import net.velalii.overworld_reforged.particle.custom.OverthiumShockwaveParticle;
import net.velalii.overworld_reforged.particle.custom.OverthiumTrailParticle;

@Mod.EventBusSubscriber(modid = OverworldReforged.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.DEER.get(), DeerEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void RegisterSpawnPlacements(SpawnPlacementRegisterEvent event){
        event.register(ModEntities.DEER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                DeerEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
    }

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.OVERTHIUM_TRAIL.get(),
                OverthiumTrailParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.OVERTHIUM_LASER.get(),
                OverthiumLaserParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.OVERTHIUM_EXPLOSION.get(),
                OverthiumExplosionParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.OVERTHIUM_SHOCKWAVE.get(),
                OverthiumShockwaveParticle.Provider::new);
    }
}
