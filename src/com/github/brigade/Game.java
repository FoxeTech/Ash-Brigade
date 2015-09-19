package com.github.brigade;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

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
			// This needs to be the last line of code in the while loop
		}
		window.exit();
	}

	private void render() {
		
	}

	private void update() {

	}
}
