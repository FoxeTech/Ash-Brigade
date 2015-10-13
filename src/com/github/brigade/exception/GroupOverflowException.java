package com.github.brigade.exception;

public class GroupOverflowException extends Exception{
	private static final long serialVersionUID = 1L;

	public GroupOverflowException(String errorReason) {
		super(errorReason);
	}
}
