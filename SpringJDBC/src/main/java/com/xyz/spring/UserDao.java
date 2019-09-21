package com.xyz.spring;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	
	public int saveUser(User u) {
		String sql="insert into user (name,country) values('"+u.getName()+"','"+u.getCountry()+"')";
		return jdbcTemplate.update(sql);
		
	}
}
