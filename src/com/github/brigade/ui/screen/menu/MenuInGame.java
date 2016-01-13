package com.github.brigade.ui.screen.menu;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.github.brigade.Game;
import com.github.brigade.Test.TestUnit01;
import com.github.brigade.exception.MapException;
import com.github.brigade.map.MapPoint;
import com.github.brigade.render.DrawUtil;
import com.github.brigade.render.GameTextureLevel;
import com.github.brigade.render.Textures;
import com.github.brigade.ui.screen.component.Button;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.Container;
import com.github.brigade.ui.screen.component.MapDisplay;
import com.github.brigade.ui.util.MouseInput;
import com.github.brigade.unit.UnitGroup;
import com.github.brigade.unit.UnitLiving;
import com.github.brigade.unit.data.UnitData;
import com.github.brigade.unit.UnitLiving;

/**
 * 
 * @author Matt
 *
 */
public class MenuInGame extends MenuScreen {

	private int x = 0, y = 0, lx = 0, ly = 0;
	private int textureSize = 128;
	private Selection sel = new Selection();
	private Tile[][] tiles;
	private Tile tileMouseOver = null;

	private UnitGroup occupyingArmy;
	private UnitGroup attackingArmy;
	private MapPoint[][] data;

	public MenuInGame(MapPoint[][] data, UnitGroup occupyingArmy, UnitGroup attackingArmy) {
		super(getComponents(), "Skirmish");
		this.data = data;
		this.occupyingArmy = occupyingArmy;
		this.attackingArmy = attackingArmy;
		TestUnit01 t = new TestUnit01(0,0,100,1000,new UnitData(0,1,-1,occupyingArmy.getFaction()),"Test Unit");
		data[0][0].setUnit(t);
	}

	/**
	 * Adds GUI Components to the screen
	 */
	public MenuInGame() {
		super(getComponents(), "MainMenu");
	}

	@Override
	public void update() {
		if (MouseInput.isRightDown()) {
			x -= MouseInput.getLastXDiff();
			y -= MouseInput.getLastYDiff();
		}
		clamp();
		if (MouseInput.isLeftDown()) {
			if (sel.canShow) {
				sel.x2 = MouseInput.getX();
				sel.y2 = MouseInput.getY();
			} else {
				sel.x1 = MouseInput.getX();
				sel.y1 = MouseInput.getY();
				sel.x2 = MouseInput.getX();
				sel.y2 = MouseInput.getY();
			}
		}
		if (tilesNeedUpdate()) {
			tiles = genTiles();
		}
		if (tiles != null) {
			int mx = MouseInput.getX();
			int my = MouseInput.getY();
			int twid = tiles.length;
			int thei = tiles[0].length;
			int tx = mx / textureSize;
			int ty = my / textureSize;
			if (tx < twid && ty < thei) {
				tileMouseOver = tiles[tx][ty];
			}
		}
		lx = x;
		ly = y;
		super.update();
		updateUnits();
	}

	public void updateUnits() {

		for (int i = 0; i < occupyingArmy.getNumUnits(); i++) {
			UnitLiving currUnit = occupyingArmy.getUnit(i);
			data[currUnit.getX()][currUnit.getY()].setUnit(currUnit);
		}

		for (int i = 0; i < occupyingArmy.getNumGroups(); i++) {
			for (int a = 0; a < occupyingArmy.getUnitGroup(i).getNumUnits(); a++) {
				UnitLiving currUnit = occupyingArmy.getUnit(i);
				data[currUnit.getX()][currUnit.getY()].setUnit(currUnit);
			}
		}
		renderUnits();
	}

	@Override
	protected void onClick(int mouseID, int x, int y, boolean isMouseReleasing) {
		if (mouseID == 0)
			if (isMouseReleasing) {
				sel.canShow = false;
				sel.selection = true;
			} else {
				sel.canShow = true;
				sel.selection = false;
				sel.x1 = x;
				sel.y1 = y;
			}
	}

	/**
	 * Ensures the user does not move the map out of bounds.
	 */
	private void clamp() {
		int xCheck = getMaxX();
		int yCheck = getMaxY();
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
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
		return Game.getMap().getHeight() * (textureSize) - Game.gameResolution.getHeight();
	}

	public void render(MapPoint[][] data) {
		renderMap();
		renderUnits();
		super.render();
	}

