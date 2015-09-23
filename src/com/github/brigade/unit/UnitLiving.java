package com.github.brigade.unit;

import com.github.brigade.inventory.Inventory;
import com.github.brigade.map.MapPoint;

public abstract class UnitLiving extends Unit {
	
	private StatHandler stats;
	private MapPoint[] lineOfSight;
	private final Inventory inventory = new Inventory();
	
	private int health, healthMax;
	private int index, commanderIndex;
	private int loyaltyToCommander;
	
	// TODO: Have a EnumTileType[] that the unit can walk across (Given their
	// unit type or allegiance)
	// Idea 1: Have this be handled in a more specific unit class.
	// Idea 2: See idea 1. Abstraction is key!

	/**
	 * Instantiates the unit with an initial X,Y, current health, and maximum
	 * health.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 * @param currHealth
	 *            Current health of the unit
	 * @param maxHealth
	 *            Maximum amount of health for the unit
	 * @param faction
	 *			  The faction name that the unit is a part of
	 *@param index
	 *			  This unit's unique index	 					           	
	 */
	public UnitLiving(int origX, int origY, int health, int healthMax, String faction, String name, int index) {
		super(origX, origY, name);
		stats = new StatHandler(faction);
		this.health = health;
		this.healthMax = healthMax;
		this.index = index;
		commanderIndex = -1;//indicates no commander
	}

	/**
	 * Instantiates the unit with an initial X,Y, and health.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 * @param currHealth
	 *            Current and max health of the unit
	 * @param index
	 * 			  This unit's unique index           		
	 */
	public UnitLiving(int origX, int origY, int health, String faction, String name, int index) {
		this(origX, origY, health, health, faction, name, index);
	}

	/**
	 * Gets the unit's current health.
	 * 
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Gets the maximum amount of health this unit can have.
	 * 
	 * @return healthMax
	 */
	public int getMaxHealth() {
		return healthMax;
	}

	/**
	 * Gets the index of the unit.
	 * 
	 * @return index
	 */
	public int getIndex(){
		return index;
	}
	
	/**
	 * Gets the index of the unit commanding this one.
	 * 
	 * @return commanderIndex
 * 				-1 denotes no commander
	 */
	public int getCommanderIndex(){
		return commanderIndex;
	}
	
	/**
	 * Gets the loyalty unit has to their commander.
	 * 
	 * @return loyaltyToCommander
	 */
	public int getLoyaltyToCommander(){
		return loyaltyToCommander;
	}
	
	/**
	 * Sets the unit's health.
	 * 
	 * @param health
	 *            Unit's new health level
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Sets the maximum amount of health this unit can have.
	 * 
	 * @param healthMax
	 */
	public void setMaxHealth(int healthMax) {
		this.healthMax = healthMax;
	}
	
	/**
	 * Sets the unit's commander using the commander's index.
	 * 
	 * @param commanderIndex
	 */
	public void setCommanderIndex(int commanderIndex){
		this.commanderIndex = commanderIndex;
	}

	/**
	 * Sets the unit's line of sight by providing the x-y coordinates of all
	 * spaces in line of sight.
	 * 
	 * @param lineOfSight
	 *            The unit's new line of sight in a 2-D MapPoint array.
	 */
	public void setLineOfSight(MapPoint[] lineOfSight) {

		this.lineOfSight = new MapPoint[lineOfSight.length];

		for (int i = 0; i < lineOfSight.length; i++) {
			this.lineOfSight[i] = lineOfSight[i];
		}

	}


	/**
	 * Gets the stat handler of the unit.
	 * 
	 * @return stats
	 */
	public StatHandler getStatHandler() {
		return stats;
	}

	/**
	 * Gets the inventory of the current unit.
	 * 
	 * @return inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}
}
