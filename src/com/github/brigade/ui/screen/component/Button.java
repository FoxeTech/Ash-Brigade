package com.github.brigade.ui.screen.component;

import org.lwjgl.opengl.GL11;

public class Button extends Component {
	// TODO: Remove example code.

	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void onClick(int mouseID) {
		f = 0.01f;
	}

	private float f = 1f;

	public void render() {
		GL11.glColor3f(isMouseOver() ? 0 : f, f, isMouseOver() ? 0 : f);
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2f(x, y);// Top Left
			GL11.glVertex2f(x + width, y);// Top Right
			GL11.glVertex2f(x + width, y + height);// Bottom Right
			GL11.glVertex2f(x, y + height); // Bottom Left
		}
		GL11.glEnd();
		if (f < 0.95f) {
			f += 0.0005f;
		}
	}
}
