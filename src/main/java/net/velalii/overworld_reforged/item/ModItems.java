package net.velalii.overworld_reforged.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.velalii.overworld_reforged.OverworldReforged;
import net.velalii.overworld_reforged.entity.ModEntities;
import net.velalii.overworld_reforged.item.custom.HammerItem;
import net.velalii.overworld_reforged.item.custom.MalletItem;
import net.velalii.overworld_reforged.item.custom.MossCatalystItem;
import net.velalii.overworld_reforged.item.custom.overlias_gift_items.*;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OverworldReforged.MOD_ID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> OVERTHIUM_INGOT = ITEMS.register("overthium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OVERTHIUM_SHARD = ITEMS.register("overthium_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOSS_CATALYST = ITEMS.register("moss_catalyst",
            () -> new MossCatalystItem(new Item.Properties()));

    public static final RegistryObject<Item> OVERTHIUM_SWORD = ITEMS.register("overthium_sword",
            () -> new OverthiumSwordItem(ModToolTiers.OVERTHIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> OVERTHIUM_PICKAXE = ITEMS.register("overthium_pickaxe",
            () -> new OverthiumPickaxeItem(ModToolTiers.OVERTHIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> OVERTHIUM_AXE = ITEMS.register("overthium_axe",
            () -> new OverthiumAxeItem(ModToolTiers.OVERTHIUM, 5, -3, new Item.Properties()));
    public static final RegistryObject<Item> OVERTHIUM_HOE = ITEMS.register("overthium_hoe",
            () -> new OverthiumHoeItem(ModToolTiers.OVERTHIUM, -3, 0, new Item.Properties()));
    public static final RegistryObject<Item> OVERTHIUM_SHOVEL = ITEMS.register("overthium_shovel",
            () -> new OverthiumShovelItem(ModToolTiers.OVERTHIUM, 1.5F, -3, new Item.Properties()));

    public static final RegistryObject<Item> WOODEN_MALLET = ITEMS.register("wooden_mallet",
            () -> new MalletItem(Tiers.WOOD, 4, -2.8F, new Item.Properties(),
                    1, 1/2F, 20));
    public static final RegistryObject<Item> STONE_MALLET = ITEMS.register("stone_mallet",
            () -> new MalletItem(Tiers.STONE, 4, -2.8F, new Item.Properties(),
                    1, 1/2F, 20));
    public static final RegistryObject<Item> IRON_MALLET = ITEMS.register("iron_mallet",
            () -> new MalletItem(Tiers.IRON, 4, -2.8F, new Item.Properties(),
                    2, 1/2F, 20));
    public static final RegistryObject<Item> GOLDEN_MALLET = ITEMS.register("golden_mallet",
            () -> new MalletItem(Tiers.GOLD, 4, -2.8F, new Item.Properties(),
                    2, 1/2F, 20));
    public static final RegistryObject<Item> DIAMOND_MALLET = ITEMS.register("diamond_mallet",
            () -> new MalletItem(Tiers.DIAMOND, 4, -2.8F, new Item.Properties(),
                    3, 1/2F, 20));
    public static final RegistryObject<Item> NETHERITE_MALLET = ITEMS.register("netherite_mallet",
            () -> new MalletItem(Tiers.NETHERITE, 4, -2.8F, new Item.Properties(),
                    3, 1/2F, 20));
    public static final RegistryObject<Item> OVERTHIUM_MALLET = ITEMS.register("overthium_mallet",
            () -> new OverthiumMalletItem(ModToolTiers.OVERTHIUM, 4, -2.8F, new Item.Properties(),
                    3, 1/2F, 20));

    public static final RegistryObject<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer",
            () -> new HammerItem(Tiers.WOOD, 6, -3.2F, new Item.Properties(),
                    1/3F, 20));
    public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(Tiers.STONE, 6, -3.2F, new Item.Properties(),
                    1/3F, 20));
    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(Tiers.IRON, 6, -3.2F, new Item.Properties(),
                    1/3F, 20));
    public static final RegistryObject<Item> GOLDEN_HAMMER = ITEMS.register("golden_hammer",
            () -> new HammerItem(Tiers.GOLD, 6, -3.2F, new Item.Properties(),
                    1/3F, 20));
    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(Tiers.DIAMOND, 6, -3.2F, new Item.Properties(),
                    1/3F, 20));
    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            () -> new HammerItem(Tiers.NETHERITE, 6, -3.2F, new Item.Properties(),
                    1/3F, 20));
    public static final RegistryObject<Item> OVERTHIUM_HAMMER = ITEMS.register("overthium_hammer",
            () -> new OverthiumHammerItem(ModToolTiers.OVERTHIUM, 6, -3.2F, new Item.Properties(),
                    1/3F, 20));

    public static final RegistryObject<Item> OVERTHIUM_HELMET = ITEMS.register("overthium_helmet",
            () -> new OverthiumArmorItem(ModArmorMaterials.OVERTHIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OVERTHIUM_CHESTPLATE = ITEMS.register("overthium_chestplate",
            () -> new OverthiumArmorItem(ModArmorMaterials.OVERTHIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> OVERTHIUM_LEGGINGS = ITEMS.register("overthium_leggings",
            () -> new OverthiumArmorItem(ModArmorMaterials.OVERTHIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> OVERTHIUM_BOOTS = ITEMS.register("overthium_boots",
            () -> new OverthiumArmorItem(ModArmorMaterials.OVERTHIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> DEER_SPAWN_EGG = ITEMS.register("deer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DEER, 0xb86c35, 0xf5ebe2,
                    new Item.Properties()));

    public static boolean isOverthium(ItemStack item){
        boolean sw = item.is(OVERTHIUM_SWORD.get());
        boolean pi = item.is(OVERTHIUM_PICKAXE.get());
        boolean ax = item.is(OVERTHIUM_AXE.get());
        boolean sh = item.is(OVERTHIUM_SHOVEL.get());
        boolean ho = item.is(OVERTHIUM_HOE.get());
        boolean ha = item.is(OVERTHIUM_HAMMER.get());
        boolean ma = item.is(OVERTHIUM_MALLET.get());
        boolean he = item.is(OVERTHIUM_HELMET.get());
        boolean ch = item.is(OVERTHIUM_CHESTPLATE.get());
        boolean le = item.is(OVERTHIUM_LEGGINGS.get());
        boolean bo = item.is(OVERTHIUM_BOOTS.get());
        return sw||pi||ax||sh||ho||ha||ma||he||ch||le||bo;
    }

    public static boolean isMultiblockPickaxe(ItemStack item){
        boolean wm = item.is(WOODEN_MALLET.get());
        boolean wh = item.is(WOODEN_HAMMER.get());
        boolean sm = item.is(STONE_MALLET.get());
        boolean sh = item.is(STONE_HAMMER.get());
        boolean im = item.is(IRON_MALLET.get());
        boolean ih = item.is(IRON_HAMMER.get());
        boolean gm = item.is(GOLDEN_MALLET.get());
        boolean gh = item.is(GOLDEN_HAMMER.get());
        boolean dm = item.is(DIAMOND_MALLET.get());
        boolean dh = item.is(DIAMOND_HAMMER.get());
        boolean nm = item.is(NETHERITE_MALLET.get());
        boolean nh = item.is(NETHERITE_HAMMER.get());
        boolean om = item.is(OVERTHIUM_MALLET.get());
        boolean oh = item.is(OVERTHIUM_HAMMER.get());
        return wm||wh||sm||sh||im||ih||gm||gh||dm||dh||nm||nh||om||oh;
    }

    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/ingot");
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/boots");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/sword");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/pickaxe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/axe");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/hoe");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/shovel");
    private static final ResourceLocation EMPTY_SLOT_BLOCK = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/block");
    private static final ResourceLocation EMPTY_SLOT_MALLET = new ResourceLocation(OverworldReforged.MOD_ID, "item/empty_slot/mallet");
    public static final RegistryObject<Item> OVERTHIUM_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("overthium_upgrade_smithing_template", () -> new SmithingTemplateItem(
            Component.translatable("item.overworld_reforged.smithing_template.overthium_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.overworld_reforged.smithing_template.overthium_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
            Component.translatable("upgrade.overworld_reforged.overthium_upgrade"),
            Component.translatable("item.overworld_reforged.smithing_template.overthium_upgrade.base_slot_description"),
            Component.translatable("item.overworld_reforged.smithing_template.overthium_upgrade.additions_slot_description"),
            List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL),
            List.of(EMPTY_SLOT_INGOT)
    ));
    public static final RegistryObject<Item> HAMMER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("hammer_upgrade_smithing_template", () -> new SmithingTemplateItem(
            Component.translatable("item.overworld_reforged.smithing_template.hammer_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.overworld_reforged.smithing_template.hammer_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
            Component.translatable("upgrade.overworld_reforged.hammer_upgrade"),
            Component.translatable("item.overworld_reforged.smithing_template.hammer_upgrade.base_slot_description"),
            Component.translatable("item.overworld_reforged.smithing_template.hammer_upgrade.additions_slot_description"),
            List.of(EMPTY_SLOT_MALLET),
            List.of(EMPTY_SLOT_BLOCK)
    ));
}
