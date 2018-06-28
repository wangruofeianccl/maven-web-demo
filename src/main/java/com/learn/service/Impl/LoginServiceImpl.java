package com.learn.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dao.UserDao;
import com.learn.entity.User;
import com.learn.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserDao userDao;

	public List<User> getAllUser(){
		return userDao.getAllUser();
	}
	
	public int login(String userName, String password) {
		return userDao.find(userName, password)==null?0:1;
	}

	public int save(User entity) {
		return userDao.save(entity);
	}

	public int update(User entity) {
		return userDao.update(entity);
	}

	public int delete(User entity) {
		return userDao.delete(entity);
	}
	
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}
	
	public int delById(String id) {
		return userDao.delById(id);
	}
}
