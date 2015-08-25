package me.Brian.Agario.listeners;

import me.Brian.Agario.cell.Cell;
import me.Brian.Agario.manager.CellManager;
import me.Brian.Agario.util.CollisonUtil;
import me.Brian.Agario.util.SlimeUtil;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;

public class ItemMergeListener implements Listener {
	//
	@EventHandler
	public void onItemMerge(ItemMergeEvent event) {
		Item from = event.getEntity();
		Item to = event.getTarget();

		if (from.getItemStack().getType() != Material.SLIME_BALL || to.getItemStack().getType() != Material.SLIME_BALL)
			return;

		if (from.getCustomName() == null || to.getCustomName() == null)
			return;
		
		event.setCancelled(true);

		Cell tocell = CellManager.getCell(to);
		Cell fromcell = CellManager.getCell(from);

		switch (tocell.getType()) {
		case "agarcell":

			switch (fromcell.getType()) {
			case "agarcell":
//				if (CollisonUtil.isCollsion(to.getLocation(), SlimeSizeUtil.getLeftUpCorner(from.getLocation(), SlimeSizeUtil.getSlimeSize(fromcell.getMass())),
//						SlimeSizeUtil.getRightDownCorner(from.getLocation(), SlimeSizeUtil.getSlimeSize(fromcell.getMass())))
//						|| CollisonUtil.isCollsion(from.getLocation(), SlimeSizeUtil.getLeftUpCorner(to.getLocation(), SlimeSizeUtil.getSlimeSize(tocell.getMass())),
//								SlimeSizeUtil.getRightDownCorner(to.getLocation(), SlimeSizeUtil.getSlimeSize(tocell.getMass())))) {
//					System.out.println("Collison");
//				}
				
				if (CollisonUtil.test(tocell, fromcell)||CollisonUtil.test(fromcell, tocell)){
					System.out.print("Collison");
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

	// @EventHandler
	// public void onItemMerge(ItemMergeEvent event) {
	// Entity from = event.getEntity();
	// Entity to = event.getTarget();
	// if (event.getEntity().getItemStack().getType() != Material.SLIME_BALL) {
	// from.remove();
	// to.remove();
	// return;
	// }
	//
	// if (from.getPassenger().getType() != EntityType.SLIME || to.getPassenger().getType() != EntityType.SLIME) {
	// from.remove();
	// to.remove();
	// from.getPassenger().remove();
	// to.getPassenger().remove();
	// return;
	// }
	//
	// Slime fromslime = (Slime) from.getPassenger();
	// Slime toslime = (Slime) to.getPassenger();
	//
	// Bukkit.broadcastMessage("to x: " + to.getLocation().getX());
	// Bukkit.broadcastMessage("to z: " + to.getLocation().getZ());
	// Bukkit.broadcastMessage("fromslimeconer x: " + SlimeSizeUtil.getSlimeConer(fromslime).getX());
	// Bukkit.broadcastMessage("fromslimeconer Z: " + SlimeSizeUtil.getSlimeConer(fromslime).getZ());
	// Bukkit.broadcastMessage("length: " + fromslime.getSize() * 0.5);
	//
	// Bukkit.broadcastMessage("From Slime: "
	// + isCollsion(to.getLocation().getX(), to.getLocation().getZ(), SlimeSizeUtil.getSlimeConer(fromslime).getX(), SlimeSizeUtil.getSlimeConer(fromslime).getZ(), fromslime.getSize() * 0.5,
	// fromslime.getSize() * 0.5));
	// Bukkit.broadcastMessage("To Slime: "
	// + isCollsion(from.getLocation().getX(), from.getLocation().getZ(), SlimeSizeUtil.getSlimeConer(toslime).getX(), SlimeSizeUtil.getSlimeConer(toslime).getZ(), toslime.getSize() * 0.5,
	// toslime.getSize() * 0.5));
	//
	// }
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
	// public static boolean isCollsion(double d, double e, double f, double g, double h, double i) {
	// return (d >= f && d <= f + h && e >= g && e <= g + i);
	// }

}
