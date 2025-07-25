package logic;

import config.DatabaseConfig;
import data.OrderDao;
import data.mysql.MySqlOrderDao;
import models.Order;
import models.OrderLineItem;
import ui.AdminUserInterface;
import utils.Utils;

import java.util.List;

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

		List<Order> ordersList = orderDao.getAll();

		if(ordersList.isEmpty()) {
			System.out.println("There are no orders to display...");
		} else {
			for(Order order : ordersList) {
				System.out.println("-----ALL ORDERS-----");
				order.print();
			}
		}

		Utils.pauseApp();
	}

	private static void viewOrderItems() {
		int orderId = Utils.getUserInputInt("Enter the order ID: ");

		Order order = orderDao.getById(orderId);
		if(order == null) {
			System.out.println("There are no orders with that ID...");
		} else {
			List<OrderLineItem> orderItems = orderDao.getItemsByOrderId(orderId);

			if(orderItems.isEmpty()) {
				System.out.println("There are no items in that order...");
			} else {
				for(OrderLineItem orderItem : orderItems) {
					orderItem.print();
				}
			}
		}

		Utils.pauseApp();
	}

	private static void processUpdateOrder() {
		int orderId = Utils.getUserInputInt("Enter the order ID of the order to update: ");

		Order order = orderDao.getById(orderId);
		if(order == null) {
			System.out.println("There are no orders with that ID...");
		} else {
			int userChoice = adminUI.displayUpdateOptions();

			switch(userChoice) {
				case 1 -> {
					String newName = Utils.getUserInput("Enter the new name for the customer: ");
					order.setCustomerName(newName);
					orderDao.updateOrder(order);
				}
				case 2 -> {
					double newAmount = Utils.getUserInputDouble("Enter the new amount for the order: ");
					order.setTotalPrice(newAmount);
					orderDao.updateOrder(order);
				}
			}
		}

		Utils.pauseApp();
	}

	private static void processDeleteOrder() {
		int orderId = Utils.getUserInputInt("Enter the Order ID of the order to be deleted: ");

		Order order = orderDao.getById(orderId);
		if(order == null) {
			System.out.println("There are no orders with that ID...");
		} else {
			orderDao.deleteOrder(orderId);
		}

		Utils.pauseApp();
	}

}
