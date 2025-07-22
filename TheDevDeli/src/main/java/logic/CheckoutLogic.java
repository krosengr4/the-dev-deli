package logic;

import config.DatabaseConfig;
import data.mysql.MySqlOrderDao;
import data.OrderDao;
import models.MenuItem;
import models.Order;
import ui.UserInterface;
import utils.Utils;

import java.time.LocalDateTime;
import java.util.List;

public class CheckoutLogic extends LogicBase {

	static OrderDao orderDao = new MySqlOrderDao(DatabaseConfig.setDataSource());

	public CheckoutLogic(UserInterface ui, List<MenuItem> customerOrder) {
		super(ui, customerOrder);
	}

	public static void processCheckout() {
		for(MenuItem item : customerOrder) {
			item.print();
		}
		int userChoice = ui.confirmOrder();
		if(userChoice == 1) {
			createAndAddOrder();
		}


	}

	private static void createAndAddOrder() {
		String customerName = Utils.getUserInput("Please enter a name for the order: ");

		Order order = new Order();
		order.setOrder_id(0);
		order.setCustomerName(customerName);
		order.setQuantityOrdered(customerOrder.size());
		order.setTotalPrice(order.getValue());
		order.setTimeOfOrder(LocalDateTime.now());
		order.setItemsOrdered(customerOrder);

		//todo: Create DAO with method to insert into the orders table
	}

	private static void addOrderLineItems() {
		//todo: Create DAO with method to insert each item in customer order into order_line_items table

	}


}
