package net.velalii.overworld_reforged.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends MultiblockPickaxe{

    public HammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties,
                      Float instancedSpeedModifier, int fatigueThreshold) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties, instancedSpeedModifier, fatigueThreshold);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.overworld_reforged.hammer"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public List<BlockPos> getAdjacentBlocks(BlockPos pPos, Vec3 raypos) {
        List<BlockPos> lblocks = new ArrayList<BlockPos>();
        double bx = pPos.getX();
        double by = pPos.getY();
        double bz = pPos.getZ();
        if (((Math.abs(by - raypos.y) <= 0.001 ) || (Math.abs(by +1 - raypos.y) <= 0.001 )) && (raypos.x >= bx -0.01) && (raypos.x <= bx + 1 +0.01) && (raypos.z >= bz -0.01) && (raypos.z <= bz + 1 +0.01)){
            lblocks.add(pPos.offset(-1, 0, -1));
            lblocks.add(pPos.offset(-1, 0, 0));
            lblocks.add(pPos.offset(-1, 0, 1));
            lblocks.add(pPos.offset(0, 0, -1));
            lblocks.add(pPos.offset(0, 0, 1));
            lblocks.add(pPos.offset(1, 0, -1));
            lblocks.add(pPos.offset(1, 0, 0));
            lblocks.add(pPos.offset(1, 0, 1));
        }if (((Math.abs(bz - raypos.z) <= 0.001 ) || (Math.abs(bz +1 - raypos.z) <= 0.001 )) && (raypos.x >= bx -0.01) && (raypos.x <= bx + 1 +0.01) && (raypos.y >= by -0.01) && (raypos.y <= by + 1 +0.01)){
            lblocks.add(pPos.offset(-1, -1, 0));
            lblocks.add(pPos.offset(-1, 0, 0));
            lblocks.add(pPos.offset(-1, 1, 0));
            lblocks.add(pPos.offset(0, -1, 0));
            lblocks.add(pPos.offset(0, 1, 0));
            lblocks.add(pPos.offset(1, -1, 0));
            lblocks.add(pPos.offset(1, 0, 0));
            lblocks.add(pPos.offset(1, 1, 0));
        }if (((Math.abs(bx -raypos.x) <= 0.001 ) || (Math.abs(bx +1 -raypos.x) <= 0.001 )) && (raypos.z >= bz -0.01) && (raypos.z <= bz + 1 +0.01) && (raypos.y >= by -0.01) && (raypos.y <= by + 1 +0.01)){
            lblocks.add(pPos.offset(0, -1, -1));
            lblocks.add(pPos.offset(0, -1, 0));
            lblocks.add(pPos.offset(0, -1, 1));
            lblocks.add(pPos.offset(0, 0, -1));
            lblocks.add(pPos.offset(0, 0, 1));
            lblocks.add(pPos.offset(0, 1, -1));
            lblocks.add(pPos.offset(0, 1, 0));
            lblocks.add(pPos.offset(0, 1, 1));
        }
        return lblocks;
    }
}
