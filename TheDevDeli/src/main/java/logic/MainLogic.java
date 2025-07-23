package logic;

import models.MenuItem;
import ui.UserInterface;
import utils.Utils;

import java.util.List;

public class MainLogic extends LogicBase{

//	private static final UserInterface ui = new UserInterface();
	public MainLogic(UserInterface ui, List<MenuItem> customerOrder) {
		super(ui, customerOrder);
	}

	public void processMainScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayMainMenu();

			switch(userChoice) {
				case 1 -> processOrderOption();
				case 2 -> processAdmin();
				case 0 -> ifContinue = false;
				default -> System.err.println("ERROR! Please enter a number that is listed!");
			}
		}
	}

	private static void processOrderOption() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayOrderScreen();

			switch(userChoice) {
				case 1 -> SandwichLogic.processSandwichMenu();
				case 2 -> ChipLogic.processChipOption();
				case 3 -> DrinkLogic.processDrinkOption();
				case 4 -> {
					CheckoutLogic.processCheckout();
					ifContinue = false;
				}
				case 0 -> ifContinue = false;
			}
		}

	}

	private static void processAdmin() {
		String password = Utils.getUserInput("Please enter the password: ");
		boolean passwordCheck = Utils.passwordCheck(password);

		if(passwordCheck) {
			AdminLogic.processAdminScreen();
		} else {
			System.out.println("That is not the password!!!");
		}
	}

}
