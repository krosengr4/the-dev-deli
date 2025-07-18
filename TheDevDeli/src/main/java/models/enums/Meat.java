package models.enums;

public enum Meat {
	STEAK("Steak"), HAM("Ham"), SALAMI("Salami"), ROAST_BEEF("Roast Beef"), CHICKEN("Chicken"), BACON("Bacon"), NONE("No Meat");

	private final String displayName;

	Meat(String displayName) {
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
