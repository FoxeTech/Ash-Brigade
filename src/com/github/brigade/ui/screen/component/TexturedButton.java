package com.github.brigade.ui.screen.component;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.Game;
import com.github.brigade.render.DrawUtil;

public class TexturedButton extends Button {
	private final Texture[] imageStates;
	private Object screen;

	/**
	 * Instantiates the TexturedButton with x,y,width,and height. Also gives the
	 * button a array of textures.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param imageStates
	 *            The button's array of Textures
	 */
	public TexturedButton(int x, int y, int width, int height, Texture[] imageStates, Object screen) {
		super(x, y, width, height);
		this.imageStates = imageStates;
		this.screen = screen;
	}
	
	/**
	 * Returns if the button is clicked
	 * @return
	 */

	/**
	 * Instantiates the TexturedButton with x,y,width,and height. Also gives the
	 * button a single textures.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 *            The button texture
	 */
	public TexturedButton(int x, int y, int width, int height, Texture image, Object screen) {
		this(x, y, width, height, new Texture[] { image },screen);
	}

	@Override
	public void onClick(int mouseID) {
		Game.setScreen(screen);
	}

	@Override
	public void render() {
		DrawUtil.drawRectangle(x, y, width, height, (imageStates.length > 1) ? (isMouseOver() ? imageStates[1] : imageStates[0]) : imageStates[0]);
	}
}
