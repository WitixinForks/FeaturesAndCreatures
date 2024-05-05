package com.opalsmile.fnc.entity.goals;

import com.opalsmile.fnc.entity.RideableNeutralMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class NeutralMeleeAttackGoal extends MeleeAttackGoal {

    public NeutralMeleeAttackGoal(RideableNeutralMob neutralMob, double speedModifier, boolean followsIfNotSeen){
        super(neutralMob, speedModifier, followsIfNotSeen);
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity target, double distanceSquared){
        super.checkAndPerformAttack(target, distanceSquared);
        double attackReachSqr = this.getAttackReachSqr(target);
        if (distanceSquared <= (attackReachSqr + attackReachSqr)) {
            RideableNeutralMob neutralMob = ((RideableNeutralMob)this.mob);
            if (getTicksUntilNextAttack() < 2 && !neutralMob.isAttacking()) {
                neutralMob.setAttacking(true);
                neutralMob.triggerAnim("controller", "attack");
            }
            if (getTicksUntilNextAttack() <= 0 && neutralMob.isAttacking()) {
                neutralMob.setAttacking(false);
            }
        }
    }
}
