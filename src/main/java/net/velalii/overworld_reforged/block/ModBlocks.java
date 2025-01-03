package net.velalii.overworld_reforged.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.velalii.overworld_reforged.Overworld_Reforged;
import net.velalii.overworld_reforged.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Overworld_Reforged.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static final RegistryObject<Block> OVERTHIUM_BLOCK = registerBlock("overthium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> POLISHED_OVERTHIUM_BLOCK = registerBlock("polished_overthium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> STRATITE = registerBlock("stratite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_STRATITE = registerBlock("cracked_stratite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OVERTHIUM_CRYSTAL = registerBlock("overthium_crystal",
            () -> new AmethystClusterBlock(10, 5, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER)
                    .strength(0.2F)));
    public static final RegistryObject<Block> LARGE_OVERTHIUM_CRYSTAL = registerBlock("large_overthium_crystal",
            () -> new AmethystClusterBlock(10, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER)
                    .strength(0.2F)));
    public static final RegistryObject<Block> STAGNANT_OVERTHIUM_CRYSTAL = registerBlock("stagnant_overthium_crystal",
            () -> new AmethystClusterBlock(10, 5, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER)
                    .strength(0.2F)));
    public static final RegistryObject<Block> LARGE_STAGNANT_OVERTHIUM_CRYSTAL = registerBlock("large_stagnant_overthium_crystal",
            () -> new AmethystClusterBlock(10, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER)
                    .strength(0.2F)));
}
