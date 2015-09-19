package com.github.brigade.render;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureUtil {
	/**
	 * Gets the Texture object of a file.
	 * 
	 * @param filename
	 *            The filename (Expected directory: 'res')
	 * @param extension
	 *            The file type
	 */	
	public static Texture loadTexture(String filename, String extension) {
		try {
			return TextureLoader.getTexture(extension, new FileInputStream(new File("res/" + filename + "." + extension)));
		} catch (IOException e) {
			System.out.println("Error Loading Texture");
		}
		return null;
	}
}
