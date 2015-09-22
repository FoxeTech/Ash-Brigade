package com.github.brigade.map;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.render.Textures;

public enum EnumTileType {
	Land(Textures.Land), Mountains(Textures.Mountain), Water(Textures.Water), Lava(Textures.Lava), Trees(Textures.Trees), Dildo(Textures.Lewd);

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
