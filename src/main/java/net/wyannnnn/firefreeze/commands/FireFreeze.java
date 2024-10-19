package net.wyannnnn.firefreeze.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.common.MinecraftForge;
import net.wyannnnn.firefreeze.Main;
import net.wyannnnn.firefreeze.events.OnServerTick;
import net.wyannnnn.firefreeze.utils.ChatUtils;

import java.util.ArrayList;
import java.util.List;

public class FireFreeze extends CommandBase {

    @Override
    public String getCommandName() {return "firefreeze";}

    @Override
    public String getCommandUsage(ICommandSender sender) {return "/firefreeze enable|disable|ticks [true|false]";}

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        if(args.length == 0) {
            ChatUtils.sendChat("§cPlease add an option:"+getCommandUsage(sender));
        }else if(args.length == 1) {
            if(args[0].equalsIgnoreCase("enable")) {
                Main.enabled = true;
                ChatUtils.sendChat("§aMod enabled.");
            }else if(args[0].equalsIgnoreCase("disable")) {
                Main.enabled = false;
                ChatUtils.sendChat("§cMod disabled.");
            }else if(args[0].equalsIgnoreCase("ticks")) {
                ChatUtils.sendChat("§cIncorrect usage. [/firefreeze ticks [true|false]]");
            }else{
                ChatUtils.sendChat("§cIncorrect usage. ["+getCommandUsage(sender)+"]");
            }
        }else if(args.length == 2) {
            if(args[0].equalsIgnoreCase("enable")) {
                Main.enabled = true;
                ChatUtils.sendChat("§aMod enabled.");
            }else if(args[0].equalsIgnoreCase("disable")) {
                Main.enabled = false;
                ChatUtils.sendChat("§cMod disabled.");
            }else if(args[0].equalsIgnoreCase("ticks")) {
                if(args[1].equalsIgnoreCase("true")) {
                    Main.ticks = true;
                    ChatUtils.sendChat("§aUsing ticks instead of seconds");
                }else if(args[1].equalsIgnoreCase("false")) {
                    Main.ticks = false;
                    ChatUtils.sendChat("§aUsing seconds instead of ticks");
                }
            }
        }
    }

    @Override
    public int getRequiredPermissionLevel() {return 0;}

    @Override
    public List<String> getCommandAliases()
    {
        List<String> aliases = new ArrayList<>();
        aliases.add("ff");
        aliases.add("fft");
        aliases.add("firefreezetimers");
        return aliases;
    }

}
