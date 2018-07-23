package com.accolite.au.springjdbc.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class SpringSimpleJdbc {

	private static final Logger log = Logger.getLogger(SpringSimpleJdbc.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	public SpringSimpleJdbc(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void testConnection() {
		List<Integer> topTenPeople = jdbcTemplate.query("select age from doctor limit 10", new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getInt("age");
			}
		});
		topTenPeople.forEach(people -> log.info("Got through template: " + people));
	}

}
