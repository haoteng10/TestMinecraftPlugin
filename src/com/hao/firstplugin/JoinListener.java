package com.hao.firstplugin;

import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
	
	private BossBar bossbar;
	
	public JoinListener(BossBar bossbar) {
		this.bossbar = bossbar;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		bossbar.addPlayer(e.getPlayer());
	}
	
}
