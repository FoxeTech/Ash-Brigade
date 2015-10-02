package com.github.brigade.ui.screen.component;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.ui.util.MouseInput;

public class DropDown extends Component{
	
	private TexturedButton button;
	private Component[] options;
	private boolean clicked;
	private ButtonAction action;
	private UpdateButton update;

	public DropDown(int x, int y, int width, int height, Texture texture,Component[] options,ButtonAction action,UpdateButton update) {
		super(x, y, width, height);
		this.options = options;
		clicked = false;
		button = new TexturedButton(x,y,width,height,texture,action,update);
	}

	@Override
	public void onClick(int mouseID) {
		if(mouseID == MouseInput.LEFT){
			clicked = !clicked;
		}
	}

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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
