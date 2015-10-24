package com.github.brigade.ui.screen.menu;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.github.brigade.Game;
import com.github.brigade.render.Textures;
import com.github.brigade.ui.screen.component.ButtonAction;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.TexturedButton;
import com.github.brigade.ui.screen.component.UpdateButton;

/**
 * Stores everything on the main menu screen
 * @author Craig
 *
 */
public class MainMenu extends MenuScreen {

	public static final int width = Display.getWidth() / 6;
	public static final int height = Display.getHeight() / 10;

	/**
	 * Adds all of the GUI components to it
	 */
	public MainMenu() {
		this(get());
	}

	/**
	 * All of the GUI components to be added to the GUI
	 * @return All of the GUI components to be added to the GUI 
	 */
	private static Component[] get() {
		ButtonAction ba1 = new ButtonAction() {
			@Override
			public void onClick() {

			}
		};
		ButtonAction ba2 = new ButtonAction() {
			@Override
			public void onClick() {
				Game.setScreen(new MenuInGame());
			}
		};
		ButtonAction ba3 = new ButtonAction() {
			@Override
			public void onClick() {
				Game.setScreen(new OptionsMenu());
			}
		};
		ButtonAction ba4 = new ButtonAction(){
			
			@Override
			public void onClick(){
				System.exit(0);
			}
		};
		UpdateButton temp = new UpdateButton(){

			@Override
			public void updateSelected(TexturedButton button) {
								
			}
		};
		TexturedButton tb = new TexturedButton(Display.getWidth() / 4, 20, Display.getWidth() / 2, Display.getHeight() / 4, Textures.placeHolder1, ba1,temp);
		TexturedButton tb1 = new TexturedButton(20, Display.getHeight() / 4 + 25, width, height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 }, ba2,temp);
		TexturedButton tb2 = new TexturedButton(20, Display.getHeight() / 4 + 37 + height, width, height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 }, null,temp);
		TexturedButton tb3 = new TexturedButton(20, (Display.getHeight() / 4) + 49 + (2 * height), width, height, new Texture[] { Textures.OptionsFirst, Textures.OptionsSecond }, ba3,temp);
		TexturedButton tb4 = new TexturedButton(20, Display.getHeight() / 4 + 61 + 3 * height, width, height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 }, null,temp);
		TexturedButton tb5 = new TexturedButton(20, Display.getHeight() / 4 + 73 + 4 * height, width, height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 }, null,temp);
		TexturedButton tb6 = new TexturedButton(20, Display.getHeight() / 4 + 85 + 5 * height, width, height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 }, ba4,temp);
		return new Component[] { tb, tb1, tb2, tb3, tb4, tb5, tb6};
	}

	/**
	 * Adds all of the components to the Main Menu GUI
	 * @param menuComponents
	 */
	public MainMenu(Component[] menuComponents) {
		super(menuComponents);
	}

}
