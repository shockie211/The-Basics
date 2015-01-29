package me.BlazingCode.TheBasics;

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
		Player player = (Player) sender;
		
		Player receiver = Bukkit.getServer().getPlayer(args[1]);
		
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
				Methods.sendMessage(player, "You do not have enough permission to perform this command");
			}
		}
		return false;
	}
}
