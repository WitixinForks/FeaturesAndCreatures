package com.opalsmile.fnc.client.renderer;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.client.DowsingRodHandRenderer;
import com.opalsmile.fnc.item.SpearItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.DefaultedGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SpearItemRenderer extends GeoItemRenderer<SpearItem> {

    public static final ModelResourceLocation SPEAR_MODEL = new ModelResourceLocation(FnCConstants.MOD_ID, "spear", "inventory");

    public SpearItemRenderer(){
        super(new DefaultedGeoModel<>(FnCConstants.resourceLocation("spear")) {
            @Override
            protected String subtype() {
                return "entity";
            }
        });
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack,
                             MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        this.animatable = (SpearItem) stack.getItem();
        this.currentItemStack = stack;
        this.renderPerspective = transformType;

        if (transformType == ItemDisplayContext.GUI || transformType == ItemDisplayContext.GROUND) {
            renderInGui(transformType, poseStack, bufferSource, packedLight, packedOverlay);
        }
        else {
            RenderType renderType = getRenderType(this.animatable, getTextureLocation(this.animatable), bufferSource, Minecraft.getInstance().getFrameTime());
            VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, false, this.currentItemStack != null && this.currentItemStack.hasFoil());

            defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer,
                    0, Minecraft.getInstance().getFrameTime(), packedLight);
        }
    }

    @Override
    protected void renderInGui(ItemDisplayContext transformType, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay){

        MultiBufferSource.BufferSource defaultBufferSource = bufferSource instanceof MultiBufferSource.BufferSource bufferSource2 ?
                bufferSource2 : Minecraft.getInstance().levelRenderer.renderBuffers.bufferSource();

        RenderType renderType = getRenderType(this.animatable, getTextureLocation(this.animatable), defaultBufferSource, Minecraft.getInstance().getFrameTime());
        VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, true, this.currentItemStack != null && this.currentItemStack.hasFoil());

        poseStack.pushPose();

        if (this.useEntityGuiLighting) {
            Lighting.setupForEntityInInventory();
        }
        else {
            Lighting.setupForFlatItems();
        }
        BakedModel spearModel = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getModelManager().getModel(
                SPEAR_MODEL);
        Minecraft.getInstance().getItemRenderer().render(currentItemStack, transformType, false, poseStack, bufferSource, packedLight, packedOverlay, spearModel);
        defaultBufferSource.endBatch();
        RenderSystem.enableDepthTest();
        Lighting.setupFor3DItems();
        poseStack.popPose();
    }

    @Override
    public void scaleModelForRender(float widthScale, float heightScale, PoseStack poseStack, SpearItem animatable, BakedGeoModel model, boolean isReRender, float partialTick, int packedLight, int packedOverlay){
        super.scaleModelForRender(widthScale, heightScale, poseStack, animatable, model, isReRender, partialTick,
                packedLight, packedOverlay);
        if (!isReRender) {
            if(renderPerspective.firstPerson()) {

                poseStack.translate(0.0f, -1.25f, 0.0f);
            }
            else if (renderPerspective == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || renderPerspective == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
                poseStack.mulPose(Axis.ZN.rotationDegrees(45));
                poseStack.translate(-0.5f, -1f, 0.0f);
            }
        }
    }
}
