package net.wyannnnn.firefreeze;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.wyannnnn.firefreeze.commands.Debug;
import net.wyannnnn.firefreeze.commands.FireFreeze;
import net.wyannnnn.firefreeze.events.FireFreezeTimer;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
    public static final String MODID = "firefreezetimers";
    public static final String VERSION = "1.0";
    public static boolean enabled = true;
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new FireFreezeTimer());

        ClientCommandHandler.instance.registerCommand(new FireFreeze());
        ClientCommandHandler.instance.registerCommand(new Debug());
    }
}
