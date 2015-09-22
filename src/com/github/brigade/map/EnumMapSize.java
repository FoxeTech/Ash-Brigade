package com.github.brigade.map;

public enum EnumMapSize {
	Tiny(25), Small(50), Medium(100), Large(200), Huge(500);

	private final int size;

	EnumMapSize(int size) {
		this.size = size;;
	}

	public int getSize() {
		return size;
	}
}