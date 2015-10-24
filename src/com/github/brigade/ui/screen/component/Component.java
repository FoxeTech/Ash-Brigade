package com.github.brigade.ui.screen.component;

import com.github.brigade.ui.util.MouseInput;

/**
 * A basic representation of a GUI component
 * @author Matt
 *
 */
public abstract class Component {
	protected int x, y, width, height;

	/**
	 * Creates a new Component
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Component(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Called when the mouse is clicked on a menu.
	 * 
	 * @param mouseID
	 *            Mouse IDs:
	 *            <ul>
	 *            <li>0 = Left</li>
	 *            <li>1 = Right</li>
	 *            <li>2 = Middle</li>
	 *            </ul>
	 */
	public abstract void onClick(int mouseID);
	/**
	 * Updates the state of the button
	 */
	public abstract void update();

	/**
	 * Returns if the mouse is over the component.
	 */
	public boolean isMouseOver() {
		int mx = MouseInput.getX();
		int my = MouseInput.getY();
		boolean hCheck = mx > x && mx < x + width;
		boolean vCheck = my > y && my < y + height;
		return (hCheck && vCheck);
	}

	/**
	 * Draws the button
	 */
	public abstract void render();

	/**
	 * Returns the value of the x position
	 * @return Returns the value of the x position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the value of x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the value of y position
	 * @return Returns the value of the y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the value of y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns the width of the component
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the component
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Returns the height of the component
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of the component
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
