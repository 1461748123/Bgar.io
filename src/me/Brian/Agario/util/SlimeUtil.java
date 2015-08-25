package me.Brian.Agario.util;

import me.Brian.Agario.cell.Cell;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Slime;

public class SlimeUtil {
	// south
	public static Point getUpCorner(Cell cell) {
		Location location = cell.getLocation();
		int size = SlimeUtil.getSize(cell.getMass());
		return new Point(location.getX() + (size * 0.25), location.getZ() + (size * 0.25));
	}
	
	public static Point getDownCorner(Cell cell) {
		Location location = cell.getLocation();
		int size = SlimeUtil.getSize(cell.getMass());
		return new Point(location.getX() - (size * 0.25), location.getZ() - (size * 0.25));
	}

	// east
	public static Location getLeftUpCorner(Location location, int size) {
		World world = location.getWorld();
		return new Location(world, location.getX() + (size * 0.25), location.getBlockY(), location.getZ() - (size * 0.25));
	}

	public static Location getLeftUpCorner(Cell cell) {
		return getLeftUpCorner(cell.getIndicator().getLocation(), getSize(cell.getMass()));
	}

	public static Location getLeftDownCorner(Location location, int size) {
		World world = location.getWorld();
		return new Location(world, location.getX() + (size * 0.25), location.getBlockY(), location.getZ() + (size * 0.25));
	}

	public static Location getRightUpCorner(Location location, int size) {
		World world = location.getWorld();
		return new Location(world, location.getX() - (size * 0.25), location.getBlockY(), location.getZ() - (size * 0.25));
	}

	public static Location getRightDownCorner(Location location, int size) {
		World world = location.getWorld();
		return new Location(world, location.getX() - (size * 0.25), location.getBlockY(), location.getZ() + (size * 0.25));
	}

	public static Location getRightDownCorner(Cell cell) {
		return getRightDownCorner(cell.getIndicator().getLocation(), getSize(cell.getMass()));
	}

	public static int getSize(int mass) {
		if (mass >= 1 && mass <= 50) {
			return 1;
		} else if (mass <= 150) {
			return 2;
		} else if (mass <= 300) {
			return 3;
		} else if (mass <= 500) {
			return 4;
		} else if (mass <= 750) {
			return 5;
		} else if (mass <= 1050) {
			return 6;
		} else if (mass <= 1500) {
			return 7;
		} else if (mass <= 2000) {
			return 8;
		} else if (mass <= 3000) {
			return 9;
		} else if (mass >= 3001) {
			return 10;
		} else {
			return 0;
		}
	}

}
