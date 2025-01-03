package net.velalii.overworld_reforged.item.custom;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.ScreenEvent;
import net.velalii.overworld_reforged.block.ModBlocks;
import net.velalii.overworld_reforged.effect.ModEffects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;
import static net.velalii.overworld_reforged.block.ModBlocks.*;

public class MultiblockPickaxe extends PickaxeItem {

    private String tag = "hammer_or_mallet";
    private int fatigue;
    private int fatigueThreshold;
    private Float varyingSpeedModifier;
    private Float instancedSpeedModifier;
    int timer;
    public MultiblockPickaxe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties,
                             Float instancedSpeedModifier, int fatigueThreshold) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.fatigue = 0;
        this.fatigueThreshold = fatigueThreshold;
        this.varyingSpeedModifier = 1F;
        this.instancedSpeedModifier = instancedSpeedModifier;
        this.timer = 0;
    }

    public String getTag(){return this.tag;}
    public int getFatigue() {return this.fatigue;}
    public int getFatigueThreshold() {return this.fatigueThreshold;}
    public void setVaryingSpeedModifier(Float varyingSpeedModifier) {this.varyingSpeedModifier = varyingSpeedModifier;}

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        return pState.is(BlockTags.MINEABLE_WITH_PICKAXE) ?
                this.speed * this.instancedSpeedModifier * this.varyingSpeedModifier : 1.0F;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if(pEntity instanceof Player && !pLevel.isClientSide) {
            if(this.fatigue>0) {
                if (this.timer > 0) {
                    this.timer--;
                } else if (this.timer == 0) {
                    this.timer = 20;
                    this.fatigue--;
                }

                Player player = (Player) pEntity;
                if(this.fatigue>this.fatigueThreshold && !player.hasEffect(ModEffects.FATIGUE.get())){
                    player.addEffect(new MobEffectInstance(ModEffects.FATIGUE.get(), 60));
                }
            }
        }
    }

    public Vec3 getTargetFace(BlockPos pPos, LivingEntity pEntityLiving) {
        Vec3 raypos = pEntityLiving.getEyePosition();
        double bx = pPos.getX();
        double by = pPos.getY();
        double bz = pPos.getZ();
        int i = 0;
        while (((raypos.x <= bx - 0.01) || (raypos.x >= bx + 1 + 0.01) || (raypos.y <= by - 0.01) || (raypos.y >= by + 1 + 0.01) || (raypos.z <= bz - 0.01) || (raypos.z >= bz + 1 + 0.01)) || ((Math.abs(bx - raypos.x) >= 0.001) && (Math.abs(bx + 1 - raypos.x) >= 0.001) && (Math.abs(by - raypos.y) >= 0.001) && (Math.abs(by + 1 - raypos.y) >= 0.001) && (Math.abs(bz - raypos.z) >= 0.001) && (Math.abs(bz + 1 - raypos.z) >= 0.001) && (i < 5000))) {
            raypos = raypos.add(pEntityLiving.getViewVector(1).multiply(0.001, 0.001, 0.001));
            i++;
        }
        return raypos;
    }

    public List<BlockPos> getAdjacentBlocks(BlockPos pPos, Vec3 raypos){
        List<BlockPos> lblocks = new ArrayList<BlockPos>();
        return lblocks;
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        this.fatigue++;
        this.timer = 100;
        Vec3 ray = this.getTargetFace(pPos, pEntityLiving);
        List<BlockPos> blockslist = this.getAdjacentBlocks(pPos, ray);
        for (BlockPos element : blockslist) {
            if ((pStack.isCorrectToolForDrops(pLevel.getBlockState(element))) && (pState.getDestroySpeed(pLevel, pPos) >= pLevel.getBlockState(element).getDestroySpeed(pLevel, element))){
                pLevel.destroyBlock(element, true, pEntityLiving);
                pStack.hurtAndBreak(1, pEntityLiving, (p_40992_) -> {
                    p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                });
            }
        }
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        InteractionResult result = InteractionResult.FAIL;

        if(!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Direction direction = pContext.getClickedFace();
            Player player = pContext.getPlayer();
            BlockState state = pContext.getLevel().getBlockState(positionClicked);
            if (state.is(ModBlocks.STRATITE.get())){
                pContext.getLevel().destroyBlock(positionClicked, false);
                pContext.getLevel().setBlock(positionClicked, CRACKED_STRATITE.get().defaultBlockState(), 1 | 2);

                BlockPos crystalPosition = new BlockPos(positionClicked.relative(direction));
                if(pContext.getLevel().getBlockState(crystalPosition).isAir()) {
                    if (random() < 0.5) {
                        BlockState crystalChoice;
                        if (random() < 0.75) {
                            crystalChoice = STAGNANT_OVERTHIUM_CRYSTAL.get().defaultBlockState();
                        } else {
                            crystalChoice = LARGE_STAGNANT_OVERTHIUM_CRYSTAL.get().defaultBlockState();
                        }
                        pContext.getLevel().setBlock(crystalPosition, crystalChoice
                                .setValue(FACING, pContext.getClickedFace()), 1 | 2);
                    }
                }

                pContext.getItemInHand().hurtAndBreak(1, player,
                        player1 -> player1.broadcastBreakEvent(player1.getUsedItemHand()));
                result = InteractionResult.SUCCESS;
            }
        }

        return result;
    }
}
