package com.github.brigade.render;

import org.lwjgl.opengl.GL11;

public class DrawUtils {

	public static void drawRectangle(int x, int y, int width, int height) {
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x, y + height);
			GL11.glVertex2f(x + width, y + height);
			GL11.glVertex2f(x + width, y);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}
}
