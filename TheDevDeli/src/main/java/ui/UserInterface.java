package ui;

import models.MenuItem;
import models.Order;
import models.sandwich.Sandwich;
import utils.Utils;

import java.util.List;

public class UserInterface {

	public int displayMainMenu() {
		System.out.println(Utils.BLUE + "\n\t\t---MAIN MENU---" + Utils.RESET);
		Utils.designLine(30, false, "_");
		System.out.println("""
						---OPTIONS---
				1 - Order			0 - Exit
				""");

		return Utils.getUserInputIntMinMax("Enter option: ", 0, 1);
	}

	public int displayOrderScreen() {
		System.out.println(Utils.BLUE + "\n\t\t---ORDER---" + Utils.RESET);
		Utils.designLine(30, false, "_");
		System.out.printf("""
								  ---OPTIONS---
				1 - Order Sandwich %s		3 - Order Drink %s
				2 - Order Chips %s			4 - Checkout
								 0 - Cancel

				""", Utils.sandwich, Utils.drink, Utils.chips);

		return Utils.getUserInputIntMinMax("Enter option: ", 0, 4);
	}

	//region SANDWICH SCREENS
	public int displaySandwichScreen() {
		System.out.println(Utils.BLUE + "\n\t\t" + Utils.sandwich + "---SANDWICH---" + Utils.sandwich + Utils.RESET);
		Utils.designLine(30, false, "_");
		System.out.println("""
					---OPTIONS---
				1 - See Signature Sandwich Options
				2 - Make Your Own Sandwich
				0 - Go Back
				""");
		return Utils.getUserInputIntMinMax("Enter option: ", 0, 2);
	}

	public int displaySignatureSandwiches() {
		System.out.println(Utils.BLUE + "\n\t\t---SIGNATURE SANDWICHES---" + Utils.RESET);
		Utils.designLine(30, false, "_");
		System.out.printf("""

                       %sBLT - $10.50            Philly Cheese Steak - $10.50			The Cowboy - $00.00
                       --------------------------------------------------------------------------------------%s
                       %s8" White Bread          	8" White Bread						 12" Sourdough
                       Bacon                   		Steak   							 Roast Beef
                       Cheddar                 		American						 	 Cheddar
                       Lettuce                 		Peppers								 Lettuce
                       Tomato                  		Mayo								 Jalapenos
                       Ranch                   		Toasted								 Onions
                       Toasted  														 BBQ Sauce
                       																	 Toasted%s

                """, Utils.CYAN, Utils.RESET, Utils.BLUE, Utils.RESET);

		System.out.println("""
					---OPTIONS---
				1 - BLT
				2 - Philly Cheese Steak
				3 - The Cowboy
				0 - Go Back
				""");
		return Utils.getUserInputIntMinMax("Enter option: ", 0, 3);
	}

	public int displaySandwichSizes() {
		//distance between despises and price = 4 indents
		System.out.println("""
								___SIZES___
				---------------------------------------
				1 - Small 4"...					$5.50
				2 - Medium 8"...				$7.00
				3 - Large 12"...				$8.50
				""");

		return Utils.getUserInputIntMinMax("Enter Option: ", 1, 3);
	}

	public int displayMeats() {
		System.out.printf("""
							%s___MEATS___%s
				-------------------------------------
				1 - Steak
				2 - Ham
				3 - Salami
				4 - Roast Beef
				5 - Chicken
				6 - Bacon
				0 - No Meat
				
				""", Utils.meat, Utils.meat);

		return Utils.getUserInputIntMinMax("Enter Option: ", 0, 6);
	}

	public int displayCheeses() {
		System.out.printf("""
						%s___CHEESES___%s
				-------------------------------------
				1 - American
				2 - Provolone
				3 - Cheddar
				4 - Swiss
				0 - No Cheese
				""", Utils.cheese, Utils.cheese);

		return Utils.getUserInputIntMinMax("Enter Option: ", 0, 4);
	}

