package com.ysbn.videotrain.managesystem.action;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hctn.dev.toolkit.util.Utility;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	
	HttpServletRequest getHttpServletRequest(){
		
		return ServletActionContext.getRequest();
	}
	
	HttpServletResponse getHttpServletResponse(){
		
		return ServletActionContext.getResponse();
	}
	
	ServletContext getServletContext(){
		
		return ServletActionContext.getServletContext();
	}
	
	ActionContext getActionContext(){
		
		return ServletActionContext.getContext();
	}

	@Override
	public String execute() throws Exception {
		Utility.Log.d(BaseAction.class, "BaseAction execute method");
		return process();
	}

	String process() throws Exception{
		
		return ActionSupport.NONE;
	}
}