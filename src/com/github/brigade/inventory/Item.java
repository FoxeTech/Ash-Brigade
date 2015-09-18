package com.github.brigade.inventory;

public class Item {
	private final String name;
	private final int id;
	// TODO: More reasons/uses to make the inventory sectionalized
	private final EnumItemType itemType;

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

	public int getId() {
		return id;
	}

	public EnumItemType getItemType() {
		// TODO:
		return itemType;
	}
}
