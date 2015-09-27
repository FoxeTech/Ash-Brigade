package com.github.brigade.ui.screen.menu;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.github.brigade.Game;
import com.github.brigade.exception.MapException;
import com.github.brigade.map.EnumTileType;
import com.github.brigade.map.MapPoint;
import com.github.brigade.render.DrawUtil;
import com.github.brigade.render.Textures;
import com.github.brigade.ui.screen.component.Button;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.Container;
import com.github.brigade.ui.screen.component.MapDisplay;
import com.github.brigade.ui.util.MouseInput;

public class MenuInGame extends MenuScreen {
	private int x = 0, y = 0, lx = 0, ly = 0;
	private int textureSize = 16;

	public MenuInGame() {
		super(getComponents());
	}

	@Override
	public void update() {
		if (MouseInput.isRightDown()) {
			x -= MouseInput.getLastXDiff();
			y -= MouseInput.getLastYDiff();
		}
		clamp();
		if (tilesNeedUpdate()) {
			tiles = genTiles();
		}
		lx = x;
		ly = y;
		super.update();
	}

	private void clamp() {
		// int xCheck = size - x - Game.gameResolution.getWidth();
		// int yCheck = size - y - Game.gameResolution.getHeight();
		// int menuHeight = getComponents()[0].getHeight() + 7;
		// int xCheck = -size + Game.gameResolution.getWidth();
		// int yCheck = -size + Game.gameResolution.getHeight() - menuHeight;
		int xCheck = getMaxX();
		int yCheck = getMaxY();
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		if (System.currentTimeMillis() % 100 == 0){
			System.out.println(x + ":" + y);
		}
		if (x > xCheck) {
			x = xCheck;
		}
		if (y > yCheck) {
			y = yCheck;
		}
	}

	/**
	 * Returns the maximum scroll amount of the map display (X) based on the
	 * screen dimensions and tile size.
	 */
	private int getMaxX() {
		return Game.getMap().getWidth() * (textureSize) - Game.gameResolution.getWidth();
	}

	/**
	 * Returns the maximum scroll amount of the map display (Y) based on the
	 * screen dimensions and tile size.
	 */
	private int getMaxY() {
		return Game.getMap().getHeight() * (textureSize)- Game.gameResolution.getHeight();
	}

	Tile[][] tiles;

	@Override
	public void render() {
		if (tiles != null) {
			for (int x = 0; x < tiles.length; x++) {
				for (int y = 0; y < tiles[0].length; y++) {
					Tile t = tiles[x][y];
					if (t == null) {
						continue;
					}
					DrawUtil.drawRectangle(t.x, t.y, t.size, t.size, t.t);
				}
			}
		}
		super.render();
	}

	private Tile[][] genTiles() {
		int twid = (int) Math.ceil(Game.gameResolution.getWidth() / textureSize);
		int thei = (int) Math.ceil(Game.gameResolution.getHeight() / textureSize);

		Tile[][] ret = new Tile[twid][thei];
		for (int x = 0; x < twid; x++) {
			for (int y = 0; y < thei; y++) {
				Texture t = null;
				try {
					MapPoint mp = Game.getMap().getPoint(x + (this.x / textureSize), y + (this.y / textureSize));
					if (mp == null) {
						System.out.println("mp");
					}
					EnumTileType ett = mp.getTileType();
					if (ett == null) {
						System.out.println("ett");
					}
					t = ett.getTexture();
					if (t == null) {
						System.out.println("t");
					}
				} catch (MapException e) {
					//e.printStackTrace();
				}
				if (t == null) {
					t = Textures.Sand;
				}
				ret[x][y] = new Tile(x * textureSize, y * textureSize, textureSize, t);
			}
		}
		return ret;
	}

	private boolean tilesNeedUpdate() {
		// TODO Auto-generated method stub
		return (tiles == null) ? true : (lx != x || ly != y);
	}

	private static Component[] getComponents() {
		int h = Game.getWindow().getHeight();
		int w = Game.getWindow().getWidth();
		// int mapHeight = (int) (h * 0.2);
		// int mapWidth = mapHeight;
		int mapResolution = 256;
		int mapX = 0;// w - mapWid;
		int mapY = h - mapResolution;
		MapDisplay mapDisp = new MapDisplay(mapX, mapY, mapResolution);
		mapDisp.setMap(Game.getMap());
		//
		int contHeight = 96;
		int contTop = h - contHeight;
		int len = 10;
		Button[] btns = new Button[len];
		//
		int hPadding = 4;
		int vPadding = 4;
		int mapOffset = mapX + mapResolution;
		for (int i = 0; i < len; i++) {
			//
			int btnHeight = 90 - vPadding * 2;
			int btnWidth = btnHeight;
			int x = hPadding + i * btnWidth + i * hPadding;
			int y = vPadding - 1;
			btns[i] = new Button(x, y, btnWidth, btnHeight);
		}
		//
		Container container = new Container(mapOffset, contTop, w - mapOffset, contHeight, btns);
		return new Component[] { container, mapDisp };
	}

	class Tile {
		public Texture t;
		public int x, y, size;

		Tile(int x, int y, int s, Texture t) {
			this.t = t;
			this.x = x;
			this.y = y;
			this.size = s;
		}
	}
}
