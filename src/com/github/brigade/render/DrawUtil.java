package com.github.brigade.render;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class DrawUtil {

	public static void drawRectangle(int x, int y, int width, int height, Texture texture) {
		GL11.glPushMatrix();
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
