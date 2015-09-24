package com.github.brigade.unit.data;

public enum EnumFaction {
	Asian("Adesh", "", "", 9, 81, 729, 6561, 39366), 
	Euro("Lanett", "", "", 8, 80, 480, 4920, 19680), 
	Arab("Reyan", "Squad", "Brigade", 10, 100, 1000, 10000, 100000), 
	Rogue("Rogue", "Gang", "Bandit", 10, 100, 1000, 10000, 100000);

	private String name, groupName1, groupName2;
	private int gSize1, gSize2, gSize3, gSize4, gSize5;

	EnumFaction(String name, String groupName1, String groupName2, int gSize1, int gSize2, int gSize3, int gSize4, int gSize5) {
		this.name = name;
		this.groupName1 = groupName1;
		this.groupName2 = groupName2;
		this.gSize1 = gSize1;
		this.gSize2 = gSize2;
		this.gSize3 = gSize3;
		this.gSize4 = gSize4;
		this.gSize5 = gSize5;
	}

	public String getName() {
		return name;
	}

	public String getGroupName1() {
		return groupName1;
	}

	public String getGroupName2() {
		return groupName2;
	}

	public int getGSize1() {
		return gSize1;
	}

	public int getGSize2() {
		return gSize2;
	}

	public int getGSize3() {
		return gSize3;
	}

	public int getGSize4() {
		return gSize4;
	}

	public int getGSize5() {
		return gSize5;
	}
}
