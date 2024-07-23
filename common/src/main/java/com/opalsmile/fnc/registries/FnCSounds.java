package com.opalsmile.fnc.registries;

import com.opalsmile.fnc.platform.FnCServices;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class FnCSounds {

    public static Supplier<SoundEvent> BOAR_HURT = FnCServices.REGISTRATION.registerSoundEvent("entity.boar.hurt");
    public static Supplier<SoundEvent> BOAR_AMBIENT = FnCServices.REGISTRATION.registerSoundEvent("entity.boar.ambient");
    public static Supplier<SoundEvent> BOAR_DEATH = FnCServices.REGISTRATION.registerSoundEvent("entity.boar.death");
    public static Supplier<SoundEvent> BOAR_ATTACK = FnCServices.REGISTRATION.registerSoundEvent("entity.boar.attack");
    public static Supplier<SoundEvent> BOAR_SADDLE = FnCServices.REGISTRATION.registerSoundEvent("entity.boar.saddle");
    public static Supplier<SoundEvent> BOAR_STEP = FnCServices.REGISTRATION.registerSoundEvent("entity.boar.step");

    public static Supplier<SoundEvent> JOCKEY_AMBIENT = FnCServices.REGISTRATION.registerSoundEvent("entity.jockey.ambient");
    public static Supplier<SoundEvent> JOCKEY_HURT = FnCServices.REGISTRATION.registerSoundEvent("entity.jockey.hurt");
    public static Supplier<SoundEvent> JOCKEY_DEATH = FnCServices.REGISTRATION.registerSoundEvent("entity.jockey.death");
    public static Supplier<SoundEvent> JOCKEY_ATTACK = FnCServices.REGISTRATION.registerSoundEvent("entity.jockey.attack");
    public static Supplier<SoundEvent> JOCKEY_YES = FnCServices.REGISTRATION.registerSoundEvent("entity.jockey.yes");
    public static Supplier<SoundEvent> JOCKEY_NO = FnCServices.REGISTRATION.registerSoundEvent("entity.jockey.no");

    public static Supplier<SoundEvent> JACKALOPE_HURT = FnCServices.REGISTRATION.registerSoundEvent("entity.jackalope.hurt");
    public static Supplier<SoundEvent> JACKALOPE_AMBIENT = FnCServices.REGISTRATION.registerSoundEvent("entity.jackalope.ambient");
    public static Supplier<SoundEvent> JACKALOPE_DEATH = FnCServices.REGISTRATION.registerSoundEvent("entity.jackalope.death");
    public static Supplier<SoundEvent> JACKALOPE_SADDLE = FnCServices.REGISTRATION.registerSoundEvent("entity.jackalope.saddle");
    public static Supplier<SoundEvent> JACKALOPE_STEP = FnCServices.REGISTRATION.registerSoundEvent("entity.jackalope.step");

    public static Supplier<SoundEvent> SABERTOOTH_AMBIENT = FnCServices.REGISTRATION.registerSoundEvent("entity.sabertooth.ambient");
    public static Supplier<SoundEvent> SABERTOOTH_HURT = FnCServices.REGISTRATION.registerSoundEvent("entity.sabertooth.hurt");
    public static Supplier<SoundEvent> SABERTOOTH_ATTACK = FnCServices.REGISTRATION.registerSoundEvent("entity.sabertooth.attack");
    public static Supplier<SoundEvent> SABERTOOTH_SADDLE = FnCServices.REGISTRATION.registerSoundEvent("entity.sabertooth.saddle");
    public static Supplier<SoundEvent> SABERTOOTH_DEATH = FnCServices.REGISTRATION.registerSoundEvent("entity.sabertooth.death");

    public static Supplier<SoundEvent> SPEAR_THROW = FnCServices.REGISTRATION.registerSoundEvent("entity.spear.throw");
    public static Supplier<SoundEvent> SPEAR_ATTACK = FnCServices.REGISTRATION.registerSoundEvent("entity.spear.attack");
    public static Supplier<SoundEvent> SPEAR_MISS = FnCServices.REGISTRATION.registerSoundEvent("entity.spear.miss");

    public static Supplier<SoundEvent> ANTLER_HEADDRESS_ATTACK_STRONG = FnCServices.REGISTRATION.registerSoundEvent(
            "entity.antler_headdress.attack_strong");
    public static Supplier<SoundEvent> ANTLER_HEADDRESS_CHARGE = FnCServices.REGISTRATION.registerSoundEvent("entity.antler_headdress.charge");
    public static Supplier<SoundEvent> ANTLER_HEADDRESS_FINISHED_CHARGING = FnCServices.REGISTRATION.registerSoundEvent(
            "entity.antler_headdress.finished_charging");

    public static Supplier<SoundEvent> ENTITY_DESADDLE = FnCServices.REGISTRATION.registerSoundEvent("entity.saddled.desaddle");

    public static Supplier<SoundEvent> DOWSING_ROD_LOCATES = FnCServices.REGISTRATION.registerSoundEvent("item.dowsing_rod.locates");

    public static void init(){

    }
}