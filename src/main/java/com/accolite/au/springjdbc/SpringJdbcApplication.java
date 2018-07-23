package com.accolite.au.springjdbc;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.accolite.au.springjdbc.db.SpringSimpleJdbc;

@SpringBootApplication
@PropertySource("classpath:db.properties")
public class SpringJdbcApplication {

	@Autowired
	Environment environment;

	private static final Logger log = Logger.getLogger(SpringJdbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
		log.info("Project is up and running");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringJdbcApplication.class);
		SpringSimpleJdbc simpleJdbc = context.getBean(SpringSimpleJdbc.class);
		simpleJdbc.testConnection();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty("simpleJdbc.url"));
		driverManagerDataSource.setUsername(environment.getProperty("simpleJdbc.user"));
		driverManagerDataSource.setPassword(environment.getProperty("simpleJdbc.pass"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("simpleJdbc.driver"));
		return driverManagerDataSource;
	}
}