	private void renderMap() {
		boolean blurTextures = false;
		boolean rotate = false;
		if (blurTextures) {
			GL11.glTranslated(textureSize / 2, textureSize / 2, 0);
		}
		if (tiles != null) {
			for (int x = 0; x < tiles.length; x++) {
				for (int y = 0; y < tiles[0].length; y++) {
					Tile t = tiles[x][y];
					if (t == null) {
						continue;
					}
					if (Game.textureLevel == GameTextureLevel.LOW || !blurTextures) {
						DrawUtil.drawRectangle(t.x, t.y, t.size, t.size, t.texture);
					} else {
						DrawUtil.drawBlendRectangle(t.x, t.y, t.size, t.size, t.texture, rotate);
					}
				}
			}
		}
		if (tileMouseOver != null) {
			DrawUtil.drawRectangle(tileMouseOver.x, tileMouseOver.y, tileMouseOver.size, tileMouseOver.size, Textures.Tile_Holder);
		}
		if (sel != null) {
			if (sel.canShow) {
				// DrawUtil.drawRectangle(sel.x1, sel.y1, sel.x2, sel.y2,
				// Textures.Tile_Grad);
				DrawUtil.drawRectangle(sel.x1, sel.y1, sel.x2 - sel.x1, sel.y2 - sel.y1, Textures.Tile_Grad);

			}
			Tile[][] tz = sel.getSelectedTiles();
			if (tz != null) {
				try {
					for (Tile[] row : tz) {
						for (Tile t : row) {
							if (t != null) {
								DrawUtil.drawRectangle(t.x, t.y, t.size, t.size, Textures.placeHolder1);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
			}
		}
		if (blurTextures) {
			GL11.glTranslated(-textureSize / 2, -textureSize / 2, 0);
		}
	}

	private void renderUnits() {
		if (tiles != null) {
			/*for (int y = 0; y < tiles.length; y++) {
				for (int x = 0; x < tiles[y].length; x++) {
					Tile t = tiles[y][x];
					if (data[y][x].hasUnit()) {
						UnitLiving unit = data[y][x].getUnit();
						DrawUtil.drawRectangle(t.y, t.x, t.size, t.size, unit.getTexture());
					}
				}
			}*/
		}
	}

	/**
	 * Returns a 2D array of Tiles to assist in rendering.
	 */
	private Tile[][] genTiles() {
		int twid = (int) Math.ceil((Game.gameResolution.getWidth() + textureSize) / textureSize);
		int thei = (int) Math.ceil((Game.gameResolution.getHeight() - getContainer().getHeight() + textureSize) / textureSize);
		Tile[][] ret = new Tile[twid][thei];
		for (int x = 0; x < twid; x++) {
			for (int y = 0; y < thei; y++) {
				Texture t = null;
				try {
					t = Game.getMap().getPoint(x + (this.x / textureSize), y + (this.y / textureSize)).getTileType().getTexture();
				} catch (MapException e) {
					e.printStackTrace();
				}
				if (t == null) {
					t = Textures.Sand;
				}
				ret[x][y] = new Tile(x * textureSize, y * textureSize, textureSize, t);
			}
		}
		return ret;
	}

	/**
	 * Returns true if the map needs to be updated.
	 */
	private boolean tilesNeedUpdate() {
		return (tiles == null) ? true : (lx != x || ly != y);
	}

	/**
	 * Returns the MapDisplay
	 * 
	 * @return Returns the MapDisplay
	 */
	private MapDisplay getMapDisplay() {
		return (MapDisplay) getComponents()[1];
	}

	/**
	 * Returns the components on the screen
	 * 
	 * @return Returns the components on the screen
	 */
	private Container getContainer() {
		return (Container) getComponents()[0];
	}

	/**
	 * Returns the components on the screen
	 * 
	 * @return
	 */
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

	/**
	 * 
	 * @author Matt
	 *
	 */
	class Selection {
		public boolean selection;
		public boolean canShow;
		public int x1, x2, y1, y2;

		public Tile[][] getSelectedTiles() {
			if (tiles == null) {
				return null;
			}
			int twid = tiles.length;
			int thei = tiles[0].length;
			int tx1 = (x1) / textureSize;
			int ty1 = (y1) / textureSize;
			int tx2 = (x2) / textureSize;
			int ty2 = (y2) / textureSize;
			boolean x2Larger = (tx2 > tx1);
			boolean y2Larger = (ty2 > ty1);
			Tile[][] ret = new Tile[x2Larger ? tx2 - tx1 : tx1 - tx2][y2Larger ? ty2 - ty1 : ty1 - ty2];
			int initX = x2Larger ? tx1 : tx2;
			int initY = y2Larger ? ty1 : ty2;
			int endX = x2Larger ? tx2 : tx1;
			int endY = y2Larger ? ty2 : ty1;
			for (int x = initX; x < endX - 1; x++) {
				for (int y = initY; y < endY - 1; y++) {
					try {
						ret[x][y] = tiles[x][y];
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
			return ret;
		}
	}

	/**
	 * 
	 * @author Matt
	 *
	 */
	class Tile {
		private Texture texture;
		private int x, y, size;

		Tile(int x, int y, int s, Texture t) {
			this.texture = t;
			this.x = x;
			this.y = y;
			this.size = s;
		}

		public Texture getTexture() {
			return texture;
		}

		public void setTexture(Texture texture) {
			this.texture = texture;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}
	}
}
