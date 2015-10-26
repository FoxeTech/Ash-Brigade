package com.github.brigade.unit.dialog;

/**
 * <b>TODO</b>: Perhaps different messages return based on the user's actions
 * and abilities?
 */
public class Dialog {
	private final int dialogIndex;
	private final String text;

	/**
	 * Creates a new dialog
	 * @param dialogIndex
	 * @param text
	 */
	public Dialog(int dialogIndex, String text) {
		this.dialogIndex = dialogIndex;
		this.text = text;
	}

	/**
	 * Returns the index of the dialog
	 * @return Returns the index of the dialog
	 */
	public int getDialogIndex() {
		return dialogIndex;
	}

	/**
	 * Returns the text of the dialog
	 * @return Returns the text of the dialog
	 */
	public String getText() {
		return text;
	}
}
