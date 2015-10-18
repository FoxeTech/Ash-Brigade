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
import com.github.brigade.ui.screen.component.UpdateButton;

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
		},new UpdateButton(){
			@Override
			public void updateSelected(TexturedButton button){
				
			}
		});
		TexturedButton vsync = new TexturedButton(40,50 + MainMenu.height,MainMenu.width,MainMenu.height,new Texture[]{Textures.vsyncOff,Textures.vsyncOn},
		new ButtonAction(){
			@Override
			public void onClick(){
				Game.vsync = !Game.vsync;
				Game.vsync60 = !Game.vsync60;
				if(Game.vsync30){
					Game.vsync30 = false;
				}
			}
		},Game.vsync,new UpdateButton(){
			@Override
			public void updateSelected(TexturedButton button){
				if(Game.vsync){
					button.setSelected(true);
				}else{
					button.setSelected(false);
				}
			}
		});
		TexturedButton vsync30 = new TexturedButton(40,60 + 2 * MainMenu.height,MainMenu.width,MainMenu.height,new Texture[]{Textures.vsyncOff30,Textures.vsyncOn30},
		new ButtonAction(){
			@Override
			public void onClick(){
				Game.vsync30 = !Game.vsync30;
				Game.vsync = Game.vsync30;
				if(Game.vsync60){
					Game.vsync60 = false;
				}
			}
		},Game.vsync30,new UpdateButton(){
			@Override
			public void updateSelected(TexturedButton button){
				if(Game.vsync30){
					button.setSelected(true);
				}else{
					button.setSelected(false);
				}
			}
		});
		TexturedButton vsync60 = new TexturedButton(40,70 + 3 * MainMenu.height,MainMenu.width,MainMenu.height,new Texture[]{Textures.vsyncOff60,Textures.vsyncOn60},
		new ButtonAction(){
			@Override
			public void onClick(){
				Game.vsync60 = !Game.vsync60;
				Game.vsync = Game.vsync60;
				if(Game.vsync30){
					Game.vsync30 = false;
				}
			}
		},Game.vsync60,new UpdateButton(){
			@Override
			public void updateSelected(TexturedButton button){
				if(Game.vsync60){
					button.setSelected(true);
				}else{
					button.setSelected(false);
				}
			}
		});
		//TexturedButton tb1 = new TexturedButton(0, 0, MainMenu.width, MainMenu.height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 },Game.previousScreen);
		//TexturedButton tb2 = new TexturedButton(0, 0, MainMenu.width, MainMenu.height, new Texture[] { Textures.placeHolder1, Textures.placeHolder2 },null);
		//DropDown d = new DropDown(20, 20, 100, 50, Textures.testTexture,null, new Component[] { tb1, tb2 });
		return new Component[] { t, d, vsync, vsync30, vsync60 };
	}
}
