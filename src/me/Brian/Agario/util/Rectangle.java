package me.Brian.Agario.util;


public class Rectangle {
	private Point up;
	private Point down;

	public Rectangle(Point up, Point down) {
		setUp(up);
		setDown(down);
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
