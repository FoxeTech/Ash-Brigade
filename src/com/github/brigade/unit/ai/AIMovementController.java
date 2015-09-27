package com.github.brigade.unit.ai;

import com.github.brigade.map.MapPoint;
import com.github.brigade.unit.UnitCommander;
import com.github.brigade.unit.UnitLiving;

public class AIMovementController {
	
	LineOfSight los = new LineOfSight();
	
	public void moveUnit(UnitLiving unit){
		
		UnitCommander commander = null;
		MapPoint bestSpace = getBestSpace(unit);
		
		if(unit.getUnitData().getCommanderID() != -1){
			
		}
	}
	
	private MapPoint getBestSpace(UnitLiving unit){
		
		int bestScore = 0;//this way even a neutral space found (0 points) is better
		MapPoint bestSpace = null;
		MapPoint[] los = unit.getLineOfSight();
		UnitLiving[] enemyUnits = analyzeUnitLOS(unit);
		
		for(int i = 0; i < enemyUnits.length; i++){
			
			MapPoint[] enemyLOS = enemyUnits[i].getLineOfSight();
			
			for(int a = 0; a < enemyLOS.length; a++){
				for(int c = 0; c < los.length; c++){
					
					if(los[c].equals(enemyLOS[a])){
						
						//calculate taking damage vs dying
						int currentScore = (enemyUnits[i].getStatHandler().getAttack() >= unit.getHealth()) ? -unit.getUnitData().getSelfWorth():-unit.getUnitData().getSelfWorth()/2;
						
						if(currentScore > bestScore){
							bestScore = currentScore;
							bestSpace = los[c];
						}
						
					}
					
				}
			}
			
		}
		return bestSpace;
	}
	
	private UnitLiving[] analyzeUnitLOS(UnitLiving unit){
		
		MapPoint[] los = unit.getLineOfSight();
		UnitLiving[] enemyUnits = new UnitLiving[los.length];
		
		int numEnemies = 0;
		
		for(int i = 0; i < los.length; i++){
			MapPoint space = los[i];
			
			if(space.getUnit() != null && unit.getUnitData().getFaction() != space.getUnit().getUnitData().getFaction()){
				enemyUnits[numEnemies] = space.getUnit();
				numEnemies++;
			}
			
		}
		
		return enemyUnits;
	}
	
}
