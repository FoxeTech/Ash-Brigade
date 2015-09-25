package com.github.brigade.unit.ai;

import com.github.brigade.Game;
import com.github.brigade.exception.MapException;
import com.github.brigade.map.MapPoint;
import com.github.brigade.unit.UnitLiving;
import com.github.brigade.map.EnumTileType;

public class LineOfSight {
	private int numLOSPoints = 0;

	/**
	 * Finds line of sight for explosive units
	 * 
	 * @param unit
	 *            The unit whose los is to be found
	 */
	public void getBombLOS(UnitLiving unit) {

	}

	/**
	 * Finds line of sight for spear units
	 * 
	 * @param unit
	 *            The unit whose los is to be found
	 */
	public void getSpearLOS(UnitLiving unit) {

	}

	/**
	 * Finds line of sight for melee units (here in case code for this changes
	 * later)
	 * 
	 * @param unit
	 *            The unit whose los is to be found
	 */
	public void getMeleeLOS(UnitLiving unit) {
		getRangeLOS(unit);
	}

	/**
	 * Finds line of sight for ranged units
	 * 
	 * @param unit
	 *            The unit whose los is to be found
	 */
	public void getRangeLOS(UnitLiving unit) {

		int agility = unit.getStatHandler().getAgility();
		int x = unit.getX();
		int y = unit.getY();

		int losSize = getSizeLOS(unit);

		MapPoint[] losList = new MapPoint[losSize];

		try {
			losList = calculateCircleLOS(Game.getMap().getPoint(x, y), 0, agility, losList);
		} catch (MapException e) {
			e.printStackTrace();
		}

	}

	public int getSizeLOS(UnitLiving unit){
		int agility = unit.getStatHandler().getAgility();
		int x = unit.getX();
		int y = unit.getY();

		// formula for determining number of spaces in a los
		int losSize = (agility * (2 * (agility + 1))) + 1;
		
		return losSize;
	}
	
	private MapPoint[] calculateCircleLOS(MapPoint space, int step, int distance, MapPoint[] losList) {
		if (step == distance || space.getTileType() == EnumTileType.Mountains || space.getTileType() == EnumTileType.Lava)
			return losList;
		else {

			if (!isDuplicate(losList, space.getX(), space.getY())) {
				losList[numLOSPoints] = space;
				numLOSPoints++;
			}

			if (space.getX() < Game.getMap().getNumXTiles()) {
				try {
					calculateCircleLOS(Game.getMap().getPoint(space.getX() + 1, space.getY()), step + 1, distance, losList);
				} catch (MapException e) {
					e.printStackTrace();
				}
			}

			if (space.getX() > 0) {
				try {
					calculateCircleLOS(Game.getMap().getPoint(space.getX() - 1, space.getY()), step + 1, distance, losList);
				} catch (MapException e) {
					e.printStackTrace();
				}
			}

			if (space.getY() < Game.getMap().getNumYTiles()) {
				try {
					calculateCircleLOS(Game.getMap().getPoint(space.getX(), space.getY() + 1), step + 1, distance, losList);
				} catch (MapException e) {
					e.printStackTrace();
				}
			}

			if (space.getY() > 0) {
				try {
					calculateCircleLOS(Game.getMap().getPoint(space.getX(), space.getY() - 1), step + 1, distance, losList);
				} catch (MapException e) {
					e.printStackTrace();
				}
			}

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
