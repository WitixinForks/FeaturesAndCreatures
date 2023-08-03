package com.opalsmile.fnc.core;

import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.common.entity.Jackalope;
import com.opalsmile.fnc.common.entity.Jockey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import opalsmile.fnc.reg.RegistrationProvider;
import opalsmile.fnc.reg.RegistryObject;

public class FnCEntities {
    public static final RegistrationProvider<EntityType<?>> REGISTRAR = RegistrationProvider.get(Registries.ENTITY_TYPE, FnCConstants.MOD_ID);

    public static final RegistryObject<EntityType<Jockey>> JOCKEY = createEntity("jockey", EntityType.Builder.of(Jockey::new, MobCategory.CREATURE).sized(0.25f, 1f));
//    public static final RegistryObject<EntityType<Boar>> BOAR = createEntity("boar", EntityType.Builder.of(Boar::new, MobCategory.CREATURE).sized(0.9F, 0.9F));
    public static final RegistryObject<EntityType<Jackalope>> JACKALOPE = createEntity("jackalope", EntityType.Builder.of(Jackalope::new, MobCategory.CREATURE).sized(1F, 0.8F));
//    public static final RegistryObject<EntityType<Sabertooth>> SABERTOOTH = createEntity("sabertooth", EntityType.Builder.of(Sabertooth::new, MobCategory.CREATURE).sized(1.2F, 1.3F));
//    public static final RegistryObject<EntityType<BlackForestSpirit>> BLACK_FOREST_SPIRIT = createEntity("black_forest_spirit", EntityType.Builder.of(BlackForestSpirit::new, MobCategory.CREATURE).sized(0.7F, 2f));
//    public static final RegistryObject<EntityType<Gup>> GUP = createEntity("gup", EntityType.Builder.of(Gup::new, MobCategory.CREATURE).sized(2.625F, 2f));
//    public static final RegistryObject<EntityType<BrimstoneGolem>> BRIMSTONE_GOLEM = createEntity("brimstone_golem", EntityType.Builder.of(BrimstoneGolem::new, MobCategory.CREATURE).sized(2.6F, 4f));
//    public static final RegistryObject<EntityType<ShulkrenYoungling>> SHULKREN_YOUNGLING = createEntity("shulkren_youngling", EntityType.Builder.of(ShulkrenYoungling::new, MobCategory.CREATURE).sized(0.8F, 1.65f));
//    public static final RegistryObject<EntityType<BFSAttack>> BFS_ATTACK = createEntity("bfs_attack", EntityType.Builder.<BFSAttack>of((p_37391_, p_37392_) -> new BFSAttack(p_37392_), MobCategory.MISC).sized(0.4F, 0.4f));
//    public static final RegistryObject<EntityType<Tbh>> TBH = createEntity("tbh", EntityType.Builder.of(Tbh::new, MobCategory.CREATURE).sized(0.4F, 0.6f));
//
//    public static final RegistryObject<EntityType<Spear>> SPEAR = createEntity("spear", EntityType.Builder.<Spear>of(Spear::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20));

    private static <T extends Entity> RegistryObject<EntityType<T>> createEntity(String name, EntityType.Builder<T> builder) {
        return REGISTRAR.register(name, () -> builder.build(name));
    }

//    public static void registerSpawnPlacements() {
//        SpawnPlacementsAccess.fnc_register(FnCEntities.BLACK_FOREST_SPIRIT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BlackForestSpirit::checkSpawnRules);
//        SpawnPlacementsAccess.fnc_register(FnCEntities.SHULKREN_YOUNGLING.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ShulkrenYoungling::checkSpawnRules);
//        SpawnPlacementsAccess.fnc_register(FnCEntities.BRIMSTONE_GOLEM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BrimstoneGolem::checkSpawnRules);
//        SpawnPlacementsAccess.fnc_register(FnCEntities.GUP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Gup::checkSpawnRules);
//        SpawnPlacementsAccess.fnc_register(FnCEntities.TBH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Tbh::checkSpawnRules);
//    }

    public static void init() {
    }
}

