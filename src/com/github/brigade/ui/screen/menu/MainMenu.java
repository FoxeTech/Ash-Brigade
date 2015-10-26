package com.github.brigade.ui.screen.menu;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.github.brigade.Game;
import com.github.brigade.exception.GroupOverflowException;
import com.github.brigade.map.MapPoint;
import com.github.brigade.render.Textures;
import com.github.brigade.ui.screen.component.ButtonAction;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.TexturedButton;
import com.github.brigade.ui.screen.component.UpdateButton;
import com.github.brigade.unit.UnitGroup;
import com.github.brigade.unit.data.EnumFaction;
import com.github.brigade.unit.unitClasses.TestUnit;

public class MainMenu extends MenuScreen {

	public static final int width = Display.getWidth() / 6;
	public static final int height = Display.getHeight() / 10;

	//here for testing/debugging purposes
	private static UnitGroup army1;
	private static UnitGroup army2;
	
	public MainMenu() {
		this(get(), "Main");
	}

	private static Component[] get() {
		ButtonAction ba1 = new ButtonAction() {
			@Override
			public void onClick() {

			}
		};
		ButtonAction ba2 = new ButtonAction() {
			@Override
			public void onClick() {
				generateArmies();
				Game.setScreen(new MenuInGame(Game.getMap().getMapData(), army1, army2));
			}
		};
		ButtonAction ba3 = new ButtonAction() {
			@Override
			public void onClick() {
				Game.setScreen(new OptionsMenu());
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
		TexturedButton tb6 = new TexturedButton(20, Display.getHeight() / 4 + 85 + 5 * height, width, height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 }, null,temp);
		return new Component[] { tb, tb1, tb2, tb3, tb4, tb5, tb6};
	}

	/**
	 * This method here only to create an army for debugging skirmish mode
	 */
	private static void generateArmies(){
		
		army1 = new UnitGroup(EnumFaction.Adesh, 1);
		army2 = new UnitGroup(EnumFaction.Reyan, 1);
		
		for(int i = 0; i < army1.getMaxUnits(); i++){
			try {
				army1.addUnit(new TestUnit(0, i, i, EnumFaction.Adesh));
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i < army2.getMaxUnits(); i++){
			try {
				army1.addUnit(new TestUnit(i+1, 0, i, EnumFaction.Reyan));
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public MainMenu(Component[] menuComponents, String screenName) {
		super(menuComponents, screenName);
	}

	@Override
	public void render(MapPoint[][] data) {}

}
