package com.github.brigade.unit.unitClasses;

import com.github.brigade.unit.UnitLiving;
import com.github.brigade.unit.data.EnumFaction;
import com.github.brigade.unit.data.UnitData;

public class TestUnit extends UnitLiving{

	public TestUnit(int origX, int origY, int index, EnumFaction faction) {
		super(origX, origY, 100, new UnitData(index, -1, 10, faction), "Test Unit");
		stats.setAccuracy(1f);
		stats.setAgility(5);
		stats.setAttack(100);
		stats.setCriticalChance(0f);
		stats.setDefense(1);
	}

}
