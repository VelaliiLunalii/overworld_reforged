package net.velalii.overworld_reforged.entity.ai;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.velalii.overworld_reforged.entity.custom.DeerEntity;

public class DeerEatBlockGoal extends EatBlockGoal {
    DeerEntity entity;
    public DeerEatBlockGoal(Mob pMob) {
        super(pMob);
        entity = ((DeerEntity) pMob);
    }

    @Override
    public void start() {
        entity.setEating(true);
        super.start();
    }

    @Override
    public void stop() {
        entity.setEating(false);
        super.stop();
    }
}
