package logic;

import config.DatabaseConfig;
import data.OrderDao;
import data.mysql.MySqlOrderDao;
import ui.AdminUserInterface;

public class AdminLogic {

	static AdminUserInterface adminUI = new AdminUserInterface();
	static OrderDao orderDao = new MySqlOrderDao(DatabaseConfig.setDataSource());

	public static void processAdminScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = adminUI.displayAdminScreen();

			switch(userChoice) {
				case 1 -> viewOrders();
				case 2 -> viewOrderItems();
				case 3 -> processUpdateOrder();
				case 4 -> processDeleteOrder();
				case 0 -> ifContinue = false;
			}
		}
	}

	private static void viewOrders() {

	}

	private static void viewOrderItems() {

	}

	private static void processUpdateOrder() {

	}

	private static void processDeleteOrder() {

	}

}
