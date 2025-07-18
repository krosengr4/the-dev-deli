package logic;

import models.MenuItem;
import models.enums.Size;
import models.sandwich.Sandwich;
import ui.UserInterface;
import utils.Utils;

import java.util.List;

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

	private static Sandwich selectSide() {
		Sandwich sandwich = new Sandwich();
		int userChoice = ui.displaySandwichSizes();

		switch(userChoice) {
			case 1 -> sandwich.setSize(Size.SMALL);
			case 2 -> sandwich.setSize(Size.MEDIUM);
			case 3 -> sandwich.setSize(Size.LARGE);
			default -> System.err.println("ERROR! Please enter a choice that is listed!!!");
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
