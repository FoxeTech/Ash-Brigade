package com.github.brigade.ui.screen.menu;

import com.github.brigade.Game;
import com.github.brigade.ui.screen.component.Button;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.Container;

public class MenuInGame extends MenuScreen {
	public MenuInGame() {
		super(getComponents());
	}

	private static Component[] getComponents() {
		Button b1 = new Button(5, 5, 90, 90);
		//
		int h = Game.getWindow().getHeight();
		int w = Game.getWindow().getWidth();
		int contHeight = 100;
		int contTop = h - contHeight;
		Container container = new Container(0, contTop, w, contHeight, new Component[] { b1 });
		return new Container[] { container };
	}

}
