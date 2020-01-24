package org.cjohnson.classicsmc;

import org.bukkit.plugin.java.JavaPlugin;
import org.cjohnson.classicsmc.command.CommandSpawn;
import org.cjohnson.classicsmc.listener.PlayerTrafficListener;

public class ClassicsMC extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		
		getCommand("spawn").setExecutor(new CommandSpawn(this));
		
		getServer().getPluginManager().registerEvents(new PlayerTrafficListener(this), this);
	}
	
}
