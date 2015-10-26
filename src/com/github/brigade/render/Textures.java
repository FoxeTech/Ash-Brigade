package com.github.brigade.render;

import org.newdawn.slick.opengl.Texture;

public class Textures {
	public static Texture testTexture;
	public static Texture placeHolder1;
	public static Texture placeHolder2;
	public static Texture OptionsFirst;
	public static Texture OptionsSecond;
	public static Texture vsyncOff;
	public static Texture vsyncOn;
	public static Texture vsyncOff30;
	public static Texture vsyncOn30;
	public static Texture vsyncOff60;
	public static Texture vsyncOn60;
	//
	public static Texture Map_Holder;
	public static Texture Map_Holder_Large;
	public static Texture Tile_Grad;
	public static Texture Tile_Holder;
	public static Texture Bar;
	public static Texture Bar_Upside;
	//
	public static Texture Grass;
	public static Texture ColdGrass;
	public static Texture Sand;
	public static Texture Snow;
	public static Texture Water;
	public static Texture Lava;
	public static Texture Mountain;
	public static Texture Trees;
	public static Texture Lewd;
	//
	public static Texture Test_Unit;

	public static void setup() {
		Test_Unit = TextureUtil.loadTexture("test", "png");
		Snow = TextureUtil.loadTexture("Tiles/snow", "png");
		ColdGrass = TextureUtil.loadTexture("Tiles/high_grass", "png");
		Grass = TextureUtil.loadTexture("Tiles/grass", "png");
		Sand = TextureUtil.loadTexture("Tiles/sand", "png");
		Water = TextureUtil.loadTexture("Tiles/water", "png");
		testTexture = TextureUtil.loadTexture("test", "png");
		placeHolder1 = TextureUtil.loadTexture("PL1", "png");
		placeHolder2 = TextureUtil.loadTexture("PL2", "png");
		Map_Holder = TextureUtil.loadTexture("holder", "png");
		Tile_Grad = TextureUtil.loadTexture("tile_grad", "png");
		Tile_Holder = TextureUtil.loadTexture("tile_holder", "png");
		Bar = TextureUtil.loadTexture("bar", "png");
		Bar_Upside = TextureUtil.loadTexture("bar_upside", "png");
		OptionsFirst = TextureUtil.loadTexture("Menu/Options_First","png");
		OptionsSecond = TextureUtil.loadTexture("Menu/Options_Second","png");
		vsyncOff = TextureUtil.loadTexture("Menu/Vsync_Off","png");
		vsyncOn = TextureUtil.loadTexture("Menu/Vsync_On","png");
		vsyncOff30 = TextureUtil.loadTexture("Menu/Vsync_Off_30","png");
		vsyncOn30 = TextureUtil.loadTexture("Menu/Vsync_On_30","png");
		vsyncOff60 = TextureUtil.loadTexture("Menu/Vsync_Off_60","png");
		vsyncOn60 = TextureUtil.loadTexture("Menu/Vsync_On_60","png");
		Map_Holder_Large = TextureUtil.loadTexture("holder_large", "png");
	}
}
