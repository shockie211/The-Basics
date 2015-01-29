package me.BlazingCode.TheBasics.Methods;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Methods 
{
	  private static String prefix = ChatColor.BLACK + "[" + ChatColor.GOLD + "TheBasics" + ChatColor.BLACK + "] " + ChatColor.GOLD;
	  
	  public static void sendMessage(Player p, String m)
	  {
	    p.sendMessage(prefix + m);
	  }
}
