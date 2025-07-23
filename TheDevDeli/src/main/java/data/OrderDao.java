package data;

import models.MenuItem;
import models.Order;
import models.OrderLineItem;

import java.util.List;

public interface OrderDao {

	List<Order> getAll();

	Order getById(int orderId);

	List<OrderLineItem> getItemsByOrderId(int orderId);

	Order addOrder(Order order);

	void addLineItems(OrderLineItem orderItem);

	void updateOrder(Order order);

	void deleteOrder(int orderId);

}
