package models.enums;

import java.util.List;

public enum SignatureSandwiches {

	THE_COWBOY(
			Size.LARGE,
			Bread.SOURDOUGH,
			Meat.ROAST_BEEF,
			Cheese.CHEDDAR,
			List.of(Topping.LETTUCE, Topping.ONIONS, Topping.JALAPENOS),
			Sauce.BBQ,
			true
	),

	BLT(
			Size.MEDIUM,
			Bread.WHITE,
			Meat.BACON,
			Cheese.CHEDDAR,
			List.of(Topping.LETTUCE, Topping.TOMATO),
			Sauce.RANCH,
			true
	),

	PHILLY_CHEESE_STEAK(
			Size.MEDIUM,
			Bread.WHITE,
			Meat.STEAK,
			Cheese.AMERICAN,
			List.of(Topping.PEPPERS),
			Sauce.MAYO,
			true
	);

	private final Size size;
	private final Bread bread;
	private final Meat meat;
	private final Cheese cheese;
	private final List<Topping> toppings;
	private final Sauce sauce;
	private final boolean isToasted;

	SignatureSandwiches(Size size, Bread bread, Meat meat, Cheese cheese, List<Topping> toppings, Sauce sauce, boolean isToasted) {
		this.size = size;
		this.bread = bread;
		this.meat = meat;
		this.cheese = cheese;
		this.toppings = toppings;
		this.sauce = sauce;
		this.isToasted = isToasted;
	}
}
