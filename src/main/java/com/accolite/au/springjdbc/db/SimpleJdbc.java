package com.accolite.au.springjdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleJdbc {

	private static final Logger log = Logger.getLogger(SimpleJdbc.class);

	@Value("${simpleJdbc.table}")
	private String simpleDbTable;

	@Value("${simpleJdbc.driver}")
	private String simpleDbDriver;

	@Value("${simpleJdbc.user}")
	private String simpleDbUser;

	@Value("${simpleJdbc.pass}")
	private String simpleDbPass;

	@Value("${simpleJdbc.url}")
	private String simpleDbUrl;

	public SimpleJdbc() {

	}

	public void testConnection() {
		try {
			Class.forName(simpleDbDriver);
		} catch (ClassNotFoundException e) {
			log.info("MySQL Driver not loaded");
			log.error(e);
			return;
		}

		log.info("MySQL JDBC Driver Registered!");

		try (Connection connection = DriverManager.getConnection(simpleDbUrl, simpleDbUser, simpleDbPass)) {
			if (null != connection) {
				log.info("Connection established successfully!");
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery("select age from doctor limit 10");
				while (rs.next()) {
					log.info("Got age " + rs.getString("age"));
				}
			} else {
				log.info("Failed to make connection!");
			}
		} catch (SQLException e) {
			log.info("Connection Failed! Check output console");
			e.printStackTrace();
			log.error(e);
		}

	}

}
