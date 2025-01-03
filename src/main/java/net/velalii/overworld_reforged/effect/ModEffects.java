package net.velalii.overworld_reforged.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.velalii.overworld_reforged.Overworld_Reforged;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Overworld_Reforged.MOD_ID);

    public static final RegistryObject<MobEffect> FATIGUE = MOB_EFFECTS.register("fatigue",
            () -> new FatigueEffect(MobEffectCategory.NEUTRAL, 1111111));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
