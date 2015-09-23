package com.github.brigade.unit;

public class UnitCommander extends UnitLiving{

	private int numSubordinates;
	
	private String rankName;
	private UnitLiving[] subordinates;
	private UnitConstants uConstants;
	
	public UnitCommander(int origX, int origY, int health, int healthMax, String faction, String name, int index) {
		super(origX, origY, health, healthMax, faction, name, index);
		uConstants = new UnitConstants();
		
		numSubordinates = 0;
		
		if(faction.equals(uConstants.ASIAN_FACTION_NAME))
			subordinates = new UnitLiving[uConstants.ASIAN_FACTION_FIRST_GROUPING_SIZE];
		else if(faction.equals(uConstants.ARABIAN_FACTION_NAME))
			subordinates = new UnitLiving[uConstants.ARABIAN_FACTION_FIRST_GROUPING_SIZE];
		else if(faction.equals(uConstants.EUROPEAN_FACTION_NAME))
			subordinates = new UnitLiving[uConstants.EUROPEAN_FACTION_FIRST_GROUPING_SIZE];
		
	}
	
	public UnitCommander(int origX, int origY, int health, String faction, String name, int index){
		super(origX, origY, health, health, faction, name, index);
		
	}
	
	public void addSubordinate(UnitLiving unit){
		try{
			subordinates[numSubordinates] = unit;
			numSubordinates++;
		}catch(ArrayIndexOutOfBoundsException ex){ex.printStackTrace();}
	}
	
	public String getRankName(){
		return rankName;
	}
	
	public UnitLiving[] getSubordinates(){
		return subordinates;
	}

}
