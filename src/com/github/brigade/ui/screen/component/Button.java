package com.github.brigade.ui.screen.component;

import org.lwjgl.opengl.GL11;

import com.github.brigade.render.DrawUtil;
import com.github.brigade.render.Textures;

/**
 * A button used for GUIs
 * @author Matt
 * 
 */
public class Button extends Component {
	
	/**
	 * Creates a new button
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * If the mouse is clicked the id of the mouse button is passed in and an action is done
	 * @param mouseID
	 */
	public void onClick(int mouseID) {

	}


	/**
	 * Draws a button with hover over events
	 */
	public void render() {
		if (isMouseOver()) {
			GL11.glColor3f(0.9f, 1f, 0.9f);
		} else {
			GL11.glColor3f(1f, 0.9f, 0.9f);
		}
		DrawUtil.drawRectangle(x, y, width, height, Textures.Tile_Grad);
		GL11.glColor3f(1f, 1f, 1f);
		DrawUtil.drawRectangle(x, y, width, height, Textures.Tile_Holder);
	}

	/**
	 * Updates the button
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
