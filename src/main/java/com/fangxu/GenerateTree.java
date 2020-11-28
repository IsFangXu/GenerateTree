package com.fangxu;

import com.fangxu.command.CommandMain;
import com.fangxu.command.cmds.Test;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class GenerateTree extends JavaPlugin {
    private static GenerateTree plugin;

    @Override
    public void onEnable () {
        plugin = this;

        getCommand("gt").setExecutor(new CommandMain());
        CommandMain.cmd.put("test", new Test());

        getLogger().info(String.format("%s插件加載成功", ChatColor.DARK_GREEN));
    }

    @Override
    public void onDisable () {
        getLogger().info(String.format("%s插件卸載成功", ChatColor.RED));
    }

    public static GenerateTree getPlugin() {
        return plugin;
    }
}
