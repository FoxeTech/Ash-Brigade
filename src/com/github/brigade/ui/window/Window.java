package com.github.brigade.ui.window;

import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

import com.github.brigade.exception.DisplayException;

public class Window {
	private int width, height;
	private boolean fullscreen;

	/**
	 * Instantiates the window with a width, height, and if it will be
	 * fullscreen.
	 * 
	 * @param width
	 * @param height
	 * @param fullscreen
	 */
	public Window(int width, int height, boolean fullscreen) {
		this.width = width;
		this.height = height;
		this.fullscreen = fullscreen;
		try {
			setDisplayMode(width, height, fullscreen);
		} catch (DisplayException e) {
			JOptionPane.showMessageDialog(null, "Could not set up the game display with the current settings.\nSend this error to the devs!\n\n" + e.toString());
			exit();
		}
	}

	/**
	 * Sets up the display for the game window.
	 */
	public void setup() {
		try {
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}

	/**
	 * Disposes of the game display and exits the game.
	 */
	public void exit() {
		Display.destroy();
		System.exit(0);
	}

	/**
	 * Returns the width of the window
	 * @return Returns the width of the window
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height of the window
	 * @return Returns the height of the window
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns if the window is fullscreen
	 * @return
	 */
	public boolean isFullscreen() {
		return fullscreen;
	}

	/**
	 * Changes the width,height, and fullscreen status of the game window.
	 * 
	 * @param width
	 *            The new width
	 * @param height
	 *            The new height
	 * @param fullscreen
	 *            The new fullscreen status
	 * @throws DisplayException
	 *             Thrown if the display mode could not be retrieved
	 */
	public void setDisplayMode(int width, int height, boolean fullscreen) throws DisplayException {
		if ((Display.getDisplayMode().getWidth() == width) && (Display.getDisplayMode().getHeight() == height) && (Display.isFullscreen() == fullscreen)) {
			return;
		}
		try {
			DisplayMode targetDisplayMode = null;
			if (fullscreen) {
				DisplayMode[] modes = Display.getAvailableDisplayModes();
				int freq = 0;
				for (int i = 0; i < modes.length; i++) {
					DisplayMode current = modes[i];
					if ((current.getWidth() == width) && (current.getHeight() == height)) {
						if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {
							if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {
								targetDisplayMode = current;
								freq = targetDisplayMode.getFrequency();
							}
						}
						// if we've found a match for bpp and frequence against
						// the original display mode then it's probably best to
						// go for this one since it's most likely compatible
						// with the monitor
						if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) && (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) {
							targetDisplayMode = current;
							break;
						}
					}
				}
				this.fullscreen = true;
			} else {
				targetDisplayMode = new DisplayMode(width, height);
				this.fullscreen = false;
			}
			if (targetDisplayMode == null) {
				throw new DisplayException("Failed to find value mode: " + width + "x" + height + " fs=" + fullscreen);
			}
			Display.setDisplayMode(targetDisplayMode);
			Display.setFullscreen(fullscreen);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
}
