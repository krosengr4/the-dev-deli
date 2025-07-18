package models.enums;

public enum Size {

    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

	private final String displayName;
	Size(String displayName) {
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
