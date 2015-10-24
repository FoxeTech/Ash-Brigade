package com.github.brigade.render.font;

import org.newdawn.slick.TrueTypeFont;

/**
 * A class that is used to set and change fonts
 * @author Craig
 */
public class FontObj {
	private TrueTypeFont ttf;
	private float size;

	/**
	 * Takes in a font and a size
	 * @param ttf
	 * @param size
	 */
	public FontObj(TrueTypeFont ttf, float size) {
		this.ttf = ttf;
		this.size = size;
	}
	
	/**
	 * Returns the TrueTypeFont
	 * @return Returns the TrueTypeFont of the font
	 */
	public TrueTypeFont getTTF() {
		return ttf;
	}

	/**
	 * Changes the TrueTypeFont to the font passed in
	 * @param ttf
	 */
	public void setTTF(TrueTypeFont ttf) {
		this.ttf = ttf;
	}

	/**
	 * Returns the size of the font
	 * @return Returns the size of the font
	 */
	public float getSize() {
		return size;
	}

	/**
	 * Changes the size of the font
	 * @param size
	 */
	public void setSize(float size) {
		this.size = size;
	}
}
