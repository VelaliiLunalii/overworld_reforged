package net.velalii.overworld_reforged.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.velalii.overworld_reforged.Overworld_Reforged;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_OVERTHIUM_TOOL = tag("needs_overthium_tool");
        public static final TagKey<Block> NEEDS_WOODEN_TOOL = tag("needs_wooden_tool");
        public static final TagKey<Block> NEEDS_STONE_TOOL = tag("needs_stone_tool");
        public static final TagKey<Block> NEEDS_IRON_TOOL = tag("needs_iron_tool");
        public static final TagKey<Block> NEEDS_GOLD_TOOL = tag("needs_gold_tool");
        public static final TagKey<Block> NEEDS_DIAMOND_TOOL = tag("needs_diamond_tool");
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = tag("needs_netherite_tool");
        public static final TagKey<Block> NEEDS_HAMMER_OR_MALLET = tag("needs_hammer_or_mallet");
        public static final TagKey<Block> STRATITE_ORE_REPLACEABLES = tag("stratite_ore_replaceables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Overworld_Reforged.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HAMMER_OR_MALLET = tag("hammer_or_mallet");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Overworld_Reforged.MOD_ID, name));
        }
    }
}
