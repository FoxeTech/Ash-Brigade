package com.github.brigade.ui.screen.menu;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.render.Textures;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.TexturedButton;

public class ExampleMenu1 extends MenuScreen{
	public ExampleMenu1() {
		this(new Component[] { 
				new TexturedButton(20,20,100,50,new Texture[]{Textures.placeHolder1,Textures.placeHolder2})
				});
	}

	public ExampleMenu1(Component[] menuComponents) {
		super(menuComponents);
	}
}
