package com.github.brigade.ui.screen.menu;

import com.github.brigade.Game;
import com.github.brigade.ui.screen.component.Button;
import com.github.brigade.ui.screen.component.Component;
import com.github.brigade.ui.screen.component.Container;
import com.github.brigade.ui.screen.component.MapDisplay;

public class MenuInGame extends MenuScreen {
	public MenuInGame() {
		super(getComponents());
	}

	private static Component[] getComponents() {
		int h = Game.getWindow().getHeight();
		int w = Game.getWindow().getWidth();
		int mapHeight = (int) (h * 0.2);
		int mapWidth = mapHeight;
		int mapResolution = 256;
		int mapX = 0;// w - mapWid;
		int mapY = h - mapResolution;
		MapDisplay mapDisp = new MapDisplay(mapX, mapY, mapResolution);
		mapDisp.setMap(Game.getMap());
		//
		int contHeight = 96;
		int contTop = h - contHeight;
		Button[] btns = new Button[12];
		//
		int hPadding = 4;
		int vPadding = 4;
		int mapOffset = mapX + mapResolution;
		for (int i = 0; i < 12; i++) {
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

}
