package com.github.brigade.ui.util;

import org.lwjgl.input.Keyboard;

public class KeyboardInput {
	/**
	 * Returns if a keyboard key due to the string representation of a key is down
	 * @param key
	 * @return
	 */
	public static boolean isKeyDown(String key) {
		return Keyboard.isKeyDown(Keyboard.getKeyIndex(key.toUpperCase()));
	}

	/**
	 * Returns if a key is down based on its numerical representation
	 * @param key
	 * @return
	 */
	public static boolean isKeyDown(int key) {
		return Keyboard.isKeyDown(key);
	}
}
