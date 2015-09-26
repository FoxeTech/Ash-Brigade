package com.github.brigade.unit.data;

public class UnitData {
	private final int id, commanderID;
	private EnumFaction faction;
	
	private int loyaltyIndex;
	private int selfWorth;//used in AI calculations (likelihood that a unit tries to save itself)
	private int honour;//used in AI calculations (likelihood that a unit will go kamikaze)
	
	public static int CURRENT_INDEX = 0;

	/**
	 * Sets up the unit's data.
	 * 
	 * @param id
	 *            The unit's unique ID
	 * @param commanderID
	 *            <b>TODO</b>: Get Chandler to elaborate what this is
	 * @param loyaltyIndex
	 *            The unit that commands this one's ID
	 * @param faction
	 *            The faction the unit belongs to
	 */
	public UnitData(int id, int commanderID, int loyaltyIndex, EnumFaction faction) {
		this.id = id;
		this.commanderID = commanderID;
		this.loyaltyIndex = loyaltyIndex;
		this.faction = faction;
		
		if(faction == EnumFaction.Arab){
			selfWorth = 100;
			honour = 50;
		}else if(faction == EnumFaction.Asian){
			selfWorth = 50;
			honour = 100;
		}else if(faction == EnumFaction.Euro){
			selfWorth = 50;
			honour = 50;
		}
		
	}

	/**
	 * Sets up the unit's data.
	 * 
	 * @param id
	 *            The unit's unique ID
	 * @param commanderID
	 *            <b>TODO</b>: Get Chandler to elaborate what this is
	 * @param faction
	 *            The faction the unit belongs to
	 */
	public UnitData(int id, int commanderID, EnumFaction faction) {
		this(id, commanderID, -1, faction);
	}

	/**
	 * Sets up the unit's data. (Default's to Rogue faction)
	 * 
	 * @param id
	 *            The unit's unique ID
	 * @param commanderID
	 *            <b>TODO</b>: Get Chandler to elaborate what this is
	 */
	public UnitData(int id, int commanderID) {
		this(id, commanderID, -1, EnumFaction.Rogue);
	}

	/**
	 * Returns if the unit has a loyalty.
	 */
	public boolean hasLoyalty() {
		return (commanderID != -1);
	}

	/**
	 * Get's the unit's faction.
	 */
	public EnumFaction getFaction() {
		return faction;
	}

	/**
	 * Returns the unit's faction name.
	 */
	public String getFactionName() {
		return faction.getName();
	}

	/**
	 * Gets the loyalty of the unit based on their commander's ID.
	 * 
	 * @return loyaltyToCommander
	 */
	public int getLoyalityIndex() {
		return loyaltyIndex;
	}

	/**
	 * Gets the unit's own selfworth. 
	 * This is used for AI calculations and determines if the unit will run away or not
	 * 
	 * @return selfWorth
	 */
	public int getSelfWorth(){
		return selfWorth;
	}
	
	/**
	 * Gets the unit's own honour.
	 * This is used for AI calculations and determines if the unit will kamikaze or not
	 * 
	 * @return honour
	 */
	public int getHonour(){
		return honour;
	}
	
	/**
	 * Sets the unit's commander using the commander's ID.
	 * 
	 * @param commanderIndex
	 */
	public void setLoyaltyToCommander(int commanderIndex) {
		this.loyaltyIndex = commanderIndex;
	}

	/**
	 * Gets the id of the unit.
	 * 
	 * @return index
	 */
	public int getID() {
		return id;
	}

	/**
	 * Gets the current unit's commander's ID.
	 * 
	 * @return commanderIndex -1 denotes no commander
	 */
	public int getCommanderID() {
		return commanderID;
	}

}
