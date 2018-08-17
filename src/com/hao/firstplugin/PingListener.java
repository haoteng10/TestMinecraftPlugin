package com.hao.firstplugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import net.md_5.bungee.api.ChatColor;

public class PingListener implements Listener {
	
	
	private String motd1 = sendCenteredMessage(ChatColor.AQUA + "Development " + ChatColor.GRAY + "Server");
	private String motd2 = sendCenteredMessage(ChatColor.RED + "Pluto" + ChatColor.GREEN + ChatColor.BOLD+ "MC " + ChatColor.GOLD + "Team");
	
	@EventHandler
	public void onPing(ServerListPingEvent e) {
		
		
		e.setMaxPlayers(20000);
		
		try {
			e.setMotd(motd1 + "\n" + motd2);
		} catch (Exception e2) {
			e.setMotd(ChatColor.RED + "Error! Please check the code again!");
			System.out.println(ChatColor.YELLOW + motd1 + "\n" + ChatColor.BLUE + motd2);
		}
		
		try {
			e.setServerIcon(Bukkit.loadServerIcon(new File("icon.png")));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("No icon.png found!");
			e1.printStackTrace();
		}
		
	}
	
	// Default 154. 114 for MOTD
	
	private final static int CENTER_PX = 114;
	 
	public static String sendCenteredMessage(String message){
	        if(message == null || message.equals("")) return "";
	                message = ChatColor.translateAlternateColorCodes('&', message);
	               
	                int messagePxSize = 0;
	                boolean previousCode = false;
	                boolean isBold = false;
	               
	                for(char c : message.toCharArray()){
	                        if(c == '§'){
	                                previousCode = true;
	                                continue;
	                        }else if(previousCode == true){
	                                previousCode = false;
	                                if(c == 'l' || c == 'L'){
	                                        isBold = true;
	                                        continue;
	                                }else isBold = false;
	                        }else{
	                                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
	                                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
	                                messagePxSize++;
	                        }
	                }
	               
	                int halvedMessageSize = messagePxSize / 2;
	                int toCompensate = CENTER_PX - halvedMessageSize;
	                int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
	                int compensated = 0;
	                StringBuilder sb = new StringBuilder();
	                while(compensated < toCompensate){
	                        sb.append(" ");
	                        compensated += spaceLength;
	                }
	                return (sb.toString() + message);
	        }
	
}
