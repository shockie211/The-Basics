package me.BlazingCode.TheBasics;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MuteUtil 
{
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e)
	{
		Player player = e.getPlayer();
		
		if(Storage.muteStorage.getInt("Mute." + player.getName() + ".Time") < System.currentTimeMillis()/1000)
		{
			e.setCancelled(true);
			Methods.sendMessage(player, "You are muted for " + ChatColor.RED + Storage.muteStorage.getInt("Mute." + player.getName() + ".Time") 
					+ ChatColor.GOLD + ".");
		}else if(Storage.muteStorage.getInt("Mute." + player.getName() + ".Time") > System.currentTimeMillis()/1000)
		{
			Storage.muteStorage.set("Mute." + player.getName() + ".Time", null);
			Methods.sendMessage(player, "You have been unmuted.");
		}
	}
}
