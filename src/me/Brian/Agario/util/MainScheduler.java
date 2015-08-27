package me.Brian.Agario.util;

import me.Brian.Agario.Agario;

import org.bukkit.scheduler.BukkitScheduler;

public class MainScheduler {
	public static void startScheduler() {
		BukkitScheduler scheduler = Agario.getInstance().getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(Agario.getInstance(), new Runnable() {
			@Override
			public void run() {
//				Bukkit.getWorld("world").playEffect(((PelletCell)CellManager.getCell(Agario.indicator)).getLocation(), Effect.COLOURED_DUST, 5);
//				Bukkit.getServer().getPluginManager().callEvent(new AgarCellMoveEvent());
			}
		}, 0L, 1L);
	}
}
