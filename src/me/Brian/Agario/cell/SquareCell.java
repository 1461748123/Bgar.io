package me.Brian.Agario.cell;

import org.bukkit.Location;

import me.Brian.Agario.util.Point;
import me.Brian.Agario.util.Rectangle;

public class SquareCell extends Cell {

	public SquareCell(int mass, Location location) {
		super(mass, location);
		// TODO Auto-generated constructor stub
	}

	public int getSize() {
		if (getMass() >= 1 && getMass() <= 50) {
			return 1;
		} else if (getMass() <= 150) {
			return 2;
		} else if (getMass() <= 300) {
			return 3;
		} else if (getMass() <= 500) {
			return 4;
		} else if (getMass() <= 750) {
			return 5;
		} else if (getMass() <= 1050) {
			return 6;
		} else if (getMass() <= 1500) {
			return 7;
		} else if (getMass() <= 2000) {
			return 8;
		} else if (getMass() <= 3000) {
			return 9;
		} else if (getMass() >= 3001) {
			return 10;
		} else {
			return 0;
		}
	}

	public Rectangle getHitbox() {
		Point uppoint = new Point(getLocation().getX() + (getSize() * 0.25), getLocation().getZ() + (getSize() * 0.25));
		Point downpoint = new Point(getLocation().getX() - (getSize() * 0.25),
				getLocation().getZ() - (getSize() * 0.25));
		return new Rectangle(uppoint, downpoint);
	}

	public Rectangle getCollisionbox() {
		Point uppoint = new Point(getLocation().getX() + (getSize() * 0.20), getLocation().getZ() + (getSize() * 0.20));
		Point downpoint = new Point(getLocation().getX() - (getSize() * 0.20),
				getLocation().getZ() - (getSize() * 0.20));
		return new Rectangle(uppoint, downpoint);
	}

	public boolean isCollision(Cell otherCell) {
		if (otherCell instanceof PointCell) {
			PointCell pointcell = (PointCell) otherCell;

			double X = pointcell.getPoint().getX();
			double Z = pointcell.getPoint().getZ();

			double maxX = getHitbox().getUp().getX();
			double maxZ = getHitbox().getUp().getZ();

			double minX = getHitbox().getDown().getX();
			double minZ = getHitbox().getDown().getZ();

			return (X > minX && X < maxX && Z > minZ && Z < maxZ);
		} else if (otherCell instanceof SquareCell) {
			return isCollison(this, (SquareCell) otherCell) || isCollison((SquareCell) otherCell, this);
		}
		return false;
	}

	private boolean isCollison(SquareCell cell1, SquareCell cell2) {
		double maxX1 = cell1.getHitbox().getUp().getX();
		double maxZ1 = cell1.getHitbox().getUp().getZ();

		double minX1 = cell1.getHitbox().getDown().getX();
		double minZ1 = cell1.getHitbox().getDown().getZ();

		double maxX2 = cell2.getHitbox().getUp().getX();
		double maxZ2 = cell2.getHitbox().getUp().getZ();

		double minX2 = cell2.getHitbox().getDown().getX();
		double minZ2 = cell2.getHitbox().getDown().getZ();

		return ((maxX2 < maxX1 && maxX2 > minX1 && maxZ2 < maxZ1 && maxZ2 > minZ1)
				&& (minX2 < maxX1 && minX2 > minX1 && minZ2 < maxZ1 && minZ2 > minZ1));
	}

	public boolean canConsume(Cell otherCell) {
		return (otherCell.getMass() * 1.1 < getMass());
	}

}
