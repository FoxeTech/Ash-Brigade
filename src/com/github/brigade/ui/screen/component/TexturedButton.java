package com.github.brigade.ui.screen.component;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.Game;
import com.github.brigade.render.DrawUtil;
import com.github.brigade.ui.screen.menu.MainMenu;
import com.github.brigade.ui.screen.menu.MenuInGame;
import com.github.brigade.ui.screen.menu.OptionsMenu;
import com.github.brigade.ui.util.MouseInput;

public class TexturedButton extends Button {
	private final Texture[] imageStates;
	private ButtonActions action;

	/**
	 * Instantiates the TexturedButton with x,y,width,and height. Also gives the
	 * button a array of textures.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param imageStates
	 *            The button's array of Textures
	 */
	public TexturedButton(int x, int y, int width, int height, Texture[] imageStates, ButtonActions action) {
		super(x, y, width, height);
		this.imageStates = imageStates;
		this.action = action;
	}
	
	/**
	 * Returns if the button is clicked
	 * @return
	 */

	/**
	 * Instantiates the TexturedButton with x,y,width,and height. Also gives the
	 * button a single textures.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 *            The button texture
	 */
	public TexturedButton(int x, int y, int width, int height, Texture image, ButtonActions action) {
		this(x, y, width, height, new Texture[] { image },action);
	}

	@Override
	public void onClick(int mouseID) {
		if(mouseID == MouseInput.LEFT){
			if(action == ButtonActions.changeScreenToMainMenu){
				Game.setScreen(new MainMenu());
			}else if(action == ButtonActions.changeScreenToOptionsMenu){
				Game.setScreen(new OptionsMenu());
			}else if(action == ButtonActions.changeScreeToGame){
				Game.setScreen(new MenuInGame());
			}else if(action == ButtonActions.toggleMSAA){
				Game.msaa = !Game.msaa;
			}else if(action == ButtonActions.toggleVsync){
				Game.vsync = !Game.vsync;
				Game.vsync60 = true;
			}else if(action == ButtonActions.toggleVsync30){
				Game.vsync30 = !Game.vsync30;
				if(Game.vsync30){
					Game.vsync = true;
				}else{
					Game.vsync = false;
				}
			}else if(action == ButtonActions.toggleVsync60){
				Game.vsync60 = !Game.vsync60;
				if(Game.vsync60){
					Game.vsync = true;
				}else{
					Game.vsync = false;
				}
			}
		}
	}

	@Override
	public void render() {
		DrawUtil.drawRectangle(x, y, width, height, (imageStates.length > 1) ? (isMouseOver() ? imageStates[1] : imageStates[0]) : imageStates[0]);
	}
}
