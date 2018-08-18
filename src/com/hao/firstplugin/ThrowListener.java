package com.hao.firstplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

import net.md_5.bungee.api.ChatColor;

public class ThrowListener implements Listener {
	
	@EventHandler 
	public void onThrow(PlayerEggThrowEvent e) {
		Player player = e.getPlayer();
		player.sendMessage(ChatColor.RED + "Egg Thrown!");
	}

}
