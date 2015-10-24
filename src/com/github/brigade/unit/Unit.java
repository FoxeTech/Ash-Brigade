package com.github.brigade.unit;

public abstract class Unit {
	protected int x, y;
	protected final int origX, origY;

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

	/**
	 * Returns the x position of the unit
	 * @return Returns the x position of the unit
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y position of the unit
	 * @return Returns the y position of the unit
	 */
	public int getY() {
		return y;
	}

	/**
	 * Returns the original x value of the unit
	 * @return Returns the original x value of the unit
	 */
	public int getOriginalX() {
		return origX;
	}

	/**
	 * Returns the original y value of the unit
	 * @return Returns the y value of the unit
	 */
	public int getOriginalY() {
		return origY;
	}
	
	/**
	 * Sets the x position of the unit
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the y position of the unit
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}
