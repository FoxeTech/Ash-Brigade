package com.github.brigade.map.generation;
public class NoiseParameters {
	private final int width, height, directions;
	private final float contrast;
	private final float[] lerpMods;

	public NoiseParameters(int width, int height, int directions, float contrast, float[] lerpMods) {
		this.width = width;
		this.height = height;
		this.directions = directions;
		this.contrast = contrast;
		this.lerpMods = lerpMods;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDirections() {
		return directions;
	}

	public float getContrast() {
		return contrast;
	}

	public float getLerpModifier(int index) {
		return lerpMods[index];
	}
}