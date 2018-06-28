package com.learn.dao;

import java.util.List;

import com.learn.entity.User;

public interface UserDao {
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getAllUser();
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public User find(String userName,String password);
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
	 * 根据ID获取
	 * @param id
	 * @return
	 */
    public User getUserById(Integer id);
    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public int delById(String id);
}
