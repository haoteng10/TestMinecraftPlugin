package com.hao.firstplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class HelloCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] arg) {
		
		double health = 0.0;
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			try {
				health = Double.parseDouble(arg[0]);
			} catch (Exception e){
				player.sendMessage(ChatColor.RED + "Please enter in such format: /hello <health>");
			}
			
			player.sendMessage(ChatColor.GRAY + "Hello, " + ChatColor.BLUE + player.getName() + ChatColor.GRAY + ". You will now receie full health or any of your choice!");
			if (health == 0.0) {
				player.setHealth(20.0);
			} else {
				player.setHealth(health);
			}
			
		} else {
			System.out.println("You are not a player! Do not send this command in console!");
		}
		
		return false;
	}

}
