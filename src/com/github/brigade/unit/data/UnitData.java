package com.github.brigade.unit.data;

import com.github.brigade.unit.EnumFaction;

public class UnitData {
	private final int id, commanderID;
	private EnumFaction faction;
	private int loyaltyIndex;

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
		this(id, commanderID, -1, EnumFaction.Rouge);
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
