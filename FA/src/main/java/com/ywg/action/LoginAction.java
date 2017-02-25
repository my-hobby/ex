package com.ywg.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ywg.dao.IBaseDao;
import com.ywg.model.TUser;
import com.ywg.utils.ApplicationUtil;
import com.ywg.webServlet.LoginServlet;

public class LoginAction extends BaseAction {
	private LoginServlet loginServlet;
	private String userName;
	private String password;
	private String flag;


	public void setLoginServlet(LoginServlet loginServlet) {
		this.loginServlet = loginServlet;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public String getFlag() {
		return flag;
	}
                                                                                                                                                                                                                                                                                                     

	@Override
	public String execute() throws Exception {
		ApplicationUtil a=new ApplicationUtil();
		HttpSession session=getRequest().getSession(); 
		ServletContext servletContext =session.getServletContext(); 
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext); 
		a.setApplicationContext(context );
		TUser user = (TUser) loginServlet.login(userName, password);
		if(user==null)return "login";
		Integer rightsId=user.getTblRights().getRighId();
		IBaseDao<TblRights, Integer> DAO =(IBaseDao<TblRights, Integer>) ApplicationUtil.getBean("BaseDao");
		DAO.setEntityClass(TblRights.class);
		TblRights t=DAO.get(rightsId);
		user.setTblRights(t);
		session.setAttribute("user", user);
		return SUCCESS;
				
	}

}
