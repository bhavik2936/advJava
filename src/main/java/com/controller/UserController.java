package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;

	@GetMapping("/")
	public String index() {
		return "spring project REST API";
	}
	
	@PostMapping("/user")
	public String addUser(UserBean userBean) {
		if (userDao.addUser(userBean) > 0)
			return "user added";
		else
			return "couldn't add user";
	}
	
	@GetMapping("/user/{id}")
	public UserBean viewUser(UserBean userBean, @PathVariable int id) {
		userBean.setId(id);
		return userDao.getUserById(userBean);
	}
	
	@PutMapping("/user/{id}")
	public String updateUser(UserBean userBean, @PathVariable int id) {
		userBean.setId(id);
		if (userDao.updateUserById(userBean) > 0) {
			return "user Updated";
		} else {
			return "couldn't update user";
		}
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(UserBean userBean, @PathVariable int id) {
		userBean.setId(id);
		if (userDao.deleteUserById(userBean) > 0) {
			return "user Deleted";
		} else {
			return "couldn't delete user";
		}
	}
	
	@GetMapping("/users")
	public List<UserBean> listUsers() {
		return userDao.getUserList();
	}
}
