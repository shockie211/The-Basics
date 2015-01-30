package me.BlazingCode.TheBasics;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Storage
{
	static Main pl;
	
	static File banningStorage = new File(pl.getDataFolder() + "BanStorage.yml");
	public static YamlConfiguration banStorage = YamlConfiguration.loadConfiguration(banningStorage);
	
	public static void saveBanningStorage() throws IOException
	{
		banStorage.save(banningStorage);
	}
	
	static File mutingStorage = new File(pl.getDataFolder() + "BanStorage.yml");
	public static YamlConfiguration muteStorage = YamlConfiguration.loadConfiguration(mutingStorage);
	
	public static void saveMutingStorage() throws IOException
	{
		muteStorage.save(mutingStorage);
	}
	
}
