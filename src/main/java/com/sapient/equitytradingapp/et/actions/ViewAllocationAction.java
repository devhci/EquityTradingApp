package com.sapient.equitytradingapp.et.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.equitytradingapp.et.service.ApproveAllocationService;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;

/**
 * Class to View Allocations from Allocation table
 * 
 * @author dkumar40
 * 
 */
@ParentPackage("tiles-default")
@Action(value = "ViewAllocation")
@Results({
		@Result(name = "success", location = "ExecutionBlotter", type = "chain"),
		@Result(location = "Error.jsp", name = "exception") })
public class ViewAllocationAction {
	@Autowired
	private ApproveAllocationService approveAllocationService;
	private List<Long> viewAllocateList = new ArrayList<Long>();

	public List<Long> getViewAllocateList() {
		return viewAllocateList;
	}

	public void setViewAllocateList(List<Long> viewAllocateList) {
		this.viewAllocateList = viewAllocateList;
	}

	public String execute() {
		
		try {

			approveAllocationService.approveAllocation(viewAllocateList);
			return "success";
		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}
	}
}
