package logic;

import models.Drink;
import models.MenuItem;
import models.enums.DrinkType;
import ui.UserInterface;

import java.util.List;

import static models.enums.Size.*;

public class DrinkLogic extends LogicBase {

	public DrinkLogic(UserInterface ui, List<MenuItem> customerOrder) {
		super(ui, customerOrder);
	}

	public static void processDrinkOption() {
		Drink drink = new Drink();

	}

	private static void selectDrinkType(Drink drink) {
		int userChoice = ui.displayDrinks();

		switch(userChoice) {
			case 1 -> drink.setDrinkType(DrinkType.FOUNTAIN);
			case 2 -> drink.setDrinkType(DrinkType.LEMONADE);
			case 3 -> drink.setDrinkType(DrinkType.SWEET_TEA);
			case 4 -> drink.setDrinkType(DrinkType.UNSWEET_TEA);
			case 5 -> drink.setDrinkType(DrinkType.MILKSHAKE);
			case 6 -> drink.setDrinkType(DrinkType.JUICE);
			case 7 -> drink.setDrinkType(DrinkType.WATER);
		}
	}

	private static void selectDrinkSize(Drink drink) {
		int userChoice = ui.displayDrinkSize();

		switch(userChoice) {
			case 1 -> drink.setSize(SMALL);
			case 2 -> drink.setSize(MEDIUM);
			case 3 -> drink.setSize(LARGE);
		}
	}

	private static void addToOrder(Drink drink) {

	}

}
