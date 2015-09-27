package com.github.brigade.ui.screen.menu;

import com.github.brigade.ui.screen.Screen;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.util.MouseInput;

public abstract class MenuScreen extends Screen {

	private final Component[] menuComponents;

	/**
	 * Instantiates the MenuScreen with an array of components.
	 * 
	 * @param menuComponents
	 *            The menu components
	 */
	public MenuScreen(Component[] menuComponents) {
		this.menuComponents = menuComponents;
	}

	/**
	 * Checks for mouse input for the components on the screen.
	 */
	@Override
	public void update() {
		if (menuComponents == null) {
			return;
		}
		for (Component component : menuComponents) {
			if (component.isMouseOver()) {
				if (MouseInput.hasClickedLeft() && MouseInput.isLeftDown()) {
					component.onClick(MouseInput.LEFT);
				}
				if (MouseInput.hasClickedRight() && MouseInput.isRightDown()) {
					component.onClick(MouseInput.RIGHT);
				}
				if (MouseInput.hasClickedMiddle() && MouseInput.isMiddleDown()) {
					component.onClick(MouseInput.MIDDLE);
				}
			}
		}
	}

	/**
	 * Renders the components onto the screen.
	 */
	@Override
	public void render() {
		for (Component component : menuComponents) {
			component.render();
		}
	}
}
