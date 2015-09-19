package com.github.brigade.inventory;

public class Item {
	private final String name;
	private final int id;
	private final EnumItemType itemType;
	private int inventorySlot = -1;

	/**
	 * Instantiates the item with a name, id, and type.
	 * 
	 * @param name
	 * @param id
	 * @param itemType
	 */
	public Item(String name, int id, EnumItemType itemType) {
		this.name = name;
		this.id = id;
		this.itemType = itemType;
	}

	/**
	 * Instantiates the item with a name and id. The item type is defaulted to
	 * Misc.
	 * 
	 * @param name
	 * @param id
	 */
	public Item(String name, int id) {
		this(name, id, EnumItemType.Misc);
	}

	public String getName() {
		return name;
	}

	/**
	 * Updates the item, letting it know what slot in the inventory it is in.
	 * 
	 * @param inventorySlot
	 *            The slot
	 */
	public void setInventorySlot(int inventorySlot) {
		this.inventorySlot = inventorySlot;
	}

	/**
	 * Get's the item's current index in the character's inventory.
	 * 
	 * @return Returns -1 if the slot has not been set
	 */
	public int getInventorySlot() {
		return inventorySlot;
	}

	public int getId() {
		return id;
	}

	public EnumItemType getItemType() {
		return itemType;
	}
}
