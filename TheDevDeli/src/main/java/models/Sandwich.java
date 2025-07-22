package models;

import models.enums.*;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements MenuItem {

	private Size size;
	private Bread bread;
	private Meat meat;
	private Cheese cheese;
	private List<Sauce> sauceList = new ArrayList<>();
	private List<Topping> toppingList = new ArrayList<>();
	//this is a boolean to determine if sandwich is toasted(true) or not(false).
	private boolean isToasted;
	private boolean hasExtraMeat;
	private boolean hasExtraCheese;

	public Sandwich() {}

	public Sandwich(Size size, Bread bread, Meat meat, Cheese cheese, List<Sauce> sauces,
					List<Topping> toppings, boolean isToasted, boolean hasExtraCheese, boolean hasExtraMeat) {
		this.size = size;
		this.bread = bread;
		this.meat = meat;
		this.cheese = cheese;
		this.sauceList = sauces;
		this.toppingList = toppings;
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

	public void setBread(Bread bread) {
		this.bread = bread;
	}

	public void setMeat(Meat meat) {
		this.meat = meat;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	public void setSauceList(Sauce sauce) {
		this.sauceList.add(sauce);
	}

	public void setToppingList(Topping topping) {
		this.toppingList.add(topping);
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
				if (this.meat != Meat.NONE) {
					value += 1.00;
				}
				if (this.cheese != Cheese.NONE) {
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
				if (this.meat != Meat.NONE) {
					value += 2.00;
				}
				if (this.cheese != Cheese.NONE) {
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
				if (this.meat != Meat.NONE) {
					value += 3.00;
				}
				if (this.cheese != Cheese.NONE) {
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
		System.out.println("Size: " + Utils.BLUE + this.size.getDisplayName() + Utils.RESET);
		System.out.println("Bread: " + Utils.BLUE + this.bread.getDisplayName() + Utils.RESET);
		System.out.println("Meat: " + Utils.BLUE + this.meat.getDisplayName() + Utils.RESET);
		if(this.hasExtraMeat)
			System.out.println(Utils.BLUE + "Extra " + this.meat.getDisplayName() + "!" + Utils.RESET);

		System.out.println("Cheese: " + Utils.BLUE + this.cheese.getDisplayName() + Utils.RESET);
		if(this.hasExtraCheese)
			System.out.println(Utils.BLUE + "Extra " + this.cheese.getDisplayName() + "!" + Utils.RESET);

		System.out.println("Sauces: ");
		if(sauceList.isEmpty()) {
			System.out.println(Utils.RED + "None." + Utils.RESET);
		} else {
			for(Sauce sauce : this.sauceList) {
				System.out.println(Utils.BLUE + sauce.getDisplayName() + " Sauce" + Utils.RESET);
			}
		}
		System.out.println("Toppings: ");
		if(toppingList.isEmpty()) {
			System.out.println(Utils.RED + "None" + Utils.RESET);
		} else {
			for(Topping topping : toppingList) {
				System.out.println(Utils.BLUE + topping.getDisplayName() + Utils.RESET);
			}
		}

		if(this.isToasted)
			System.out.println(Utils.BLUE + "Toasted!" + Utils.RESET);

		System.out.printf("Price:%s $%.2f%s\n", Utils.GREEN, this.getValue(), Utils.RESET);
		System.out.println("------------------------------------------------");
	}
}
