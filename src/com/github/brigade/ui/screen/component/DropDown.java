package com.github.brigade.ui.screen.component;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.ui.util.MouseInput;

/**
 * A menu of buttons that can go up and down
 * @author Craig
 *
 */
public class DropDown extends Component{
	
	private TexturedButton button;
	private Component[] options;
	private boolean clicked;
	private ButtonAction action;
	private UpdateButton update;

	/**
	 * Creates a drop down menu
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param texture
	 * @param options
	 * @param action
	 * @param update
	 */
	public DropDown(int x, int y, int width, int height, Texture texture,Component[] options,ButtonAction action,UpdateButton update) {
		super(x, y, width, height);
		this.options = options;
		clicked = false;
		button = new TexturedButton(x,y,width,height,texture,action,update);
	}

	/**
	 * If the drop down menu is clicked events occur
	 */
	@Override
	public void onClick(int mouseID) {
		if(mouseID == MouseInput.LEFT){
			clicked = !clicked;
		}
	}

	/**
	 * Draws the drop down menu to the screen
	 */
	@Override
	public void render() {
		if(clicked){
			button.render();
			for(int i = 0; i < options.length;i++){
				options[i].setX(x);
				options[i].setY(options[i].getHeight() + y + (options[i].getHeight() * (i)));
				options[i].render();
			}
		}else{
			button.render();
		}
	}

	/**
	 * Updates the state of the drop down menu
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
