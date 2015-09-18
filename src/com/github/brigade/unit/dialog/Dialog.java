package com.github.brigade.unit.dialog;

/**
 * <b>TODO</b>: Perhaps different messages return based on the user's actions
 * and abilities?
 */
public class Dialog {
	private final int dialogIndex;
	private final String text;

	public Dialog(int dialogIndex, String text) {
		this.dialogIndex = dialogIndex;
		this.text = text;
	}

	public int getDialogIndex() {
		return dialogIndex;
	}

	public String getText() {
		return text;
	}
}
