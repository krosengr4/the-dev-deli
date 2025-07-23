package data.mysql;

import config.DatabaseConfig;
import data.OrderDao;
import models.*;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDao extends MySqlBaseDao implements OrderDao {

	static BasicDataSource dataSource = DatabaseConfig.setDataSource();

	public MySqlOrderDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
 	public List<Order> getAll() {
		List<Order> ordersList = new ArrayList<>();
		String query = "SELECT * FROM orders;";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet results = statement.executeQuery();
			while(results.next()) {
				ordersList.add(mapRowToOrder(results));
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return ordersList;
	}

	@Override
	public Order getById(int orderId) {
		String query = "SELECT * FROM orders WHERE order_id = ?;";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, orderId);

			ResultSet results = statement.executeQuery();
			if(results.next()) {
				return mapRowToOrder(results);
			} else {
				System.out.println("No orders with that order ID!");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	@Override
	public List<MenuItem> getItemsByOrderId(int orderId) {
		List<MenuItem> orderItems = new ArrayList<>();


		return orderItems;
	}

	@Override
	public Order addOrder(Order order) {
		String query = "INSERT INTO orders (customer_name, quantity_of_items, total_price, time_ordered) " +
							   "VALUES (?, ?, ?, ?);";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, order.getCustomerName());
			statement.setInt(2, order.getQuantityOrdered());
			statement.setDouble(3, order.getTotalPrice());
			statement.setTimestamp(4, Timestamp.valueOf(order.getTimeOfOrder()));

			int rows = statement.executeUpdate();

			if(rows > 0) {
				ResultSet key = statement.getGeneratedKeys();

				if(key.next()) {
					int orderId = key.getInt(1);
					return getById(orderId);
				}
			} else {
				System.err.println("ERROR! Could not add order to the database!!!");
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	@Override
	public void addLineItems(OrderLineItem orderItem) {
		String query = "INSERT INTO order_line_items (order_id, item_ordered, price) " +
							   "VALUES (?, ?, ?);";
		try(Connection connection = getConnection()) {
			String itemName = "";
			if(orderItem.getItemOrdered() instanceof Sandwich) {
				itemName = "Sandwich";
			} else if(orderItem.getItemOrdered() instanceof Chip) {
				itemName = "Chip";
			} else if(orderItem.getItemOrdered() instanceof Drink) {
				itemName = "Drink";
			}

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, orderItem.getOrderId());
			statement.setString(2, itemName);
			statement.setDouble(3, orderItem.getPrice());

			int rows = statement.executeUpdate();
			if(rows > 0) {
				System.out.println("All items logged to database");
			} else {
				System.err.println("ERROR! Could not log items ordered to database!");
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Order mapRowToOrder(ResultSet results) throws SQLException {
		int orderId = results.getInt("order_id");
		String customerName = results.getString("customer_name");
		int quantity = results.getInt("quantity_of_items");
		double totalPrice = results.getDouble("total_price");
		LocalDateTime timeOrdered = results.getTimestamp("time_ordered").toLocalDateTime();

		return new Order(orderId, customerName, quantity, totalPrice, timeOrdered);
	}

	private OrderLineItem mapRowToOrderItem(ResultSet results) throws SQLException{
		int orderLineItemId = results.getInt("order_line_item_id");
		int orderId = results.getInt("order_id");
		String itemOrdered = results.getString("item_ordered");
		double price = results.getDouble("price");

		return new OrderLineItem(orderLineItemId, orderId, itemOrdered, price);
	}

}
