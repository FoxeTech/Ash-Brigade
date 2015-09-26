package com.github.brigade.ui.screen.menu;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.github.brigade.render.Textures;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.DropDown;
import com.github.brigade.ui.screen.component.TexturedButton;

public class OptionsMenu extends MenuScreen{

	private static final int width = Display.getWidth() / 6;
	private static final int height = Display.getHeight() / 10;
	public OptionsMenu() {
		this(new Component[] { 
			new DropDown(20,20,100,50,Textures.testTexture,new Component[]{new TexturedButton(0,0,MainMenu.width,MainMenu.height,new Texture[]{Textures.placeHolder1,Textures.placeHolder2}),new TexturedButton(0,0,MainMenu.width,MainMenu.height,new Texture[]{Textures.placeHolder1,Textures.placeHolder2})})
		});
	}

	public OptionsMenu(Component[] menuComponents) {
		super(menuComponents);
	}

}
