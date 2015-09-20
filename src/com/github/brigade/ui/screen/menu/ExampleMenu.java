package com.github.brigade.ui.screen.menu;

import com.github.brigade.ui.screen.component.Button;
import com.github.brigade.ui.screen.component.Component;

public class ExampleMenu extends MenuScreen {

	public ExampleMenu() {
		this(new Component[] { 
				new Button(20, 20, 100, 50), new Button(130, 20, 100, 50), new Button(240, 20, 100, 50), new Button(350, 20, 100, 50),
				new Button(20, 80, 100, 50), new Button(130, 80, 100, 50), new Button(240, 80, 100, 50), new Button(350, 80, 100, 50),
				new Button(20, 140, 100, 50), new Button(130, 140, 100, 50), new Button(240, 140, 100, 50), new Button(350, 140, 100, 50),
				new Button(20, 200, 100, 50), new Button(130, 200, 100, 50), new Button(240, 200, 100, 50), new Button(350, 200, 100, 50),
				new Button(20, 260, 100, 50), new Button(130, 260, 100, 50), new Button(240, 260, 100, 50), new Button(350, 260, 100, 50)
				});
	}

	public ExampleMenu(Component[] menuComponents) {
		super(menuComponents);
	}

}