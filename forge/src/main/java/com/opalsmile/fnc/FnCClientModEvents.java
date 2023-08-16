package com.opalsmile.fnc;

import com.opalsmile.fnc.client.renderer.BoarRenderer;
import com.opalsmile.fnc.client.renderer.JackalopeRenderer;
import com.opalsmile.fnc.client.renderer.JockeyRenderer;
import com.opalsmile.fnc.client.renderer.SpearRenderer;
import com.opalsmile.fnc.registries.FnCEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = FnCConstants.MOD_ID)
public class FnCClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(FnCEntities.JACKALOPE.get(), JackalopeRenderer::new);
        event.registerEntityRenderer(FnCEntities.JOCKEY.get(), JockeyRenderer::new);
        event.registerEntityRenderer(FnCEntities.SPEAR.get(), SpearRenderer::new);
        event.registerEntityRenderer(FnCEntities.BOAR.get(), BoarRenderer::new);
    }
}
