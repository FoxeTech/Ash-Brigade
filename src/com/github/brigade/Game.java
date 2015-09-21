package com.github.brigade;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.github.brigade.render.Textures;
import com.github.brigade.ui.screen.menu.ExampleMenu;
import com.github.brigade.ui.util.MouseInput;
import com.github.brigade.ui.window.Window;

public class Game {
	private static Game instance;
	private final Window window;
	private int updateTicks;
	private	ExampleMenu em;
	private Textures textures;

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
		window.setup();//All textures loading code must go after window.setup
		textures = new Textures();
		em = new ExampleMenu();

		long lastTime = System.nanoTime();
		double nanoCap = 1000000000.0 / (60.0);
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		while (!Display.isCloseRequested()) {
			GL11.glViewport(0, 0, window.getWidth(), window.getHeight());
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glLoadIdentity();
			long now = System.nanoTime();
			delta += (now - lastTime) / nanoCap;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta = 0;
				updates++;
			}
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				updateTicks = updates;
				updates = 0;
			}
			render();
			Display.update();
			Display.sync(60);
		}
		window.exit();
	}


	private void render() {
		em.render();
	}

	private void update() {
		MouseInput.update();
		em.update();
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
