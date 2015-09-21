package com.github.brigade.render;

import org.newdawn.slick.opengl.Texture;

public class Textures {
	public static final Texture testTexture;
	public static final Texture placeHolder1;
	public static final Texture placeHolder2;

	static{
		testTexture = TextureUtil.loadTexture("test", "png");
		placeHolder1 = TextureUtil.loadTexture("PL1", "png");
		placeHolder2 = TextureUtil.loadTexture("PL2", "png");
	}
}
