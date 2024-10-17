package net.wyannnnn.firefreeze.utils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreboardUtils {
    public static String clean(String scoreboard){
        char[] tmpString = StringUtils.stripControlCodes(scoreboard).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : tmpString) {
            if((int) c>20 && (int) c <127){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static List<String> getSidebar(){
        List<String> sidebar = new ArrayList<String>();
        World w= Minecraft.getMinecraft().theWorld;
        if(w==null){return sidebar;}

        Scoreboard sb = w.getScoreboard();
        if(sb==null){return sidebar;}

        ScoreObjective objective = sb.getObjectiveInDisplaySlot(1);
        if(objective==null){return sidebar;}

        Collection<Score> scores = sb.getSortedScores(objective);
        List<Score> list = scores.stream()
                .filter(input -> input != null && input.getPlayerName() != null && !input.getPlayerName()
                        .startsWith("#"))
                .collect(Collectors.toList());
        if(list.size()>15){
            scores = Lists.newArrayList(Iterables.skip(list, scores.size()-15));
        }else{
            scores = list;
        }
        for(Score score : scores){
            ScorePlayerTeam team = sb.getPlayersTeam(score.getPlayerName());
            sidebar.add(ScorePlayerTeam.formatPlayerName(team, score.getPlayerName()));
        }
        return sidebar;
    }
}
