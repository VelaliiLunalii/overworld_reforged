package net.velalii.overworld_reforged.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.velalii.overworld_reforged.Overworld_Reforged;
import net.velalii.overworld_reforged.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Overworld_Reforged.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OVERWORLD_REFORGED_TAB = CREATIVE_MODE_TABS.register(
            "overworld_reforged_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OVERTHIUM_SHARD.get()))
                    .title(Component.translatable("creativetab.overworld_reforged_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.OVERTHIUM_INGOT.get());
                        pOutput.accept(ModItems.OVERTHIUM_SHARD.get());
                        pOutput.accept(ModItems.MOSS_CATALYST.get());
                        pOutput.accept(ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.HAMMER_UPGRADE_SMITHING_TEMPLATE.get());

                        pOutput.accept(ModItems.OVERTHIUM_SWORD.get());
                        pOutput.accept(ModItems.OVERTHIUM_PICKAXE.get());
                        pOutput.accept(ModItems.OVERTHIUM_AXE.get());
                        pOutput.accept(ModItems.OVERTHIUM_HOE.get());
                        pOutput.accept(ModItems.OVERTHIUM_SHOVEL.get());

                        pOutput.accept(ModItems.WOODEN_MALLET.get());
                        pOutput.accept(ModItems.STONE_MALLET.get());
                        pOutput.accept(ModItems.IRON_MALLET.get());
                        pOutput.accept(ModItems.GOLDEN_MALLET.get());
                        pOutput.accept(ModItems.DIAMOND_MALLET.get());
                        pOutput.accept(ModItems.NETHERITE_MALLET.get());
                        pOutput.accept(ModItems.OVERTHIUM_MALLET.get());

                        pOutput.accept(ModItems.WOODEN_HAMMER.get());
                        pOutput.accept(ModItems.STONE_HAMMER.get());
                        pOutput.accept(ModItems.IRON_HAMMER.get());
                        pOutput.accept(ModItems.GOLDEN_HAMMER.get());
                        pOutput.accept(ModItems.DIAMOND_HAMMER.get());
                        pOutput.accept(ModItems.NETHERITE_HAMMER.get());
                        pOutput.accept(ModItems.OVERTHIUM_HAMMER.get());

                        pOutput.accept(ModItems.OVERTHIUM_HELMET.get());
                        pOutput.accept(ModItems.OVERTHIUM_CHESTPLATE.get());
                        pOutput.accept(ModItems.OVERTHIUM_LEGGINGS.get());
                        pOutput.accept(ModItems.OVERTHIUM_BOOTS.get());

                        pOutput.accept(ModItems.DEER_SPAWN_EGG.get());

                        pOutput.accept(ModBlocks.OVERTHIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.POLISHED_OVERTHIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.STRATITE.get());
                        pOutput.accept(ModBlocks.CRACKED_STRATITE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
