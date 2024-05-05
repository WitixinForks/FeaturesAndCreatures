package com.opalsmile.fnc.entity;

import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.registries.FnCEntities;
import com.opalsmile.fnc.registries.FnCSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class Boar extends RideableNeutralMob {

    public static final TagKey<Item> BOAR_FOOD = TagKey.create(Registries.ITEM, FnCConstants.resourceLocation("boar_food"));

    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.boar.walk");
    public static final RawAnimation ATTACK = RawAnimation.begin().then("animation.boar.attack", Animation.LoopType.PLAY_ONCE);

    public Boar(EntityType<? extends RideableMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 11.0D).add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.ATTACK_DAMAGE, 8);
    }

    @Override
    public TagKey<Item> getFoodTag(){
        return BOAR_FOOD;
    }

    @Override
    public SoundEvent getSaddleSound(){
        return FnCSounds.BOAR_SADDLE.get();
    }

    @Override
    int getTimeToAttack(){
        return 2;
    }

    @Override
    public boolean isPlayerRideable() {
        return true;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return FnCEntities.BOAR.get().create(serverLevel);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar){
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate)
                .triggerableAnim("attack", ATTACK));
    }

    private PlayState predicate(final AnimationState<Boar> event){
        if (ATTACK.equals(event.getController().getCurrentRawAnimation())) return PlayState.STOP;
        if (event.isMoving()) return event.setAndContinue(WALK);
        return PlayState.STOP;
    }


}
