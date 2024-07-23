package com.opalsmile.fnc.mixin.client.spear;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.opalsmile.fnc.registries.FnCItems;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemRenderer.class)
public abstract class MixinSpearRendering {

    @ModifyExpressionValue(method = "Lnet/minecraft/client/renderer/entity/ItemRenderer;render(Lnet/minecraft/world/item/ItemStack;" +
            "Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;" +
            "Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V", at = @At(value =
            "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z", ordinal = 2))
    private boolean isSpearOrTrident(boolean original, ItemStack target) {
        return original || target.is(FnCItems.SPEAR.get());
    }

}
