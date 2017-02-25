package com.ywg.webServlet.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ywg.dao.IBaseDao;
import com.ywg.model.TblUser;
import com.ywg.webServlet.LoginServlet;

public class LoginServletImpl implements LoginServlet {

	private String sql = "select * from tbl_user WHERE user_Name=? AND user_password=?";
	private String hql = "from TblUser  WHERE userName=? AND userPassword=?";

	private IBaseDao<TblUser, Integer> userDAO;

	public IBaseDao getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IBaseDao<TblUser, Integer> userDAO) {
		this.userDAO = userDAO;
	}

	public Object login(String userName, String password) {

		Object user = (Object) userDAO.getByHQL(hql, userName, password);
		TblUser u = (TblUser) user;
		return u;
	}

}
