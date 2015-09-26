package com.github.brigade.ui.screen.component;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.ui.util.MouseInput;

public class DropDown extends Component{
	
	private TexturedButton button;
	private Component[] options;
	private boolean clicked;

	public DropDown(int x, int y, int width, int height, Texture texture, Component[] options) {
		super(x, y, width, height);
		this.options = options;
		clicked = false;
		button = new TexturedButton(x,y,width,height,texture);
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
				options[i].setY(y + options[i].getHeight());
				options[i].render();
			}
		}else{
			button.render();
		}
	}

}
