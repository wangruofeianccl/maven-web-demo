package com.learn.service;

import java.util.List;

import com.learn.entity.User;

public interface LoginService {
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public int login(String userName,String password);
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int save(User entity);
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public int update(User entity);
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public int delete(User entity);
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getAllUser();
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	/**
	 * 根据ID删除用户
	 * @param id
	 */
	public int delById(String id);
}
