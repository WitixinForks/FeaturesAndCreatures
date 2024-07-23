package com.opalsmile.fnc.registries;

import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.platform.FnCServices;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class FnCBlocks {

//    public final BlockRegistryObject<Block> STONE_DAWN_ORE = createBlock("stone_dawn_ore", createOre(FeaturesCreaturesOre.Duration.DAWN));
//    public final BlockRegistryObject<Block> STONE_SUNSET_ORE = createBlock("stone_sunset_ore", createOre(FeaturesCreaturesOre.Duration.SUNSET));
//    public final BlockRegistryObject<Block> STONE_MIDNIGHT_ORE = createBlock("stone_midnight_ore", createOre(FeaturesCreaturesOre.Duration.MIDNIGHT));
//
//    public final BlockRegistryObject<Block> DAWN_ORE = createBlock("dawn_ore", createOre(FeaturesCreaturesOre.Duration.DAWN));
//    public final BlockRegistryObject<Block> SUNSET_ORE = createBlock("sunset_ore", createOre(FeaturesCreaturesOre.Duration.SUNSET));
//    public final BlockRegistryObject<Block> MIDNIGHT_ORE = createBlock("midnight_ore", createOre(FeaturesCreaturesOre.Duration.MIDNIGHT));
//
//    public final BlockRegistryObject<Block> DEEPSLATE_DAWN_ORE = createBlock("deepslate_dawn_ore", createOre(FeaturesCreaturesOre.Duration.DAWN));
//    public final BlockRegistryObject<Block> DEEPSLATE_SUNSET_ORE = createBlock("deepslate_sunset_ore", createOre(FeaturesCreaturesOre.Duration.SUNSET));
//    public final BlockRegistryObject<Block> DEEPSLATE_MIDNIGHT_ORE = createBlock("deepslate_midnight_ore", createOre(FeaturesCreaturesOre.Duration.MIDNIGHT));

    public static final Supplier<Block> DAWN_BLOCK = FnCServices.REGISTRATION.registerBlock("dawn_block", FnCBlocks::createBlock);
    public static final Supplier<Block> SUNSET_BLOCK = FnCServices.REGISTRATION.registerBlock("sunset_block", FnCBlocks::createBlock);
    public static final Supplier<Block> MIDNIGHT_BLOCK = FnCServices.REGISTRATION.registerBlock("midnight_block", FnCBlocks::createBlock);

    private static Block createBlock(){
        return new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK));
    }

    public static void init(){
    }
}