	public int displayExtraChoice(String item) {
		String smallPrice = "";
		String medPrice = "";
		String largePrice = "";

		if (item.equalsIgnoreCase("meat")) {
			smallPrice = "$0.50";
			medPrice = "$1.00";
			largePrice = "$1.50";
		} else if(item.equalsIgnoreCase("cheese")) {
			smallPrice = "$0.30";
			medPrice = "$0.60";
			largePrice = "$0.90";
		}

		System.out.printf("""
					WOULD YOU LIKE TO ADD EXTRA CHEESE?
				__________________________________________
				1 - YES							2 - NO
				-------------------------------------------
				Size Small...		+		 %s
				Size Medium...		+		 %s
				Size Large...		+		 %s
				""", smallPrice, medPrice, largePrice);

		return Utils.getUserInputIntMinMax("Enter Option: ", 1, 2);
	}

	public int displayToppings() {
		System.out.println("""
							___TOPPINGS___
				---------------------------------------
				1 - Lettuce					6 - Cucumbers
				2 - Peppers					7 - Pickles
				3 - Onions					8 - Guacamole
				4 - Tomatoes				9 - Mushrooms
				5 - Jalapenos				0 - No Toppings
				""");

		return Utils.getUserInputIntMinMax("Enter Option: ", 0, 9);
	}

	public int displaySauces() {
		System.out.println("""
							___SAUCES___
				---------------------------------------
				1 - Mayo					6 - Vinaigrette
				2 - Mustard					7 - Au Jus
				3 - Ketchup					8 - Barbeque
				4 - Thousand Islands		0 - No Toppings
				""");

		return Utils.getUserInputIntMinMax("Enter Option: ", 0, 8);
	}

	public int displayToastedOption() {
		System.out.println("""
					WOULD YOU LIKE YOUR SANDWICH TOASTED?
				_____________________________________________
				1 - YES						2 - NO
				""");

		return Utils.getUserInputIntMinMax("Enter Option: ", 1, 2);
	}

	public int confirmSandwich(Sandwich sandwich) {
		sandwich.print();
		System.out.println("""
					IS THIS SANDWICH CORRECT?
				---------------------------------
				1 - Yes!
				2 - No...
				""");
		return Utils.getUserInputIntMinMax("Enter Option: ", 1, 2);
	}
	//endregion

	public int displayChips() {
		System.out.printf("""
								%s___CHIP_OPTIONS___%s
				--------------------------------------------------
				1 - French Fries...						$2.75
				2 - Nacho Cheese Doritos...				$1.50
				3 - Miss Vickies Jalapeno Chips...		$1.50
				4 - Lays Original Potato Chips...		$1.50
				5 - Cheetos...							$1.50
				6 - Takis...							$1.50
				7 - Cheez-Its...						$1.50
									0 - Go Back
				
				""", Utils.chips, Utils.chips);

		return Utils.getUserInputIntMinMax("Enter Option: ", 0, 7);
	}

	//region DRINK SCREENS
	public int displayDrinks() {
		System.out.printf("""
						%s___DRINK_OPTIONS___%s
				-------------------------------------
				1 - Fountain Drink
				2 - Lemonade
				3 - Sweet Tea
				4 - Unsweet Tea
				5 - Milkshake
				6 - Juice
				7 - Water 	*** Water is Free ***
				0 - Go Back
				
				""", Utils.drink, Utils.drink);

		return Utils.getUserInputIntMinMax("Enter Option: ", 0, 7);
	}

	public int displayDrinkSize() {
		System.out.println("""
								___DRINK_SIZES___
				---------------------------------------
				1 - Small 12 Oz...				$2.00
				2 - Medium 24 Oz...				$2.50
				3 - Large 32 Oz...				$3.00
				""");

		return Utils.getUserInputIntMinMax("Enter Option: ", 1, 3);
	}
	//endregion

	public int confirmOrder(Order order) {
		List<MenuItem> itemsInOrder = order.getItemsOrdered();

		for(MenuItem item : itemsInOrder) {
			item.print();
		}
	}

}
