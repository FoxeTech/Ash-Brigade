package com.github.brigade.ui.util;

import org.lwjgl.input.Mouse;

import com.github.brigade.Game;

public class MouseInput {
	public final static int LEFT = 0, RIGHT = 1, MIDDLE = 2;
	private final static int CLICK_TICKS = 1;
	private static boolean leftDown, rightDown, middleDown;
	private static int clt, crt, cmt;
	private static int lastX, lastY;
	private static int lastXDiff, lastYDiff;

	/**
	 * Updates the following:
	 * <ul>
	 * <li>Last mouse X,Y coordinates</li>
	 * <li>Mouse down checks</li>
	 * </ul>
	 */
	public static void update() {
		if (clt > 0) {
			clt--;
		}
		if (crt > 0) {
			crt--;
		}
		if (cmt > 0) {
			cmt--;
		}
		boolean leftDownNow = isLeftDown();
		boolean rightDownNow = isRightDown();
		boolean middleDownNow = isMiddleDown();
		if (leftDown != leftDownNow) {
			clt = CLICK_TICKS;
		}
		if (rightDown != rightDownNow) {
			crt = CLICK_TICKS;
		}
		if (middleDown != middleDownNow) {
			cmt = CLICK_TICKS;
		}
		leftDown = leftDownNow;
		rightDown = rightDownNow;
		middleDown = middleDownNow;
		lastXDiff = Mouse.getX() - lastX;
		lastYDiff = Game.getWindow().getHeight() - Mouse.getY() - lastY;
		lastX = Mouse.getX();
		lastY = Game.getWindow().getHeight() - Mouse.getY();
	}

	/**
	 * Returns true if the left mouse button is down or false if it it up
	 * @return Returns true if the left mouse button is down or false if it is up
	 */
	public static boolean isLeftDown() {
		return Mouse.isButtonDown(LEFT);
	}

	/**
	 * Returns if the right mouse button is down or false if it is up
	 * @return Returns if the right mouse button is down or false if it is up
	 */
	public static boolean isRightDown() {
		return Mouse.isButtonDown(RIGHT);
	}

	/**
	 * Returns if the middle mouse button is down or false if it is up
	 * @return Returns if the middle mouse button is down or false if it is up
	 */
	public static boolean isMiddleDown() {
		return Mouse.isButtonDown(MIDDLE);
	}

	/**
	 * Returns true if the left mouse button was already clicked
	 * @return Returns true if the left mouse button was already clicked
	 */
	public static boolean hasClickedLeft() {
		return clt > 0;
	}

	/**
	 * Returns true if the right mouse button was already clicked
	 * @return Returns true if the right mouse button was already clicked
	 */
	public static boolean hasClickedRight() {
		return crt > 0;
	}

	/**
	 * Returns true if the middle mouse button was already click
	 * @return Returns true if the middle mouse button was already clicked
	 */
	public static boolean hasClickedMiddle() {
		return cmt > 0;
	}

	/**
	 * Returns the last value of x
	 * @return Returns the last value of x
	 */
	public static int getLastX() {
		return lastX;
	}

	/**
	 * Returns the last value of y
	 * @return Returns the last value of y
	 */
	public static int getLastY() {
		return lastY;
	}

	/**
	 * Returns the difference in the last x and the x values
	 * @return Returns the difference in the last x and the x values
	 */
	public static int getLastXDiff() {
		return lastXDiff;
	}

	/**
	 * Returns the difference in the last y and the y values
	 * @return Returns the difference in the last y and the y values
	 */
	public static int getLastYDiff() {
		return lastYDiff;
	}

	/**
	 * Returns the x position of the mouse
	 * @return Returns the x position of the mouse
	 */
	public static int getX() {
		return Mouse.getX();
	}

	/**
	 * Returns the y position of the mouse
	 * @return Returns the y position of the mouse
	 */
	public static int getY() {
		return Game.getWindow().getHeight() - Mouse.getY();
	}

}
