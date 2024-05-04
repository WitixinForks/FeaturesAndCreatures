package com.opalsmile.fnc.mixin.client.spear;

import com.opalsmile.fnc.client.DowsingRodHandRenderer;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelBakery.class)
public abstract class MixinSpearInHand {

    @Inject(method = "Lnet/minecraft/client/resources/model/ModelBakery;<init>(Lnet/minecraft/client/color/block/BlockColors;Lnet/minecraft/util/profiling/ProfilerFiller;Ljava/util/Map;Ljava/util/Map;)V",
    at = @At(value = "RETURN"), cancellable = false)
    void featuresandcreatures_loadSpearHandModel(BlockColors blockColors, ProfilerFiller profilerFiller, Map<ResourceLocation, BlockModel> blockModelMap, Map<ResourceLocation, List<ModelBakery.LoadedJson>> loadedJsons, CallbackInfo callbackInfo) {
        profilerFiller.push("featuresandcreatures");
        this.loadTopLevel(DowsingRodHandRenderer.SPEAR_IN_HAND_MODEL);
        profilerFiller.pop();
    }

    @Shadow
    abstract void loadTopLevel(ModelResourceLocation location);
}
