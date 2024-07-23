package com.opalsmile.fnc.platform.services;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface FnCIRegistrationHelper {

    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block);

    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item);

    <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String name, Supplier<T> creativeModeTab);

    <T extends Entity> Supplier<EntityType<T>> registerEntityType(String name, Supplier<EntityType<T>> builder);

    Supplier<SoundEvent> registerSoundEvent(String name);
}
