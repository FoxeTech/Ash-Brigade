package com.github.brigade;

import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.ARBMultisample;

import com.github.brigade.map.EnumMapSize;
import com.github.brigade.map.Map;
import com.github.brigade.map.MapPoint;
import com.github.brigade.render.GameTextureLevel;
import com.github.brigade.render.Resolution;
import com.github.brigade.render.Textures;
import com.github.brigade.ui.screen.Screen;
import com.github.brigade.ui.screen.menu.MainMenu;
import com.github.brigade.ui.screen.menu.MenuInGame;
import com.github.brigade.ui.screen.menu.MenuScreen;
import com.github.brigade.ui.util.MouseInput;
import com.github.brigade.ui.window.Window;

public class Game {
	// Options Variables
	public static boolean vsync = false;
	public static boolean vsync60 = false;
	public static boolean vsync30 = false;
	public static boolean msaa = false;
	public static GameTextureLevel textureLevel = GameTextureLevel.MEDIUM;
	public static Resolution gameResolution = Resolution.X1600x900;
	// End Options Variables
	private static Game instance;
	private final Map map;
	private final Window window;
	private final UserClient client;
	private int updateTicks;
	private Screen currentScreen;

	/**
	 * Initializes everything needed to create a window and start the game
	 */
	public Game() {
		instance = this;
		// TODO: Load from settings to get last display settings for the window
		int displayWidth = gameResolution.getWidth(), displayHeight = gameResolution.getHeight();
		boolean fullscreen = true;
		window = new Window(displayWidth, displayHeight, fullscreen);
		//
		String username = "test";
		String password = "password";
		client = new UserClient(username, password);
		client.setup();
		//
		map = new Map(EnumMapSize.Small);
	}

	public void run() {
		window.setup();// All textures loading code must go after window.setup
		Textures.setup();
		//
		map.generateTerrain();
		//
		currentScreen = new MainMenu();// currentScreen must be initialized
										// after textures have been loaded
		// setup();
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
			render(map.getMapData());
			Display.update();
			Display.sync(60);
		}
		window.exit();
	}

	/**
	 * Sets up network connections
	 */
	private void setup() {
		try {
			boolean isPlaying = true;
			boolean isHost = true;
			client.setGame("localhost", 7777, isPlaying, isHost);
			client.getConnection().setClientCount(2);
			client.joinGame();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Unable to create/connect client, abandon networking
	}

	/**
	 * Updates the mouse values and the screen
	 */
	private void update() {
		// client.getConnection().receive();
		MouseInput.update();
		currentScreen.update();
	}//meme

	private void render(MapPoint[][] data) {

		if (currentScreen.getScreenName().equalsIgnoreCase("Skirmish")) {
			((MenuInGame) currentScreen).render(data);
		} else {
			currentScreen.render();
		}
	}

	/**
	 * Draws the current screen to the screen
	 */
	private void render() {
		currentScreen.render();
		if (vsync) {
			if (vsync60) {
				Display.sync(60);
			} else if (vsync30) {
				Display.sync(30);
			}
		}
		if (msaa) {
			GL11.glEnable(ARBMultisample.GL_MULTISAMPLE_ARB);
		} else {
			GL11.glDisable(ARBMultisample.GL_MULTISAMPLE_ARB);
		}
	}

	/**
	 * Returns an instance of the current screen.
	 * 
	 * @return Returns an instance of the current screen
	 */
	public static Screen getCurrentScreen() {
		return instance.currentScreen;
	}

	/**
	 * Sets the screen to a new screen
	 * 
	 * @param screen
	 */
	public static void setScreen(MenuScreen screen) {
		instance.currentScreen = screen;
	}

	/**
	 * Returns the window object of the game.
	 */
	public static Window getWindow() {
		return instance.window;
	}

	/**
	 * Returns the UserClient instance of the game.
	 */
	public static UserClient getClient() {
		return instance.client;
	}

	/**
	 * Returns how many updates were performed in the last second.
	 */
	public int getUpdateTicks() {
		return updateTicks;
	}

	/**
	 * Returns the map
	 * 
	 * @return Returns the map
	 */
	public static Map getMap() {
		return instance.map;
	}

}
