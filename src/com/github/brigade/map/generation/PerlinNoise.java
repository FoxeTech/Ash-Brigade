package com.github.brigade.map.generation;

import java.util.Random;

//TODO: Find and credit whoever wrote this
public class PerlinNoise {
	// Width and Height of the map.
	public int width, height;

	// Random directions of length 1.
	private Vec2[] values;

	/**
	 * Creates a noise map with specified dimensions.
	 *
	 * @param width
	 *            of the noise map.
	 * @param height
	 *            of the noise map.
	 */
	public PerlinNoise(NoiseParameters data) {
		this.width = data.getWidth();
		this.height = data.getHeight();
		// Create an array to store random directions.
		values = new Vec2[(width + 1) * (height + 1)];
		for (int y = 0; y < (height + 1); y++) {
			for (int x = 0; x < (width + 1); x++) {
				Random random = new Random(System.nanoTime());
				int rotation = random.nextInt(data.getDirections());
				// Store random direction of length 1 to our directions array.
				values[x + (y * width)] = Rotation.point(new Vec2(0, 0), new Vec2(0, -1), rotation);
			}
		}
	}

	public float getAt(float x, float y, NoiseParameters data) {
		// Grid cell coordinates in integer values.
		int gridTopLeft = (int) (Math.floor(x)); // Top-Left
		int gridTopLeft2 = (int) (Math.floor(y)); // Top-Left
		int gridBotRight = gridTopLeft + 1; // Down-Right
		int gridBotRight2 = gridTopLeft2 + 1; // Down-Right
		// Random directions.
		Vec2 randDirTopLeft = g(gridTopLeft, gridTopLeft2); // Top-Left
		Vec2 randDirTopRight = g(gridBotRight, gridTopLeft2); // Top-Right
		Vec2 randDirBotRight = g(gridBotRight, gridBotRight2); // Down-Right
		Vec2 randDirBotLeft = g(gridTopLeft, gridBotRight2); // Down-Left
		// Subtract grid cells values from the point specified.
		Vec2 deltaTopLeft = new Vec2(x - gridTopLeft, y - gridTopLeft2); // Top-Left
		Vec2 deltaTopRight = new Vec2(x - gridBotRight, y - gridTopLeft2); // Top-Right
		Vec2 deltaBotRight = new Vec2(x - gridBotRight, y - gridBotRight2); // Down-Right
		Vec2 deltaBotLeft = new Vec2(x - gridTopLeft, y - gridBotRight2); // Down-Left
		// Compute a dot product between random directions and corresponding
		// delta values.
		float topLeft = dot(randDirTopLeft, new Vec2(deltaTopLeft.x, deltaTopLeft.y)); // Top-Left
		float topRight = dot(randDirTopRight, new Vec2(deltaTopRight.x, deltaTopRight.y)); // Top-Right
		float botRight = dot(randDirBotRight, new Vec2(deltaBotRight.x, deltaBotRight.y)); // Down-Right
		float botLeft = dot(randDirBotLeft, new Vec2(deltaBotLeft.x, deltaBotLeft.y)); // Down-Left
		// Compute the weights for x and y axis.
		float weightX = weigh(deltaTopLeft.x);
		float weightY = weigh(deltaTopLeft.y);
		// Interpolate Top-Left(s) and Down-Left(v).
		// We can also call this LEFT
		float a = lerp(weightY, topLeft, botLeft) * data.getLerpModifier(0);
		// Interpolate Top-Right(t) and Down-Right(u)
		// We can also call this RIGHT
		float b = lerp(weightY, topRight, botRight) * data.getLerpModifier(1);
		// Interpolate LEFT(a) and RIGHT(b). We can
		// call this height(h)
		float h = lerp(weightX, a, b) * data.getLerpModifier(2);
		h *= data.getContrast(); // Multiply here so adjust contrast.
		// Make sure it is -1 to 1. If you don't change contrast, you don't have
		// to do this.
		if (h > 1) {
			h = 1;
		} else if (h < -1) {
			h = -1;
		}
		return h;
	}

	/**
	 * Computes a weight using S-curve function f(x) = 3 * (x * x) - 2 * (x * x
	 * * x).
	 *
	 * @param x
	 *            NOT as in axis, but as a variable.
	 */
	private float weigh(float x) {
		return (3 * (x * x)) - (2 * (x * x * x));
	}

	/**
	 * Interpolate between 2 values, using weight.
	 */
	private float lerp(float weight, float a, float b) {
		float result = a + (weight * (b - a));
		return result;
	}

	/**
	 * Compute a dot product. Example: dot product between (a, b) and (c, d) is:
	 * a * c + b * d
	 */
	private float dot(Vec2 v0, Vec2 v1) {
		return (v0.x * v1.x) + (v0.y * v1.y);
	}

	/**
	 * Get the random direction.
	 */
	private Vec2 g(int x, int y) {
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		if (x >= width) {
			x = width;
		}
		if (y >= height) {
			y = height;
		}
		return values[x + (y * width)];
	}

	public static class Vec2 {

		public float x, y;

		/**
		 * Just holds some float values.
		 *
		 * @param x
		 * @param y
		 */
		public Vec2(float x, float y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return (int) x;
		}

		public int getY() {
			return (int) y;
		}

	}

	public static class Rotation {

		/**
		 * Rotates specified point around pivot.
		 *
		 * @param pivot
		 *            to rotate around.
		 * @param point
		 *            to rotate around pivot.
		 * @param rotation
		 *            - how many degrees to rotate.
		 * @return a new point, which was created by rotating given point around
		 *         pivot by some degrees.
		 */
		public static Vec2 point(Vec2 pivot, Vec2 point, float rotation) {
			rotation *= Math.random() * 2;
			float rot = (float) ((1f / 180) * rotation * Math.PI);

			float x = point.x - pivot.x;
			float y = point.y - pivot.y;

			float newx = (float) ((x * Math.cos(rot)) - (y * Math.sin(rot)));
			float newy = (float) ((x * Math.sin(rot)) + (y * Math.cos(rot)));

			newx += pivot.x;
			newy += pivot.y;

			return new Vec2(newx, newy);
		}

	}
}
