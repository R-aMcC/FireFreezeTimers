package net.wyannnnn.firefreeze.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;

public class ChatUtils {

    public static boolean sendChat(String msg){
        EntityPlayerSP p = Minecraft.getMinecraft().thePlayer;
        if(p == null) return false;
        p.addChatMessage(new ChatComponentText(msg));
        return true;
    }
}
