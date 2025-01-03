package net.velalii.overworld_reforged.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TheEndGatewayBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.velalii.overworld_reforged.entity.ModEntities;
import net.velalii.overworld_reforged.particle.ModParticles;

import javax.annotation.Nullable;

public class OverthiumLaserProjectile extends ThrowableProjectile {
    private int life;
    ItemStack pStack;
    /*private double prevX;
    private double prevY;
    private double prevZ;*/
    public OverthiumLaserProjectile(EntityType<? extends ThrowableProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Override
    public boolean isNoGravity() {
        return true;
    }

    public OverthiumLaserProjectile(Level pLevel, Entity pShooter, ItemStack pStack, int life) {
        super(ModEntities.OVERTHIUM_LASER.get(), pLevel);
        this.life = life;
        this.pStack = pStack;

        Vec3 pos = pShooter.getEyePosition();
        this.setPos(pos.add(0, -0.2, 0));
        this.setOwner(pShooter);
    }

    public OverthiumLaserProjectile(Level pLevel, Entity pShooter, ItemStack pStack) {
        super(ModEntities.OVERTHIUM_LASER.get(), pLevel);
        this.pStack = pStack;
        this.life = 40;
        /*this.prevX = 0;
        this.prevY = 0;
        this.prevZ = 0;*/

        Vec3 pos = pShooter.getEyePosition();
        this.setPos(pos.add(0, -0.3, 0));
        this.setOwner(pShooter);
    }

    @Override
    public void tick() {
        super.tick();
        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        boolean flag = false;
        if (hitresult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockHitResult)hitresult).getBlockPos();
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.is(Blocks.NETHER_PORTAL)) {
                this.handleInsidePortal(blockpos);
                flag = true;
            } else if (blockstate.is(Blocks.END_GATEWAY)) {
                BlockEntity blockentity = this.level().getBlockEntity(blockpos);
                if (blockentity instanceof TheEndGatewayBlockEntity && TheEndGatewayBlockEntity.canEntityTeleport(this)) {
                    TheEndGatewayBlockEntity.teleportEntity(this.level(), blockpos, blockstate, this, (TheEndGatewayBlockEntity)blockentity);
                }

                flag = true;
            }
        }

        if (hitresult.getType() != HitResult.Type.MISS && !flag && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
            this.onHit(hitresult);
        }

        this.checkInsideBlocks();
        Vec3 vec3 = this.getDeltaMovement();
        double d2 = this.getX() + vec3.x;
        double d0 = this.getY() + vec3.y;
        double d1 = this.getZ() + vec3.z;
        this.updateRotation();
        if (this.isInWater()) {
            for(int i = 0; i < 4; ++i) {
                float f1 = 0.25F;
                this.level().addParticle(ParticleTypes.BUBBLE, d2 - vec3.x * 0.25D, d0 - vec3.y * 0.25D, d1 - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
            }
        }

        this.setDeltaMovement(vec3);

        this.setPos(d2, d0, d1);

        if(this.level().isClientSide){
            if(this.life == 40){

            }
            System.out.println(this.random);
            this.level().addParticle(ModParticles.OVERTHIUM_LASER.get(), this.getX(), this.getY(), this.getZ(), this.getXRot(), this.getYRot(), 0);
        }

        if(!this.level().isClientSide) {
            if (this.life <= 0) {
                this.discard();
            } else {
                this.life--;
            }
        }
    }

    public void shootFromRotation(Entity pShooter, float pX, float pY, float pZ, float pVelocity, float pInaccuracy) {
        super.shootFromRotation(pShooter, pX, pY, pZ, pVelocity, pInaccuracy);
    }

    @Override
    public void shoot(double pX, double pY, double pZ, float pVelocity, float pInaccuracy) {
        Vec3 vec3 = (new Vec3(pX, pY, pZ)).normalize().scale((double)pVelocity);
        this.setDeltaMovement(vec3);
        double d0 = vec3.horizontalDistance();
        this.setYRot((float)(Mth.atan2(vec3.x, vec3.z) * (double)(180F / (float)Math.PI)));
        this.setXRot((float)(Mth.atan2(vec3.y, d0) * (double)(180F / (float)Math.PI)));
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();
    }

    public void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        int i = 4;
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float)i);
        this.discard();
    }

    @Override
    public void onHitBlock(BlockHitResult pResult) {
        this.discard();
        super.onHitBlock(pResult);
        Level level = this.level();
        if (!level.isClientSide) {
            BlockPos pos = pResult.getBlockPos();
            if (pStack.isCorrectToolForDrops(level.getBlockState(pos))) {
                level.destroyBlock(pos, true, this);
            }
        }
    }

    public void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
        }
    }

    @Override
    protected void defineSynchedData() {
    }
}
