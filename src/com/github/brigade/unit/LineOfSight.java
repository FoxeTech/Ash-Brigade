package com.github.brigade.unit;

import com.github.brigade.map.MapPoint;
import com.github.brigade.map.EnumTileType;

public class LineOfSight {

	private MapPoint[][] map;
	private int numLoSPoints;
	
	public LineOfSight(MapPoint[][] map){
		
		numLoSPoints = 0;
		
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y < map[x].length; y++){
				this.map[x][y] = map[x][y];
			}
		}
		
	}
	
	public void getLineOfSight(UnitLiving unit){
		
	}
	
	private MapPoint[] calculateLOS(int x, int y, int step, int distance, MapPoint[] losList, MapPoint[][] map) {
		if (step == distance || map[x][y].getTileType() == EnumTileType.Mountains || map[x][y].getTileType() == EnumTileType.Lava)
			return losList;
		else {

			if (!isDuplicate(losList, x, y)) {
				losList[numLoSPoints] = map[x][y];
				numLoSPoints++;
			}

			if (x < losList.length)
				calculateLOS(x + 1, y, step + 1, distance, losList, map);
			if (x >= 0)
				calculateLOS(x - 1, y, step + 1, distance, losList, map);
			if (y < losList.length)
				calculateLOS(x, y + 1, step + 1, distance, losList, map);
			if (y >= 0)
				calculateLOS(x, y - 1, step + 1, distance, losList, map);
			
		}
		return losList;
	}

	private boolean isDuplicate(MapPoint[] losList, int x, int y) {
		for (int i = 0; i < losList.length; i++) {
			if (losList[i].getX() == x && losList[i].getY() == y)
				return true;
		}
		return false;
	}
	
}
