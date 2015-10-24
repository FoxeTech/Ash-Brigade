package com.github.brigade.exception;

/**
 * Is thrown when the creating the window encounters an excpetion
 * @author Matt
 *
 */
public class DisplayException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Displays error message passed in
	 * @param errorReason
	 */
	public DisplayException(String errorReason) {
		super(errorReason);
	}

}
