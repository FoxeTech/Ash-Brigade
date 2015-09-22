package com.github.brigade.map;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.render.Textures;

public enum EnumTileType {
	Land(Textures.Land), Mountains(Textures.Mountain), Water(Textures.Water), Lava(Textures.Lava), Trees(Textures.Trees);

	private final Texture[] textures;

	EnumTileType(Texture[] textures) {
		this.textures = textures;
	}

	EnumTileType(Texture textures) {
		this(new Texture[] { textures });
	}

	public Texture[] getTextures() {
		return textures;
	}
}
