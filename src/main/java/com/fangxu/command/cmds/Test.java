package com.fangxu.command.cmds;

import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test implements CommandExecutor {
    @Override
    public boolean onCommand (CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 1) {
                World world = player.getWorld();
                Location location = player.getLocation();
                if (! world.generateTree(location, TreeType.TREE)) {
                    player.sendMessage("生成失敗");
                    return false;
                }
                return true;
            } else if (strings.length == 2) {
                World world = player.getWorld();
                Location location = player.getLocation();
                TreeType[] values = TreeType.values();
                for (TreeType value : values) {
                    System.out.println(value.name());
                    if (value.name().toLowerCase().equalsIgnoreCase(strings[1].toLowerCase())) {
                        if (! world.generateTree(location, value)) {
                            player.sendMessage("生成失敗");
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
