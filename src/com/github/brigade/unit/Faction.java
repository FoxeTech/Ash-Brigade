package com.github.brigade.unit;

import com.github.brigade.exception.UnitException;
import com.github.brigade.unit.data.EnumFaction;

public class Faction {

	//will also hold cities under faction's control
	
	private int numUnits;
	
	private UnitLiving[] army;
	private EnumFaction faction;
	
	/**
	 * Creates a faction
	 * @param faction
	 */
	public Faction(EnumFaction faction){
		numUnits = 0;
		this.faction = faction;
		army = new UnitLiving[faction.getGSize5()];
	}
	
	/**
	 * Adds the unit parameter to the array of units
	 * @param unit
	 */
	public void addUnit(UnitLiving unit){
		army[numUnits] = unit;
		numUnits++;
	}
	
	/**
	 * Returns the number of units
	 * @return Returns the number of units
	 */
	public int getNumUnits(){
		return numUnits;
	}
	
	/**
	 * Returns the army
	 * @return Returns the army
	 */
	public UnitLiving[] getArmy(){
		return army;
	}
	
	/**
	 * Returns the unit at a specific index
	 * @param ID
	 * @return
	 * @throws UnitException
	 */
	public UnitLiving getUnit(int ID) throws UnitException{
		
		for(int i = 0; i < army.length; i++){
			if(army[i].getUnitData().getID() == ID)
				return army[i];
		}
		throw new UnitException("A unit with the ID " + ID + " does not exist.");
	}
	
}
