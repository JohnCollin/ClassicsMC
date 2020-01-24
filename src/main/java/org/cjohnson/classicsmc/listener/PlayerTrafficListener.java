package org.cjohnson.classicsmc.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.cjohnson.classicsmc.ClassicsMC;

import java.text.MessageFormat;

public class PlayerTrafficListener implements Listener {
	
	public static final String JOIN_MESSAGE_PATH = "joinMessage";
	public static final String QUIT_MESSAGE_PATH = "quitMessage";
	
	public static final String TITLE = "title";
	public static final String SUBTITLE = "subtitle";
	public static final String FADE_IN = "fadeIn";
	public static final String STAY = "stay";
	public static final String FADE_OUT = "fadeOut";
	
	private ClassicsMC classicsMC;
	
	public PlayerTrafficListener(ClassicsMC classicsMC) {
		this.classicsMC = classicsMC;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
		playerJoinEvent.setJoinMessage(
			ChatColor.translateAlternateColorCodes('&',
				MessageFormat.format(
					classicsMC.getConfig().getString(PlayerTrafficListener.JOIN_MESSAGE_PATH),
					playerJoinEvent.getPlayer().getName()
				)
			)
		);
		
		playerJoinEvent.getPlayer().sendTitle(
			ChatColor.translateAlternateColorCodes('&', classicsMC.getConfig().getString(PlayerTrafficListener.TITLE)),
			ChatColor.translateAlternateColorCodes('&', classicsMC.getConfig().getString(PlayerTrafficListener.SUBTITLE)),
			classicsMC.getConfig().getInt(PlayerTrafficListener.FADE_IN),
			classicsMC.getConfig().getInt(PlayerTrafficListener.STAY),
			classicsMC.getConfig().getInt(PlayerTrafficListener.FADE_OUT)
		);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerQuit(PlayerQuitEvent playerQuitEvent) {
		playerQuitEvent.setQuitMessage(
			ChatColor.translateAlternateColorCodes('&',
				MessageFormat.format(
					classicsMC.getConfig().getString(PlayerTrafficListener.QUIT_MESSAGE_PATH),
					playerQuitEvent.getPlayer().getName()
				)
			)
		);
	}

}
