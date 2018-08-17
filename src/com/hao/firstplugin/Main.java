package com.hao.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		System.out.println("First Plugin had worked!");
		Bukkit.getPluginManager().registerEvents(this,this);
		
		getCommand("hello").setExecutor(new HelloCommand());
		getCommand("trolltoggle").setExecutor(new TrollCommand());
		
	}
		
	@Override
	public void onDisable() {
		System.out.println("First Plugin had been disabled!");
	}
			
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (TrollCommand.toggleStatus == true) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.BLUE + "You shouldn't move!");
		} else {
			e.getPlayer().sendMessage(ChatColor.BLUE + "You are free!");
		}
	}
	
	@EventHandler 
	public void onThrow(PlayerEggThrowEvent e) {
		Player player = e.getPlayer();
		player.sendMessage(ChatColor.RED + "Egg Thrown!");
	}
}
