<%@taglib uri="/struts-tags" prefix="s"%>
<center><% String msg=null; 
  msg =(String)request.getAttribute("message");
  if((msg)!=null){%><script type="text/javascript">alert("<%=msg%>");</script><%} %> </center>
  
	<center>
		<font size="5" color="white"><h5>Order Blotter</h5></font>
	</center>
	<form action="CheckButtonPressed">
		<div class="scrollableContainer">
			<div class="scrollingArea">
				<table  class="cruises scrollable"  >
					<thead>
						<tr>
							<th><div class="checkbox"></div></th>
							<th><div class="order-id">ORDER ID</div></th>
							<th><div class="side">SIDE</div></th>
							<th><div class="symbol">SYMBOL</div></th>
							<th><div style="width: 130px;">ORDER TYPE</div></th>
							<th><div style="width: 90px;">QUALIFIER</div></th>
							<th><div style="width: 98px;">TOTAL QUANTITY</div></th>
							<th><div class="limit-price">LIMIT PRICE</div></th>
							<th><div class="stop-price">STOP PRICE</div></th>
							<th><div class="manager">MANAGER</div></th>
							<th><div class="account-type">ACCOUNT TYPE</div></th>
							<th><div style="width: 140px;">PORTFOLIO</div></th>
							
						</tr>
					</thead>
					<tbody>
						<s:iterator value="orderList">
							<tr>
								<td><div class="checkbox">
										<input type="checkbox" name="orderIdList"
											value='<s:property value="orderId"/>'>
									</div></td>
								<td><div class="order-id">
										<s:property value="orderId" />
									</div></td>
								<td><div class="side">
										<s:property value="side" />
									</div></td>
								<td><div class="symbol">
										<s:property value="symbol" />
									</div></td>
									<td><div style="width: 130px;">
										<s:property value="orderType" />
									</div></td>
									<td><div style="width: 90px;">
										<s:property value="orderQualifier" />
									</div></td>
								<td><div style="width: 98px;">
										<s:property value="totalQuantity" />
									</div></td>
								<td><div class="limit-price">
										<s:property value="limitPrice" />
									</div></td>
								<td><div class="stop-price">
										<s:property value="stopPrice" />
									</div></td>
								<td><div class="manager">
										<s:property value="manager" />
									</div></td>
								<td><div class="account-type">
										<s:property value="accountType" />
									</div></td>
								<td><div style="width: 140px;">
										<s:property value="portfolioName" />
									</div></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
		<center>
			<s:submit  cssClass="button" id="button" name="buttonName"
				value="Create Block Order" theme="simple" style="width: 130px; margin-bottom: 30px;"></s:submit>
			<s:submit cssClass="button" id="button" name="buttonName" style="width: 130px; margin-bottom: 30px;"
				value="Add to Block Order" theme="simple"></s:submit>
		</center>
		


	</form>
