package net.velalii.overworld_reforged.effect;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.velalii.overworld_reforged.enchantment.ModEnchantments;
import net.velalii.overworld_reforged.item.ModItems;
import net.velalii.overworld_reforged.item.custom.MultiblockPickaxe;

public class FatigueEffect extends MobEffect {
    int tickTimer;
    protected FatigueEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
        this.tickTimer = 1;
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        ItemStack heldItem = pLivingEntity.getItemInHand(InteractionHand.MAIN_HAND);
        if (ModItems.isMultiblockPickaxe(heldItem) && pLivingEntity instanceof Player){
            MultiblockPickaxe heldMuPi = (MultiblockPickaxe) heldItem.getItem();
            if (heldItem.getAllEnchantments().containsKey(ModEnchantments.ENDURANCE.get())){
                Player player = (Player)pLivingEntity;
                if(this.tickTimer <= 1) {
                    player.getFoodData().setExhaustion(player.getFoodData().getExhaustionLevel() + 4);   //setFoodLevel(player.getFoodData().getFoodLevel() - 1);
                    this.tickTimer = 60;}else{this.tickTimer --;
                }
            }else {
                if (heldMuPi.getFatigue() > heldMuPi.getFatigueThreshold() && heldMuPi.getFatigue() < heldMuPi.getFatigueThreshold() + 5) {
                    heldMuPi.setVaryingSpeedModifier(1F - ((float) heldMuPi.getFatigue() - heldMuPi.getFatigueThreshold()) / 10);
                }else if (heldMuPi.getFatigue() >= heldMuPi.getFatigueThreshold() + 5) {
                    heldMuPi.setVaryingSpeedModifier(0.5F);
                }
            }
            if (heldMuPi.getFatigue() <= heldMuPi.getFatigueThreshold()){
                heldMuPi.setVaryingSpeedModifier(1F);
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
