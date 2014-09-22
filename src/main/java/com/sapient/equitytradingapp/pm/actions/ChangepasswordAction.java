package com.sapient.equitytradingapp.pm.actions;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sapient.equitytradingapp.pm.service.ChangePasswordService;

/**
 * To call "Change Password" service.
 * 
 */

@SuppressWarnings("serial")
@ParentPackage(value = "tiles-default")
@Action(value = "changepassword", results = {
		@Result(location = "login-view", type = "tiles", name = "success"),
		@Result(location = "login-view", type = "tiles", name = "failure"),
		@Result(location = "changePassword-view", type = "tiles", name = "input") })
public class ChangepasswordAction extends ActionSupport {

	private static Logger logger = Logger.getLogger(LoginAction.class);
	String newPassword;
	String confirmPassword;
	@Autowired
	ChangePasswordService changePasswordservice;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public ChangePasswordService getChangePasswordservice() {
		return changePasswordservice;
	}

	public void setChangePasswordservice(
			ChangePasswordService changePasswordservice) {
		this.changePasswordservice = changePasswordservice;
	}

	public String execute() {
		logger.info("in change password action");
		String result = changePasswordservice.authenticate(newPassword,
				confirmPassword);
		return result;
	}

	@Override
	public void validate() {

		if (!(newPassword.equals(confirmPassword))) {
			addActionError(getText("password.mismatch"));
		}

		if (newPassword.length() < 6) {
			addActionError(getText("password.short"));
		}
if(newPassword.length()==0|| confirmPassword.length()==0){
	addActionError(getText("password.null"));
}
	}
}
