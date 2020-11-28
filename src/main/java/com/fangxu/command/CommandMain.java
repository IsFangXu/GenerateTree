package com.fangxu.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandMain implements TabExecutor {
    public static Map<String, CommandExecutor> cmd = new HashMap<>();

    @Override
    public boolean onCommand (CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length >= 1) {
            CommandExecutor commandExecutor = cmd.get(strings[0]);
            if (commandExecutor != null) {
                return commandExecutor.onCommand(commandSender, command, s, strings);
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete (CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> mainListString = new ArrayList<>();
        if (strings.length == 1) mainListString.addAll(cmd.keySet());
        return mainListString;
    }
}
