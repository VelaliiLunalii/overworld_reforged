package net.velalii.overworld_reforged.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.velalii.overworld_reforged.entity.custom.OverthiumLaserProjectile;
import net.velalii.overworld_reforged.item.IOveliasGiftToggle;
import net.velalii.overworld_reforged.item.ModItems;

import java.util.ArrayList;

public class OverthiumArmorItem extends ArmorItem implements IOveliasGiftToggle {
    private int masterSlot;
    private int powerLevel;
    private int tickCooldown;
    private int laserCooldown;
    private boolean oveliasGiftToggle;
    public OverthiumArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
        this.tickCooldown = 0;
        this.laserCooldown = 0;
        this.masterSlot = -1;
        this.oveliasGiftToggle = true;
    }


    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(oveliasGiftToggle) {
            if (this.tickCooldown <= 0) {
                this.powerLevel = this.getPowerLevel(player);
                this.tickCooldown = 20;
            } else {
                this.tickCooldown--;
            }
            if (!level.isClientSide && this.masterSlot == this.getEquipmentSlot().getFilterFlag()) {
                if (this.laserCooldown >= 20 * (6 - this.powerLevel) && player.swinging) {
                    this.laserCooldown = 0;
                    OverthiumLaserProjectile laser = new OverthiumLaserProjectile(level, player, stack);
                    laser.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 1F, 0F);
                    level.addFreshEntity(laser);
                } else {
                    this.laserCooldown++;
                }
            }
        }
        super.onArmorTick(stack, level, player);
    }

    public void toggleOveliasGift(){
        this.oveliasGiftToggle = !this.oveliasGiftToggle;
    }

    public int getPowerLevel(Player player){
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

        int count = 0;
        for (int i = 0; i<5; i++) {
            if (ModItems.isOverthium(itemList.get(i))){
                count++;
                this.masterSlot = 4 - i;  //0=hand, 1=boots, 4=helmet, it's in reverse order to allow the hand to take priority
            }
        }

        return count;
    }
}
