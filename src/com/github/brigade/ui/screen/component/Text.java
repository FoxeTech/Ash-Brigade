package com.github.brigade.ui.screen.component;

import com.github.brigade.render.DrawUtil;

public class Text extends Component{

	private String text;
	private float fontSize;
	
	public Text(int x, int y, int width, int height,String text,float fontSize) {
		super(x, y, width, height);
		this.text = text;
		this.fontSize = fontSize;
	}
	
	public float getFontSize(){
		return fontSize;
	}

	@Override
	public void onClick(int mouseID) {
		
	}

	@Override
	public void render() {
		DrawUtil.FONT.drawString(x,y,text);
	}

}
