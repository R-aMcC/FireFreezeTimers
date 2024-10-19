package net.wyannnnn.firefreeze.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.wyannnnn.firefreeze.Main;

import java.util.ArrayList;

import static net.wyannnnn.firefreeze.utils.ChatUtils.sendChat;


public class OnServerTick {
    public static int ticks = 0;
    public static long time = -1;
    public static ArrayList<Integer> times = new ArrayList<>();
    public static int seconds = 0;

    @SubscribeEvent
    public void onServerTick(ServerTickEvent event) {
        //if(!event.modid.equals(Main.MODID)){return;}
        if(!Main.ticks){return;}
        ticks++;

        int timeSince = (int) (System.currentTimeMillis()-time);
        seconds += timeSince;

        //sendChatMessage("Tick received: " + (ticks++) +" at: " + timeSince + " ms");
        if(ticks%20==0){
            //sendChat("20 ticks received, Time : "+seconds);
            seconds = 0;
        }
        time = System.currentTimeMillis();
    }
}
