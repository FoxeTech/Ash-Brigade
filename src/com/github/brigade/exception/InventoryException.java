package com.github.brigade.exception;

public class InventoryException extends Exception {
	private static final long serialVersionUID = 1L;

	public InventoryException(String errorReason) {
		super(errorReason);
	}

}
