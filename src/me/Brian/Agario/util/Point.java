package me.Brian.Agario.util;

import me.Brian.Agario.cell.Cell;

public class Point {
	private double x;
	private double z;

	public Point(double x, double z) {
		setX(x);
		setZ(z);
	}

	public Point(Cell cell) {
		setX(cell.getLocation().getX());
		setZ(cell.getLocation().getZ());
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

}
