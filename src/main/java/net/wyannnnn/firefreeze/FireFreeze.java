package net.wyannnnn.firefreeze;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = FireFreeze.MODID, version = FireFreeze.VERSION)
public class FireFreeze {
    public static final String MODID = "firefreezetimers";
    public static final String VERSION = "1.0";
    public static boolean enabled = true;
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
		// some example code
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
    }
}
