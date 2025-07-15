package logic;

import ui.UserInterface;

public class MainLogic extends LogicBase{

//	private static final UserInterface ui = new UserInterface();
	public MainLogic(UserInterface ui) {
		super(ui);
	}

	public void processMainScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayMainScreen();

			switch(userChoice) {
				case 1 -> processOrderOption();
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



}
