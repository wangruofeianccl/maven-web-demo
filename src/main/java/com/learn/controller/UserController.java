package com.learn.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.entity.User;
import com.learn.service.LoginService;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	@Autowired
	LoginService loginService;
	
	/**
	 * 获取用户列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getUserList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")	
	public Map<String,Object> getUserList(HttpServletRequest req){
		Map<String,Object> result = new HashMap<String, Object>();
		
		try {
			List<User> list = loginService.getAllUser();
			result.put("data", list);
		}catch(Exception e) {
			logger.error("getUserList", e);
		}
		return result;
	}
	/**
	 * 根据ID获取用户
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getUserById",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")	
	public User getUserById(@RequestParam(value="id",required=false) String id){
		User user=null;
		try {
			if(!id.isEmpty()&&id.length()>0) {
				int _id = Integer.parseInt(id);
				user = loginService.getUserById(_id);
			}
		}catch(Exception e) {
			logger.error("getUserList", e);
		}
		return user;
	}
	
	/**
	 * 新增用户
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addUser",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public Map<String,Object> addUser(@ModelAttribute User entity) {
		try {
			if(entity==null) {
				ret.put("success", false);
			}
			 loginService.save(entity);
			 ret.put("success", true);
		}catch(Exception e) {
			logger.error("addUser", e);
			ret.put("success", false);
		}
		return ret;
	}
	
	/**
	 * 新增用户
	 * 
	 * @return
	 */
	@RequestMapping(value="/updateUser",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public Map<String,Object> updateUser(@ModelAttribute User entity) {
		try {
			if(entity==null) {
				ret.put("success", false);
			}
			loginService.update(entity);
			 ret.put("success", true);
		}catch(Exception e) {
			logger.error("addUser", e);
			ret.put("success", false);
		}
		return ret;
	}
	
	/**
	 * 新增用户
	 * 
	 * @return
	 */
	@RequestMapping(value="/delUser/{id}",method = RequestMethod.POST)
	public Map<String,Object> delUser(@PathVariable("id") String userId) {
		try {
			if(!userId.isEmpty()||userId.length()>0) {
				loginService.delById(userId);
				ret.put("success", true);
			}
			ret.put("success", false);
		}catch(Exception e) {
			logger.error("addUser", e);
			ret.put("success", false);
		}
		return ret;
	}
	
}
