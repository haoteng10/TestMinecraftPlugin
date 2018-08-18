package com.hao.firstplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.md_5.bungee.api.ChatColor;

public class MoveListener implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (TrollCommand.toggleStatus == true) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.BLUE + "You shouldn't move!");
		} else {
			e.getPlayer().sendMessage(ChatColor.BLUE + "You are free!");
		}
	}
	
}
