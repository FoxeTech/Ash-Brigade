package com.github.brigade.ui.screen.component;

import com.github.brigade.render.font.FontObj;

public class Text extends Component {
	private String text;
	private FontObj font;

	public Text(int x, int y, int width, int height, String text, FontObj font) {
		super(x, y, width, height);
		this.text = text;
		this.font = font;
	}

	public FontObj getFontSize() {
		return font;
	}

	@Override
	public void onClick(int mouseID) {

	}

	@Override
	public void render() {
		font.getTTF().drawString(x, y, text);
	}
}
