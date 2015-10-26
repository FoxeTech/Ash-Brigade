package com.github.brigade.ui.screen.component;

import com.github.brigade.render.font.FontObj;

/**
 * Stores the font type and a string of text that can be displayed in a GUI
 * @author Craig
 *
 */
public class Text extends Component {
	private String text;
	private FontObj font;

	/**
	 * Creates a new Text object
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param text
	 * @param font
	 */
	public Text(int x, int y, int width, int height, String text, FontObj font) {
		super(x, y, width, height);
		this.text = text;
		this.font = font;
	}

	/**
	 * Returns the font object of the text object
	 * @return
	 */
	public FontObj getFontSize() {
		return font;
	}

	/**
	 * Handles if the text is clicked
	 */
	@Override
	public void onClick(int mouseID) {

	}

	/**
	 * Draws the text to the screen
	 */
	@Override
	public void render() {
		font.getTTF().drawString(x, y, text);
	}

	/**
	 * Updates the state of the text
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
