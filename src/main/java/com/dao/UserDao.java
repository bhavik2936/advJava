package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;
	
	public int insertUser(UserBean userBean) {
		return stmt.update("insert into user (email, password) values (?, ?)", userBean.getEmail(), userBean.getPassword());
	}
	
}
