package com.github.brigade.unit;

import com.github.brigade.unit.data.UnitData;
import com.github.brigade.unit.dialog.Dialog;

public class UnitCharacter extends UnitLiving {
	protected Dialog[] dialogs;

	/**
	 * Instantiates the unit with an initial X,Y, current & maximum health, a
	 * name, faction/loyalty data, and a list of character dialog.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 * @param currHealth
	 *            Current health of the unit
	 * @param maxHealth
	 *            Maximum amount of health for the unit
	 * @param name
	 *            The name of the character
	 * @param data
	 *            The faction/loyalty data for the character
	 * @param dialogs
	 *            The dialogs for the character
	 */
	public UnitCharacter(int origX, int origY, int health, int healthMax, String name, UnitData data, Dialog[] dialogs) {
		super(origX, origY, health, healthMax, data, name);
		this.dialogs = dialogs;
	}

	/**
	 * Instantiates the unit with an initial X,Y, current & maximum health, a
	 * name, and faction/loyalty data.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 * @param currHealth
	 *            Current health of the unit
	 * @param maxHealth
	 *            Maximum amount of health for the unit
	 * @param name
	 *            The name of the character
	 * @param data
	 *            The faction/loyalty data for the character
	 */
	public UnitCharacter(int origX, int origY, int health, int healthMax, UnitData data) {
		this(origX, origY, health, healthMax, UnitConstants.DEFAULT_NAME, data, null);
	}

	/**
	 * Instantiates the unit with an initial X,Y, current & maximum health, a
	 * name, and faction/loyalty data.
	 * 
	 * @param origX
	 *            Original and current X of the unit
	 * @param origY
	 *            Original and current Y of the unit
	 * @param health
	 *            Health of the unit
	 * @param name
	 *            The name of the character
	 * @param data
	 *            The faction/loyalty data for the character
	 */
	public UnitCharacter(int origX, int origY, int health, String name, UnitData data) {
		this(origX, origY, health, health, name, data, null);
	}

	/**
	 * Returns if the unit has dialog.
	 */
	public boolean hasDialog() {
		return dialogs == null ? false : dialogs.length == 0 ? false : true;
	}

	/**
	 * Returns the dialog's text based on a given index.
	 * 
	 * @param index
	 *            The dialog index
	 */
	public String getDialog(int index) {
		return dialogs[index].getText();
	}

	/**
	 * Returns the array of the unit's dialog.
	 */
	public Dialog[] getDialogs() {
		return dialogs;
	}

	/**
	 * Adds a dialog to the unit's array. <br>
	 * <hr>
	 * <b>TODO</b>: Redo in effecient way ( <a href=
	 * "http://stackoverflow.com/questions/1427200/most-memory-efficient-way-to-grow-an-array-in-java">
	 * StackOverflow with good insight</a>)
	 */
	public void addDialog(String text) {
		Dialog[] oldDialog = getDialogs();
		if (oldDialog == null) {
			dialogs = new Dialog[] { new Dialog(0, text) };
		} else {
			int newLength = oldDialog.length + 1;
			dialogs = new Dialog[newLength];
			for (int i = 0; i < newLength - 1; i++) {
				dialogs[i] = oldDialog[i];
			}
			dialogs[newLength] = new Dialog(newLength, text);
		}
	}
}
