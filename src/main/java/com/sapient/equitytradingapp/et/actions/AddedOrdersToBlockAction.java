package com.sapient.equitytradingapp.et.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sapient.equitytradingapp.et.service.AddedOrdersToBlockService;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;

@Action(value = "AddedOrdersToBlock")
@Results({ @Result(name = "input", location = "orders", type = "chain"),
		@Result(name = "success", location = "orders", type = "chain"),
		@Result(location = "Error.jsp", name = "exception") })
public class AddedOrdersToBlockAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Long> blockOrderIdList = new ArrayList<Long>();
	@Autowired
	private AddedOrdersToBlockService service;

	public String execute() {
		try {
			if (blockOrderIdList == null || blockOrderIdList.size() == 0) {
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("message",
						"Please select atleast one blockorder");
				return "input";
			}
			if (blockOrderIdList.size() > 1) {
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("message",
						"Please select only one blockorder");
				return "input";
			}
			List<Long> orderIdList = (List<Long>) ActionContext.getContext()
					.getSession().get("orderIdList");

			service.addOrdersToBlock(blockOrderIdList.get(0), orderIdList);
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("message", "Orders added successfully");
			return "success";
		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}
	}

	public List<Long> getBlockOrderIdList() {
		return blockOrderIdList;
	}

	public void setBlockOrderIdList(List<Long> blockOrderIdList) {
		this.blockOrderIdList = blockOrderIdList;
	}

}
