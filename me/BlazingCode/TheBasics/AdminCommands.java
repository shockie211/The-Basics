package me.BlazingCode.TheBasics;

import java.io.IOException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands implements CommandExecutor
{
	Main pl;
	
	public AdminCommands(Main instance)
	{
		pl = instance;
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		//Get the player who sent commands.
		Player player = (Player) sender;
		
		//Get the player who receives the commands. Labeled as args[1], ex: /ban <player>
		Player receiver = Bukkit.getServer().getPlayer(args[1]);
		
		//Combines all the arguments into one string, reason.
		String reason = "";
		for(String a: args)
		{
			reason = reason + a + " ";
		}
		
		if(label.equalsIgnoreCase("ban"))
		{
			if(player.hasPermission("thebasics.ban"))
			{
				if(args.length > 2)
				{
					if(receiver.isOnline() == true)
					{
						receiver.setBanned(true);
						receiver.kickPlayer(reason);
						
						Methods.sendMessage(player, "You have banned " + ChatColor.RED + receiver.getName() + ChatColor.GOLD + "!");
					}else
					{
						Methods.sendMessage(player, "The player " + ChatColor.RED + receiver.getName() + ChatColor.GOLD + " is not online!");
					}
				}else
				{
					Methods.sendMessage(player, "Please use this format: /ban <name> <reason>.");
				}
			}else
			{
				Methods.noPermMessage(player);
			}
		}else if(label.equalsIgnoreCase("kick"))
		{
			if(player.hasPermission("thebasics.kick"))
			{
				if(args.length > 2)
				{
					if(receiver.isOnline() == true)
					{
						receiver.kickPlayer(reason);
						
						Methods.sendMessage(player, "You have kicked " + ChatColor.RED + receiver.getName() + ChatColor.GOLD + "!");
					}else
					{
						Methods.sendMessage(player, "The player " + ChatColor.RED + receiver.getName() + ChatColor.GOLD + " is not online!");
					}
				}else
				{
					Methods.sendMessage(player, "Please use this format: /kick <name> <reason>.");
				}
			}else
			{
				Methods.noPermMessage(player);
			}
		}else if(label.equalsIgnoreCase("tempban"))
		{
			if(player.hasPermission("thebasics.tempban"))
			{
				if(args.length > 3)
				{
					if(receiver.isOnline() == true)
					{
						int currentTime = (int) (System.currentTimeMillis() /1000);
						
						int banTime = Integer.parseInt(args[2]);
						
						int timeToUnban = currentTime + banTime;
						
						Storage.banStorage.set("Ban." + receiver.getName() + ".Time", timeToUnban);
						
						try {
							Storage.saveBanningStorage();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						receiver.kickPlayer(reason);
						
						receiver.setBanned(true);
					}else
					{
						Methods.sendMessage(player, "The player " + ChatColor.RED + receiver.getName() + ChatColor.GOLD + " is not online!");
					}
				}else
				{
					Methods.sendMessage(player, "Please use this format: /tempban <name> <time> <reason>.");
				}
			}else
			{
				Methods.noPermMessage(player);
			}
		}else if(label.equalsIgnoreCase("mute"))
		{
			
		}
		return false;
	}
}
