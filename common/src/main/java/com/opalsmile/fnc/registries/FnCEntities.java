package com.opalsmile.fnc.registries;

import com.opalsmile.fnc.entity.*;
import com.opalsmile.fnc.platform.FnCServices;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class FnCEntities {
    public static final Supplier<EntityType<Jockey>> JOCKEY = FnCServices.REGISTRATION.registerEntityType("jockey",
            () -> EntityType.Builder.of(Jockey::new, MobCategory.CREATURE).sized(0.25f, 1f).build("jockey"));
    public static final Supplier<EntityType<Boar>> BOAR = FnCServices.REGISTRATION.registerEntityType("boar",
            () -> EntityType.Builder.of(Boar::new, MobCategory.CREATURE).sized(0.9F, 0.9F).build("boar"));
    public static final Supplier<EntityType<Jackalope>> JACKALOPE = FnCServices.REGISTRATION.registerEntityType("jackalope",
            () -> EntityType.Builder.of(Jackalope::new, MobCategory.CREATURE).sized(1F, 0.8F).build("jackalope"));
    public static final Supplier<EntityType<Sabertooth>> SABERTOOTH = FnCServices.REGISTRATION.registerEntityType("sabertooth",
            () -> EntityType.Builder.of(Sabertooth::new, MobCategory.CREATURE).sized(1.2F, 1.3F).build("sabertooth"));
    public static final Supplier<EntityType<Spear>> SPEAR = FnCServices.REGISTRATION.registerEntityType("spear",
            () -> EntityType.Builder.<Spear>of(Spear::new, MobCategory.MISC).sized(0.5F, 1.0F).clientTrackingRange(4).updateInterval(20).build("spear"));

    //public static final Supplier<EntityType<BlackForestSpirit>> BLACK_FOREST_SPIRIT = FnCServices.REGISTRATION.registerEntityType
    // ("black_forest_spirit", EntityType.Builder.of(BlackForestSpirit::new, MobCategory.CREATURE).sized(0.7F, 2f));
    //    public static final Supplier<EntityType<Gup>> GUP = FnCServices.REGISTRATION.registerEntityType("gup", EntityType.Builder.of
    //    (Gup::new, MobCategory.CREATURE).sized(2.625F, 2f));
    //    public static final Supplier<EntityType<BrimstoneGolem>> BRIMSTONE_GOLEM = FnCServices.REGISTRATION.registerEntityType
    //    ("brimstone_golem", EntityType.Builder.of(BrimstoneGolem::new, MobCategory.CREATURE).sized(2.6F, 4f));
    //    public static final Supplier<EntityType<ShulkrenYoungling>> SHULKREN_YOUNGLING = FnCServices.REGISTRATION.registerEntityType
    //    ("shulkren_youngling", EntityType.Builder.of(ShulkrenYoungling::new, MobCategory.CREATURE).sized(0.8F, 1.65f));
    //    public static final Supplier<EntityType<BFSAttack>> BFS_ATTACK = FnCServices.REGISTRATION.registerEntityType("bfs_attack",
    //    EntityType.Builder.<BFSAttack>of((p_37391_, p_37392_) -> new BFSAttack(p_37392_), MobCategory.MISC).sized(0.4F, 0.4f));
    //    public static final Supplier<EntityType<Tbh>> TBH = FnCServices.REGISTRATION.registerEntityType("tbh", EntityType.Builder.of
    //    (Tbh::new, MobCategory.CREATURE).sized(0.4F, 0.6f));
    //
    //    public static void registerSpawnPlacements() {
    //        SpawnPlacementsAccess.fnc_register(FnCEntities.BLACK_FOREST_SPIRIT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types
    //        .MOTION_BLOCKING_NO_LEAVES, BlackForestSpirit::checkSpawnRules);
    //        SpawnPlacementsAccess.fnc_register(FnCEntities.SHULKREN_YOUNGLING.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types
    //        .MOTION_BLOCKING_NO_LEAVES, ShulkrenYoungling::checkSpawnRules);
    //        SpawnPlacementsAccess.fnc_register(FnCEntities.BRIMSTONE_GOLEM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types
    //        .MOTION_BLOCKING_NO_LEAVES, BrimstoneGolem::checkSpawnRules);
    //        SpawnPlacementsAccess.fnc_register(FnCEntities.GUP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types
    //        .MOTION_BLOCKING_NO_LEAVES, Gup::checkSpawnRules);
    //        SpawnPlacementsAccess.fnc_register(FnCEntities.TBH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types
    //        .MOTION_BLOCKING_NO_LEAVES, Tbh::checkSpawnRules);
    //    }

    public static void init() {
    }
}

