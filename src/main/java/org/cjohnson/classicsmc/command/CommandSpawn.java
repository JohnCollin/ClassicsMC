package org.cjohnson.classicsmc.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cjohnson.classicsmc.ClassicsMC;

public class CommandSpawn implements CommandExecutor {
	
	private ClassicsMC classicsMC;
	
	public CommandSpawn(ClassicsMC classicsMC) {
		this.classicsMC = classicsMC;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("spawn") || command.getName().equalsIgnoreCase("hub")) {
			if(!(sender instanceof Player)) {
				return false;
			}
			
			Player player = (Player) sender;
			
			player.teleport(new Location(
					classicsMC.getServer().getWorld(classicsMC.getConfig().getString("spawn.world")),
					classicsMC.getConfig().getDouble("spawn.x"),
					classicsMC.getConfig().getDouble("spawn.y"),
					classicsMC.getConfig().getDouble("spawn.z")
				)
			);
		}
		
		return false;
	}
	
}
