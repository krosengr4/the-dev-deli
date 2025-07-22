package logic;

import config.DatabaseConfig;
import data.mysql.MySqlOrderDao;
import data.OrderDao;
import models.MenuItem;
import models.Order;
import models.OrderLineItem;
import models.Sandwich;
import ui.UserInterface;
import utils.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
		} else {
			System.out.println("Sorry for the inconvenience... Try again?");
			Utils.playSound("womp-womp.wav");
		}
	}

	private static void createAndAddOrder() {
		String customerName = Utils.getUserInput("Please enter a name for the order: ");

		Order order = new Order();
		order.setOrder_id(0);
		order.setCustomerName(customerName);
		order.setQuantityOrdered(customerOrder.size());
		order.setTimeOfOrder(LocalDateTime.now());
		order.setItemsOrdered(customerOrder);
		order.setTotalPrice(order.getValue());

		//todo: Create DAO with method to insert into the orders table
		Order addedOrder = orderDao.addOrder(order);
		addedOrder.print();

		addOrderLineItems(addedOrder);
		customerOrder.clear();
	}

	private static void addOrderLineItems(Order order) {
		//todo: Create DAO with method to insert each item in customer order into order_line_items table
		List<OrderLineItem> orderItems = new ArrayList<>();
		for(MenuItem item : customerOrder) {
			OrderLineItem orderItem = new OrderLineItem();
			orderItem.setOrderId(order.getOrder_id());
			orderItem.setItemOrdered(item);
			orderItem.setPrice(item.getValue());

			orderDao.addLineItems(orderItem);
		}

	}


}
