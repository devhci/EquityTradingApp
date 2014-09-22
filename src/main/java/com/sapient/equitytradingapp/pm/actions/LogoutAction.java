package com.sapient.equitytradingapp.pm.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;

@ParentPackage(value = "tiles-default")
@Action(value = "Logout", results = { @Result(location = "login-view", type = "tiles") })
public class LogoutAction implements SessionAware {

	Map<String, Object> session;

	public String execute() {
		try {
			session = ActionContext.getContext().getSession();

			((SessionMap) session).invalidate();

			System.out.println("username is " + session.get("sessionUsername"));
			return StringLiterals.SUCCESS;
		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}
	}

	public void setSession(Map<String, Object> arg0) {

	}
}
