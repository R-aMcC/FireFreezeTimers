package net.wyannnnn.firefreeze;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.wyannnnn.firefreeze.commands.FireFreeze;
import net.wyannnnn.firefreeze.events.OnChatReceived;
import net.wyannnnn.firefreeze.events.OnWorldRender;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
    public static final String MODID = "firefreezetimers";
    public static final String VERSION = "1.0";
    public static boolean enabled = true;
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new OnChatReceived());
        MinecraftForge.EVENT_BUS.register(new OnWorldRender());

        ClientCommandHandler.instance.registerCommand(new FireFreeze());
    }
}
