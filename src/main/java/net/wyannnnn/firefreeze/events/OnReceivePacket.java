package net.wyannnnn.firefreeze.events;

import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.wyannnnn.firefreeze.Main;
import net.wyannnnn.firefreeze.packets.PacketEvent;

public class OnReceivePacket {
    @SubscribeEvent
    public void onReceivePacket(PacketEvent.ReceiveEvent event) {
        try{
            if(event.packet instanceof S32PacketConfirmTransaction){
                MinecraftForge.EVENT_BUS.post(new ServerTickEvent((S32PacketConfirmTransaction) event.packet, Main.MODID));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
