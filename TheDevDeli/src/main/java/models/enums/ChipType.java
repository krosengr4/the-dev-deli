package models.enums;

public enum ChipType {

	FRENCHFRIES("French Fries"), DORITOS("Nacho Cheese Doritos"), MISS_VICKIES_JALAPENO("Miss Vickies Jalapeno Chips"), LAYS_ORIGINAL("Lays Original Potato Chips"),
	CHEETOS("Cheetos"), TAKIS("Takis"), CHEEZITS("Cheez-Its");

	private final String displayName;
	ChipType(String displayName) {
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
