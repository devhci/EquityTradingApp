package com.sapient.equitytradingapp.et.pojo;

import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement
public class BlockOrderListWrapper {

	private List<BlockOrder> blockOrderList = new ArrayList<BlockOrder>();

	public List<BlockOrder> getBlockOrderList() {
		return blockOrderList;
	}

	@XmlElement
	public void setBlockOrderList(List<BlockOrder> blockOrderList) {
		this.blockOrderList = blockOrderList;
	}

	public BlockOrderListWrapper(List<BlockOrder> blockOrderList) {
		this.blockOrderList = blockOrderList;
	}

	public BlockOrderListWrapper() {
		// TODO Auto-generated constructor stub
	}

}
