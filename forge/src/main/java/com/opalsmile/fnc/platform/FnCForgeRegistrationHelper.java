package com.opalsmile.fnc.platform;

import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.FnCForge;
import com.opalsmile.fnc.platform.services.FnCIRegistrationHelper;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class FnCForgeRegistrationHelper implements FnCIRegistrationHelper {


    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        return FnCForge.BLOCKS.register(name, block);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        return FnCForge.ITEMS.register(name, item);
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String name, Supplier<T> creativeModeTab) {
        return FnCForge.TABS.register(name, creativeModeTab);
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntityType(String name, Supplier<EntityType<T>> builder) {
        return FnCForge.ENTITIES.register(name, builder);
    }

    @Override
    public Supplier<SoundEvent> registerSoundEvent(String name) {
        return FnCForge.SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(FnCConstants.resourceLocation(name)));
    }
}
