package com.github.brigade.map;

public enum EnumMapSize {
	Tiny(32), Small(64), Medium(128), Large(256), Huge(512);

	private final int size;

	EnumMapSize(int size) {
		this.size = size;;
	}

	public int getSize() {
		return size;
	}
}