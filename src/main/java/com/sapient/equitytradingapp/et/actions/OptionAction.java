package com.sapient.equitytradingapp.et.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;

/**
 * Action Class to Pass Value of Block Order for Execution, Editing or Removal
 * 
 * @author dkumar40
 * 
 */
@ParentPackage("tiles-default")
@Action(value = "option")
@Results({
		@Result(name = "create", location = "SentForExecution", type = "chain"),
		@Result(name = "edit", location = "editblockOrder", type = "tiles"),
		@Result(name = "cancel", location = "CancelBlockOrder", type = "chain"),
		@Result(name = "input", location = "BlockOrderBlotter", type = "chain"),
		@Result(location = "Error.jsp", name = "exception")})
public class OptionAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlockOrder editBlock;
    Map<String, Object> map;
	private String option1;
	List<Long> blockOrderIdList;
	@Autowired
	BlockOrderDAO blockOrderDAO;
	public String execute() {
		try {
			map.put("editBlock", editBlock);
			if (option1.equals("Send For Execution"))
				return "create";
			else if (option1.equals("Edit")) {
				if (blockOrderIdList == null||blockOrderIdList.size() == 0) {
					HttpServletRequest request = ServletActionContext.getRequest();
					request.setAttribute("message",
							"Please select at least one order to edit");
					return StringLiterals.INPUT;
					
				}
				
				Long bId = blockOrderIdList.get(0);
				editBlock = blockOrderDAO.getBlockOrderById(bId);
				
				return "edit";
			} else if (option1.equals("Cancel")) {
				return StringLiterals.CANCEL;
			} else
				return StringLiterals.INPUT;
			
		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}


	}
	public BlockOrder getEditBlock() {
		return editBlock;
	}

	public void setEditBlock(BlockOrder editBlock) {
		this.editBlock = editBlock;
	}
	public BlockOrderDAO getBlockOrderDAO() {
		return blockOrderDAO;
	}

	public void setBlockOrderDAO(BlockOrderDAO blockOrderDAO) {
		this.blockOrderDAO = blockOrderDAO;
	}

	public List<Long> getBlockOrderIdList() {
		return blockOrderIdList;
	}

	public void setBlockOrderIdList(List<Long> blockOrderIdList) {
		this.blockOrderIdList = blockOrderIdList;
	}

       public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public void setSession(Map<String, Object> arg0) {

		this.map = arg0;
	}
}
