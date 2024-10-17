package net.wyannnnn.firefreeze.events;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.wyannnnn.firefreeze.events.OnChatReceived.ttFreeze;

public class OnWorldRender {

    @SubscribeEvent
    public static void onWorldRender(RenderWorldLastEvent event) {
        if(ttFreeze!=null){
            if(System.currentTimeMillis()<ttFreeze){

            }
        }
    }
}
