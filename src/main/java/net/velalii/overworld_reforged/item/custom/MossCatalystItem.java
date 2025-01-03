package net.velalii.overworld_reforged.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.velalii.overworld_reforged.block.ModBlocks;

import java.util.Random;

import static java.lang.Math.*;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;
import static net.velalii.overworld_reforged.block.ModBlocks.LARGE_OVERTHIUM_CRYSTAL;
import static net.velalii.overworld_reforged.block.ModBlocks.OVERTHIUM_CRYSTAL;

public class MossCatalystItem extends Item {
    public MossCatalystItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        InteractionResult result = InteractionResult.FAIL;
        BlockPos positionClicked = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState state = pContext.getLevel().getBlockState(positionClicked);
        boolean isCrystal = state.is(ModBlocks.STAGNANT_OVERTHIUM_CRYSTAL.get()) || state.is(ModBlocks.LARGE_STAGNANT_OVERTHIUM_CRYSTAL.get());

        if(isCrystal){
            if(!pContext.getLevel().isClientSide()){
                BlockState crystalChoice;
                if(state.is(ModBlocks.STAGNANT_OVERTHIUM_CRYSTAL.get())) {
                    crystalChoice = OVERTHIUM_CRYSTAL.get().defaultBlockState();
                }else{
                    crystalChoice = LARGE_OVERTHIUM_CRYSTAL.get().defaultBlockState();
                }
                pContext.getLevel().setBlock(positionClicked, crystalChoice.setValue(FACING, state.getValue(FACING)),
                        1 | 2);

                pContext.getItemInHand().shrink(1);
                result = InteractionResult.SUCCESS;

            }else{
                pContext.getLevel().playSound(player, positionClicked, SoundEvents.AMETHYST_BLOCK_CHIME,
                        SoundSource.BLOCKS, 10, 1);
                int maxParticles = 3 + new Random().nextInt(3);
                double deviation = random() * 20;
                for (int i = 0; i < maxParticles; i++) {
                    pContext.getLevel().addParticle(ParticleTypes.SPORE_BLOSSOM_AIR,
                            positionClicked.getX() + 0.5, positionClicked.getY() + 0.5, positionClicked.getZ() + 0.5,
                            cos(((360 / maxParticles) * i) + deviation) * 1.3,
                            0.5 * random() - 1, sin(((360 / maxParticles) * i) + deviation) * 1.3);
                }
            }
        }

        return result;
    }
}
