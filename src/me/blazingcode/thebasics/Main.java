package me.BlazingCode.TheBasics;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	Logger logger = Logger.getLogger("TheBasics");

        public void onEnable() {
        	getLogger().info(ChatColor.AQUA + "The basics V1 has been enabled!")
        	
        } 
	    
	}

	public void onDisable() {
	    getLogger().info(ChatColor.AQUA + "The basics is being disabled!")
	                        
	}
}
