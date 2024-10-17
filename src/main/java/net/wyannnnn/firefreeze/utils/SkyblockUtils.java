package net.wyannnnn.firefreeze.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;

import java.util.List;

public class SkyblockUtils {
    public static boolean inSkyblock = false;
    public static boolean inCatacombs = false;

    /**
     * Taken from Danker's Skyblock Mod under the GNU General Public License v3.0
     * https://github.com/bowser0000/SkyblockMod/blob/master/LICENSE
     * @author bowser0000
     */
    public static void checkForSkyblock() {

        Minecraft mc = Minecraft.getMinecraft();
        if (mc != null && mc.theWorld != null && !mc.isSingleplayer()) {
            ScoreObjective scoreboardObj = mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
            if (scoreboardObj != null) {
                String scObjName = ScoreboardUtils.clean(scoreboardObj.getDisplayName());
                if (scObjName.contains("SKYBLOCK")) {
                    inSkyblock = true;
                    return;
                }
            }
        }
        inSkyblock = false;
    }

    /**
     * Taken from Danker's Skyblock Mod under the GNU General Public License v3.0
     * https://github.com/bowser0000/SkyblockMod/blob/master/LICENSE
     * @author bowser0000
     */
    public static void checkForCatacombs() {
        if (inSkyblock) {
            List<String> scoreboard = ScoreboardUtils.getSidebar();
            for (String s : scoreboard) {
                String sCleaned = ScoreboardUtils.clean(s);
                if (sCleaned.contains("The Catacombs")) {
                    inCatacombs = true;
                    return;
                }
            }
        }
        inCatacombs = false;
    }

}
