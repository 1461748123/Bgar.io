package me.Brian.Agario.util;

import me.Brian.Agario.Agario;
import me.Brian.Agario.cell.FoodCell;
import me.Brian.Agario.events.AgarCellMoveEvent;
import me.Brian.Agario.manager.CellManager;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.scheduler.BukkitScheduler;

public class MainScheduler {
	public static void startScheduler() {
		BukkitScheduler scheduler = Agario.getInstance().getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(Agario.getInstance(), new Runnable() {
			@Override
			public void run() {
				Bukkit.getWorld("world").playEffect(((FoodCell)CellManager.getCell(Agario.indicator)).getLocation(), Effect.COLOURED_DUST, 5);
				Bukkit.getServer().getPluginManager().callEvent(new AgarCellMoveEvent());
			}
		}, 0L, 1L);
	}
}
