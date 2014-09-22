package com.sapient.equitytradingapp.et.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import com.sapient.equitytradingapp.et.service.AllocationBlockService;
import com.sapient.equitytradingapp.et.service.AllocationBlotterService;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;

@ParentPackage("tiles-default")
@Action(value = "AllocationBlock")
@Results({
		@Result(name = "success", location = "ExecutionBlotter", type = "chain"),
		@Result(location = "Error.jsp", name = "exception") })
public class AllocationBlockAction {

	@Autowired
	private AllocationBlockService allocationBlockService;

	@Autowired
	private AllocationBlotterService allocationBlotterService;

	private List<Long> executionAllocateList = new ArrayList<Long>();

	public List<Long> getExecutionAllocateList() {
		return executionAllocateList;
	}

	public void setExecutionAllocateList(List<Long> executionAllocateList) {
		this.executionAllocateList = executionAllocateList;
	}

	public String execute() {
		try {
			allocationBlockService
					.allocateExecutionList(getExecutionAllocateList());
			return "success";
		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}
	}

}
