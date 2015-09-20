package com.github.brigade;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.github.brigade.ui.util.MouseInput;
import com.github.brigade.ui.window.Window;

public class Game {
	private static Game instance;
	private final Window window;

	public Game() {
		instance = this;
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
			MouseInput.update();
			// NOTE: This while loop fucks mouse input up big-time.
			// Try the example test I set up with and without the while loop.
			// Alternatively having it in the render function works too...
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

	}
	
	private void update() {

	}

	/**
	 * Returns a static instance of the game.
	 */
	public static Game get() {
		return instance;
	}

	/**
	 * Returns the window object of the game.
	 */
	public Window getWindow() {
		return window;
	}
}
