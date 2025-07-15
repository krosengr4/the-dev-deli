package logic;

import ui.UserInterface;

public class MainLogic {

	private static final UserInterface ui = new UserInterface();

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

	}



}
