package net.wyannnnn.firefreeze.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.font.FontRenderContext;

public class UiUtils {

    public static void displayText(String text, float posx, float posy, float scale) {
        try {
            FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
            ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());

            int screenWidth = scaledResolution.getScaledWidth();
            int screenHeight = scaledResolution.getScaledHeight();

            int textWidth = fr.getStringWidth(text);
            float x = screenWidth/2.0f-(textWidth / 2.0f);
            float y = screenHeight/2.0f+posy;

            GlStateManager.pushMatrix();

            GlStateManager.enableBlend();
            GlStateManager.disableDepth();

            GlStateManager.translate(x, y, Constants.zTranslate);
            GlStateManager.scale(scale, scale, 1f);



            fr.drawString(text, 0, 0, 0xFFFFFF, true);

            GlStateManager.enableDepth();
            GlStateManager.disableBlend();

            GlStateManager.popMatrix();
        } catch (Exception e) {
            e.printStackTrace();
            ChatUtils.sendChat("§cSomething went wrong: " + e.getLocalizedMessage());
        }

    }
}
