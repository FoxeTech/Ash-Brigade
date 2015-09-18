package com.github.brigade.map;

public class MapPoint {
	private final int x, y;
	private EnumTileType tileType;

	/**
	 * Instantiates the point with X and Y positions and the tile type.
	 * 
	 * @param x
	 * @param y
	 * @param tileType
	 */
	public MapPoint(int x, int y, EnumTileType tileType) {
		this.x = x;
		this.y = y;
		this.tileType = tileType;
	}

	/**
	 * Instantiates the point with X and Y positions. Default tile type is Land.
	 * 
	 * @param x
	 * @param y
	 */
	public MapPoint(int x, int y) {
		this(x, y, EnumTileType.Land);
	}

	public EnumTileType getTileType() {
		return tileType;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
