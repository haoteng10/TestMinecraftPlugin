package com.hao.firstplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class TrollCommand implements CommandExecutor {

	public static boolean toggleStatus = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {
		
		
		if (toggleStatus == false) {
			toggleStatus = true;
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.sendMessage("Toggled On. Current Status is " + ChatColor.YELLOW + toggleStatus);
			} else {
				System.out.println("Toggled On. Current Status is " + toggleStatus);
			}
		} else {
			toggleStatus = false;
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.sendMessage("Toggled Off. Current Status is " + ChatColor.YELLOW + toggleStatus);
			} else {
				System.out.println("Toggled Off. Current Status is " + toggleStatus);
			}
		}
		
		return false;

	}

}
