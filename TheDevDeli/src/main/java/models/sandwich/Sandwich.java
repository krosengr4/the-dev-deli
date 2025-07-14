package models.sandwich;

import models.MenuItems;
import models.enums.Size;

import java.util.List;

public class Sandwich implements MenuItems {

	private Size size;
	private Bread bread;
	private Meat meat;
	private Cheese cheese;
	private List<Sauce> sauces;
	private List<Topping> toppings;
	private boolean isToasted;
	private boolean hasExtraMeat;
	private boolean hasExtraCheese;

	public Sandwich(Size size, Bread bread, Meat meat, Cheese cheese, List<Sauce> sauces, List<Topping> toppings, boolean isToasted, boolean hasExtraCheese, boolean hasExtraMeat) {
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
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Bread getBread() {
		return bread;
	}

	public void setBread(Bread bread) {
		this.bread = bread;
	}

	public Meat getMeat() {
		return meat;
	}

	public void setMeat(Meat meat) {
		this.meat = meat;
	}

	public Cheese getCheese() {
		return cheese;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	public List<Sauce> getSauces() {
		return sauces;
	}

	public void setSauces(List<Sauce> sauces) {
		this.sauces = sauces;
	}

	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}

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
	//endregion

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
		System.out.println("Size: " + this.size.getDisplayName());
		System.out.println("Bread: " + this.bread.getDisplayName());
		System.out.println("Meat: " + this.meat.getDisplayName());
		if(this.hasExtraMeat)
			System.out.println("Extra " + this.meat.getDisplayName() + "!");

		System.out.println("Cheese: " + this.cheese.getDisplayName());
		if(this.hasExtraCheese)
			System.out.println("Extra " + this.cheese.getDisplayName() + "!");

		for(Sauce sauce : this.sauces) {
			System.out.println(sauce.getDisplayName() + " Sauce");
		}
		for(Topping topping : toppings) {
			System.out.println(topping.getDisplayName());
		}

		if(this.isToasted)
			System.out.println("Toasted!");
	}
}
