package me.Brian.Agario.cell;

import org.bukkit.Location;

import me.Brian.Agario.util.Point;

public class PointCell extends Cell {

	public PointCell(int mass, Location location) {
		super(mass, location);
		// TODO Auto-generated constructor stub
	}

	public Point getPoint() {
		return new Point(this);
	}

	public boolean isCollision(Cell otherCell) {
		if (otherCell instanceof PointCell) {
			return (getLocation().getX() == otherCell.getLocation().getX()
					&& getLocation().getY() == otherCell.getLocation().getY()
					&& getLocation().getZ() == otherCell.getLocation().getZ());
		} else if (otherCell instanceof SquareCell) {
			SquareCell squarecell = (SquareCell) otherCell;

			double X = getPoint().getX();
			double Z = getPoint().getZ();

			double maxX = squarecell.getHitbox().getUp().getX();
			double maxZ = squarecell.getHitbox().getUp().getZ();

			double minX = squarecell.getHitbox().getDown().getX();
			double minZ = squarecell.getHitbox().getDown().getZ();

			return (X > minX && X < maxX && Z > minZ && Z < maxZ);
		}
		return false;
	}

}
