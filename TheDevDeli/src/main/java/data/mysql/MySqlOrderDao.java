package data.mysql;

import config.DatabaseConfig;
import data.OrderDao;
import models.MenuItem;
import models.Order;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				ordersList.add(mapRow(results));
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
				return mapRow(results);
			} else {
				System.out.println("No orders with that order ID!");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	@Override
	public Order addOrder(Order order) {
		return null;
	}

	@Override
	public Order addLineItems(List<MenuItem> orderItems) {
		return null;
	}

	private Order mapRow(ResultSet results) throws SQLException {
		int orderId = results.getInt("order_id");
		String customerName = results.getString("customer_name");
		int quantity = results.getInt("quantity_of_items");
		double totalPrice = results.getDouble("total_price");
		LocalDateTime timeOrdered = results.getTimestamp("time_ordered").toLocalDateTime();

		return new Order(orderId, customerName, quantity, totalPrice, timeOrdered);
	}

}
