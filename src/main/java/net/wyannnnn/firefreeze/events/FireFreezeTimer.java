package net.wyannnnn.firefreeze.events;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.wyannnnn.firefreeze.Main;
import net.wyannnnn.firefreeze.utils.ChatUtils;
import net.wyannnnn.firefreeze.utils.Constants;
import net.wyannnnn.firefreeze.utils.UiUtils;
import scala.collection.immutable.Stream;

public class FireFreezeTimer {
    static Long ttFreeze = null;
    static Integer tkstFreeze = null;
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onChatReceived(ClientChatReceivedEvent e) {

        if (Main.enabled) {
            String msg = e.message.getUnformattedText();
            System.out.println(msg);
            if (msg.equals("[BOSS] The Professor: Oh? You found my Guardians' one weakness?")) {
                if(!Main.ticks){
                    ttFreeze = System.currentTimeMillis() + 6000;
                }else{
                    tkstFreeze = 120;

                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onServerTick(ServerTickEvent e) {
        if (Main.enabled && Main.ticks) {
            if(tkstFreeze != null){
                tkstFreeze--;
            }
        }
    }

    @SubscribeEvent
    public void onGuiRender(RenderGameOverlayEvent.Text event) {
        try{
            float f = 1.5f;

            if(Main.ticks){
                if(tkstFreeze != null){
                    String text;
                    if(tkstFreeze > 20){
                        text = "§bFireFreeze in " + (tkstFreeze/20) + " seconds";
                    }else if (tkstFreeze > 0){
                        text = "§bFireFreeze NOW";
                    }else{
                        text = "§bFireFreeze NOW";
                        tkstFreeze = null;
                    }
                    UiUtils.displayText(text, Constants.posx, Constants.posy, Constants.scale);
                }
            }
            if(ttFreeze != null){
                String text;
                if(ttFreeze > System.currentTimeMillis()+1000){
                    text = "§bFireFreeze in " + (int)((ttFreeze - System.currentTimeMillis())/1000) + " seconds";
                }else if (ttFreeze > System.currentTimeMillis()){
                    text = "§bFireFreeze NOW";
                }else{
                    text = "§bFireFreeze NOW";
                    ttFreeze = null;
                }
                UiUtils.displayText(text, Constants.posx, Constants.posy, Constants.scale);
            }
        }catch(Exception e){
            e.printStackTrace();
            ChatUtils.sendChat("§cSomething went wrong: "+e.getLocalizedMessage());
        }
    }


}
