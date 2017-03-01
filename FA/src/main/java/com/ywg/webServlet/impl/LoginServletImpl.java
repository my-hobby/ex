package com.ywg.webServlet.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ywg.dao.IBaseDao;
import com.ywg.model.TUser;
import com.ywg.webServlet.LoginServlet;

public class LoginServletImpl implements LoginServlet {

	private String sql = "select * from t_user WHERE userName=? AND password=?";
	private IBaseDao<TUser, Integer> userDAO;

	public IBaseDao<TUser, Integer> getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IBaseDao<TUser, Integer> userDAO) {
		this.userDAO = userDAO;
	}

	public Object login(String userName, String password) {
		userDAO.setEntityClass(TUser.class);
		Object user = (Object) userDAO.getBySQL(sql, userName, password);
		TUser u = (TUser) user;
		return u;
	}

}
