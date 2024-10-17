package net.wyannnnn.firefreeze.events;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.wyannnnn.firefreeze.Main;
import net.wyannnnn.firefreeze.utils.ChatUtils;
import net.wyannnnn.firefreeze.utils.Constants;
import net.wyannnnn.firefreeze.utils.SkyblockUtils;
import net.wyannnnn.firefreeze.utils.UiUtils;

public class FireFreezeTimer {
    static Long ttFreeze = null;
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onChatReceived(ClientChatReceivedEvent e) {
        if (Main.enabled && SkyblockUtils.inSkyblock && SkyblockUtils.inCatacombs) {
            String msg = e.message.getUnformattedText();
            if (msg.equals("[BOSS] The Professor: Oh? You found my Guardians' one weakness?")) {
                ttFreeze = System.currentTimeMillis() + 6000;
            } else if (msg.contains("[BOSS]")) {
                //ChatUtils.sendChat(msg);
                System.out.println(msg);

            }
        }
    }

    @SubscribeEvent
    public void onGuiRender(RenderGameOverlayEvent.Text event) {
        try{
            float f = 1.5f;


            if(ttFreeze != null){
                String text;
                if(ttFreeze > System.currentTimeMillis()+1000){
                    text = "§bFireFreeze in " + (int)((ttFreeze - System.currentTimeMillis())/1000) + " s";
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
