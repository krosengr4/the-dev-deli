package models.sandwich;

import models.MenuItem;
import models.enums.Size;

import java.util.List;

public class Sandwich implements MenuItem {

	private Size size;
	private SandwichOptions.Bread bread;
	private SandwichOptions.Meat meat;
	private SandwichOptions.Cheese cheese;
	private List<SandwichOptions.Sauce> sauces;
	private List<SandwichOptions.Topping> toppings;
	//this is a boolean to determine if sandwich is toasted(true) or not(false).
	private boolean isToasted;
	private boolean hasExtraMeat;
	private boolean hasExtraCheese;

	public Sandwich() {}

	public Sandwich(Size size, SandwichOptions.Bread bread, SandwichOptions.Meat meat, SandwichOptions.Cheese cheese, List<SandwichOptions.Sauce> sauces,
					List<SandwichOptions.Topping> toppings, boolean isToasted, boolean hasExtraCheese, boolean hasExtraMeat) {
		this.size = size;
		this.bread = bread;
		this.meat = meat;
		this.cheese = cheese;
		this.sauces = sauces;
		this.toppings = toppings;
		this.isToasted = isToasted;
		this.hasExtraCheese = hasExtraCheese;
		this.hasExtraMeat = hasExtraMeat;
	}

	//region Getters and Setters
	public boolean isToasted() {
		return isToasted;
	}

	public void setToasted(boolean toasted) {
		isToasted = toasted;
	}

	public boolean isHasExtraMeat() {
		return hasExtraMeat;
	}

	public void setHasExtraMeat(boolean hasExtraMeat) {
		this.hasExtraMeat = hasExtraMeat;
	}

	public boolean isHasExtraCheese() {
		return hasExtraCheese;
	}

	public void setHasExtraCheese(boolean hasExtraCheese) {
		this.hasExtraCheese = hasExtraCheese;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setBread(SandwichOptions.Bread bread) {
		this.bread = bread;
	}

	public void setMeat(SandwichOptions.Meat meat) {
		this.meat = meat;
	}

	public void setCheese(SandwichOptions.Cheese cheese) {
		this.cheese = cheese;
	}

	public void setSauces(List<SandwichOptions.Sauce> sauces) {
		this.sauces = sauces;
	}

	public void setToppings(List<SandwichOptions.Topping> toppings) {
		this.toppings = toppings;
	}
//endregion

	//! Might wanna think about refactoring...
	@Override
	public double getValue() {
		double value = 0.0;

		switch (this.size) {
			case SMALL -> {
				value = 5.5;

				//Calculate value for adding meat and cheese
				if (this.meat != SandwichOptions.Meat.NONE) {
					value += 1.00;
				}
				if (this.cheese != SandwichOptions.Cheese.NONE) {
					value += 0.75;
				}
				//Calculate value for adding EXTRA meat and cheese
				if (this.hasExtraMeat) {
					value += 0.50;
				}
				if (this.hasExtraCheese) {
					value += 0.30;
				}
			}
			case MEDIUM -> {
				value = 7.00;

				//Calculate value for adding meat and cheese
				if (this.meat != SandwichOptions.Meat.NONE) {
					value += 2.00;
				}
				if (this.cheese != SandwichOptions.Cheese.NONE) {
					value += 1.50;
				}
				//Calculate value for adding EXTRA meat and cheese
				if (this.hasExtraMeat) {
					value += 1.00;
				}
				if (this.hasExtraCheese) {
					value += 0.60;
				}
			}
			case LARGE -> {
				value = 8.50;

				//Calculate value for adding meat and cheese
				if (this.meat != SandwichOptions.Meat.NONE) {
					value += 3.00;
				}
				if (this.cheese != SandwichOptions.Cheese.NONE) {
					value += 2.25;
				}
				//Calculate value for adding EXTRA meat and cheese
				if (this.hasExtraMeat) {
					value += 1.50;
				}
				if (this.hasExtraCheese) {
					value += 0.90;
				}
			}
			default -> System.out.println("ERROR! models.enums.Size needs to be SMALL, MEDIUM, OR LARGE!");
		}

		return value;
	}

	@Override
	public void print() {
		System.out.println("-----SANDWICH------");
		System.out.println("Size: " + this.size.getDisplayName());
		System.out.println("Bread: " + this.bread.getDisplayName());
		System.out.println("Meat: " + this.meat.getDisplayName());
		if(this.hasExtraMeat)
			System.out.println("Extra " + this.meat.getDisplayName() + "!");

		System.out.println("Cheese: " + this.cheese.getDisplayName());
		if(this.hasExtraCheese)
			System.out.println("Extra " + this.cheese.getDisplayName() + "!");

		for(SandwichOptions.Sauce sauce : this.sauces) {
			System.out.println(sauce.getDisplayName() + " Sauce");
		}
		for(SandwichOptions.Topping topping : toppings) {
			System.out.println(topping.getDisplayName());
		}

		if(this.isToasted)
			System.out.println("Toasted!");

		System.out.printf("\nPrice: $%.2f\n", this.getValue());
	}
}
