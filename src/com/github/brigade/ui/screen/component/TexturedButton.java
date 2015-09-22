package com.github.brigade.ui.screen.component;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.render.DrawUtil;

public class TexturedButton extends Button {
	private final Texture[] imageStates;

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
	public TexturedButton(int x, int y, int width, int height, Texture[] imageStates) {
		super(x, y, width, height);
		this.imageStates = imageStates;
	}

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
	public TexturedButton(int x, int y, int width, int height, Texture image) {
		this(x, y, width, height, new Texture[] { image });
	}

	@Override
	public void onClick(int mouseID) {

	}

	@Override
	public void render() {
		DrawUtil.drawRectangle(x, y, width, height, (imageStates.length > 1) ? (isMouseOver() ? imageStates[1] : imageStates[0]) : imageStates[0]);
	}
}
