package com.github.brigade.unit.ai;

import com.github.brigade.map.MapPoint;
import com.github.brigade.unit.UnitLiving;

public class AIMovementController {
	
	LineOfSight los = new LineOfSight();
	
	public void moveUnit(UnitLiving unit){
		
	}
	
	private MapPoint[][] analyzeUnit(UnitLiving unit){
		
		MapPoint[][] actions = new MapPoint[2][los.getSizeLOS(unit)];
		
		return actions;
	}
	
}
