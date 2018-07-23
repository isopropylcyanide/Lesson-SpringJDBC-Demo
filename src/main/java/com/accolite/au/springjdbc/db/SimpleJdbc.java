package com.accolite.au.springjdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class SimpleJdbc {

	private static final Logger log = Logger.getLogger(SimpleJdbc.class);

	private final String simpleDbName = "hk_db";
	private final String simpleDbTable = "doctor";
	private final String simpleDbUser = "root";
	private String simpleDbPass = "";
	private String simpleDbUrl = "jdbc:mysql://localhost:3306/";

	public void testConnection() {
		log.info("-------- MySQL JDBC Connection Testing ------------" + simpleDbUrl + simpleDbName + simpleDbUser
				+ simpleDbPass + ":" + simpleDbTable);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			log.info("MySQL Driver not loaded");
			log.error(e);
			return;
		}

		log.info("MySQL JDBC Driver Registered!");

		try (Connection connection = DriverManager.getConnection(simpleDbUrl + simpleDbName, simpleDbUser,
				simpleDbPass)) {
			if (null != connection) {
				log.info("Connection established successfully!");
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery("select age from doctor");
				while (rs.next()) {
					log.info("Got age " + rs.getString("age"));
				}
			} else {
				log.info("Failed to make connection!");
			}
		} catch (SQLException e) {
			log.info("Connection Failed! Check output console");
			log.error(e);
		}

	}

}
