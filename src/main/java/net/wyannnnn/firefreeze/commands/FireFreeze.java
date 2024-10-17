package net.wyannnnn.firefreeze.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.wyannnnn.firefreeze.Main;
import net.wyannnnn.firefreeze.utils.ChatUtils;

public class FireFreeze extends CommandBase {

    @Override
    public String getCommandName() {return "firefreeze";}

    @Override
    public String getCommandUsage(ICommandSender sender) {return "/firefreeze enable|disable";}

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
            }else{
                ChatUtils.sendChat("§cIncorrect usage. ["+getCommandUsage(sender)+"]");
            }
        }
    }

    @Override
    public int getRequiredPermissionLevel() {return 0;}

}
