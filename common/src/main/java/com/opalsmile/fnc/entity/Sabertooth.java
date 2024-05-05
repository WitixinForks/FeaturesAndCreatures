package com.opalsmile.fnc.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

public class Sabertooth extends RideableNeutralMob {

    private static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.sabertooth.walk");
    private static final RawAnimation ATTACK = RawAnimation.begin().then("animation.sabertooth.attack", Animation.LoopType.PLAY_ONCE);

    public Sabertooth(EntityType<? extends RideableMob> entityType, Level level){
        super(entityType, level);
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Fox.class, 10, true, true, fox -> ((Fox)fox).getVariant() == Fox.Type.SNOW));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Sheep.class, 10, true, true, null));
    }

    @Override
    TagKey<Item> getFoodTag(){
        return ItemTags.FISHES;
    }

    @Override
    SoundEvent getSaddleSound(){
        return SoundEvents.HORSE_SADDLE;
    }

    @Override
    int getTimeToAttack(){
        return 4;
    }

    @Override
    public boolean isPlayerRideable() {
        return false;
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 12.0D).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.ATTACK_DAMAGE, 4);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar){
        controllerRegistrar.add(new AnimationController<>(this, "controller",20, state -> {
            if(state.isMoving()) {
                return state.setAndContinue(WALK);
            }
            return PlayState.STOP;
        }).triggerableAnim("attack", ATTACK));
    }
}
