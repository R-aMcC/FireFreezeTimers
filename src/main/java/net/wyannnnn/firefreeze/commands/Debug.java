package net.wyannnnn.firefreeze.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.wyannnnn.firefreeze.events.FireFreezeTimer;
import net.wyannnnn.firefreeze.utils.ChatUtils;
import net.wyannnnn.firefreeze.utils.Constants;
import scala.Int;

import java.lang.reflect.Field;
import java.util.IllegalFormatException;

public class Debug extends CommandBase {
    @Override
    public String getCommandName() {return "fftdebug";}

    @Override
    public String getCommandUsage(ICommandSender sender) {return "/fftdebug <option> <value>";}

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (!sender.getName().contains("_Wyan")) {
            ChatUtils.sendChat("§eAre you sure you want to do this?");
        }

        if (args.length == 0) {
            return;
        } else {
            if(args[0].equals("ttf") && args.length > 1){
                try{
                    Field field = FireFreezeTimer.class.getDeclaredField("ttFreeze");
                    field.setAccessible(true);
                    field.set(null, System.currentTimeMillis()+Integer.parseInt(args[1])+1000);
                }catch (Exception ignored){

                }
            }




            try {
                Field field = Constants.class.getDeclaredField(args[0]);
                String type = field.getAnnotatedType().getType().getTypeName();
                field.setAccessible(true);
                Object currentValue = field.get(null);
                if (args.length == 1) {
                    ChatUtils.sendChat("§b" + args[0] + ": " + currentValue);
                } else {
                    switch (type.toLowerCase()) {
                        case "int":
                            field.set(null, Integer.valueOf(args[1]));
                            break;
                        case "float":
                            field.set(null, Float.valueOf(args[1]));
                            break;
                        case "boolean":
                            field.set(null, Boolean.valueOf(args[1]));
                            break;
                        case "double":
                            field.set(null, Double.valueOf(args[1]));
                            break;
                        case "string":
                            field.set(null, args[1]);
                            break;
                    }
                    ChatUtils.sendChat("§bChanged [" + args[0] + "] from " + currentValue + " to " + args[1]);
                }


            } catch (NoSuchFieldException e) {
                ChatUtils.sendChat("§cInvalid argument: " + args[0]);
            } catch (IllegalAccessException e) {
                ChatUtils.sendChat("§cIllegal access (Most likely private");
            } catch (IllegalFormatException e) {
                ChatUtils.sendChat("§cWrong type");
            } catch (Exception e) {
                if (args.length == 1) {
                    ChatUtils.sendChat("§cSomething went wrong... Command [/srmdebug " + args[0] + "]");
                } else {
                    ChatUtils.sendChat("§cSomething went wrong... Command [/srmdebug " + args[0] + " " + args[1] + "]");
                }
            }
        }
    }
    @Override
    public int getRequiredPermissionLevel() {return 0;}
}
