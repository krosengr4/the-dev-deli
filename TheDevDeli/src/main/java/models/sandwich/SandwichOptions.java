package models.sandwich;

enum Bread {
	WHITE("White"), WHEAT("Wheat"), RYE("Rye"), WRAP("Wrap");

	private final String displayName;
	Bread(String displayName) {
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

enum Meat {
	STEAK("Steak"), HAM("Ham"), SALAMI("Salami"), ROASTBEEF("Roast Beef"), CHICKEN("Chicken"), BACON("Bacon"), NONE("No Meat");

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

enum Cheese {
	AMERICAN("American"), PROVOLONE("Provolone"), CHEDDAR("Cheddar"), SWISS("Swiss"), NONE("No Cheese");

	private final String displayName;
	Cheese(String displayName) {
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

enum Topping {
	LETTUCE("Lettuce"), PEPPERS("Peppers"), ONIONS("Onions"), TOMATOES("Tomatoes"), JALAPENOS("Jalapenos"), CUCUMBERS("Cucumbers"),
	PICKLES("Pickles"), GUACAMOLE("Guacamole"), MUSHROOMS("Mushrooms"), NONE("No Topping");

	private final String displayName;
	Topping(String displayName) {
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

enum Sauce {
	MAYO("Mayo"), MUSTARD("Mustard"), KETCHUP("Ketchup"), RANCH("Ranch"), THOUSANDISLANDS("Thousand Islands"), VINAIGRETTE("Vinaigrette"), AUJUS("Au Jus"), NONE("No Sauce");

	private final String displayName;
	Sauce(String displayName) {
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



