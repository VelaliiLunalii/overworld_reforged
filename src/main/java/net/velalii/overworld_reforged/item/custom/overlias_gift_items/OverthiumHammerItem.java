package net.velalii.overworld_reforged.item.custom.overlias_gift_items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.velalii.overworld_reforged.entity.custom.OverthiumLaserProjectile;
import net.velalii.overworld_reforged.item.IOveliasGiftToggle;
import net.velalii.overworld_reforged.item.ModItems;
import net.velalii.overworld_reforged.item.custom.HammerItem;

import java.util.ArrayList;

public class OverthiumHammerItem extends HammerItem implements IOveliasGiftToggle {
    private int laserCooldown;
    private boolean oveliasGiftToggle;
    public OverthiumHammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, Float instancedSpeedModifier, int fatigueThreshold) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties, instancedSpeedModifier, fatigueThreshold);
        this.laserCooldown = 0;
        this.oveliasGiftToggle = true;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        System.out.println("tick");
        if(oveliasGiftToggle && !pLevel.isClientSide()) {
            if(pEntity instanceof Player player) {
                if (player.swinging) {
                    int powerLevel = this.getPowerLevel(player);
                    if (this.laserCooldown >= 20 * (6 - powerLevel)) {
                        this.laserCooldown = 0;
                        OverthiumLaserProjectile laser = new OverthiumLaserProjectile(pLevel, player, pStack);
                        laser.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 1F, 0F);
                        pLevel.addFreshEntity(laser);
                    }
                } else {
                    this.laserCooldown++;
                }
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
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
            }
        }
        return count;
    }

    public void toggleOveliasGift(){this.oveliasGiftToggle = !this.oveliasGiftToggle;}
}
