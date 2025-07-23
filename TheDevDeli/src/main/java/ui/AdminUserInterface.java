package ui;

import utils.Utils;

public class AdminUserInterface {

	public int displayAdminScreen() {
		System.out.println("----------ADMIN SCREEN----------");
		Utils.designLine(30, false, "_");
		System.out.println("""
							---OPTIONS---
				1 - View All Orders
				2 - View Items in an Order
				3 - Update an Order
				4 - Delete an Order
				0 - Go Back
				""");

		return Utils.getUserInputIntMinMax("Enter Option: ", 0, 4);
	}
}
