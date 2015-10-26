package com.github.brigade.unit.unitClasses;

import com.github.brigade.unit.UnitLiving;
import com.github.brigade.unit.data.EnumFaction;
import com.github.brigade.unit.data.UnitData;

public class Bowman extends UnitLiving{

	public Bowman(int origX, int origY, int index){
		super(origX, origY, 10, new UnitData(index, -1, 10, EnumFaction.Lanett), "Bowman");
		stats.setAccuracy(0.95f);
		stats.setAgility(3);
		stats.setAttack(5);
		stats.setCriticalChance(0.05f);
		stats.setDefense(2);
	}
	
}
