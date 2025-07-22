package data.mysql;

import config.DatabaseConfig;
import data.OrderDao;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class MySqlOrderDao extends MySqlBaseDao implements OrderDao {

	static BasicDataSource dataSource = DatabaseConfig.setDataSource();

	public MySqlOrderDao(DataSource dataSource) {
		super(dataSource);
	}

}
