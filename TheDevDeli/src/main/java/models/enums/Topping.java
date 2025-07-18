package models.enums;

public enum Topping {
	LETTUCE("Lettuce"), PEPPERS("Peppers"), ONIONS("Onions"), TOMATO("Tomatoes"), JALAPENOS("Jalapenos"), CUCUMBERS("Cucumbers"),
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
