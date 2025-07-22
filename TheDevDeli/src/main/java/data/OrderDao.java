package data;

import models.MenuItem;
import models.Order;

import java.util.List;

public interface OrderDao {

	List<Order> getAll();

	Order getById(int orderId);

	Order addOrder(Order order);

	Order addLineItems(List<MenuItem> orderItems);

}
