package com.github.brigade.render;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.BufferedImageUtil;

public class TextureUtil {
	public static final int SCALE_NEAREST_NEIGHBOR = 1, SCALE_BILINEAR = 2, SCALE_BICUBIC = 3;
	/**
	 * Gets the Texture object of a file.
	 * 
	 * @param filename
	 *            The filename (Expected directory: 'res')
	 * @param extension
	 *            The file type
	 * @return Returns null if the file could not be found
	 */
	public static Texture loadTexture(String filename, String extension) {
		try {
			return TextureLoader.getTexture(extension, new FileInputStream(new File("res/" + filename + "." + extension)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Converts a BufferedImage into a Texture.
	 * 
	 * @param image
	 *            The image to load
	 * @return Returns null if the image could not be converted
	 */
	public static Texture loadTexture(BufferedImage image) {
		try {
			return BufferedImageUtil.getTexture("", image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Scales an image to a new size.
	 * 
	 * @param image
	 *            The original image
	 * @param width
	 *            The new width
	 * @param height
	 *            The new height
	 * @param scaleType
	 *            The scaling type. <br>
	 *            <ol type="1">
	 *            <li>TextureUtil.SCALE_NEAREST_NEIGHBOR</li>
	 *            <li>TextureUtil.SCALE_BILINEAR</li>
	 *            <li>TextureUtil.SCALE_BICUBIC</li>
	 *            </ol>
	 * @return Returns a TYPE_INT_RGB BufferedImage of the new size
	 */
	public static BufferedImage resize(BufferedImage image, int width, int height, int scaleType) {
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		double scaleX = (double) width / imageWidth;
		double scaleY = (double) height / imageHeight;
		AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
		AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, scaleType);
		return bilinearScaleOp.filter(image, new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
	}
}
