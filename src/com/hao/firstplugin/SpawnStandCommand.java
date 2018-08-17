package com.hao.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.util.EulerAngle;

public class SpawnStandCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] arg) {
		
		SpawnStand(new Location(Bukkit.getWorld("world"),-346, 63, 96));
		
		return false;
	}

	public static void SpawnStand(Location location) {
		ArmorStand stand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
		
		stand.setInvulnerable(true);
		
		// 286, 0 , 0
		stand.setBodyPose(new EulerAngle(286, 0, 0));
		
		//295, 23, 0
		stand.setHeadPose(new EulerAngle(295, 23, 0));
		
		//157, 70, 0
		stand.setLeftLegPose(new EulerAngle(157, 70, 0));
	
		//136, 260, 0
		stand.setRightLegPose(new EulerAngle(136, 260, 0));
		
	}
	
}
