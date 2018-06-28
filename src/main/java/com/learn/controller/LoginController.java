package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learn.entity.User;
import com.learn.service.LoginService;

@Controller // 注解为控制器
@RequestMapping(value = "/login") // 截获带有/login的请求
public class LoginController extends BaseController{
	@Autowired
	LoginService loginService; // 注入service层

	/**
	 * 返回登录页面
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "login";
	}

	/**
	 * 处理用户的登陆请求
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String post(User user) {
		if (loginService.login(user.getUserName(), user.getPassword()) == 1) {
			return "login_success";
		}
		return "login";
	}
	
	
}
