package com.github.brigade.ui.screen.component;

import com.github.brigade.ui.util.MouseInput;

public abstract class Component {
	protected int x, y, width, height;

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

	public abstract void render();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
