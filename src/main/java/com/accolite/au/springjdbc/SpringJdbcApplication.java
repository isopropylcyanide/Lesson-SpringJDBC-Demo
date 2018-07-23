package com.accolite.au.springjdbc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.accolite.au.springjdbc.db.SimpleJdbc;

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
		SimpleJdbc simpleJdbc = context.getBean(SimpleJdbc.class);
		simpleJdbc.testConnection();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
