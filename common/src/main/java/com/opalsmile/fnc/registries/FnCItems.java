package com.opalsmile.fnc.registries;

import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.item.SpearItem;
import com.opalsmile.fnc.platform.FnCServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class FnCItems {

    public static final Supplier<Item> ANTLER = FnCServices.REGISTRATION.registerItem("antler", FnCItems::createItem);
    public static final Supplier<Item> SABERTOOTH_FANG = FnCServices.REGISTRATION.registerItem("sabertooth_fang", FnCItems::createItem);

    // Armor, Weapons, and Tools //TODO FIX
    public static final Supplier<? extends ArmorItem> ANTLER_HEADDRESS = FnCServices.PLATFORM.getAntlerHeaddress();
    public static final Supplier<? extends SpearItem> SPEAR = FnCServices.PLATFORM.getSpear();
    //public static final Supplier<? extends ArmorItem> LUNAR_HEADDRESS = REGISTER.register("lunar_headdress", () -> PlatformItemHandler.INSTANCE.getLunarHeaddressItem(FnCArmorMaterial.LUNAR, EquipmentSlot.HEAD, createProperties()));


    public static final Supplier<Item> THROWAWAY_JOKE = FnCServices.REGISTRATION.registerItem("throwaway", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DOWSING_ROD = FnCServices.REGISTRATION.registerItem("dowsing_rod", () -> new Item(new Item.Properties().stacksTo(1)));
    //dawn spear goes here
    //dawn dowser goes here
    //sunset dowser goes here
    //midnight dowser goes here

    //Blocks
    public static final Supplier<Item> DAWN_BLOCK = FnCServices.REGISTRATION.registerItem("dawn_block",
            () -> createBlockItem(FnCBlocks.DAWN_BLOCK));
    public static final Supplier<Item> SUNSET_BLOCK = FnCServices.REGISTRATION.registerItem("sunset_block",
            () -> createBlockItem(FnCBlocks.SUNSET_BLOCK));
    public static final Supplier<Item> MIDNIGHT_BLOCK = FnCServices.REGISTRATION.registerItem("midnight_block",
            () -> createBlockItem(FnCBlocks.MIDNIGHT_BLOCK));
    //public static final Supplier<Item> SUNSET_ORE = REGISTER.register("sunset_ore", createBlockItem(FeaturesCreaturesBlocks.SUNSET_ORE));
    //public static final Supplier<Item> STONE_SUNSET_ORE = REGISTER.register("stone_sunset_ore", createBlockItem(FeaturesCreaturesBlocks.STONE_SUNSET_ORE));
    //public static final Supplier<Item> DEEPSLATE_SUNSET_ORE = REGISTER.register("deepslate_sunset_ore", createBlockItem(FeaturesCreaturesBlocks.DEEPSLATE_SUNSET_ORE));
    //public static final Supplier<Item> MIDNIGHT_ORE = REGISTER.register("midnight_ore", createBlockItem(FeaturesCreaturesBlocks.MIDNIGHT_ORE));
    //public static final Supplier<Item> STONE_MIDNIGHT_ORE = REGISTER.register("stone_midnight_ore", createBlockItem(FeaturesCreaturesBlocks.STONE_MIDNIGHT_ORE));
    //public static final Supplier<Item> DEEPSLATE_MIDNIGHT_ORE = REGISTER.register("deepslate_midnight_ore", createBlockItem(FeaturesCreaturesBlocks.DEEPSLATE_MIDNIGHT_ORE));

    //public static final Supplier<Item> DAWN_ORE = REGISTER.register("dawn_ore", createBlockItem(FeaturesCreaturesBlocks.DAWN_ORE));
    //public static final Supplier<Item> STONE_DAWN_ORE = REGISTER.register("stone_dawn_ore", createBlockItem(FeaturesCreaturesBlocks.STONE_DAWN_ORE));
    //public static final Supplier<Item> DEEPSLATE_DAWN_ORE = REGISTER.register("deepslate_dawn_ore", createBlockItem(FeaturesCreaturesBlocks.DEEPSLATE_DAWN_ORE));

    // Misc.
    public static final Supplier<Item> DAWN_CRYSTAL = FnCServices.REGISTRATION.registerItem("dawn_crystal", FnCItems::createItem);
    public static final Supplier<Item> SUNSET_CRYSTAL = FnCServices.REGISTRATION.registerItem("sunset_crystal", FnCItems::createItem);
    public static final Supplier<Item> MIDNIGHT_CRYSTAL = FnCServices.REGISTRATION.registerItem("midnight_crystal", FnCItems::createItem);
    //tinted potion goes here

    // Hidden
    public static final Supplier<Item> MEGA_POTION = FnCServices.REGISTRATION.registerItem("mega_potion",
            () -> new Item(new Item.Properties()));
    //public static final Supplier<Item> BFS_ATTACK_ITEM = FnCServices.REGISTRATION.registerItem("bfs_attack_item",
            //() -> new Item(new Item.Properties()));


    private static Item createItem(){
        return new Item(new Item.Properties());
    }

    private static Item createBlockItem(Supplier<Block> block){
        return new BlockItem(block.get(), new Item.Properties());
    }

    public static final Supplier<CreativeModeTab> TAB = FnCServices.REGISTRATION.registerCreativeModeTab("creative_tab", () ->
            CreativeModeTab
                    .builder(null, -1)
                    .icon(() -> MEGA_POTION.get().getDefaultInstance())
                    .title(Component.translatable("creativetab." + FnCConstants.MOD_ID))
                    .displayItems((parameters, output) -> {
                        output.accept(MIDNIGHT_CRYSTAL.get());
                        output.accept(MIDNIGHT_BLOCK.get());
                        output.accept(SUNSET_CRYSTAL.get());
                        output.accept(SUNSET_BLOCK.get());
                        output.accept(DAWN_CRYSTAL.get());
                        output.accept(DAWN_BLOCK.get());
                        output.accept(SABERTOOTH_FANG.get());
                        output.accept(ANTLER.get());
                        output.accept(SPEAR.get());
                        output.accept(DOWSING_ROD.get());
                        output.accept(BuiltInRegistries.ITEM.get(FnCConstants.resourceLocation("boar_spawn_egg")));
                        output.accept(BuiltInRegistries.ITEM.get(FnCConstants.resourceLocation("jockey_spawn_egg")));
                        output.accept(BuiltInRegistries.ITEM.get(FnCConstants.resourceLocation("sabertooth_spawn_egg")));
                        output.accept(BuiltInRegistries.ITEM.get(FnCConstants.resourceLocation("jackalope_spawn_egg")));
                        output.accept(ANTLER_HEADDRESS.get());

                    })
                    .build());


    public static void init(){
    }
}
