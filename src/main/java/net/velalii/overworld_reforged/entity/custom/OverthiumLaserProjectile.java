package net.velalii.overworld_reforged.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TheEndGatewayBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.velalii.overworld_reforged.entity.ModEntities;
import net.velalii.overworld_reforged.particle.ModParticles;

public class OverthiumLaserProjectile extends ThrowableProjectile {
    private int life;

    public OverthiumLaserProjectile(EntityType<? extends ThrowableProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public OverthiumLaserProjectile(Level pLevel, Entity pShooter, ItemStack pStack, int life) {
        super(ModEntities.OVERTHIUM_LASER.get(), pLevel);
        this.life = life;

        Vec3 pos = pShooter.getEyePosition();
        this.setPos(pos.add(0, -0.2, 0));
        this.setOwner(pShooter);
    }

    public OverthiumLaserProjectile(Level pLevel, Entity pShooter, ItemStack pStack) {
        super(ModEntities.OVERTHIUM_LASER.get(), pLevel);
        this.life = 40;

        Vec3 pos = pShooter.getEyePosition();
        this.setPos(pos.add(0, -0.3, 0));
        this.setOwner(pShooter);
    }

    @Override
    public void tick() {
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

        if(this.life ==40){
            this.level().playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.NEUTRAL, 5F, this.level().getRandom().nextFloat() * 0.4F + 0.8F);
        }

        if(this.level().isClientSide){
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

    public void onDiscard(){
        this.level().playSound((Player) null, this.getX(), this.getY(), this.getZ(), SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.NEUTRAL, 5F, this.level().getRandom().nextFloat() * 0.4F + 0.8F);
        if(this.level().isClientSide) {
            this.level().addParticle(ModParticles.OVERTHIUM_EXPLOSION.get(), this.getX(), this.getY(), this.getZ(), this.getXRot(), this.getYRot(), 0);
        }
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    public void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        int i = 4;
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float) i);
    }

    @Override
    public void onHitBlock(BlockHitResult pResult) {
        Level level = this.level();
        if (!level.isClientSide && this.getOwner() instanceof Player) {
            BlockPos pos = pResult.getBlockPos();
            ItemStack stack = ((Player) this.getOwner()).getItemInHand(InteractionHand.MAIN_HAND);
            if (stack.isCorrectToolForDrops(level.getBlockState(pos))) {
                level.destroyBlock(pos, true, this);
            }
        }
        super.onHitBlock(pResult);
    }

    public void onHit(HitResult pResult) {
        this.onDiscard();
        if (!this.level().isClientSide) {
            this.discard();
            this.level().broadcastEntityEvent(this, (byte) 3);
        }
        super.onHit(pResult);
    }

    @Override
    protected void defineSynchedData() {
    }
}
