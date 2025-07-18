package models.enums;

public enum Sauce {
	MAYO("Mayo"), MUSTARD("Mustard"), KETCHUP("Ketchup"), RANCH("Ranch"), THOUSANDISLANDS("Thousand Islands"), VINAIGRETTE("Vinaigrette"), AUJUS("Au Jus"), BBQ("Barbeque"), NONE("No Sauce");

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
