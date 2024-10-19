package net.wyannnnn.firefreeze;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.wyannnnn.firefreeze.commands.Debug;
import net.wyannnnn.firefreeze.commands.FireFreeze;
import net.wyannnnn.firefreeze.events.FireFreezeTimer;
import net.wyannnnn.firefreeze.events.OnReceivePacket;
import net.wyannnnn.firefreeze.events.OnServerTick;
import net.wyannnnn.firefreeze.packets.PacketHandler;
import net.wyannnnn.firefreeze.utils.ChatUtils;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
    public static final String MODID = "firefreezetimers";
    public static final String VERSION = "1.0";
    public static boolean enabled = true;
    public static boolean ticks = true;
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new FireFreezeTimer());
        MinecraftForge.EVENT_BUS.register(new OnReceivePacket());
        if(ticks){
            MinecraftForge.EVENT_BUS.register(new OnServerTick());
        }
        MinecraftForge.EVENT_BUS.register(this);

        ClientCommandHandler.instance.registerCommand(new FireFreeze());
        ClientCommandHandler.instance.registerCommand(new Debug());
    }

    @SubscribeEvent
    public void onServerConnect(FMLNetworkEvent.ClientConnectedToServerEvent event){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException ignored){

        }
        Minecraft mc = Minecraft.getMinecraft();
        if(mc.getCurrentServerData() == null){return;}
        if(mc.getCurrentServerData().serverIP.toLowerCase().contains("hypixel.")){
            ChatUtils.sendChat("Connected to hypixel. Setting packet handler");
            event.manager.channel().pipeline().addBefore("packet_handler", "firefreeze_packet_handler", new PacketHandler());
        }

    }
}
