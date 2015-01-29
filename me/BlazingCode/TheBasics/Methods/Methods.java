package me.BlazingCode.TheBasics.Methods;

public class Methods 
{
  String prefix = ChatColor.BLACK + "[" + ChatColor.GOLD + "TheBasics" + ChatColor.BLACK + "] " + ChatColor.GOLD;
  
  public static void sendMessage(Player p, String m)
  {
    p.sendMessage(prefix + m);
  }
}
