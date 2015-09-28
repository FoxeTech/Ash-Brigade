package com.github.brigade.story;

public class Decision {
	
	private String name;
	private String text;
	private int numChoices;
	private boolean isAlive;//if player will come across this decision later in story
	private boolean isDecisionMade;
	
	private Choice pickedChoice;
	
	Choice[] choices;
	Decision[] dependentDecisions;//decisions that are dependent on this one being alive
	
	public Decision(String name, Choice choice1, Choice choice2){
		this.name = name;
		text = "No decision for you.";
		numChoices = 2;//gotta be two otherwise its not a decision
		isAlive = true;
		isDecisionMade = false;
		
		pickedChoice = null;
		choices = new Choice[5];//assuming a max of five choices per decision
		dependentDecisions = new Decision[10];//TODO: come up with more accurate number of dependentDecisions
		
		choice1.setChoiceNum(0);
		choice2.setChoiceNum(1);
		
		choices[0] = choice1;
		choices[1] = choice2;
		
	}
	
	public Decision(String name, String text, Choice choice1, Choice choice2){
		this.name = name;
		this.text = text;
		numChoices = 2;//gotta be two otherwise its not a decision
		isAlive = true;
		isDecisionMade = false;
		
		pickedChoice = null;
		choices = new Choice[5];//assuming a max of five choices per decision
		
		choice1.setChoiceNum(0);
		choice2.setChoiceNum(1);
		
		choices[0] = choice1;
		choices[1] = choice2;
		
	}
	
	public int getNumChoices(){
		return numChoices;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	public boolean isDecisionMade(){
		return isDecisionMade;
	}
	
	public String getName(){
		return name;
	}
	
	public String getText(){
		return text;
	}
	
	public Choice getChoice(int numChoice){
		return choices[numChoice];
	}
	
	public Choice getPickedChoice(){
		return pickedChoice;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void addChoice(Choice choice){
		choice.setChoiceNum(numChoices);
		choices[numChoices] = choice;
		numChoices++;
	}
	
	public void makeChoice(int numChoice){
		isAlive = false;//to make sure player can't make decision again
		isDecisionMade = true;
		pickedChoice = choices[numChoice];
	}
	
	public void kill(){
		isAlive = false;
	}
	
}
