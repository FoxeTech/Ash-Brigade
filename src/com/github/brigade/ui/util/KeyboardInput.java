package com.github.brigade.ui.util;

import org.lwjgl.input.Keyboard;

public class KeyboardInput {
	public static boolean isKeyDown(String key) {
		return Keyboard.isKeyDown(Keyboard.getKeyIndex(key.toUpperCase()));
	}

	public static boolean isKeyDown(int key) {
		return Keyboard.isKeyDown(key);
	}
}
