package models.enums;

public enum Bread {
	WHITE("White"), WHEAT("Wheat"), RYE("Rye"), WRAP("Wrap"), SOURDOUGH("Sourdough");

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
