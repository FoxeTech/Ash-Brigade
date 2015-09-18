package com.github.brigade.inventory;

import com.github.brigade.exception.InventoryException;

public class Inventory {
	// TODO: Have sectionalized items (Combat items, Potions, etc.)
	// Could be a function to just get a certain range or have separate arrays.
	private final Item[] items = new Item[20];

	/**
	 * Sets the inventory's item array to another item array. <br>
	 * Example:
	 * 
	 * <pre>
	 * Inventory inv = unit.getInventory();
	 * int invLength = inv.lenght();
	 * Item[] newInventory = new Item[invLength];
	 * // Load items into the array
	 * try {
	 * 	inv.loadItems(newInventory);
	 * } catch (InventoryException e) {
	 * 	// Handle the error.
	 * }
	 * </pre>
	 * 
	 * @param items
	 *            The new array of items to become the inventory
	 * @throws InventoryException
	 *             If the size of the parameter items does not match the
	 *             inventory's length
	 */
	public void loadItems(Item[] items) throws InventoryException {
		if (this.items.length != items.length) {
			throw new InventoryException("Tried loading a inventory of invalid size (Loaded:" + items.length + ", Expected:" + this.items.length + ")");
		}
		for (int i = 0; i < items.length; i++) {
			setItem(i, items[i]);
		}
	}

	/**
	 * Sets an item in the inventory at a given index to a given item. <br>
	 * <hr>
	 * <b>TODO</b>: For ease of access, items can have a field (int invSlot)
	 * that will be set here notifying it which slot it is in. The Item's field
	 * will be handled here so that a dev could use code such as: <br>
	 * 
	 * <pre>
	 * Item i = ... //get the item in some way
	 * unit.getInventory().setItem(i.getInventorySlot(), new Item(...)); //Swap it out (potentially move it to another slot)
	 * </pre>
	 * 
	 * @param index
	 *            Index for setting
	 * @param item
	 *            The new item
	 */
	public void setItem(int index, Item item) {

		this.items[index] = item;
	}

	/**
	 * Gets an item from the inventory at the given index.<br>
	 * Example usage:
	 * 
	 * <pre>
	 * Item heldItem = unit.getInventory().getItem(0)); 
	 * if (heldItem != null){
	 * //code Here
	 * }
	 * </pre>
	 * 
	 * @param index
	 * @return
	 */
	public Item getItem(int index) {
		return items[index];
	}

	/**
	 * Returns the array of items in the inventory. <br>
	 * Example usage:
	 * 
	 * <pre>
	 * for (Item item : unit.getInventory().getItems()) {
	 * 	// Item slots not filled will be null
	 * 	if (item == null)
	 * 		continue;
	 * 	// code here
	 * }
	 * </pre>
	 * 
	 * @return
	 */
	public Item[] getItems() {
		return items;
	}

	/**
	 * Returns the length of the inventory array.
	 * 
	 * @return items.length
	 */
	public int length() {
		return items.length;
	}
}
