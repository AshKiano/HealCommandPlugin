package com.ashkiano.healcommandplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HealCommandPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HealCommandPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("HealCommandPlugin has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by players.");
                return true;
            }

            Player player = (Player) sender;
            if (player.hasPermission("heal.use")) {
                player.setHealth(player.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH).getValue());
                player.setFoodLevel(20);
                player.setFireTicks(0);
                player.sendMessage("You have been healed.");
            } else {
                player.sendMessage("You do not have permission to use this command.");
            }
            return true;
        }
        return false;
    }
}