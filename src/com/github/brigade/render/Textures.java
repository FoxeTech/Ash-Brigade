package com.github.brigade.render;

import org.newdawn.slick.opengl.Texture;

public class Textures {
	public static Texture testTexture;
	public static Texture placeHolder1;
	public static Texture placeHolder2;
	public static Texture Land;
	public static Texture Mountain;
	public static Texture Water;
	public static Texture Lava;
	public static Texture Trees;
	public static Texture Lewd;

	public static void setup() {
		testTexture = TextureUtil.loadTexture("test", "png");
		placeHolder1 = TextureUtil.loadTexture("PL1", "png");
		placeHolder2 = TextureUtil.loadTexture("PL2", "png");
	}
}
