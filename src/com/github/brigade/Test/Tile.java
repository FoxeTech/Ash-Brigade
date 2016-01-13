package com.github.brigade.Test;

import org.newdawn.slick.opengl.Texture;

import com.github.brigade.render.DrawUtil;
import com.github.brigade.unit.Unit;

public class Tile {
	private int x, y, size;
	private Texture texture;
	private Unit unit;
	
	public Tile(int x, int y, int size, Texture texture){
		this.x = x;
		this.y = y;
		this.size = size;
		this.texture = texture;
	}
	
	public void addUnit(Unit unit){
		this.unit = unit;
	}
	
	public Unit getUnit(){
		return unit;
	}
	
	public void render(){
		DrawUtil.drawRectangle(x, y, size, size, texture);
		if(unit != null){
			DrawUtil.drawRectangle(x, y, size, size, unit.getTexture());
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
}
