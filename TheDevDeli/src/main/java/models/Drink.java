package models;

import java.util.concurrent.RecursiveTask;

public class Drink implements MenuItems{

	Size size;
	DrinkType drinkType;

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
		System.out.println("Cost: " + this.getValue());
		System.out.println("------------------------------------------------");
	}
}
