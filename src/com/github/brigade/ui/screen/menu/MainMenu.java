package com.github.brigade.ui.screen.menu;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.github.brigade.render.Textures;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.TexturedButton;

public class MainMenu extends MenuScreen{

	public static final int width = Display.getWidth() / 6;
	public static final int height = Display.getHeight() / 10;
	public MainMenu() {
		this(new Component[] { 
				new TexturedButton(Display.getWidth()/4,20,Display.getWidth()/2,Display.getHeight()/4,Textures.placeHolder1,new MenuInGame()),
				new TexturedButton(20,Display.getHeight()/4 + 25,width,height,new Texture[]{Textures.placeHolder1,Textures.placeHolder2},null),
				new TexturedButton(20,Display.getHeight()/4 + 25 + height,width,height,new Texture[]{Textures.placeHolder1,Textures.placeHolder2},null),
				new TexturedButton(20,Display.getHeight()/4 + 25 + 2 * height,width,height,new Texture[]{Textures.tempOptionsFirst,Textures.tempOptionsSecond},new OptionsMenu()),
				new TexturedButton(20,Display.getHeight()/4 + 25 + 3 * height,width,height,new Texture[]{Textures.placeHolder1,Textures.placeHolder2},null),
				new TexturedButton(20,Display.getHeight()/4 + 25 + 4 * height,width,height,new Texture[]{Textures.placeHolder1,Textures.placeHolder2},null),
				new TexturedButton(20,Display.getHeight()/4 + 25 + 5 * height,width,height,new Texture[]{Textures.placeHolder1,Textures.placeHolder2},null)
		});
	}

	public MainMenu(Component[] menuComponents) {
		super(menuComponents);
	}

}
