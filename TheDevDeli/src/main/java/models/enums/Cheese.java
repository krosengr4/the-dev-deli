package models.enums;

public enum Cheese {
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
