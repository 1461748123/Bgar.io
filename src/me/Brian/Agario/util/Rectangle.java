package me.Brian.Agario.util;

import me.Brian.Agario.cell.Cell;

public class Rectangle {
	private Point up;
	private Point down;

	public Rectangle(Point up, Point down) {
		setUp(up);
		setDown(down);
	}

	public Rectangle(Cell cell) {
		setUp(SlimeUtil.getUpCorner(cell));
		setDown(SlimeUtil.getDownCorner(cell));
	}

	public Point getUp() {
		return up;
	}

	public void setUp(Point up) {
		this.up = up;
	}

	public Point getDown() {
		return down;
	}

	public void setDown(Point down) {
		this.down = down;
	}

}
