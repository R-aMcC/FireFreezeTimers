package net.wyannnnn.firefreeze.events;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.wyannnnn.firefreeze.FireFreeze;
import net.wyannnnn.firefreeze.utils.ChatUtils;

public class OnChatReceived {
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onChatReceived(ClientChatReceivedEvent e) {
        if(FireFreeze.enabled){
            String msg = e.message.getFormattedText();
            if(msg.equals("[BOSS] The Professor: Oh? You found my Guardians' one weakness?")){
                new Thread(()->{
                    long ttFreeze = System.currentTimeMillis()+5000;
                    while(System.currentTimeMillis()<ttFreeze){
                        try{
                            ChatUtils.sendChat("FireFreeze in "+(System.currentTimeMillis()-ttFreeze)+" ms");
                            Thread.sleep(1000);
                        }catch(InterruptedException ignored){
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }

                    }
                    ChatUtils.sendChat("FireFreeze NOW");
                }).start();
            }
        }
    }
}
