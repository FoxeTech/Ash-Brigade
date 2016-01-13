package com.github.brigade.unit;

import org.newdawn.slick.opengl.Texture;

public abstract class Unit {
	protected int x, y;
	protected final int origX, origY;

	protected Texture texture;

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
		y = origY;
	}

	public Unit(int origX, int origY, Texture texture) {
		this.origX = origX;
		this.origY = origY;
		this.texture = texture;
		x = origX;
		y = origY;
	}

	/**
	 * Returns the x position of the unit
	 * 
	 * @return Returns the x position of the unit
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y position of the unit
	 * 
	 * @return Returns the y position of the unit
	 */
	public int getY() {
		return y;
	}

	/**
	 * Returns the original x value of the unit
	 * 
	 * @return Returns the original x value of the unit
	 */
	public int getOriginalX() {
		return origX;
	}

	/**
	 * Returns the original y value of the unit
	 * 
	 * @return Returns the y value of the unit
	 */
	public int getOriginalY() {
		return origY;
	}

	public Texture getTexture() {
		return texture;
	}

	/**
	 * Sets the x position of the unit
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the y position of the unit
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
}
