package net.velalii.overworld_reforged.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MalletItem extends MultiblockPickaxe{
    int range;
    public MalletItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties,
                      int range, Float instancedSpeedModifier, int fatigueThreshold) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties, instancedSpeedModifier, fatigueThreshold);
        this.range = range;
    }

    public List<BlockPos> ListIteration(Vec3i boffset, List<BlockPos> lblocks, BlockPos pPos, int iter){
        for (int i = 0; i<iter; i++){
            lblocks.add(pPos.offset(boffset));
            pPos = pPos.offset(boffset);
        }
        return lblocks;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.overworld_reforged.mallet.start").append(String.valueOf(range + 1)).append(Component.translatable("tooltip.overworld_reforged.mallet.end")));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public List<BlockPos> getAdjacentBlocks(BlockPos pPos, Vec3 raypos) {
        List<BlockPos> lblocks = new ArrayList<BlockPos>();
        double bx = pPos.getX();
        double by = pPos.getY();
        double bz = pPos.getZ();
        if ((Math.abs(by - raypos.y) <= 0.001 ) && (raypos.x >= bx -0.01) && (raypos.x <= bx + 1 +0.01) && (raypos.z >= bz -0.01) && (raypos.z <= bz + 1 +0.01)){
            lblocks = ListIteration(new Vec3i(0, 1, 0), lblocks, pPos, range);
        }if ((Math.abs(by +1 - raypos.y) <= 0.001 ) && (raypos.x >= bx -0.01) && (raypos.x <= bx + 1 +0.01) && (raypos.z >= bz -0.01) && (raypos.z <= bz + 1 +0.01)){
            lblocks = ListIteration(new Vec3i(0, -1, 0), lblocks, pPos, range);
        }if ((Math.abs(bz - raypos.z) <= 0.001 ) && (raypos.x >= bx -0.01) && (raypos.x <= bx + 1 +0.01) && (raypos.y >= by -0.01) && (raypos.y <= by + 1 +0.01)){
            lblocks = ListIteration(new Vec3i(0, 0, 1), lblocks, pPos, range);
        }if ((Math.abs(bz +1 - raypos.z) <= 0.001 ) && (raypos.x >= bx -0.01) && (raypos.x <= bx + 1 +0.01) && (raypos.y >= by -0.01) && (raypos.y <= by + 1 +0.01)){
            lblocks = ListIteration(new Vec3i(0, 0, -1), lblocks, pPos, range);
        }if ((Math.abs(bx -raypos.x) <= 0.001 ) && (raypos.z >= bz -0.01) && (raypos.z <= bz + 1 +0.01) && (raypos.y >= by -0.01) && (raypos.y <= by + 1 +0.01)){
            lblocks = ListIteration(new Vec3i(1, 0, 0), lblocks, pPos, range);
        }if ((Math.abs(bx +1 -raypos.x) <= 0.001 ) && (raypos.z >= bz -0.01) && (raypos.z <= bz + 1 +0.01) && (raypos.y >= by -0.01) && (raypos.y <= by + 1 +0.01)){
            lblocks = ListIteration(new Vec3i(-1, 0, 0), lblocks, pPos, range);
        }
        return lblocks;
    }
}
