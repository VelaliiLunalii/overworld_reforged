package net.velalii.overworld_reforged.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.velalii.overworld_reforged.item.ModItems;
import net.velalii.overworld_reforged.loot.AddItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, "overworld_reforged");
    }

    @Override
    protected void start() {
        add("hammer_upgrade_smithing_template_from_abandoned_mineshaft", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()}, ModItems.HAMMER_UPGRADE_SMITHING_TEMPLATE.get()));
        add("hammer_upgrade_smithing_template_from_simple_dungeon", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()}, ModItems.HAMMER_UPGRADE_SMITHING_TEMPLATE.get()));
        add("hammer_upgrade_smithing_template_from_stronghold_corridor", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stronghold_corridor")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()}, ModItems.HAMMER_UPGRADE_SMITHING_TEMPLATE.get()));
        add("hammer_upgrade_smithing_template_from_stronghold_crossing", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stronghold_crossing")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()}, ModItems.HAMMER_UPGRADE_SMITHING_TEMPLATE.get()));
        add("hammer_upgrade_smithing_template_from_village_toolsmith", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()}, ModItems.HAMMER_UPGRADE_SMITHING_TEMPLATE.get()));
        add("hammer_upgrade_smithing_template_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()}, ModItems.HAMMER_UPGRADE_SMITHING_TEMPLATE.get()));
        add("hammer_upgrade_smithing_template_from_village_armorer", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_armorer")).build(),
                LootItemRandomChanceCondition.randomChance(1f).build()}, ModItems.HAMMER_UPGRADE_SMITHING_TEMPLATE.get()));

        add("overthium_upgrade_smithing_template_from_abandoned_mineshaft", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()}, ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("overthium_upgrade_smithing_template_from_buried_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/buried_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.75f).build()}, ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("overthium_upgrade_smithing_template_from_jungle_temple", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.75f).build()}, ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("overthium_upgrade_smithing_template_from_shipwreck_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.75f).build()}, ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("overthium_upgrade_smithing_template_from_simple_dungeon", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()}, ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("overthium_upgrade_smithing_template_from_stonghold_corridor", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stonghold_corridor")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()}, ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("overthium_upgrade_smithing_template_from_stonghold_crossing", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stonghold_crossing")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()}, ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("overthium_upgrade_smithing_template_from_underwater_ruin_big", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/underwater_ruin_big")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()}, ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get()));
        add("overthium_upgrade_smithing_template_from_underwater_ruin_small", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/underwater_ruin_small")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()}, ModItems.OVERTHIUM_UPGRADE_SMITHING_TEMPLATE.get()));


    }
}
