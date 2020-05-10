package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public int addUser(UserBean userBean) {
		return stmt.update("INSERT INTO user (name, password, email) VALUES (?, ?, ?)", userBean.getName(),
				userBean.getPassword(), userBean.getEmail());
	}

	public List<UserBean> getUserList() {
		return stmt.query("SELECT * FROM user", new RowMapper<UserBean>() {
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean userBean = new UserBean();
				userBean.setId(rs.getInt("id"));
				userBean.setName(rs.getString("name"));
				userBean.setEmail(rs.getString("email"));
				userBean.setPassword(rs.getString("password"));
				return userBean;
			}
		});
	}

	public UserBean getUserById(UserBean userBean) {
		try {
			return stmt.queryForObject("SELECT * FROM user WHERE id = ?", new Object[] { userBean.getId() },
					new BeanPropertyRowMapper<UserBean>(UserBean.class));
		} catch (EmptyResultDataAccessException e) {
			return userBean;
		}
	}

	public int updateUserById(UserBean userBean) {
		return stmt.update("UPDATE user SET name = ?, password = ?, email = ? WHERE id = ?", userBean.getName(), userBean.getPassword(), userBean.getEmail(), userBean.getId());
	}

	public int deleteUserById(UserBean userBean) {
		return stmt.update("DELETE FROM user WHERE id = ?", userBean.getId());
	}
}
