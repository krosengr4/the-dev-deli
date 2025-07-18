package logic;

import models.MenuItem;
import models.enums.*;
import models.sandwich.Sandwich;
import ui.UserInterface;
import utils.Utils;
import java.util.List;

//import static models.enums.Meat.*;
import static models.enums.Size.*;

public class SandwichLogic extends LogicBase {

	public SandwichLogic(UserInterface ui, List<MenuItem> customerOrder) {
		super(ui, customerOrder);
	}

	public static void processSandwichMenu() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displaySandwichScreen();

			switch(userChoice) {
				case 1 -> createNewSandwich();
			}
		}
		//This is a comment
		//COMMENT
	}

	private static void createNewSandwich() {
		boolean ifContinue = true;
		// Build sandwich by calling methods to add item on sandwich


		Sandwich sandwich = new Sandwich();
	}

	private static Sandwich selectSize(Sandwich sandwich) {
		int userChoice = ui.displaySandwichSizes();

		switch(userChoice) {
			case 1 -> sandwich.setSize(SMALL);
			case 2 -> sandwich.setSize(MEDIUM);
			case 3 -> sandwich.setSize(LARGE);
			default -> System.err.println("ERROR! Please enter a choice that is listed!!!");
		}

		return sandwich;
	}

	private static Sandwich selectBread(Sandwich sandwich) {
		int userChoice = ui.displayBreads();

		switch(userChoice) {
			case 1 -> sandwich.setBread(Bread.WHITE);
			case 2 -> sandwich.setBread(Bread.WHEAT);
			case 3 -> sandwich.setBread(Bread.RYE);
			case 4 -> sandwich.setBread(Bread.SOURDOUGH);
			default -> System.err.println("ERROR! Please enter a choice that is listed!!!");
		}

		return sandwich;
	}

	private static Sandwich selectMeat(Sandwich sandwich) {
		int userChoice = ui.displayMeats();

		switch(userChoice) {
			case 1 -> sandwich.setMeat(Meat.STEAK);
			case 2 -> sandwich.setMeat(Meat.HAM);
			case 3 -> sandwich.setMeat(Meat.SALAMI);
			case 4 -> sandwich.setMeat(Meat.ROAST_BEEF);
			case 5 -> sandwich.setMeat(Meat.CHICKEN);
			case 6 -> sandwich.setMeat(Meat.BACON);
			case 0 -> sandwich.setMeat(Meat.NONE);
			default -> System.err.println("ERROR! Please enter a choice that is listed!!!");
		}

		int extraMeatChoice = ui.displayExtraChoice("meat");
		sandwich.setHasExtraMeat(extraMeatChoice == 1);

		return sandwich;
	}

	private static Sandwich setCheese(Sandwich sandwich) {
		int userChoice = ui.displayCheeses();

		switch(userChoice) {
			case 1 -> sandwich.setCheese(Cheese.AMERICAN);
			case 2 -> sandwich.setCheese(Cheese.PROVOLONE);
			case 3 -> sandwich.setCheese(Cheese.CHEDDAR);
			case 4 -> sandwich.setCheese(Cheese.SWISS);
			case 0 -> sandwich.setCheese(Cheese.NONE);
			default -> System.err.println("ERROR! Please enter a choice that is listed!!!");
		}

		int extraCheeseChoice = ui.displayExtraChoice("cheese");
		sandwich.setHasExtraCheese(extraCheeseChoice == 1);

		return sandwich;
	}

	private static Sandwich setToppings(Sandwich sandwich) {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayToppings();
			switch(userChoice) {
				case 1 -> sandwich.setToppingList(Topping.LETTUCE);
				case 2 -> sandwich.setToppingList(Topping.PEPPERS);
				case 3 -> sandwich.setToppingList(Topping.ONIONS);
				case 4 -> sandwich.setToppingList(Topping.TOMATO);
				case 5 -> sandwich.setToppingList(Topping.JALAPENOS);
				case 6 -> sandwich.setToppingList(Topping.CUCUMBERS);
				case 7 -> sandwich.setToppingList(Topping.PICKLES);
				case 8 -> sandwich.setToppingList(Topping.GUACAMOLE);
				case 9 -> sandwich.setToppingList(Topping.MUSHROOMS);
				case 0 -> sandwich.setToppingList(Topping.NONE);
				default -> System.err.println("ERROR! Please enter a choice that is listed!!!");
			}

			int addMoreOption = ui.displayMoreMenu();
			if(addMoreOption == 2)
				ifContinue = false;
		}

		return sandwich;
	}

	private static Sandwich setSauces(Sandwich sandwich) {
		boolean ifContinue = true;
		while(ifContinue) {
			int userChoice = ui.displaySauces();

			switch(userChoice) {
				case 1 -> sandwich.setSauceList(Sauce.MAYO);
				case 2 -> sandwich.setSauceList(Sauce.MUSTARD);
				case 3 -> sandwich.setSauceList(Sauce.KETCHUP);
				case 4 -> sandwich.setSauceList(Sauce.THOUSANDISLANDS);
				case 5 -> sandwich.setSauceList(Sauce.VINAIGRETTE);
				case 6 -> sandwich.setSauceList(Sauce.AUJUS);
				case 7 -> sandwich.setSauceList(Sauce.BBQ);
				case 0 -> sandwich.setSauceList(Sauce.NONE);
			}

			int addMoreOption = ui.displayMoreMenu();
			if(addMoreOption == 2) {
				ifContinue = false;
			}
		}

		return sandwich;
	}

	private static void addToOrder(Sandwich sandwich) {
		int userConfirmation = ui.confirmSandwich(sandwich);

		if(userConfirmation == 1) {
			customerOrder.add(sandwich);
			System.out.println(Utils.GREEN + "Your sandwich was added to the order!" + Utils.RESET);
			Utils.playSound("owin31");
		} else {
			System.out.println("Apologies for the inconvenience. Please try again!");
			Utils.playSound("womp-womp");
		}
	}

}
