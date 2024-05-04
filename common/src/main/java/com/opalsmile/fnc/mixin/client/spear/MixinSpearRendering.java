package com.opalsmile.fnc.mixin.client.spear;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.mojang.blaze3d.vertex.PoseStack;
import com.opalsmile.fnc.client.DowsingRodHandRenderer;
import com.opalsmile.fnc.registries.FnCItems;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(ItemRenderer.class)
@Debug(export = true, print = true)
public abstract class MixinSpearRendering {

    @Inject(method = "Lnet/minecraft/client/renderer/entity/ItemRenderer;render(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/model/ItemTransform;apply(ZLcom/mojang/blaze3d/vertex/PoseStack;)V", shift = At.Shift.BEFORE))
    void featuresandcreatures_swapModel(ItemStack itemStack, ItemDisplayContext context, boolean bool, PoseStack poseStack, MultiBufferSource multiBufferSource, int a, int b, BakedModel original, CallbackInfo callbackInfo, @Local LocalRef<BakedModel> bakedModel) {
        if(itemStack.is(FnCItems.SPEAR.get())) {
            bakedModel.set(this.itemModelShaper.getModelManager().getModel(DowsingRodHandRenderer.SPEAR_MODEL));
        }
    }

    @Inject(method = "Lnet/minecraft/client/renderer/entity/ItemRenderer;getModel(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;I)Lnet/minecraft/client/resources/model/BakedModel;",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/BakedModel;getOverrides()Lnet/minecraft/client/renderer/block/model/ItemOverrides;", shift = At.Shift.BEFORE))
    void featuresandcreatures_returnProperModel(ItemStack $$0, @Nullable Level $$1, @Nullable LivingEntity $$2, int $$3, CallbackInfoReturnable callbackInfo, @Local LocalRef<BakedModel> bakedModel) {
        if ($$0.is(FnCItems.SPEAR.get())) {
            bakedModel.set(this.itemModelShaper.getModelManager().getModel(DowsingRodHandRenderer.SPEAR_MODEL));
        }
    }

    @ModifyExpressionValue(
            method = "Lnet/minecraft/client/renderer/entity/ItemRenderer;render(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z", ordinal = 2)
    )
    private boolean isSpearOrTrident(boolean original, ItemStack target) {
        return original || target.is(FnCItems.SPEAR.get());
    }

    @Shadow
    ItemModelShaper itemModelShaper;
}
