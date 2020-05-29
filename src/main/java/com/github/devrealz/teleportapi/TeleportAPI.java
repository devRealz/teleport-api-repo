package com.github.devrealz.teleportapi;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class TeleportAPI {
    Plugin plugin;
    public TeleportAPI(Plugin pl) {
        plugin = pl;
    }

    public void teleportPlayer(Player player, int delay, Location loc) {
        plugin.getServer().getScheduler().runTaskLater(plugin,task ->{
            player.sendMessage(ChatColor.YELLOW + "Teleporting you now.");
            player.teleport(loc);
        },20*delay);
        player.getWorld().playEffect(loc, Effect.PORTAL_TRAVEL,delay);
        player.sendMessage(ChatColor.AQUA + "Teleportation will commence shortly.");
    }

    public void teleportPlayer(Player player, int delay, Location loc,String onTeleportMessage) {
        plugin.getServer().getScheduler().runTaskLater(plugin,task ->{
            player.sendMessage(onTeleportMessage);
            player.teleport(loc);
        },20*delay);
        player.getWorld().playEffect(loc, Effect.PORTAL_TRAVEL,delay);
        player.sendMessage(ChatColor.AQUA + "Teleportation will commence shortly.");
    }
}
