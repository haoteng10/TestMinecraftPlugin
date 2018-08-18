package com.hao.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	private BossBar bossbar;
	
	@Override
	public void onEnable() {
		
		// Send Console Message 
		// Bukkit.getConsoleSender().sendMessage(colorMessage); 
		
		System.out.println("First Plugin had worked!");
		
		bossbar = Bukkit.createBossBar(ChatColor.AQUA + "PlutoMC Development Server", BarColor.GREEN, BarStyle.SOLID);
		
		Bukkit.getPluginManager().registerEvents(new ThrowListener(), this);
		Bukkit.getPluginManager().registerEvents(new PingListener(),this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(bossbar), this);
		Bukkit.getPluginManager().registerEvents(new MoveListener(), this);
		
		getCommand("hello").setExecutor(new HelloCommand());
		getCommand("trolltoggle").setExecutor(new TrollCommand());
		getCommand("spawnstand").setExecutor(new SpawnStandCommand());
		
	}
		
	@Override
	public void onDisable() {
		System.out.println("First Plugin had been disabled!");
	}
			
	
}
	

