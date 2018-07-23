package com.accolite.au.springjdbc;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcApplication {

	private static final Logger log = Logger.getLogger(SpringJdbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
		log.info("Project is up and running");
	}
}
