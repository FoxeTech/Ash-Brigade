package com.github.brigade.unit;

import com.github.brigade.map.MapPoint;

public class UnitMovementController {

	/**
	 * To be used whenever moving any unitLiving in the game.
	 * 
	 * Checks for movement legality and deals with movement of UnitLiving object
	 * from one MapPoint object to another.
	 */
	
	public void moveUnit(MapPoint oldSpace, MapPoint newSpace){
		
		if(aStar(oldSpace, newSpace)){
			UnitLiving unitLiving = oldSpace.getUnit();
			oldSpace.RemoveUnit();
			newSpace.setUnit(unitLiving);
		}
		
	}
	
	/**
	 * A* Pathfinding, returns true if a path is found, false otherwise
	 * 
	 * @param startSpace
	 * @param endSpace
	 * @return isMoveFound
	 */
	private boolean aStar(MapPoint startSpace, MapPoint endSpace){
		
		boolean isMoveFound = false;
		
		//Implement A* code here...obviously...
		
		return isMoveFound;
		
	}
	
}
