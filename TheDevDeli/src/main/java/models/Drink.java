package models;

import models.enums.DrinkType;
import models.enums.Size;

public class Drink implements MenuItem {

	Size size;
	DrinkType drinkType;

	public Drink() {}

	public Drink(Size size, DrinkType drinkType) {
		this.size = size;
		this.drinkType = drinkType;
	}

	//region getters and setter
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public DrinkType getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}
	//endregion

	@Override
	public double getValue() {
		double value = 0.0;

		if(!this.drinkType.equals(DrinkType.WATER)) {
			switch(this.size) {
				case SMALL -> value = 2.00;
				case MEDIUM -> value = 2.50;
				case LARGE -> value = 3.00;
				default -> System.err.println("ERROR! INCORRECT DRINK SIZE!!!");
			}
		}

		return value;
	}

	@Override
	public void print() {
		System.out.println("-----DRINK-----");
		System.out.println("Type: " + this.drinkType);
		System.out.println("Size: " + this.size);
		System.out.printf("Price: $%.2f\n", this.getValue());
		System.out.println("------------------------------------------------");
	}
}
