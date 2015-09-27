package com.github.brigade.unit;

import com.github.brigade.inventory.Inventory;
import com.github.brigade.map.EnumTileType;
import com.github.brigade.map.MapPoint;
import com.github.brigade.unit.data.UnitData;
import com.github.brigade.unit.data.StatHandler;

public abstract class UnitLiving extends Unit {
	protected String name;
	protected StatHandler stats;
	protected MapPoint[] lineOfSight;
	protected final Inventory inventory = new Inventory();
	protected final UnitData data;
	protected int health, healthMax;
	protected EnumTileType[] allowedTiles = new EnumTileType[] { EnumTileType.Land };

	/**
	 * Instantiates the unit with an initial X,Y, current health, maximum
	 * health, faction/loyalty data, and a name.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 * @param currHealth
	 *            Current health of the unit
	 * @param maxHealth
	 *            Maximum amount of health for the unit
	 * @param data
	 *            The faction and loyalty data for the unit
	 * @param name
	 *            The unit's name
	 */
	public UnitLiving(int origX, int origY, int health, int healthMax, UnitData data, String name) {
		super(origX, origY);
		stats = new StatHandler(data.getFactionName());
		this.health = health;
		this.healthMax = healthMax;
		this.data = data;
		this.name = name;
	}

	/**
	 * Instantiates the unit with an initial X,Y, health, faction/loyalty data,
	 * and a name.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 * @param health
	 *            Health of the unit
	 * @param data
	 *            The faction and loyalty data for the unit
	 * @param name
	 *            The unit's name
	 */
	public UnitLiving(int origX, int origY, int health, UnitData data, String name) {
		this(origX, origY, health, health, data, name);
	}

	/**
	 * Instantiates the unit with an initial X,Y, health, and faction/loyalty
	 * data.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 * @param health
	 *            Health of the unit
	 * @param data
	 *            The faction and loyalty data for the unit
	 */
	public UnitLiving(int origX, int origY, int health, UnitData data) {
		this(origX, origY, health, health, data, UnitConstants.DEFAULT_NAME);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get's the type of tiles the unit can pass over.
	 */
	public EnumTileType[] getAllowedTiles() {
		return allowedTiles;
	}

	/**
	 * Set the type of tiles the unit can pass over.
	 * 
	 * @param allowedTiles
	 *            Array of tiles <br>
	 *            Example:
	 * 
	 *            <pre>
	 *            new EnumTileType[] { EnumTileType.Land };
	 *            </pre>
	 */
	public void setAllowedTiles(EnumTileType[] allowedTiles) {
		this.allowedTiles = allowedTiles;
	}

	/**
	 * Sets the unit's line of sight by providing the MapPoint objects of all
	 * spaces in line of sight.
	 * 
	 * @param lineOfSight
	 *            The unit's new line of sight in a 2-D MapPoint array.
	 */
	public void setLineOfSight(MapPoint[] lineOfSight) {
		this.lineOfSight = lineOfSight;
	}

	/**
	 * Gets the unit's line of sight in a MapPoint array
	 * 
	 * @return lineOfSight
	 */
	public MapPoint[] getLineOfSight(){
		return lineOfSight;
	}
	
	public boolean isPointInLOS(MapPoint space){
		for(int i = 0; i < lineOfSight.length; i++){
			if(space.equals(lineOfSight[i]))
				return true;
		}
		return false;
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

	/**
	 * Get's the unit's data.
	 */
	public UnitData getUnitData() {
		return data;
	}
}
