package com.learn.dao;

import com.learn.entity.User;

public interface UserDao {
	public User find(String userName,String password);
}
