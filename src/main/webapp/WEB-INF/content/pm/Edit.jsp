<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
	function validate() {
		var quantity = document
				.getElementById("edit_change_order_totalQuantity").value;
		var stop_price = document.getElementById("edit_change_order_stopPrice").value;
		var limit_price = document
				.getElementById("edit_change_order_limitPrice").value;
		if (isNaN(quantity) || isNaN(stop_price) || isNaN(limit_price)) {
			alert("Quantity, Limit price and Stop Price can only contain a numerical value");
			return false;
		} else if (Math.floor(quantity) != quantity) {
			alert("Quantity can only contain an integer");
			return false;
		} else
			return true;
	}
</script>

<center>
	<!--  May be redundent when integrated with tiles -->
	<h1 style="margin-left: -60px; color: white;">Edit Order</h1>

</center>
<div style="margin-left: 400px;">
	<s:form action="edit_change" validate="true" style="color:white; font-family: monospace; font-weight: bold; font-size: 15px;"
		onsubmit="return validate()">
		<s:actionerror />
		<br />
		<br />
		<s:textfield name="order.orderId" label="Order ID" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:textfield name="order.symbol" label="Symbol" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:textfield name="order.side" label="Side" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:textfield name="order.status" label="Status" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:select
			list="#{'Market Order':'Market Order', 'Limit Order':'Limit Order', 'Stop Order':'Stop Order','Stop Limit Order':'Stop Limit Order'}"
			name="order.orderType" label="Order Type"></s:select>

		<s:select
			list="#{'Day Order':'Day Order', 'Day Order':'Day Order', 'GTC':'GTC'}"
			name="order.orderQualifier" label="Order Qualifier"></s:select>

		<s:select list="trader" name="order.trader" label="Trader"
			listKey="username" listValue="username"></s:select>


		<s:select list="#{'cash':'cash', 'margin':'margin'}"
			name="order.accountType" label="Account Type"></s:select>

		<s:select list="portfolio" name="order.portfolioName"
			label="Portfolio" listKey="portfolioName" listValue="portfolioName"></s:select>

		<s:textfield name="order.totalQuantity" label="Quantity" />

		<s:textfield name="order.stopPrice" label="Stop Price" />

		<s:textfield name="order.limitPrice" label=" Limit Price" />

		<s:textarea rows="5" cols="50" id="comments"
			label=" Add your comments here ">

		</s:textarea>

		<s:hidden name="order.cusip" />
		<s:hidden name="order.accountId" />
		<s:hidden name="order.manager" />

		<s:submit cssClass="button" value="Save"
			style="position:relative;left:-200px;">
		</s:submit>


	</s:form>

</div>


