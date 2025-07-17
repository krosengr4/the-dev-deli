package models.enums;

public enum DrinkType {

	FOUNTAIN("Fountain Drink"), LEMONADE("Lemonade"), SWEET_TEA("Sweet Tea"), UNSWEET_TEA("Unsweet Tea"), MILKSHAKE("Milkshake"), JUICE("Juice"), WATER("Water");

	private final String displayName;
	DrinkType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String toString() {
		return displayName;
	}

}
