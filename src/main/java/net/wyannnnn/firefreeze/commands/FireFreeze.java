package net.wyannnnn.firefreeze.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.wyannnnn.firefreeze.Main;
import net.wyannnnn.firefreeze.utils.ChatUtils;

import java.util.ArrayList;
import java.util.List;

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
