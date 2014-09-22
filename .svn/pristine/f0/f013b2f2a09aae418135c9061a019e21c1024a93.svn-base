package com.sapient.equitytradingapp.pm.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.service.SendForExecutionService;

@Action(value = "SendForExecutionPM", results = {
		@Result(location = "view-order-blotter", type = "chain", name = "success"),
		@Result(location = "view-order-blotter", type = "chain", name = "input") })
public class SendForExecutionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	List<Long> checkboxes;
	String showMessage;
	Boolean value = true;

	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}

	public List<Long> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(List<Long> checkboxes) {
		this.checkboxes = checkboxes;
	}

	@Autowired
	SendForExecutionService sendForExecutionService;

	Map<String, Object> session = ActionContext.getContext().getSession();

	public String execute() {

		if (value) {
			for (long index : checkboxes)
				sendForExecutionService.sendOrder(index);
			showMessage = "Successfully sent for execution.";
			session.put("sessionMessage", new String(showMessage));
			return StringLiterals.SUCCESS;
		}
		else
			return StringLiterals.INPUT;

	}

	public void validate() {
		showMessage = "Only new orders can be sent for execution";
		for (long index : checkboxes)
			if (!sendForExecutionService.checkStatus(index).equals(
					StringLiterals.NEW)) {
				value = false;
				showMessage = "Only new orders can be sent for execution";
				break;
			}
		session.put("sessionMessage", new String(showMessage));
	}

}