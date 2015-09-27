package com.github.brigade.ui.screen.component;

import org.lwjgl.opengl.GL11;

import com.github.brigade.render.DrawUtil;
import com.github.brigade.render.Textures;

public class Button extends Component {
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void onClick(int mouseID) {

	}


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
}
