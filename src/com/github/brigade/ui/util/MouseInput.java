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

	public static boolean isLeftDown() {
		return Mouse.isButtonDown(LEFT);
	}

	public static boolean isRightDown() {
		return Mouse.isButtonDown(RIGHT);
	}

	public static boolean isMiddleDown() {
		return Mouse.isButtonDown(MIDDLE);
	}

	public static boolean hasClickedLeft() {
		return clt > 0;
	}

	public static boolean hasClickedRight() {
		return crt > 0;
	}

	public static boolean hasClickedMiddle() {
		return cmt > 0;
	}

	public static int getLastX() {
		return lastX;
	}

	public static int getLastY() {
		return lastY;
	}

	public static int getLastXDiff() {
		return lastXDiff;
	}

	public static int getLastYDiff() {
		return lastYDiff;
	}

	public static int getX() {
		return Mouse.getX();
	}

	public static int getY() {
		return Game.getWindow().getHeight() - Mouse.getY();
	}

}
