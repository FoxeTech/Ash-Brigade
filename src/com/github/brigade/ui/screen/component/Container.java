package com.github.brigade.ui.screen.component;

import org.lwjgl.opengl.GL11;

import com.github.brigade.render.DrawUtil;

/**
 * Contains sub-components and passes information along to them.
 */
public class Container extends Component {
	private final Component[] components;

	public Container(int x, int y, int width, int height, Component[] components) {
		super(x, y, width, height);
		for (Component c : components) {
			c.setX(x + c.getX());
			c.setY(y + c.getY());
		}
		this.components = components;
	}

	@Override
	public void onClick(int mouseID) {
		for (Component c : components) {
			if (c.isMouseOver()) {
				c.onClick(mouseID);
			}
		}
	}

	@Override
	public void render() {
		GL11.glColor4f(1f, 0.8f, 0.8f, 0.1f);
		DrawUtil.drawRectangle(x, y, width, height);
		GL11.glColor3f(1f, 1f, 1f);
		for (Component c : components) {
			c.render();
		}
	}

	public Component[] getComponents() {
		return components;
	}

	public Component getComponent(int index) {
		return components[index];
	}
}
