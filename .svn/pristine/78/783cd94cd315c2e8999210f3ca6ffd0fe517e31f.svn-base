<%@taglib uri="/struts-tags" prefix="s" %>

	<form name="form1" action="AddedOrdersToBlock">
		<input style="display: none" type="text" name="count">
		<div class="scrollableContainer" style="margin-left: 1%">
			<div class="scrollingArea">
				<table  class="cruises scrollable draggable"  >

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
			<s:iterator value="blockOrderList">
				<tr>
					<td><div class="checkbox"><input type="radio" name="blockOrderIdList" value='<s:property value="blockOrderId"/>'></div></td>
					<td><div class="block-order-id"><s:property value="blockOrderId" /></div></td>
				<td><div class="side"><s:property  value="side" /></div></td>
				<td><div class="symbol"><s:property  value="symbol" /></div></td>
				<td><div class="symbol">
										<s:property value="blockOrderType" />
									</div></td>
									<td><div class="limit-price">
										<s:property value="qualifier" />
									</div></td>
				<td><div class="limit-price"><s:property value="limitPrice" /></div></td>
				<td><div class="stop-price"><s:property value="limitPrice" /></div></td>
				<td><div class="total-quantity"><s:property  value="totalQuantity" /></div></td>
				<td><div class="executed-quantity"><s:property  value="executedQuantity" /></div></td>
				<td><div class="open-quantity"><s:property  value="openQuantity" /></div></td>
				<td><div class="status"><s:property  value="status" /></div></td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		</div>
		</div>
		<center>
			<input type="submit" class="button" name="Add Order" value="Add Order"/>
		</center>
	</form>
