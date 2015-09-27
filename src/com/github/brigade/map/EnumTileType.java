package com.github.brigade.map;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.render.Textures;

public enum EnumTileType {
	Land(Textures.Grass), 
	Beach(Textures.Sand), 
	Mountains(Textures.Snow), 
	Water(Textures.Water), 
	Lava(Textures.Lava), 
	Trees(Textures.Trees), 
	Dildo(Textures.Lewd), 
	Highland(Textures.ColdGrass);

	private final Texture[] textures;

	EnumTileType(Texture[] textures) {
		this.textures = textures;
	}

	EnumTileType(Texture texture) {
		this(new Texture[] { texture });
	}
	
	public Texture[] getTextures(){
		return textures;
	}
	
	public Texture getTexture(){
		return textures[0];
	}
}
