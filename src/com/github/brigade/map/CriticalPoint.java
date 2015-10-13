package com.github.brigade.map;

import com.github.brigade.unit.UnitGroup;
import com.github.brigade.unit.data.EnumFaction;

public class CriticalPoint {

	private UnitGroup occupyingArmy;
	private EnumFaction faction;
	
	private int numAdjacentPoints;
	private CriticalPoint[] adjacentPoints;
	
	/**
	 * A CriticalPoint is a MapPoint on the Conquest Map.
	 */
	public CriticalPoint(EnumFaction faction){
		this.faction = faction;
		numAdjacentPoints = 0;
	}
	
	public void setFaction(EnumFaction faction){
		this.faction = faction;
	}
	
	public void setArmy(UnitGroup occupyingArmy){
		this.occupyingArmy = occupyingArmy;
	}
	
	public void removeArmy(){
		occupyingArmy = null;
	}
	
	public void addAdjacentPoint(CriticalPoint adjacentPoint){
		adjacentPoints[numAdjacentPoints] = adjacentPoint;
		numAdjacentPoints++;
	}
	
	public UnitGroup getArmy(){
		return occupyingArmy;
	}
	
	public CriticalPoint[] getAdjacentPoints(){
		return adjacentPoints;
	}
	
}
