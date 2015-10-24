package com.github.brigade.render;

import org.lwjgl.opengl.GL11;

import org.newdawn.slick.opengl.Texture;

public class DrawUtil {
	/**
	 * Draws a texture at (x,y) with the width an hight parameters respectively
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param texture
	 */
	public static void drawRectangle(int x, int y, int width, int height, Texture texture) {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		texture.bind();
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(x, y);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(x, y + height);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(x + width, y + height);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(x + width, y);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}
	/**
	 * Draws a rectangle based on the x, y coordinates with a width and height. The rectangle is given a texture and is rotated
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param texture
	 * @param rotate
	 */
	public static void drawBlendRectangle(int x, int y, int width, int height, Texture texture, boolean rotate) {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		texture.bind();
		for (int mx = 0; mx < 3; mx++) {
			for (int my = 0; my < 3; my++) {
				GL11.glPushMatrix();
				float xOff = 0, yOff = 0;
				if (mx == 0) {
					xOff -= width;
				} else if (mx > 1f) {
					xOff += width;
				}
				if (my == 0) {
					yOff -= height;
				} else if (my > 1f) {
					yOff += height;
				}
				float topLeft = 0f;
				float topRight = 0f;
				float botLeft = 0f;
				float botRight = 0f;
				if (mx == 0 && my == 0) {
					if (rotate) {
						double angle = -90;
						GL11.glTranslated(x - width / 2, y - height / 2, 0);
						GL11.glRotated(angle, 0, 0, 1);
						GL11.glTranslated(-x + width / 2, -y + height / 2, 0);
						topLeft = 0f;
						topRight = 0f;
						botLeft = 1f;
						botRight = 0f;
					} else {
						topLeft = 0f;
						topRight = 0f;
						botLeft = 0f;
						botRight = 1f;
					}
				}
				if (mx == 1 && my == 0) {
					topLeft = 0f;
					topRight = 0f;
					botLeft = 1f;
					botRight = 1f;
				}
				if (mx == 2 && my == 0) {
					topLeft = 0f;
					topRight = 0f;
					botLeft = 1f;
					botRight = 0f;
				}
				if (mx == 0 && my == 1) {
					topLeft = 0f;
					topRight = 1f;
					botLeft = 0f;
					botRight = 1f;
				}
				if (mx == 1 && my == 1) {
					topLeft = 1f;
					topRight = 1f;
					botLeft = 1f;
					botRight = 1f;
				}
				if (mx == 2 && my == 1) {
					topLeft = 1f;
					topRight = 0f;
					botLeft = 1f;
					botRight = 0f;
				}
				if (mx == 0 && my == 2) {
					topLeft = 0f;
					topRight = 1f;
					botLeft = 0f;
					botRight = 0f;
				}
				if (mx == 1 && my == 2) {
					topLeft = 1f;
					topRight = 1f;
					botLeft = 0f;
					botRight = 0f;
				}
				if (mx == 2 && my == 2) {
					if (rotate) {
						double angle = 90;
						GL11.glTranslated(x + width / 2 + width * 2, y + height / 2, 0);
						GL11.glRotated(angle, 0, 0, 1);
						GL11.glTranslated(-x - width / 2, -y - height / 2, 0);
						topLeft = 0f;
						topRight = 0f;
						botLeft = 1f;
						botRight = 0f;
					} else {
						topLeft = 1f;
						topRight = 0f;
						botLeft = 0f;
						botRight = 0f;
					}
				}
				GL11.glBegin(GL11.GL_QUADS);
				{
					GL11.glColor4f(1f, 1f, 1f, topLeft);
					GL11.glTexCoord2f(0, 0);
					GL11.glVertex2f(x + xOff, y + yOff);

					GL11.glColor4f(1f, 1f, 1f, botLeft);
					GL11.glTexCoord2f(0, 1);
					GL11.glVertex2f(x + xOff, y + height + yOff);

					GL11.glColor4f(1f, 1f, 1f, botRight);
					GL11.glTexCoord2f(1, 1);
					GL11.glVertex2f(x + xOff + width, y + height + yOff);

					GL11.glColor4f(1f, 1f, 1f, topRight);
					GL11.glTexCoord2f(1, 0);
					GL11.glVertex2f(x + xOff + width, y + yOff);
				}
				GL11.glEnd();
				GL11.glPopMatrix();
			}
		}
	}

	/**
	 * Draws a rectangle at (x,y)
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public static void drawRectangle(int x, int y, int width, int height) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(x, y);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(x, y + height);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(x + width, y + height);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(x + width, y);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}

}
