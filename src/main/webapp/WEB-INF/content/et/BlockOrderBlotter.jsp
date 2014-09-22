<%@taglib uri="/struts-tags" prefix="s"%>
	<%
		String msg = null;
		msg = (String) request.getAttribute("message");
		if ((msg) != null) {
	%><script type="text/javascript">alert("<%=msg%>");
		</script>
	<%
		}
	%>
	<center>
	<font size="5" color="white"><h5>Block Order Blotter</h5></font>
	</center>


	<form name="form1" action="option">
		<div class="scrollableContainer" style="margin-left: 5%; width: 1112px;">
			<div class="scrollingArea">
				<table  class="cruises scrollable"  >

					<thead>
						<tr>
							<th><div class="checkbox"></div></th>
							<th><div class="block-order-id">BLOCK ORDER ID</div></th>
							<th><div class="side">SIDE</div></th>
							<th><div class="symbol">SYMBOL</div></th>
							<th><div class="symbol">ORDER TYPE</div></th>
							<th><div class="limit-price">QUALIFIER</div></th>
							<th><div class="limit-price">LIMIT PRICE</div></th>
							<th><div class="stop-price">STOP PRICE</div></th>
							<th><div class="total-quantity">TOTAL QUANTITY</div></th>
							<th><div class="executed-quantity">EXECUTED QUANTITY</div></th>
							<th><div class="open-quantity">OPEN QUANTITY</div></th>
							<th><div class="status">STATUS</div></th>
						</tr>
					</thead>
					<tbody>
			<s:iterator value="blockOrderList" status="alloc" var="obj" >
							<tr>
													
								<s:set name="checkStatus" value="%{#obj.status}"></s:set>
								<td><div class="checkbox"><s:if test="%{#checkStatus=='Completed'}">
										<input type="checkbox" name="blockOrderIdList"
											value='<s:property value="blockOrderId"/>'
											disabled="disabled">
									</s:if> <s:else>
										<input type="checkbox" name="blockOrderIdList"
											value='<s:property value="blockOrderId"/>'>
									</s:else></div></td>
								<td><div class="block-order-id">
										<s:url id="orderURL" action="ViewBlockOrder">
											<s:param name="blockOrderId" value="blockOrderId" />
										</s:url>
										<s:a href="%{orderURL}">
											<s:property value="blockOrderId" />
										</s:a>
									</div></td>
								<td><div class="side">
										<s:property value="side" />
									</div></td>
								<td><div class="symbol">
										<s:property value="symbol" />
									</div></td>
									<td><div class="symbol">
										<s:property value="blockOrderType" />
									</div></td>
									<td><div class="limit-price">
										<s:property value="qualifier" />
									</div></td>
								<td><div class="limit-price">
										<s:property value="limitPrice" />
									</div></td>
								<td><div class="stop-price">
										<s:property value="stopPrice" />
									</div></td>
								<td><div class="total-quantity">
										<s:property value="totalQuantity" />
									</div></td>
								<td><div class="executed-quantity">
										<s:property value="executedQuantity" />
									</div></td>
								<td><div class="open-quantity">
										<s:property value="openQuantity" />
									</div></td>
								<td><div class="status">
										<s:property value="status" />
									</div></td>

							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>

		<br>
		<center>
			<input class="button" id="button" type="submit" name="option1"
				value="Send For Execution" style="width: 130px" > <input
				class="button" id="button" type="submit" name="option1" value="Edit"
				onclick="return check()"> <input class="button" id="button"
				type="submit" name="option1" value="Cancel"
				onclick="return checkCancel()">
		</center>
	</form>
