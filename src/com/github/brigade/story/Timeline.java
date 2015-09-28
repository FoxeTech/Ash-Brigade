package com.github.brigade.story;

public class Timeline {

	private int numDecisions;
	private Decision[] decisions;
	
	public Timeline(){
		numDecisions = 0;
		decisions = new Decision[10];//TODO: come up with more accurate number of Decisions
	}
	
	public Decision getDecision(int numDecision){
		return decisions[numDecision];
	}
	
	public void addDecision(Decision decision){
		decisions[numDecisions] = decision;
		numDecisions++;
	}
	
}
