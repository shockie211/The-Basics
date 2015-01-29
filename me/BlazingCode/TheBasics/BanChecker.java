package me.BlazingCode.TheBasics;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class BanChecker
{
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e)
	{
		Player player = e.getPlayer();
		
		if(player.isBanned() == true)
		{
			if(Storage.banStorage.getInt("Ban." + player.getName() + ".Time") >= System.currentTimeMillis()/1000)
			{
				Storage.banStorage.set("Ban." + player.getName() + ".Time", null);
				
				player.setBanned(false);
			}else if(Storage.banStorage.getInt("Ban." + player.getName() + ".Time") < System.currentTimeMillis()/1000)
			{
				e.setResult(Result.KICK_BANNED);
			}else
			{
				e.setResult(Result.ALLOWED);
			}
		}
	}
}
