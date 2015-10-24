package com.github.brigade.exception;

/**
 * 
 * @author Chandler
 *
 */
public class InventoryException extends Exception {
	private static final long serialVersionUID = 1L;

	public InventoryException(String errorReason) {
		super(errorReason);
	}

}
