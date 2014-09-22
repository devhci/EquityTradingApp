<%@taglib uri="/struts-tags" prefix="s"%>
<center>
		<font size="5" color="white"><h5>Allocation Blotter</h5></font>
	</center>
	<form action="ViewAllocation">
		<div class="scrollableContainer">
			<div class="scrollingArea">
				<table class="cruises scrollable" >
					<thead>
						<tr>
							<th><div class="checkbox"></div></th>
							<th><div class="allocation-id">ALLOCATION ID</div></th>
							<th><div class="side">SIDE</div></th>
							<th><div style="width: 130px;">TRANSACTION PRICE</div></th>
							<th><div style="width: 130px;">TRANSACTION FEE</div></th>
							<th><div style="width: 160px;">ALLOCATED
									QUANTITY</div></th>
							<th><div class="open-quantity">OPEN QUANTITY</div></th>
							<th><div style="width: 94px;">STATUS</div></th>
							<th><div style="width: 100px;">ORDER ID</div></th>
							<th><div style="width: 100px;">EXECUTION ID</div></th>
							<th><div class="trader">TRADER</div></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="allocationList" status="alloc" var="obj">
							<tr>
								<s:set name="checkStatus" value="%{#obj.status}"></s:set>
								<td><div class="checkbox"><s:if test="%{#checkStatus=='Approved'}">
										<input type="checkbox" name="viewAllocateList"
											value='<s:property value="allocationId"/>'
											disabled="disabled">
									</s:if> <s:else>
										<input type="checkbox" name="viewAllocateList"
											value='<s:property value="allocationId"/>'>
									</s:else></div></td>
								
								<td ><div class="allocation-id">
										<s:property value="allocationId" />
									</div></td>
								<td ><div class="side">
										<s:property value="side" />
									</div></td>
								<td ><div style="width: 130px;">
										<s:property value="transactionPrice" />
									</div></td>
								<td ><div style="width: 130px;">
										<s:property value="transactionFee" />
									</div></td>
								<td ><div style="width: 160px;">
										<s:property value="allocatedQuantity" />
									</div></td>
								<td ><div class="open-quantity">
										<s:property value="openQuantity" />
									</div></td>
								<td ><div style="width: 94px;">
										<s:property value="status" />
									</div></td>
								<td ><div style="width: 100px;">
										<s:property value="orderId" />
									</div></td>
								<td ><div style="width: 100px;">
										<s:property value="executionId" />
									</div></td>
								<td ><div class="trader">
										<s:property value="trader" />
									</div></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
		<center>
			<input class="button" id="button" type="submit" name="allocate"
				value="Approve Allocation" onclick="return validateApprove()" style="width: 130px">
		</center>
	</form>

