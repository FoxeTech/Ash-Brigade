package com.github.brigade.unit.data;

/**
 * The list and properties of each faction
 * @author Chandler
 *
 */
public enum EnumFaction {
	Asian("Adesh", "", "", "", "", "", 9, 81, 729, 6561, 39366), 
	Euro("Lanett", "Contubernium", "Cohort", "", "", "", 8, 80, 480, 4920, 19680), 
	Arab("Reyan", "Squad", "Brigade", "", "", "",10, 100, 1000, 10000, 100000), 
	Rogue("Rogue", "Gang", "Bandit", "", "", "",10, 100, 1000, 10000, 100000);

	private String name, groupName1, groupName2, groupName3, groupName4, groupName5;
	private int gSize1, gSize2, gSize3, gSize4, gSize5;

	/**
	 * Creates a new faction
	 * @param name
	 * @param groupName1
	 * @param groupName2
	 * @param groupName3
	 * @param groupName4
	 * @param groupName5
	 * @param gSize1
	 * @param gSize2
	 * @param gSize3
	 * @param gSize4
	 * @param gSize5
	 */
	EnumFaction(String name, String groupName1, String groupName2, String groupName3, String groupName4, String groupName5, 
			int gSize1, int gSize2, int gSize3, int gSize4, int gSize5) {
		this.name = name;
		this.groupName1 = groupName1;
		this.groupName2 = groupName2;
		this.groupName3 = groupName3;
		this.groupName4 = groupName4;
		this.groupName5 = groupName5;
		this.gSize1 = gSize1;
		this.gSize2 = gSize2;
		this.gSize3 = gSize3;
		this.gSize4 = gSize4;
		this.gSize5 = gSize5;
	}

	/**
	 * Returns the factions name
	 * @return Returns the factions name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the group 1 name
	 * @return Returns the group 1 name
	 */
	public String getGroupName1() {
		return groupName1;
	}

	/**
	 * Returns the group 2 name
	 * @return Returns the group 2 name
	 */
	public String getGroupName2() {
		return groupName2;
	}
	
	/**
	 * Returns the group 3 name
	 * @return Returns the group 3 name
	 */
	public String getGroupName3() {
		return groupName3;
	}
	
	/**
	 * Returns the group 4 name
	 * @return Returns the group 4 name
	 */
	public String getGroupName4() {
		return groupName4;
	}
	
	/**
	 * Returns the group 5 name
	 * @return Returns the group 5 name
	 */
	public String getGroupName5() {
		return groupName5;
	}

	/**
	 * Returns the Gsize 1 
	 * @return Returns the Gsize 1
	 */
	public int getGSize1() {
		return gSize1;
	}

	/**
	 * Returns the Gsize 2
	 * @return Returns the Gsize 2
	 */
	public int getGSize2() {
		return gSize2;
	}

	/**
	 * Returns the Gsize 3
	 * @return Returns the Gsize 3
	 */
	public int getGSize3() {
		return gSize3;
	}

	/**
	 * Returns the Gsize 4
	 * @return Returns the Gsize 4
	 */
	public int getGSize4() {
		return gSize4;
	}

	/**
	 * Returns the Gsize 5
	 * @return Returns the Gsize 5
	 */
	public int getGSize5() {
		return gSize5;
	}
}
