package models;

import models.enums.ChipType;

public class Chip implements MenuItem {

	ChipType chipType;

	public Chip() {}

	public Chip(ChipType chipType) {
		this.chipType = chipType;
	}

	//region Getter and Setter
	public ChipType getChipType() {
		return chipType;
	}

	public void setChipType(ChipType chipType) {
		this.chipType = chipType;
	}
	//endregion

	@Override
	public double getValue() {
		if(this.chipType.equals(ChipType.FRENCHFRIES))
			return 2.75;
		else
			return 1.50;
	}

	@Override
	public void print() {
		System.out.println("-----CHIP-----");
		System.out.println("Type: " + this.chipType);
		System.out.printf("Price: $%.2f\n", this.getValue());
		System.out.println("------------------------------------------------");
	}

}
