package dev.mrshawn.actualflamingarrows;

import dev.mrshawn.actualflamingarrows.listeners.ArrowListener;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class ActualFlamingArrows extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new ArrowListener(), this);
	}

	@Override
	public void onDisable() {
		HandlerList.unregisterAll(this);
	}
}
