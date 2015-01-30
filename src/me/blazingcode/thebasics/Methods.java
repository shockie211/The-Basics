package me.BlazingCode.TheBasics;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Methods 
{
	  private static String prefix = ChatColor.BLACK + "[" + ChatColor.GOLD + "TheBasics" + ChatColor.BLACK + "] " + ChatColor.GOLD;
	  
	  public static void sendMessage(Player p, String m)
	  {
		  p.sendMessage(prefix + m);
	  }
	  
	  public static void noPermMessage(Player p)
	  {
		  p.sendMessage(prefix + "You do not have enough permission to perform this command!");
	  }
}
