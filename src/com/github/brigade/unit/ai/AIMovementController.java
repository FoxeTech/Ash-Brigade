package com.github.brigade.unit.ai;

import com.github.brigade.map.MapPoint;
import com.github.brigade.unit.Faction;
import com.github.brigade.unit.UnitLiving;
import com.github.brigade.unit.data.EnumFaction;

/**
 * 
 * Currently the skirmish AI works as follows:
 * 
 * Unit looks for best space in its line of sight to go to.
 * 
 * @author Chandler
 *
 */
public class AIMovementController {
	
	LineOfSight los = new LineOfSight();
	Faction faction = new Faction(EnumFaction.Reyan);
	Faction enemyFaction = new Faction(EnumFaction.Adesh);
	
	public void moveUnit(UnitLiving unit){
		
		MapPoint bestOverallSpace = null;
		MapPoint bestUnitSpace = getBestSpace(unit, analyzeUnitLOS(unit));
		MapPoint bestCommanderSpace = getBestSpace(unit, analyzeUnitVicinity(unit));
		
		if(unit.getUnitData().getCommanderID() != -1){
			double ran = Math.random();
			//deals with percent chance of unit following orders
			if(ran < unit.getUnitData().getLoyaltyIndex())
				bestOverallSpace = bestCommanderSpace;
		}else
			bestOverallSpace = bestUnitSpace;
		
		//TODO: move unit to best overall space
		
	}
	
	//find the space with the highest number of points in favor of the unit
	private MapPoint getBestSpace(UnitLiving unit, UnitLiving[] enemyUnits){
		
		int bestScore = 0;
		MapPoint bestSpace = null;
		MapPoint[] los = unit.getLineOfSight();
		
		//loop through all enemy units in this unit's line of sight
		for(int i = 0; i < enemyUnits.length; i++){
			MapPoint[] enemyLOS = enemyUnits[i].getLineOfSight();
			//loop through the enemy's and the unit's los
			for(int a = 0; a < enemyLOS.length; a++){
				for(int c = 0; c < los.length; c++){
					
					//if unit's and enemy's los intersect
					if(los[c].equals(enemyLOS[a])){
						
						//calculate taking damage vs dying
						int currentScore = (enemyUnits[i].getStatHandler().getAttack() >= unit.getHealth()) ? -unit.getUnitData().getSelfWorth() : -unit.getUnitData().getSelfWorth()/2;
						
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

	
	/**
	 * Looks for enemy units in the given unit's line of sight
	 * (used for single unit AI)
	 * 
	 * @param unit
	 * 			unit whose line of sight is to be analyzed
	 * 
	 * @return enemyUnits
	 * 			a list UnitLiving objects that are the enemy units
	 */
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
	
	/**
	 * Looks for enemy units in the given unit's vicinity
	 * (used for commander AI)
	 * 
	 * vicinity is defined as two units' lines of sight overlapping
	 * 
	 * @param unit
	 * 			the unit whose vicinity you are checking
	 * 
	 * @return enemyUnits
	 * 			a list of UnitLiving objects that are the enemy units
	 */
	private UnitLiving[] analyzeUnitVicinity(UnitLiving unit){
		
		int numEnemyUnits = 0;
		int unitAgility = unit.getStatHandler().getAgility();
		
		UnitLiving[] enemyUnits = enemyFaction.getArmy();
		UnitLiving[] unitsInVicinity = new UnitLiving[enemyFaction.getNumUnits()];
		
		for(int i = 0; i < enemyFaction.getNumUnits(); i++){
			//enemy is in vicinity if enemy's agility plus current unit's agility >= distance between the two
			if(unitAgility + enemyUnits[i].getStatHandler().getAgility() >= getDistance(unit, enemyUnits[i])){
				unitsInVicinity[numEnemyUnits] = enemyUnits[i];
				numEnemyUnits++;
			}
		}
		
		return enemyUnits;
	}
	
	/**
	 * Get distance between two units
	 * 
	 * @param unit1
	 * @param unit2
	 * @return distance
	 */
	private double getDistance(UnitLiving unit1, UnitLiving unit2){
		
		int x1 = unit1.getX();
		int y1 = unit1.getY();
		int x2 = unit2.getX();
		int y2 = unit2.getY();
		
		return Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2));
		
	}
	
}
