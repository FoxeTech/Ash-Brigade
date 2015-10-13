package com.github.brigade.unit;

import com.github.brigade.exception.GroupOverflowException;
import com.github.brigade.unit.data.EnumFaction;

public class UnitGroup {
	
	private int groupType;
	private String groupName;
	private EnumFaction faction;
	
	private int maxUnits;
	private int numUnits;
	private int numGroups;
	private UnitLiving[] units;
	private UnitGroup[] groups;
	
	public UnitGroup(EnumFaction faction, int groupType){
		this.faction = faction;
		this.groupType = groupType;
		
		switch(groupType){
			case 1: 
				maxUnits = faction.getGSize1();
				groupName = faction.getGroupName1();
			case 2:
				maxUnits = faction.getGSize2();
				groupName = faction.getGroupName2();
			case 3:
				maxUnits = faction.getGSize3();
				groupName = faction.getGroupName3();
			case 4:
				maxUnits = faction.getGSize4();
				groupName = faction.getGroupName4();
			case 5:
				maxUnits = faction.getGSize5();
				groupName = faction.getGroupName5();
			default:
				maxUnits = 0;
				groupName = "";
		}
		
	}
	
	public void addUnit(UnitLiving unit) throws GroupOverflowException{
		if(numUnits <= maxUnits){
			units[numUnits] = unit;
			numUnits++;
		}else
			throw new GroupOverflowException("Group's maximum capacity is "+maxUnits+". Cannot add more units.");
	}
	
	public void addGroup(UnitGroup group) throws GroupOverflowException{
		if(numUnits + group.getNumUnits() <= maxUnits){
			groups[numGroups] = group;
			numGroups++;
		}else
			throw new GroupOverflowException("Group's maximum capacity is "+maxUnits+". Cannot add group.");
	}
	
	public int getNumUnits(){
		return numUnits;
	}
	
	public int getGroupType(){
		return groupType;
	}
	
	public String getGroupName(){
		return groupName;
	}
	
	public EnumFaction getFaction(){
		return faction;
	}
	
}
