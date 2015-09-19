package com.github.brigade;

import java.awt.image.BufferedImage;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.github.brigade.map.EnumMapSize;
import com.github.brigade.map.Map;
import com.github.brigade.render.DrawUtils;
import com.github.brigade.render.TextureUtil;
import com.github.brigade.window.Window;

public class Game {
	private final Window window;

	public Game() {
		// TODO: Load from settings to get last display settings for the window
		int displayWidth = 500, displayHeight = 500;
		boolean fullscreen = false;
		window = new Window(displayWidth, displayHeight, fullscreen);
	}

	public void run() {
		// TODO: System.nanoTime() is more accurate, although with testing I
		// cannot get this or nanoTime to run on a lower framerate (I can't
		// figure out how to manually slow the game)
		window.setup();
		long lastTime = System.currentTimeMillis() / 1000;
		int deltaTime = 0;
		while (!Display.isCloseRequested()) {
			GL11.glViewport(0, 0, window.getWidth(), window.getHeight());
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glLoadIdentity();
			long currentTime = System.currentTimeMillis() / 1000;
			deltaTime += (currentTime - lastTime) * 60;
			lastTime = currentTime;
			while (deltaTime >= 1) {
				update();
				--deltaTime;
			}
			render();
			Display.update();
		}
		window.exit();
	}

	private void render() {
		Map test = new Map(EnumMapSize.Medium);
		test.generateTerrain();
		BufferedImage img = TextureUtil.resize(test, 500, 500, TextureUtil.SCALE_NEAREST_NEIGHBOR);
		Texture t = TextureUtil.loadTexture(img);
		DrawUtils.drawRectangle(0, 0, t.getImageWidth(), t.getImageHeight(), t);
	}

	private void update() {

	}
}
