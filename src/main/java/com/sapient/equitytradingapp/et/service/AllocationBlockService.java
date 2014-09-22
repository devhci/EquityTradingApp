package com.sapient.equitytradingapp.et.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.dao.AllocationDAO;
import com.sapient.equitytradingapp.et.dao.ExecutionDAO;
import com.sapient.equitytradingapp.et.pojo.Execution;

@Component
public class AllocationBlockService {

	@Autowired
	AllocationDAO allocationDAO;
	@Autowired
	ExecutionDAO executionDAO;

	public void allocateExecutionList(List<Long> executionAllocateList) {
		List<Execution> executionList = new ArrayList<Execution>();
		for (Long id : executionAllocateList) {
			Execution execution = executionDAO.getExecutionById(id);
			executionList.add(execution);
		}
		allocationDAO.allocate(executionList);

	}

}
