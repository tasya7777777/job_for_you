package main.java.com.oursite.controller.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/job_for_you", "root", "root");
		return connection;
	}
}
