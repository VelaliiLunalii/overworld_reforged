package net.velalii.overworld_reforged.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.velalii.overworld_reforged.entity.ModEntities;
import net.velalii.overworld_reforged.entity.ai.DeerEatBlockGoal;
import net.velalii.overworld_reforged.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class DeerEntity extends Animal {
    private static final EntityDataAccessor<Boolean> EATING =
            SynchedEntityData.defineId(DeerEntity.class, EntityDataSerializers.BOOLEAN);
    public DeerEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState eatAnimationState = new AnimationState();
    private int eatAnimationTimeout = 0;
    public final AnimationState bowAnimationState = new AnimationState();
    public boolean isBowing;
    private Player player;
    private boolean hasSpedUp;
    private int panicTimeout;
    private static final EntityDataAccessor<Boolean> RUNNING = SynchedEntityData.defineId(DeerEntity.class, EntityDataSerializers.BOOLEAN);


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.SWEET_BERRIES), true));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.GLOW_BERRIES), true));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.APPLE), true));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1D));
        this.goalSelector.addGoal(6, new DeerEatBlockGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.2);
    }

    public void setEating(Boolean eating){
        this.entityData.set(EATING, eating);
    }

    public Boolean isEating(){
        return this.entityData.get(EATING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EATING, false);
        this.entityData.define(RUNNING, false);
    }

    public boolean isRunning() {
        return this.entityData.get(RUNNING);
    }

    public void setRunning(boolean running) {
        this.entityData.set(RUNNING, running);
    }

    public void setPanicTimeout(int panicTimeout){
        this.panicTimeout = panicTimeout;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("DeerRunning", this.isRunning());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setRunning(compound.getBoolean("DeerRunning"));
    }

    @Override
    public void tick() {
        super.tick();
        if(this.level().isClientSide()){
            setupAnimationStates();
        }
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        }else{
            --this.idleAnimationTimeout;
        }
        if (this.isEating() && eatAnimationTimeout <= 0){
            eatAnimationTimeout = 40;   //Length in tick of the animation
            eatAnimationState.start(this.tickCount);
        }else{
            --this.eatAnimationTimeout;
        }

        if(!this.isEating()){
            eatAnimationState.stop();
        }

        if(this.isBowing){
            bowAnimationState.start(this.tickCount);
            this.lookAt(player, 100, 100);
            this.isBowing = false;
        }

        if(panicTimeout > 0){
            panicTimeout--;
        }
        this.setRunning(panicTimeout > 0);
        if(isRunning() && !hasSpedUp){
            hasSpedUp = true;
            this.setSprinting(true);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.45F);
        }
        if(!isRunning() && hasSpedUp){
            hasSpedUp = false;
            this.setSprinting(false);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2F);
        }

    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6F, 1f);
        }else{
            f= 0f;
        }
        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        this.panicTimeout = 100;
        return super.hurt(pSource, pAmount);
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (itemstack.is(ModItems.OVERTHIUM_INGOT.get()) && !this.isBaby()) {       //OVELIA_OFFERING
            pPlayer.playSound(SoundEvents.AMETHYST_BLOCK_CHIME, 5.0F, 1.0F);
            this.player = pPlayer;
            this.isBowing = true;
            ItemStack itemstack1 = new ItemStack(ModItems.OVERTHIUM_HELMET.get());  //OVELIA_OFFERING
            pPlayer.setItemInHand(pHand, itemstack1);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    public static boolean canSpawn(EntityType<DeerEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType,
                                   BlockPos pos, RandomSource random){
        return Animal.checkAnimalSpawnRules(entityType, level, spawnType, pos, random);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.DEER.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.SWEET_BERRIES) || pStack.is(Items.GLOW_BERRIES) || pStack.is(Items.APPLE);
    }
}
