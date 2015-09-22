package com.github.brigade.ui.screen.component;

import org.lwjgl.opengl.GL11;

public class Button extends Component {
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void onClick(int mouseID) {

	}

	public void render() {
		GL11.glColor3f(0.5f,0.5f,0.5f);
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2f(x, y);// Top Left
			GL11.glVertex2f(x + width, y);// Top Right
			GL11.glVertex2f(x + width, y + height);// Bottom Right
			GL11.glVertex2f(x, y + height); // Bottom Left
		}
		GL11.glEnd();
	}
}
