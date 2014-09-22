package com.sapient.equitytradingapp.et.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sapient.equitytradingapp.et.pojo.Allocation;
import com.sapient.equitytradingapp.et.pojo.Execution;
import com.sapient.equitytradingapp.et.service.AllocationBlotterService;
import com.sapient.equitytradingapp.et.service.ExecutionBlotterService;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;

@ParentPackage("tiles-default")
@Action(value = "ExecutionBlotter")
@Results({
		@Result(name = "success", location = "executionBlotter", type = "tiles"),
		@Result(location = "Error.jsp", name = "exception") })
public class ExecutionBlotterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ExecutionBlotterService executionBlotterService;

	@Autowired
	private AllocationBlotterService allocationBlotterService;

	private List<Execution> executionList;

	public String execute() {
		try {
			String userName = (String) ActionContext.getContext().getSession()
					.get("sessionUsername");
			executionList = executionBlotterService
					.getExecutionsForTrader(userName);
			allocationList = allocationBlotterService
					.getAllocationsForTrader(userName);
			return StringLiterals.SUCCESS;

		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}

	}

	public List<Execution> getExecutionList() {
		return executionList;
	}

	public void setExecutionList(List<Execution> executionList) {
		this.executionList = executionList;
	}

	private List<Allocation> allocationList;

	public List<Allocation> getAllocationList() {
		return allocationList;
	}

	public void setAllocationList(List<Allocation> allocationList) {
		this.allocationList = allocationList;
	}

}
