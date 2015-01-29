package me.BlazingCode.TheBasics;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class TeleportRequest
{
	private final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("TheBasics");

	private final int tickTime = 20;
	private final int maxWait = 20;

	private String sender, target;
	private int wait;

	public TeleportRequest(String sender, String target, int wait)
	{
		this.sender = sender;
		this.target = target;
		this.wait = wait;

		Bukkit.getScheduler().runTaskTimer(plugin, new Runnable()
		{
			public void run()
			{
				wait--;
			}
		}, tickTime * 1, tickTime * maxWait);
	}

	public String getSender()
	{
		return sender;
	}

	public String getTarget()
	{
		return target;
	}

	public int getWait()
	{
		return wait;
	}
}
