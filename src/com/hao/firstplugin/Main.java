package com.hao.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
	}
		
	@Override
	public void onDisable() {
		System.out.println("First Plugin had been disabled!");
	}
	
	public boolean toggleStatus = false;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equals("hello")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.sendMessage(ChatColor.GRAY + "Hello, " + ChatColor.BLUE + player.getName() + ChatColor.GRAY + ". You will now receie full health!");
				player.setHealth(20.0);
				
			} else {
				System.out.println("You are not a player! Do not send this command in console!");
			}
		}
		
		if (cmd.getName().equals("trolltoggle")) {
			if (toggleStatus == false) {
				toggleStatus = true;
				if (sender instanceof Player) {
					Player player = (Player) sender;
					player.sendMessage("Toggled On. Current Status is " + ChatColor.YELLOW + toggleStatus);
				}
			} else {
				toggleStatus = false;
				if (sender instanceof Player) {
					Player player = (Player) sender;
					player.sendMessage("Toggled Off. Current Status is " + ChatColor.YELLOW + toggleStatus);
				}
			}
		}
		
		return false;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (toggleStatus == true) {
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
