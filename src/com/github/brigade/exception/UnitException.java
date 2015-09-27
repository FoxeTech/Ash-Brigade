package com.github.brigade.exception;

public class UnitException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnitException(String errorReason) {
		super(errorReason);
	}
}
