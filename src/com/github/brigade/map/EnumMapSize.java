package com.github.brigade.map;

import java.awt.Dimension;

public enum EnumMapSize {
	Tiny(25, 25), Small(50, 50), Medium(100, 100), Large(200, 200), Huge(500, 500);

	private final Dimension size;

	EnumMapSize(int width, int height) {
		size = new Dimension(width, height);
	}

	public int getHeight() {
		return (int) size.getHeight();
	}

	public int getWidth() {
		return (int) size.getWidth();
	}

	public Dimension getSize() {
		return size;
	}
}