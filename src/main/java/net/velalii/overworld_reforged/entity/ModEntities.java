package net.velalii.overworld_reforged.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.velalii.overworld_reforged.OverworldReforged;
import net.velalii.overworld_reforged.entity.custom.DeerEntity;
import net.velalii.overworld_reforged.entity.custom.OverthiumLaserProjectile;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OverworldReforged.MOD_ID);

    public static final RegistryObject<EntityType<DeerEntity>> DEER =
            ENTITY_TYPE.register("deer", () -> EntityType.Builder.of(DeerEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 1.2f).build("deer"));
    public static final RegistryObject<EntityType<OverthiumLaserProjectile>> OVERTHIUM_LASER =
            ENTITY_TYPE.register("overthium_laser", () -> EntityType.Builder.<OverthiumLaserProjectile>of(OverthiumLaserProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("overthium_laser"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPE.register(eventBus);
    }
}
