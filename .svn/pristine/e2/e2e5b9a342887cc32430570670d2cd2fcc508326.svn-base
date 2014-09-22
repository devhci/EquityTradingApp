package com.sapient.equitytradingapp.et.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.sapient.equitytradingapp.pm.constant.StringLiterals;

@Action(value = "CheckButtonPressed")
@Results({
		@Result(name = "create", location = "CreateBlockOrder", type = "chain"),
		@Result(name = "add", location = "AddToBlockOrder", type = "chain"),
		@Result(name = "input", location = "orders", type = "chain"),
		@Result(location = "Error.jsp", name = "exception") })
public class CheckButtonPressedAction {
	private String buttonName;

	public String execute() {
		try {
			if (buttonName.equals("Create Block Order"))
				return "create";
			else if (buttonName.equals("Add to Block Order"))
				return "add";
			else
				return StringLiterals.INPUT;

		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
}
