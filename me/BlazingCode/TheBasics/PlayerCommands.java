package me.BlazingCode.TheBasics;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommands
{
	private Main plugin;

	private ArrayList<TeleportRequest> requestList = new ArrayList<>();

	private final int tickTime = 20;
	private final int maxWait = tickTime * 20;

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (label.equalsIgnoreCase(PlayerCommand.TPA) && sender instanceof Player)
		{
			Player player = (Player) sender;

			if (args[0] != null && args[0] != "")
			{
				Player reciever = Bukkit.getPlayer(args[0]);

				TeleportRequest request=new TeleportRequest(player.getName(),reciever.getName(),20);
				
				requestList.add(request);

				reciever.sendMessage(player.getName() + " has requested to teleport to you. Type /tpaccept, or /tpdeny");

				player.sendMessage("Request sent to " + reciever.getName());
			}
		}
		if (label.equalsIgnoreCase(PlayerCommand.TPACCEPT) && sender instanceof Player)
		{
			Player player = (Player) sender;

			if (requestList.contains(o))
		}

		return false;
	}
}
