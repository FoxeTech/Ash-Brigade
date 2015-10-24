package com.github.brigade.render.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

/**
 * Helper methods for loading fonts
 * @author Craig
 * @version 1.0.2
 */
public class FontUtil {
	/**
	 * Creates a FontObj given a font's filename and size.
	 * 
	 * @param filename
	 * @param size
	 */
	public static FontObj CreateFont(String filename, float size) {
		try {
			InputStream inputStream = ResourceLoader.getResourceAsStream("res/Fonts/" + filename);
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(size);
			return new FontObj(new TrueTypeFont(awtFont, false), size);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
		return null;
	}
}
