package com.learn.dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.learn.dao.UserDao;
import com.learn.entity.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	// HibernateDaoSupport来操作数据库更加方便
	// 用来注入sessionFactory（不注入会报错）
	@Resource(name = "sessionFactory")
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public List<User> getAllUser(){
		List<?> users = getHibernateTemplate().find("from User where 1=1");
		return (List<User>)users;
	}

	public User find(String userName, String password) {
		List<?> users = getHibernateTemplate().find("from User where userName=? and password=?", userName, password);
		return users.size() > 0 ? (User) users.get(0) : null;
	}
	
	public User getUserById(Integer id) {
		List<?> users = getHibernateTemplate().find("from User where id=? ", id);
		return users.size() > 0 ? (User) users.get(0) : null;
	}

	public int save(User entity) {
		try {
			getHibernateTemplate().save(entity);
			return 1;
		} catch (Exception e) {
			logger.error("save:", e);
		}
		return 0;
	}

	public int update(User entity) {
		try {
			getHibernateTemplate().update(entity);
			return 1;
		} catch (Exception e) {
			logger.error("update:", e);
		}
		return 0;
	}

	public int delete(User entity) {
		try {
			getHibernateTemplate().delete(entity);			
			return 1;
		} catch (Exception e) {
			logger.error("delete:", e);
		}
		return 0;
	}
	
	 public int delById(String id) {
			try {
				List<?> users = getHibernateTemplate().find("from User where id=? ", id);
				User user = users.size() > 0 ? (User) users.get(0) : null;
				if(user==null)return 0;
				getHibernateTemplate().delete(user);			
				return 1;
			} catch (Exception e) {
				logger.error("delete:", e);
			}
			return 0;
	 }

}
