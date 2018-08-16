package com.hao.firstplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("First Plugin had worked!");
	}
		
	@Override
	public void onDisable() {
		System.out.println("First Plugin had been disabled!");
	}
	
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
		
		return false;
	}
	
}
