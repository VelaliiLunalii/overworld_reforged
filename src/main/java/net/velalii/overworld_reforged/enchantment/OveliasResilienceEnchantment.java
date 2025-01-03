package net.velalii.overworld_reforged.enchantment;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.velalii.overworld_reforged.item.ModItems;

public class OveliasResilienceEnchantment extends Enchantment {
    protected OveliasResilienceEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {  // [] -> ...
        super(pRarity, pCategory, pApplicableSlots);
    }
}
