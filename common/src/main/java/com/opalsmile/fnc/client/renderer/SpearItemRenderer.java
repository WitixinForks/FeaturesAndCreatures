package com.opalsmile.fnc.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.opalsmile.fnc.FnCConstants;
import com.opalsmile.fnc.item.SpearItem;
import net.minecraft.world.item.ItemDisplayContext;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.DefaultedGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SpearItemRenderer extends GeoItemRenderer<SpearItem> {

    public SpearItemRenderer(){
        super(new DefaultedGeoModel<>(FnCConstants.resourceLocation("spear")) {
            @Override
            protected String subtype() {
                return "entity";
            }
        });
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
