package com.github.brigade.render;

import org.lwjgl.opengl.GL11;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.font.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.ResourceLoader;

public class DrawUtil {

	public static TrueTypeFont FONT;
	public static float FONT_SIZE;

	public static void CreateString(String filename,float size){
		try{
			InputStream inputStream = ResourceLoader.getResourceAsStream("res/Fonts/" + filename);
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(size);
			FONT = new TrueTypeFont(awtFont,false);
			FONT_SIZE = size;
		}catch(FileNotFoundException e){
			CreateString("Xeranthemum.ttf",24f);
			e.printStackTrace();
		} catch (FontFormatException e) {
			CreateString("Xeranthemum.ttf",24f);
			e.printStackTrace();
		} catch (IOException e) {
			CreateString("Xeranthemum.ttf",24f);
			e.printStackTrace();
		}
	}

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
