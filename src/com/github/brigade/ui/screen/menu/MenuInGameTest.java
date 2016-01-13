package com.github.brigade.ui.screen.menu;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.github.brigade.Game;
import com.github.brigade.map.EnumTileType;
import com.github.brigade.map.MapPoint;
import com.github.brigade.render.DrawUtil;
import com.github.brigade.ui.screen.Camera;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.util.KeyboardInput;
import com.github.brigade.ui.util.MouseInput;
import com.github.brigade.unit.UnitGroup;
import com.github.brigade.unit.data.UnitData;
import com.github.brigade.unit.units.TestUnit01;
import com.sun.org.apache.bcel.internal.generic.LAND;

public class MenuInGameTest extends MenuScreen{
	
	public static final int SIZE = 128;
	
	private MapPoint[][] data;
	private UnitGroup occypyingArmy, attackingArmy;
	private Tile[][] tiles;
	private int x = 0, y = 0, lx = 0, ly = 0;
	private int textureSize = 128;
	private Tile tileMouseOver = null;
	private Camera camera;

	public MenuInGameTest(MapPoint[][] data, UnitGroup occupyingArmy, UnitGroup attackingArmy) {
		super(getComponents(), "Test");
		this.occypyingArmy = occupyingArmy;
		this.attackingArmy = attackingArmy;
		this.data = data;
		camera = new Camera(0,0,data[0].length,data.length,0,9);
		tiles = new Tile[data[0].length][data.length];
		TestUnit01 t = new TestUnit01(0,0,100,1000,new UnitData(0,1,-1,occupyingArmy.getFaction()),"Test Unit");
		data[1][1].setUnit(t);
		generateTiles();
	}
	private static Component[] getComponents(){
		return null;
	}
	
	@Override
	public void update() {
		if(MouseInput.getX() <= 1 || KeyboardInput.isKeyDown(Keyboard.KEY_LEFT))
		{
			camera.moveRight();
		}
		if(MouseInput.getY() <= 1 || KeyboardInput.isKeyDown(Keyboard.KEY_UP))
		{
			camera.moveUp();
		}
		if(MouseInput.getX() >= Game.gameResolution.getWidth() - 1 || KeyboardInput.isKeyDown(Keyboard.KEY_RIGHT))
		{
			camera.moveLeft();
		}
		if(MouseInput.getY() >= Game.gameResolution.getHeight() - 1 || KeyboardInput.isKeyDown(Keyboard.KEY_DOWN))
		{
			camera.moveDown();
		}
		
		super.update();
	}
	
	private void generateTiles(){
		for(int y = 0; y < data.length;y++){
			for(int x = 0; x < data[0].length;x++){
				switch(data[x][y].getTileType()){
					case Land:
						tiles[x][y] = new Tile(x * SIZE, y * SIZE, SIZE, EnumTileType.Land.getTexture());
						break;
					case Beach:
						tiles[x][y] = new Tile(x * SIZE, y * SIZE, SIZE, EnumTileType.Beach.getTexture());
						break;
					case Mountains:
						tiles[x][y] = new Tile(x * SIZE, y * SIZE, SIZE, EnumTileType.Mountains.getTexture());
						break;
					case Water:
						tiles[x][y] = new Tile(x * SIZE, y * SIZE, SIZE, EnumTileType.Water.getTexture());
						break;
					case Lava:
						tiles[x][y] = new Tile(x * SIZE, y * SIZE, SIZE, EnumTileType.Lava.getTexture());
						break;
					case Trees:
						tiles[x][y] = new Tile(x * SIZE, y * SIZE, SIZE, EnumTileType.Trees.getTexture());
						break;
					case Dildo:
						tiles[x][y] = new Tile(x * SIZE, y * SIZE, SIZE, EnumTileType.Dildo.getTexture());
						break;
					case Highland:
						tiles[x][y] = new Tile(x * SIZE, y * SIZE, SIZE, EnumTileType.Highland.getTexture());
						break;
					default:
						tiles[x][y] = new Tile(x * SIZE, y * SIZE, SIZE, EnumTileType.Land.getTexture());
				}
				if(data[x][y].hasUnit()){
					tiles[x][y].addUnit(data[x][y].getUnit());
				}
			}
		}
	}
	
	public void render(){
		//for(int y = 0; y < tiles.length; y++){
		//	for(int x = 0; x < tiles[0].length;x++){
		//		tiles[x][y].render();
		//	}
		//}
		int camerax = -camera.getPositionX();
		int cameray = -camera.getPositionY();
		int cameramx = (-camera.getPositionX()) + Game.gameResolution.getWidth();
		int cameramy = (-camera.getPositionY()) + Game.gameResolution.getHeight();
		if(camerax <= 0){
			camera.setPositionX(0);
			camerax = 0;
		}
		if(cameray <= 0){
			camera.setPositionY(0);
			cameray = 0;
		}
		if(camerax + Game.gameResolution.getWidth() >= tiles.length * textureSize){
			camera.setPositionY(tiles.length * textureSize);
		}
		camerax = -camera.getPositionX();
		cameray = -camera.getPositionY();
		cameramx = (-camera.getPositionX()) + Game.gameResolution.getWidth();
		cameramy = (-camera.getPositionY()) + Game.gameResolution.getHeight();
		camera.update();
		GL11.glTranslatef(camera.getXoff(),camera.getYoff(),0);
		for (int y = cameray / textureSize; y < (cameramy + textureSize) / textureSize; y++)
		{
			for (int x = camerax / textureSize; x < (cameramx + textureSize) / textureSize; x++)
			{
				tiles[x][y].render();
			}
		}
	}
}
