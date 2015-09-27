package com.github.brigade.ui.screen.menu;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.github.brigade.Game;
import com.github.brigade.render.Textures;
import com.github.brigade.render.font.FontObj;
import com.github.brigade.render.font.FontUtil;
import com.github.brigade.ui.screen.component.ButtonAction;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.DropDown;
import com.github.brigade.ui.screen.component.Text;
import com.github.brigade.ui.screen.component.TexturedButton;

public class OptionsMenu extends MenuScreen {

	private static final int width = Display.getWidth() / 6;
	private static final int height = Display.getHeight() / 10;

	public OptionsMenu() {
		super(get());
	}

	public static Component[] get() {
		FontObj font = FontUtil.CreateFont("Xeranthemum.ttf", 20);
		Text t = new Text(Display.getWidth() / 2 - 4 * ((int) (font.getSize())), 20, 0, 0, "Options", font);
		TexturedButton d = new TexturedButton(40,40,MainMenu.width,MainMenu.height,new Texture[]{Textures.placeHolder1,Textures.placeHolder2},
		new ButtonAction() {
			@Override
			public void onClick() {
				Game.setScreen(new MainMenu());
			}
		});
		//TexturedButton tb1 = new TexturedButton(0, 0, MainMenu.width, MainMenu.height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 },Game.previousScreen);
		//TexturedButton tb2 = new TexturedButton(0, 0, MainMenu.width, MainMenu.height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 },null);
		//DropDown d = new DropDown(20, 20, 100, 50, Textures.testTexture,null, new Component[] { tb1, tb2 });
		return new Component[] { t, d };
	}
}
