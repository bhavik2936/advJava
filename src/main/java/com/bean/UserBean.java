package com.bean;

import javax.validation.constraints.NotBlank;

public class UserBean {
	int userId;
	@NotBlank(message = "Email ID required")
	String email;
	@NotBlank(message = "Password required")
	String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
