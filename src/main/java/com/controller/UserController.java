package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "signup")
	public String signUp(Model model) {
		UserBean userBean = new UserBean();
		model.addAttribute("userBean", userBean);
		return "SignUp";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="dashboard")
	public String dashboard(@Valid UserBean userBean, BindingResult result, Model model) {
		model.addAttribute("userName", userBean);
		if (result.hasErrors())
			return "SignUp";
		else {
			userDao.insertUser(userBean);
			return "Dashboard";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "profile")
	public String profile() {
		return "UpdateProfile";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "updateProfile")
	public String updateProfile(@RequestParam("display_picture") MultipartFile file) {
		File f = new File("C:\\Users\\bhavik2936\\Desktop\\", file.getOriginalFilename());
		try {
			FileOutputStream fos = new FileOutputStream(f);
			byte b[] = file.getBytes();
			fos.write(b);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "UpdateProfile";
	}
}
