package net.wyannnnn.firefreeze.events;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.wyannnnn.firefreeze.Main;
import net.wyannnnn.firefreeze.utils.ChatUtils;
import net.wyannnnn.firefreeze.utils.SkyblockUtils;

public class OnChatReceived {
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onChatReceived(ClientChatReceivedEvent e) {
        if(Main.enabled && SkyblockUtils.inSkyblock && SkyblockUtils.inCatacombs){
            String msg = e.message.getUnformattedText();
            if(msg.equals("[BOSS] The Professor: Oh? You found my Guardians' one weakness?")){
                new Thread(()->{
                    long ttFreeze = System.currentTimeMillis()+5000;
                    while(System.currentTimeMillis()<ttFreeze){
                        try{
                            ChatUtils.sendChat("FireFreeze in "+(ttFreeze-System.currentTimeMillis())+" ms");
                            Thread.sleep(1000);
                        }catch(InterruptedException ignored){
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }

                    }
                    ChatUtils.sendChat("FireFreeze NOW");
                }).start();
            } else if (msg.contains("[BOSS]")) {
                //ChatUtils.sendChat(msg);
                System.out.println(msg);

            }
        }

    }
}
