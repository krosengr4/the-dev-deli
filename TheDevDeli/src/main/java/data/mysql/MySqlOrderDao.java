package data.mysql;

import config.DatabaseConfig;
import data.OrderDao;
import models.MenuItem;
import models.Order;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
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


		return ordersList;
	}

	@Override
	public Order getById(int orderId) {
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

}
