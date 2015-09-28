package com.github.brigade.story;

import java.awt.event.ActionListener;

public class Choice{

	private String text;
	private int choiceNum;
	private ActionListener action;
	
	public Choice(ActionListener action){
		this.action = action;
	}
	
	public Choice(String text, ActionListener action){
		this.text = text;
		this.action = action;
	}
	
	public String getText(){
		return text;
	}
	
	public int getChoiceNum(){
		return choiceNum;
	}
	
	public ActionListener getAction(){
		return action;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void setChoiceNum(int choiceNum){
		this.choiceNum = choiceNum;
	}
	
}
