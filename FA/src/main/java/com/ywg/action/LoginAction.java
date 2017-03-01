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

	public void setLoginServlet(LoginServlet loginServlet) {
		this.loginServlet = loginServlet;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String execute() throws Exception {
		ApplicationUtil a = new ApplicationUtil();
		HttpSession session = getRequest().getSession();
		ServletContext servletContext = session.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		a.setApplicationContext(context);
		// 判断是否有用户存在
		TUser user = (TUser) loginServlet.login(userName, password);
		if (user == null) {
		    String f=(String) session.getAttribute("flag");
			int i = 0;
			if(f==null||f.equals("")){
				i=1;
			}else{
				i=Integer.parseInt(f);
				++i;
			}
			f=i+"";
			session.setAttribute("flag",f );
			//是否显示错误信息0是1否
			session.setAttribute("show",0 );
			return "login";
		}
		session.setAttribute("flag",'0' );
		return SUCCESS;

	}

}
