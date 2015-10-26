package com.github.brigade.map;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import com.github.brigade.exception.MapException;
import com.github.brigade.map.generation.NoiseParameters;
import com.github.brigade.map.generation.PerlinNoise;
import com.github.brigade.unit.UnitGroup;
import com.github.brigade.unit.UnitLiving;

/**
 * <b>TODO</b>: Assosicate more data with map point and perhaps have multiple 2D
 * arrays for information storage. (Example: Another layer for adding trees and
 * other things)
 */
public class Map extends BufferedImage {
	private final static int HEIGHT_BEACH = 125, HEIGHT_LAND = 139, HEIGHT_HIGHLAND = 190, HEIGHT_MOUNTAIN = 220;
	private MapPoint[][] data;

	public Map(int size) {
		super(size, size, TYPE_INT_ARGB);
		data = new MapPoint[size][size];
	}

	public Map(EnumMapSize mapSize) {
		this(mapSize.getSize());
	}

	/**
	 * Generates layers of terrain and merges them into one realistic map.
	 */
	public void generateTerrain() {
		int octaves = 7;
		int w = getWidth();
		int h = getHeight();
		data = new MapPoint[w][h];
		HashMap<Integer, int[][]> maps = new HashMap<Integer, int[][]>();
		for (int oct = 0; oct < octaves; oct++) {
			int size = (oct + 1) * oct;
			float contrast = oct * 1.5f + 2;
			int map[][] = getHeightMap(w, h, size, contrast);
			maps.put(oct, map);
		}

		int out[][] = new int[w][h];
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				data[x][y] = new MapPoint(x, y);
			}
		}
		float persistance = 3f;
		for (int oct = 0; oct < octaves; oct++) {
			for (int x = 0; x < getWidth(); x++) {
				for (int y = 0; y < getHeight(); y++) {
					int height = (int) Math.floor(maps.get(oct)[x][y] * persistance);
					out[x][y] += height;
					data[x][y].addHeight(height);
				}
			}
			persistance /= 1.2f;
		}
		populate();
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				MapPoint mp = data[x][y];
				int height = mp.getHeight() / octaves;
				if (height > 255) {
					height = 255;
				}
				if (height < 0) {
					height = 0;
				}
				mp.setHeight(height);
				mp.setTileType( (height > HEIGHT_MOUNTAIN) ? EnumTileType.Mountains : 
								(height > HEIGHT_HIGHLAND) ? EnumTileType.Highland : 
								(height > HEIGHT_LAND) ? EnumTileType.Land : 
								(height > HEIGHT_BEACH) ? EnumTileType.Beach : EnumTileType.Water);
			}
		}
		sanitize();
		drawMap();
	}

	public void drawMap() {
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				int height = data[x][y].getHeight();
				Color color = getColor(height);
				setRGB(x, y, mix(color, height).getRGB());
			}
		}
	}

	private void populate() {
		// TODO: Add resources (trees, rare minerals and bonuses) to map)
		// TODO: Place player spawn points
	}
	
	private void sanitize() {
		// TODO: Clear out tiny islands
	}

	private int[][] getHeightMap(int w, int h, int noiseSize, float noiseContrast) {
		int[][] map = new int[w][h];
		int directions = 360;
		float[] lerpMods = { 1, 1, 1 };
		NoiseParameters noiseParams = new NoiseParameters(noiseSize, noiseSize, directions, noiseContrast, lerpMods);
		PerlinNoise noise = new PerlinNoise(noiseParams);
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				float xx = (float) x / getWidth() * noiseSize;
				float yy = (float) y / getHeight() * noiseSize;
				float n = (float) noise.getAt(xx, yy, noiseParams);
				n -= 0.2f;
				if (n < -1) {
					n = -1;
				}
				int height = (int) ((((n + 1) * 255) / 2f));
				map[x][y] = height;
			}
		}
		return map;
	}

	private Color mix(Color color, int height) {
		boolean isLand = true;
		boolean isBeach = false;
		if (height > HEIGHT_MOUNTAIN) {
			height = height + HEIGHT_MOUNTAIN;
		} else if (height > HEIGHT_HIGHLAND) {
			height = height + HEIGHT_HIGHLAND;
		} else if (height > HEIGHT_LAND) {
			height = height + HEIGHT_LAND;
		} else if (height > HEIGHT_BEACH) {
			isBeach = true;
			height = height + HEIGHT_BEACH;
		} else {
			isLand = false;
		}
		height /= 2;
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		if (isLand) {
			int red = (r + height * 3) / 4;
			int green = (g * 2 + height * 3) / 5;
			int blue = (b + height * 3) / 4 + 5;
			if (isBeach) {
				red += 40;
				green -= 10;
			}
			return new Color(red, green, blue);
		} else {
			int red = (r * 4 + height * 4) / 8;
			int green = (g * 2 + height * 4) / 6 + 20;
			int blue = (b * 2 + height * 5) / 7 + 20;
			return new Color(red, green, blue);
		}
	}

	private Color getColor(int height) {
		if (height > HEIGHT_BEACH) {
			if (height > HEIGHT_LAND) {
				if (height > HEIGHT_HIGHLAND) {
					if (height > HEIGHT_MOUNTAIN) {
						return new Color(120, 120, 120);
					}
					return new Color(20, 150, 80);
				}
				return new Color(15, 200, 40);
			}
			return new Color(170, 190, 30);
		} else {
			return new Color(20, 130, 210);
		}
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
		if ((x < 0 || x > getWidth()-1) || (y < 0 || y > getHeight()-1)) {
			throw new MapException("The given x,y coordinates are out of the map bounds: [" + getWidth() + "," + getHeight() + "]");
		}
		return data[x][y];
	}

	public MapPoint[][] getMapData() {
		return data;
	}
}
