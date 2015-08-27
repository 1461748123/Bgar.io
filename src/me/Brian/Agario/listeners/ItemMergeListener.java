package me.Brian.Agario.listeners;

import me.Brian.Agario.cell.Cell;
import me.Brian.Agario.cell.SquareCell;
import me.Brian.Agario.manager.CellManager;

import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;

public class ItemMergeListener implements Listener {
	//
	@EventHandler
	public void onItemMerge(ItemMergeEvent event) {
		Item from = event.getEntity();
		Item to = event.getTarget();

		Cell tocell = CellManager.getCell(to);
		Cell fromcell = CellManager.getCell(from);

		if (tocell == null || fromcell == null)
			return;

		event.setCancelled(true);

		if (!(tocell instanceof SquareCell) && !(fromcell instanceof SquareCell))
			return;

		if (tocell.isCollision(fromcell) || fromcell.isCollision(tocell)) {
			Cell maxcell = Cell.getMax(tocell, fromcell);
			Cell mincell = Cell.getMin(tocell, fromcell);

			if (maxcell instanceof SquareCell) {
				SquareCell squarecell = (SquareCell) maxcell;
				if (squarecell.canConsume(mincell)) {
					// do sth
				}
			}
		}

	}

	//
	public static boolean isCollsion(Location point, Location rec1, Location rec2) {
		double maxX = Math.max(rec1.getX(), rec2.getX());
		double minX = Math.min(rec1.getX(), rec2.getX());

		double maxZ = Math.max(rec1.getZ(), rec2.getZ());
		double minZ = Math.min(rec1.getZ(), rec2.getZ());

		double x = point.getX();
		double z = point.getZ();

		return (x > minX && x < maxX && z > minZ && z < maxZ);

	}

	//
	// /**
	// *
	// * @param d 点
	// * @param e 点
	// * @param f 矩形view x
	// * @param g 矩形view y
	// * @param h 矩形view 宽
	// * @param i 矩形view 高
	// * @return
	// */
	// public static boolean isCollsion(double d, double e, double f, double g,
	// double h, double i) {
	// return (d >= f && d <= f + h && e >= g && e <= g + i);
	// }

}
