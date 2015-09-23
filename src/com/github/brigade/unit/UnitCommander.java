package com.github.brigade.unit;

import com.github.brigade.unit.data.UnitData;

public class UnitCommander extends UnitLiving {
	protected int numSubordinates;
	protected String rankName;// TODO: Put rank types and data into EnumFaction
	protected UnitLiving[] subordinates;

	/**
	 * Instantiates the commander with an initial X,Y, current & maximum health,
	 * a name, and faction/loyalty data.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 * @param currHealth
	 *            Current health of the unit
	 * @param maxHealth
	 *            Maximum amount of health for the unit
	 * @param name
	 *            The name of the character
	 * @param data
	 *            The faction/loyalty data for the character
	 */
	public UnitCommander(int origX, int origY, int health, int healthMax, String name, UnitData data) {
		super(origX, origY, health, healthMax, data, name);
		subordinates = new UnitLiving[data.getFaction().gSize1];
	}

	public UnitCommander(int origX, int origY, int health, String name, UnitData data) {
		this(origX, origY, health, health, name, data);
	}

	/**
	 * Add's a unit to the commander's roster.
	 * 
	 * @param unit
	 * @throws ArrayIndexOutOfBoundsException
	 *             Thrown when the index is over the maximum amount of units
	 *             allowed
	 */
	public void addSubordinate(UnitLiving unit) throws ArrayIndexOutOfBoundsException {
		subordinates[numSubordinates] = unit;
		numSubordinates++;
	}

	public String getRankName() {
		return rankName;
	}

	public UnitLiving[] getSubordinates() {
		return subordinates;
	}

	/**
	 * Returns how many units the commander can command.
	 */
	public int getCommandCap() {
		return subordinates.length;
	}
}
