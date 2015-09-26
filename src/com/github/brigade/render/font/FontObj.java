package com.github.brigade.render.font;

import org.newdawn.slick.TrueTypeFont;

public class FontObj {
	private TrueTypeFont ttf;
	private float size;

	public FontObj(TrueTypeFont ttf, float size) {
		this.ttf = ttf;
		this.size = size;
	}

	public TrueTypeFont getTTF() {
		return ttf;
	}

	public void setTTF(TrueTypeFont ttf) {
		this.ttf = ttf;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}
}
