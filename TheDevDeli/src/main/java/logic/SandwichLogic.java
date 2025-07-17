package logic;

import models.MenuItem;
import models.sandwich.Sandwich;
import ui.UserInterface;
import utils.Utils;

import java.util.List;

public class SandwichLogic extends LogicBase{

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
		Sandwich sandwich = new Sandwich();
	}

	private static void addToOrder(Sandwich sandwich) {
		boolean ifContinue = true;

		while(ifContinue) {
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

}
