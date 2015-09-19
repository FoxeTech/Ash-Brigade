package com.github.brigade.inventory;

import com.github.brigade.exception.InventoryException;

/**
 * <b>TODO:</b> Make method for increasing/decreasing the inventory
 *
 */
public class Inventory {
	private final Item[] potions = new Item[16];
	private final Item[] armor = new Item[6];
	private final Item[] weapons = new Item[6];
	private final Item[] misc = new Item[6];

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
	 * 	inv.loadItems(newInventory, EnumItemType.Potion);
	 * } catch (InventoryException e) {
	 * 	// Handle the error.
	 * }
	 * </pre>
	 * 
	 * @param items
	 *            The new array of items to become the inventory
	 * @param type
	 *            The inventory type
	 * @throws InventoryException
	 *             If the size of the parameter items does not match the
	 *             inventory's length
	 */
	public void loadItems(Item[] items, EnumItemType type) throws InventoryException {
		switch (type) {
		case Armor:
			if (this.armor.length != items.length) {
				throw new InventoryException("Tried loading a inventory of invalid size (Loaded:" + items.length + ", Expected:" + this.armor.length + ")");
			}
			for (int i = 0; i < items.length; i++) {
				setItem(i, items[i], type);
			}
			break;

		case Potion:
			if (this.potions.length != items.length) {
				throw new InventoryException("Tried loading a inventory of invalid size (Loaded:" + items.length + ", Expected:" + this.potions.length + ")");
			}
			for (int i = 0; i < items.length; i++) {
				setItem(i, items[i], type);
			}
			break;
		case Weapon:
			if (this.weapons.length != items.length) {
				throw new InventoryException("Tried loading a inventory of invalid size (Loaded:" + items.length + ", Expected:" + this.weapons.length + ")");
			}
			for (int i = 0; i < items.length; i++) {
				setItem(i, items[i], type);
			}
			break;
		case Misc:
			if (this.misc.length != items.length) {
				throw new InventoryException("Tried loading a inventory of invalid size (Loaded:" + items.length + ", Expected:" + this.misc.length + ")");
			}
			for (int i = 0; i < items.length; i++) {
				setItem(i, items[i], type);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Sets an item in the inventory at a given index (of the given type) to a
	 * given item. <br>
	 * 
	 * Example:
	 * <pre>
	 * Item i = ... //get the item in some way
	 * unit.getInventory().setItem(i.getInventorySlot(), new Item(...), EnumItemType.Potion);
	 * </pre>
	 * 
	 * @param index
	 *            Index for setting
	 * @param item
	 *            The new item
	 * @param type
	 *            The inventory type
	 * @throws InventoryException Thrown if the index is over the intended array's bounds
	 */
	public void setItem(int index, Item item, EnumItemType type) throws InventoryException {
		switch (type) {
		case Armor:
			if (this.armor.length >= index) {
				throw new InventoryException("Tried setting an item in an invalid index (Tried:" + index + ", Array Length:" + this.armor.length + ")");
			}
			this.armor[index] = item;
			item.setInventorySlot(index);
			break;
		case Potion:
			if (this.potions.length >= index) {
				throw new InventoryException("Tried setting an item in an invalid index (Tried:" + index + ", Array Length:" + this.potions.length + ")");
			}
			this.potions[index] = item;
			item.setInventorySlot(index);
			break;
		case Weapon:
			if (this.weapons.length >= index) {
				throw new InventoryException("Tried setting an item in an invalid index (Tried:" + index + ", Array Length:" + this.weapons.length + ")");
			}
			this.weapons[index] = item;
			item.setInventorySlot(index);
			break;
		case Misc:
			if (this.misc.length >= index) {
				throw new InventoryException("Tried setting an item in an invalid index (Tried:" + index + ", Array Length:" + this.misc.length + ")");
			}
			this.misc[index] = item;
			item.setInventorySlot(index);
			break;
		default:
			break;
		}
	}

	/**
	 * Gets an item from the inventory at the given index (of the given type).
	 * <br>
	 * Example usage:
	 * 
	 * <pre>
	 * Item heldItem = unit.getInventory().getItem(0, EnumItemType.Potion)); 
	 * if (heldItem != null){
	 * //code Here
	 * }
	 * </pre>
	 * 
	 * @param index
	 * @param type
	 *            The inventory type
	 * @return Returns null if type is not valid
	 */
	public Item getItem(int index, EnumItemType type) {
		switch (type) {
		case Armor:
			return this.armor[index];
		case Misc:
			return this.misc[index];
		case Potion:
			return this.potions[index];
		case Weapon:
			return this.weapons[index];
		default:
			break;
		}
		return null;
	}

	/**
	 * Returns the array of items of the given type in the inventory. <br>
	 * Example usage:
	 * 
	 * <pre>
	 * for (Item item : unit.getInventory().getItems(EnumItemType.Potion)) {
	 * 	// Item slots not filled will be null
	 * 	if (item == null)
	 * 		continue;
	 * 	// code here
	 * }
	 * </pre>
	 * 
	 * @return Returns null if type is not valid
	 */
	public Item[] getItems(EnumItemType type) {
		switch (type) {
		case Armor:
			return this.armor;
		case Potion:
			return this.potions;
		case Weapon:
			return this.weapons;
		case Misc:
			return this.misc;
		default:
			break;
		}
		return null;
	}

	/**
	 * Returns the length of the inventory array.
	 * 
	 * @param type
	 *            The inventory type
	 * @return Returns -1 if type is not valid
	 */
	public int length(EnumItemType type) {
		switch (type) {
		case Armor:
			return this.armor.length;
		case Potion:
			return this.potions.length;
		case Weapon:
			return this.weapons.length;
		case Misc:
			return this.misc.length;
		default:
			break;
		}
		return -1;
	}
}
