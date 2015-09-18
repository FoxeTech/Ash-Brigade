package com.github.brigade.unit;

import com.github.brigade.inventory.Inventory;

public class UnitLiving extends Unit {
	// TODO: Inventory for items and something else for Armor? How exactly is
	// armor working for units?
	// Idea 1: Have sectionalized inventory (one section being armor)
	// Idea 2: Have armor be linked to an upgrade system (like a tech tree)
	private final Inventory inventory = new Inventory();
	private int health, healthMax;
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
	 */
	public UnitLiving(int origX, int origY, int health, int healthMax) {
		super(origX, origY);
		this.health = health;
		this.healthMax = healthMax;
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
	 */
	public UnitLiving(int origX, int origY, int health) {
		this(origX, origY, health, health);
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

	/**
	 * Gets the inventory of the current unit.
	 * 
	 * @return inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}
}
