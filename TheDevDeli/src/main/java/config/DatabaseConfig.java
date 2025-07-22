package config;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConfig {

	private final BasicDataSource dataSource = new BasicDataSource();

	public BasicDataSource setDataSource() {
		dataSource.setUrl("jdbc:mysql://localhost:3306/dev_deli_db");
		dataSource.setUsername("root");
		dataSource.setPassword(System.getenv("SQL_PASSWORD"));

		return dataSource;
	}

}
