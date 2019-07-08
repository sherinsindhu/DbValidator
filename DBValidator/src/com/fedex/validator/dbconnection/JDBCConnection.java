package com.fedex.validator.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.fedex.validator.utility.Utility;

public class JDBCConnection {

	public static Connection getJDBCConnection() {

		System.out.println("-------- Oracle JDBC Connection Testing ------");
		Properties property = Utility.loadProperties(
				"C:\\Users\\wills\\Desktop\\Sindhu\\plan\\projects\\workspace\\DBValidator\\src\\resources\\db.properties");
		try {

			Class.forName(property.getProperty("DBDriver"));

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(property.getProperty("url"), property.getProperty("username"),
					property.getProperty("password"));

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			return connection;
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}

	public static Statement createJDBCStatement(Connection connection) throws SQLException {
		Statement stat = null;
		if (connection == null) {
			connection = getJDBCConnection();
		}
		try {
			stat = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connection.close();
			e.printStackTrace();
		}

		return stat;
	}

	
}
