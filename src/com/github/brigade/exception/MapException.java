package com.github.brigade.exception;

public class MapException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MapException(String errorReason){
		super(errorReason);
	}

}
