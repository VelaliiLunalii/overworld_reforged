package net.velalii.overworld_reforged.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;
import net.velalii.overworld_reforged.Overworld_Reforged;
import net.velalii.overworld_reforged.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier OVERTHIUM = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1561, 8.0F, 3.0F, 15,
                    ModTags.Blocks.NEEDS_OVERTHIUM_TOOL, () -> Ingredient.of(ModItems.OVERTHIUM_INGOT.get())),
            new ResourceLocation(Overworld_Reforged.MOD_ID, "overthium"), List.of(Tiers.IRON), List.of(Tiers.NETHERITE));
}
