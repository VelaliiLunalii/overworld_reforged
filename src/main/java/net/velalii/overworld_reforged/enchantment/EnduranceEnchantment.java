package net.velalii.overworld_reforged.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.velalii.overworld_reforged.item.ModItems;

public class EnduranceEnchantment extends Enchantment {
    protected EnduranceEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {  // [] -> ...
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return ModItems.isMultiblockPickaxe(pStack);
    }
}
