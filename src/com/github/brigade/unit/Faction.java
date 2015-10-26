package com.github.brigade.unit;

import com.github.brigade.exception.UnitException;
import com.github.brigade.unit.data.EnumFaction;

public class Faction {

	/**
	 * 
	 * This class is meant to hold all of the conquest-level information
	 * of a faction. Including the army and cities under the faction's control.
	 * 
	 * @author Chandler
	 */
	
	private int numUnits;
	
	private UnitLiving[] army;
	private EnumFaction faction;
	
	public Faction(EnumFaction faction){
		numUnits = 0;
		this.faction = faction;
		army = new UnitLiving[faction.getGSize5()];
	}
	
	public void addUnit(UnitLiving unit){
		army[numUnits] = unit;
		numUnits++;
	}
	
	public int getNumUnits(){
		return numUnits;
	}
	
	public UnitLiving[] getArmy(){
		return army;
	}
	
	public UnitLiving getUnit(int ID) throws UnitException{
		
		for(int i = 0; i < army.length; i++){
			if(army[i].getUnitData().getID() == ID)
				return army[i];
		}
		throw new UnitException("A unit with the ID " + ID + " does not exist.");
	}
	
}
