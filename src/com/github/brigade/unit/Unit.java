package com.github.brigade.unit;

public abstract class Unit {
	private final int origX, origY;
	private int x, y;

	/**
	 * Instantiates the unit with an initial X and Y.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 */
	public Unit(int origX, int origY) {
		this.origX = origX;
		this.origY = origY;
		x = origX;
		x = origY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getOriginalX() {
		return origX;
	}

	public int getOriginalY() {
		return origY;
	}
}
