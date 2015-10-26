package com.github.brigade.ui.screen.menu;

import org.lwjgl.input.Mouse;

import com.github.brigade.ui.screen.Screen;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.util.MouseInput;

/**
 * 
 * @author Matt
 *
 */
public abstract class MenuScreen extends Screen {

	private final Component[] menuComponents;

	/**
	 * Instantiates the MenuScreen with an array of components.
	 * 
	 * @param menuComponents
	 *            The menu components
	 */
	public MenuScreen(Component[] menuComponents, String screenName) {
		super(screenName);
		this.menuComponents = menuComponents;
	}

	/**
	 * Checks for mouse input for the components on the screen.
	 */
	@Override
	public void update() {
		super.update();
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
			component.update();
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
