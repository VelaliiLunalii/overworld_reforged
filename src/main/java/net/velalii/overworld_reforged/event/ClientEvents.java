package net.velalii.overworld_reforged.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.velalii.overworld_reforged.OverworldReforged;
import net.velalii.overworld_reforged.item.custom.overlias_gift_items.IOveliasGiftToggle;
import net.velalii.overworld_reforged.item.ModItems;
import net.velalii.overworld_reforged.util.KeyBinding;

import java.util.ArrayList;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = OverworldReforged.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.OVELIAS_BLESSING_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Toggled Ovelia's gift"));
                Player player = Minecraft.getInstance().player;
                ItemStack hand = player.getItemInHand(InteractionHand.MAIN_HAND);
                ItemStack boots = player.getInventory().getArmor(0);
                ItemStack leggings = player.getInventory().getArmor(1);
                ItemStack chestplate = player.getInventory().getArmor(2);
                ItemStack helmet = player.getInventory().getArmor(3);

                ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
                itemList.add(helmet);
                itemList.add(chestplate);
                itemList.add(leggings);
                itemList.add(boots);
                itemList.add(hand);

                int masterSlot = -1;
                for (int i = 0; i<5; i++) {
                    if (ModItems.isOverthium(itemList.get(i))){
                        masterSlot = 4 - i;  //0=hand, 1=boots, 4=helmet, it's in reverse order to allow the hand to take priority
                    }
                }

                if(masterSlot != -1){
                    if(itemList.get(4-masterSlot).getItem() instanceof IOveliasGiftToggle)
                        ((IOveliasGiftToggle) itemList.get(4-masterSlot).getItem()).toggleOveliasGift();
                }
            }
        }
    }
    @Mod.EventBusSubscriber(modid = OverworldReforged.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.OVELIAS_BLESSING_KEY);
        }
    }
}
