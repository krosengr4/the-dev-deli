package logic;

import ui.AdminUserInterface;

public class AdminLogic {

	static AdminUserInterface adminUI = new AdminUserInterface();

	public static void processAdminScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = adminUI.displayAdminScreen();

			switch(userChoice) {

			}
		}
	}

}
