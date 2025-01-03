package net.velalii.overworld_reforged.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.velalii.overworld_reforged.Overworld_Reforged;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Overworld_Reforged.MOD_ID);

    public static final RegistryObject<SimpleParticleType> OVERTHIUM_TRAIL =
            PARTICLE_TYPES.register("overthium_trail",
            () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> OVERTHIUM_LASER =
            PARTICLE_TYPES.register("overthium_laser",
                    () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus){
        PARTICLE_TYPES.register(eventBus);
    }
}
