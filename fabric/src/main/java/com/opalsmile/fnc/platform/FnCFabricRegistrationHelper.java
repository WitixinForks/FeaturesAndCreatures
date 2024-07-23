package com.opalsmile.fnc.platform;

import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.platform.services.FnCIRegistrationHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class FnCFabricRegistrationHelper implements FnCIRegistrationHelper {

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        T registeredBlock = Registry.register(BuiltInRegistries.BLOCK, FnCConstants.resourceLocation(name), block.get());;
        return () -> registeredBlock;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        T registeredItem = Registry.register(BuiltInRegistries.ITEM, FnCConstants.resourceLocation(name), item.get());
        return () -> registeredItem;
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String name, Supplier<T> creativeModeTab) {
        T tab = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, FnCConstants.resourceLocation(name), creativeModeTab.get());
        return () -> tab;
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntityType(String name, Supplier<EntityType<T>> entityType) {
        EntityType<T> type = Registry.register(BuiltInRegistries.ENTITY_TYPE, FnCConstants.resourceLocation(name), entityType.get());
        return () -> type;
    }

    @Override
    public Supplier<SoundEvent> registerSoundEvent(String name) {
        SoundEvent event = Registry.register(BuiltInRegistries.SOUND_EVENT, FnCConstants.resourceLocation(name),
                SoundEvent.createVariableRangeEvent(FnCConstants.resourceLocation(name)));
        return () -> event;
    }
}
