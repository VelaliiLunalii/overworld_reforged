package net.velalii.overworld_reforged;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.velalii.overworld_reforged.block.ModBlocks;
import net.velalii.overworld_reforged.effect.ModEffects;
import net.velalii.overworld_reforged.enchantment.ModEnchantments;
import net.velalii.overworld_reforged.entity.ModEntities;
import net.velalii.overworld_reforged.entity.client.DeerRenderer;
import net.velalii.overworld_reforged.entity.client.OverthiumLaserRenderer;
import net.velalii.overworld_reforged.item.ModCreativeModTabs;
import net.velalii.overworld_reforged.item.ModItems;
import net.velalii.overworld_reforged.loot.ModLootModifiers;
import net.velalii.overworld_reforged.particle.ModParticles;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OverworldReforged.MOD_ID)
public class OverworldReforged {
    public static final String MOD_ID = "overworld_reforged";
    private static final Logger LOGGER = LogUtils.getLogger();

    public OverworldReforged() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModEffects.register(modEventBus);
        ModEnchantments.register(modEventBus);
        ModEntities.register(modEventBus);
        ModParticles.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.DEER.get(), DeerRenderer::new);
            EntityRenderers.register(ModEntities.OVERTHIUM_LASER.get(), OverthiumLaserRenderer::new);
        }
    }
}