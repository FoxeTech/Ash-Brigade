package com.github.brigade.unit.data;

public class StatHandler {
	
	private int attack;
	private int defense;
	private int agility;
	
	private float accuracy;
	private float accuracyDecay;
	private float criticalChance;
	
	/**
	 * 
	 * Instantiates all unit stats to 0 and saves unit's current faction.
	 * 
	 * @param faction
	 * 			The name of the faction that the unit is a part of.
	 * 
	 */
	public StatHandler(){
		attack = 0;
		defense = 0;
		agility = 0;
		
		accuracy = 0;
		accuracyDecay = 0;
		criticalChance = 0;
	}
	
	/**
	 * Sets the unit's attack power.
	 * 
	 * @param attack
	 * 			The unit's new attack power.
	 */
	public void setAttack(int attack){
		this.attack = attack;
	}
	
	/**
	 * Sets the unit's defense power.
	 * 
	 * @param defense
	 * 			The unit's new defense power.
	 */
	public void setDefense(int defense){
		this.defense = defense;
	}
	
	/**
	 * Sets the unit's agility rating.
	 * 
	 * @param agility
	 * 			The unit's new agility rating.
	 */
	public void setAgility(int agility){
		this.agility = agility;
	}
	
	/**
	 * Sets the unit's accuracy rating.
	 * 
	 * @param accuracy
	 * 			The unit's new accuracy rating.
	 */
	public void setAccuracy(float accuracy){
		this.accuracy = accuracy;
	}
	
	/**
	 * Sets the unit's new accuracy decay rating.
	 * 
	 * @param accuracyDecay
	 * 			The unit's new accuracy decay rating.
	 */
	public void setAccuracyDecay(float accuracyDecay){
		this.accuracyDecay = accuracyDecay;
	}
	
	/**
	 * Sets the unit's new critical chance rating.
	 * 
	 * @param criticalChance
 * 				The unit's new critical chance rating.
	 */
	public void setCriticalChance(float criticalChance){
		this.criticalChance = criticalChance;
	}
	
	/**
	 * Gives the attack power of the unit.
	 * 
	 * @return attack
	 */
	public int getAttack(){
		return attack;
	}
	
	/**
	 * Gives the defense power of the unit.
	 * 
	 * @return defense
	 */
	public int getDefense(){
		return defense;
	}
	
	/**
	 * Gives the agility rating of the unit.
	 * 
	 * @return agility
	 */
	public int getAgility(){
		return agility;
	}
	
	/**
	 * Gives the accuracy rating of the unit.
	 * 
	 * @return accuracy
	 */
	public float getAccuracy(){
		return accuracy;
	}
	
	/**
	 * Gives the accuracy decay rating of the unit.
	 * 
	 * @return accuracyDecay
	 */
	public float getAccuracyDecay(){
		return accuracyDecay;
	}
	
	/**
	 * Gives the critical chance rating of the unit.
	 * 
	 * @return criticalChance
	 */
	public float getCriticalChance(){
		return criticalChance;
	}
	
}
