package com.ywg.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ywg.utils.ApplicationUtil;



public class BaseAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware   {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public Map<String, Object> getSession() {
		return this.session;
	}


	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
		
	}


	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}


	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public HttpServletResponse getResponse() {
		return response;
	}


	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
