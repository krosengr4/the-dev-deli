package data;

import models.Order;

public interface OrderDao {

	Order getAll();

	Order getById();

	Order addOrder();

	Order addLineItems();

}
