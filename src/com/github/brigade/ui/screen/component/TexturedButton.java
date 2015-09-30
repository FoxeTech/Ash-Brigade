package com.github.brigade.ui.screen.component;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.render.DrawUtil;
import com.github.brigade.render.Textures;
import com.github.brigade.ui.util.MouseInput;

public class TexturedButton extends Button {
	private final Texture[] imageStates;
	private ButtonAction action;

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
	public TexturedButton(int x, int y, int width, int height, Texture[] imageStates, ButtonAction action) {
		super(x, y, width, height);
		this.imageStates = imageStates;
		this.action = action;
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
	public TexturedButton(int x, int y, int width, int height, Texture image, ButtonAction action) {
		this(x, y, width, height, new Texture[] { image },action);
	}

	@Override
	public void onClick(int mouseID) {
		if(action != null && mouseID == MouseInput.LEFT){
			action.onClick();
		}
	}

	@Override
	public void render() {
		DrawUtil.drawRectangle(x - 6, y - 6, width + 12, height + 12, Textures.Map_Holder_Large);
		DrawUtil.drawRectangle(x, y, width, height, (imageStates.length > 1) ? (isMouseOver() ? imageStates[1] : imageStates[0]) : imageStates[0]);
	}
}
