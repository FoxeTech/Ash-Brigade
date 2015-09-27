package com.github.brigade.ui.screen.component;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.github.brigade.map.Map;
import com.github.brigade.render.DrawUtil;
import com.github.brigade.render.TextureUtil;
import com.github.brigade.render.Textures;

public class MapDisplay extends Component {
	private Map lastMap;
	private Texture mapTexture;

	public MapDisplay(int x, int y, int resolution) {
		super(x, y, resolution, resolution);
	}

	public void onClick(int mouseID) {

	}

	public void setMap(Map map) {
		lastMap = map;
		mapTexture = TextureUtil.loadTexture(map);
	}

	public Map getLastMap() {
		return lastMap;
	}

	public void render() {
		if (mapTexture == null) {
			return;
		}
		GL11.glColor3f(0.4f, 0.4f, 0.4f);
		// DrawUtil.drawRectangle(x, y, width, height);
		GL11.glColor3f(1f, 1f, 1f);
		DrawUtil.drawRectangle(x + 5, y + 5, width - 10, height - 10, mapTexture);
		DrawUtil.drawRectangle(x, y, width, height, Textures.Map_Holder);

	}
}
