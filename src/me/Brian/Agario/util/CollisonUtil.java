package me.Brian.Agario.util;

import me.Brian.Agario.cell.Cell;

import org.bukkit.Location;

public class CollisonUtil {

	public static boolean isCellCollison(Cell cell1, Cell cell2) {
		if (isCollsion(SlimeUtil.getLeftUpCorner(cell1), SlimeUtil.getLeftUpCorner(cell2), SlimeUtil.getRightDownCorner(cell2))
				&& isCollsion(SlimeUtil.getRightDownCorner(cell1), SlimeUtil.getLeftUpCorner(cell2), SlimeUtil.getRightDownCorner(cell2))) {
			if (isCollsion(SlimeUtil.getLeftUpCorner(cell2), SlimeUtil.getLeftUpCorner(cell1), SlimeUtil.getRightDownCorner(cell1))
					&& isCollsion(SlimeUtil.getRightDownCorner(cell2), SlimeUtil.getLeftUpCorner(cell1), SlimeUtil.getRightDownCorner(cell1))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isCollsion(Cell point, Cell rec) {
		double pointX = point.getIndicator().getLocation().getX();
		double pointZ = point.getIndicator().getLocation().getZ();

		double maxX = Math.max(SlimeUtil.getLeftUpCorner(rec).getX(), SlimeUtil.getRightDownCorner(rec).getX());
		double minX = Math.min(SlimeUtil.getLeftUpCorner(rec).getX(), SlimeUtil.getRightDownCorner(rec).getX());

		double maxZ = Math.max(SlimeUtil.getLeftUpCorner(rec).getZ(), SlimeUtil.getRightDownCorner(rec).getZ());
		double minZ = Math.min(SlimeUtil.getLeftUpCorner(rec).getZ(), SlimeUtil.getRightDownCorner(rec).getZ());
		return (pointX > minX && pointX < maxX && pointZ > minZ && pointZ < maxZ);
	}

	public static boolean isCollsion(Location point, Location rec1, Location rec2) {
		double maxX = Math.max(rec1.getX(), rec2.getX());
		double minX = Math.min(rec1.getX(), rec2.getX());

		double maxZ = Math.max(rec1.getZ(), rec2.getZ());
		double minZ = Math.min(rec1.getZ(), rec2.getZ());

		double x = point.getX();
		double z = point.getZ();

		return (x > minX && x < maxX && z > minZ && z < maxZ);

	}

	// south

//	public static boolean test(Cell pointcell, Cell reccell) {
//		Point point = new Point(pointcell);
//		Rectangle rec = new Rectangle(reccell);
//
//		return (point.getX() > rec.getDown().getX() && point.getX() < rec.getUp().getX() && point.getZ() > rec.getDown().getZ() && point.getZ() < rec.getUp().getZ());
//	}

}
