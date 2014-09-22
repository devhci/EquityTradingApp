<%@taglib uri="/struts-tags" prefix="s"%>
	<% String msg=null; 
	
  msg =(String)request.getAttribute("message1");

  if((msg)!=null){%><script type="text/javascript">alert("<%=msg%>");</script><%}%>
 

	

	<center>
		<font size="5" color="white"><h5>Block Contents</h5></font>
	</center>
	<center>

		<form name="form1" action="CheckOrderButtonPressed" onsubmit="return validateRemove()">
		<div class="scrollableContainer" >
			<div class="scrollingArea" style="margin-left: -1.6%;" >
				<table class="cruises scrollable">

					<thead>
						<tr>
							<th><div style="width: 20px;"></div></th>
							<th><div style="width: 60px;">ORDER ID</div></th>
							<th><div style="width: 60px;">SIDE</div></th>
							<th><div style="width: 70px;">SYMBOL</div></th>
							<th><div style="width: 100px;">TOTAL QUANTITY</div></th>
							<th><div style="width: 90px;">LIMIT PRICE</div></th>
							<th><div style="width: 90px;">STOP PRICE</div></th>
							<th><div style="width: 90px;">OPEN QUANTITY</div></th>
							<th><div style="width: 100px;">ALLOCATED QUANTITY</div></th>
							<th><div style="width: 95px;">STATUS</div></th>
							<th><div style="width: 90px;">MANAGER</div></th>
							<th><div style="width: 90px;">ACCOUNT TYPE</div></th>
							<th><div style="width: 100px;">PORTFOLIO</div></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="orderList" status="alloc" var="obj">
							<tr>
								<s:set name="checkStatus" value="%{blockStatus}"></s:set>
								<td><div style="width: 20px;"><s:if test="%{#checkStatus!='new'}">
										<input type="checkbox" name="orderIdList"
											value='<s:property value="orderId"/>'
											disabled="disabled">
									</s:if> <s:else>
										<input type="checkbox" name="orderIdList"
											value='<s:property value="orderId"/>'>
									</s:else></div></td>
								
								<td><div style="width: 60px;">
										<s:property value="orderId" />
									</div></td>
								<td><div style="width: 60px;">
										<s:property value="side" />
									</div></td>
									<td><div style="width: 70px;">
										<s:property value="symbol" />
									</div></td>
								<td><div style="width: 100px;">
										<s:property value="totalQuantity" />
									</div></td>
								<td><div style="width: 90px;">
										<s:property value="limitPrice" />
									</div></td>
								<td><div style="width: 90px;">
										<s:property value="stopPrice" />
									</div></td>
								<td><div style="width: 90px;">
										<s:property value="totalQuantity-allocatedQuantity" />
									</div></td>
								<td><div style="width: 100px;">
										<s:property value="allocatedQuantity" />
									</div></td>
								<td><div style="width: 95px;">
										<s:property value="status" />
									</div></td>
								<td><div style="width: 90px;">
										<s:property value="manager" />
									</div></td>
								<td><div style="width: 90px;">
										<s:property value="accountType" />
									</div></td>
								<td><div style="width: 100px;">
										<s:property value="portfolioName" />
									</div></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
			
			<input type="hidden" name="blockOrderId"
				value='<s:property value="blockOrderId" />'> <br>
			
			<input class="button" id="button" type="submit" name="buttonName"
				value="Remove Orders"  style="margin-top: -20px; text-align: center; height: 25px; width: 120px">

		</form>

	</center>
