package com.github.brigade.unit.units;

import com.github.brigade.render.Textures;
import com.github.brigade.unit.UnitLiving;
import com.github.brigade.unit.data.UnitData;

public class TestUnit01 extends UnitLiving{

	public TestUnit01(int origX, int origY, int health, int healthMax, UnitData data, String name) {
		super(origX, origY, health, healthMax, data, name);
		this.texture = Textures.placeHolder1;
	}

}
