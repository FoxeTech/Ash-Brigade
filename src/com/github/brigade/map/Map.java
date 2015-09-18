package com.github.brigade.map;

import com.github.brigade.exception.MapException;

public class Map {
	private final int width, height;
	private MapPoint[][] data;

	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		data = new MapPoint[width][height];
	}

	public void generateTerrain() {
		// NOTE: Not sure what kind of terrain generation everyone wants and if
		// using somebody else's Perlin Noise generator is OK with you.
		//
		// TODO: Creating the terrain
		// 1. Make int array same size as data (for height map generation)
		// 2. Generate height map based on noise generator
		// 3. Based on height, each point will be translated to a EnumTileType
		// 4. Save data to data array (X,Y,EnumTileType)
		// 5. Create image of field with the saved data
		// 6. Display image via OpenGL texture binding (Make this class extend
		// BufferedImage for simplicity's sake?)
		// 7. Battle with data array's information (Obstacles for pathing)
	}

	/**
	 * Gets map information of a point with given coordinates.
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @throws MapException
	 *             If the coordinates are outside of the map's bounds.
	 */
	public MapPoint getPoint(int x, int y) throws MapException {
		if ((x < 0 || x > width) || (y < 0 || y > height)) {
			throw new MapException("The given x,y coordinates are out of the map bounds: [" + width + "," + height + "]");
		}
		return data[x][y];
	}

	public MapPoint[][] getData() {
		return data;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
