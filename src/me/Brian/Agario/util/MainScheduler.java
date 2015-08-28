package me.Brian.Agario.util;

import me.Brian.Agario.Agario;
import me.Brian.Agario.cell.SquareCell;
import me.Brian.Agario.events.AgarCellMoveEvent;
import me.Brian.Agario.manager.CellManager;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitScheduler;

public class MainScheduler {
	public static void startScheduler() {
		BukkitScheduler scheduler = Agario.getInstance().getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(Agario.getInstance(), new Runnable() {
			@Override
			public void run() {
				SquareCell sc = (SquareCell) CellManager.getCell(Agario.indicator);
				Bukkit.getWorld("world").playEffect(new Location(sc.getLocation().getWorld(), sc.getHitbox().getUp().getX(), sc.getLocation().getY(), sc.getHitbox().getUp().getZ()), Effect.COLOURED_DUST, 1);
				Bukkit.getWorld("world").playEffect(new Location(sc.getLocation().getWorld(), sc.getHitbox().getDown().getX(), sc.getLocation().getY(), sc.getHitbox().getDown().getZ()), Effect.COLOURED_DUST, 1);
				Bukkit.getWorld("world").playEffect(new Location(sc.getLocation().getWorld(), sc.getCollisionbox().getUp().getX(), sc.getLocation().getY(), sc.getCollisionbox().getUp().getZ()), Effect.COLOURED_DUST, 1);
				Bukkit.getWorld("world").playEffect(new Location(sc.getLocation().getWorld(), sc.getCollisionbox().getDown().getX(), sc.getLocation().getY(), sc.getCollisionbox().getDown().getZ()), Effect.COLOURED_DUST, 1);

				Bukkit.getServer().getPluginManager().callEvent(new AgarCellMoveEvent());
			}
		}, 0L, 1L);
	}
}
