package com.github.brigade.render;

import org.newdawn.slick.opengl.Texture;

public class Textures {
	public static Texture testTexture;
	
	public Textures(){
		testTexture = TextureUtil.loadTexture("test", "png");
	}
}
