<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
	function validate() {
		var quantity = document
				.getElementById("amend_change_order_totalQuantity").value;
		var stop_price = document
				.getElementById("amend_change_order_stopPrice").value;
		var limit_price = document
				.getElementById("amend_change_order_limitPrice").value;
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
	<!--  May be redundent when integrated with tiles -->
	<h1 style="color: white; margin-left: -158px; ">Amend Order</h1>
	<%session.setAttribute("sessionMessage",null);%>
</center>
<div style="margin-left: 260px;">
	<s:form action="amend_change" validate="true" style="color:white; font-family: monospace; font-weight: bold; font-size: 15px;"
		onsubmit="return validate()">
		<s:actionerror />
		<br />
		<br />
		<!-- order status, side and symbol -->
		<s:textfield style="width: 175px;" name="order.orderId" label="Order ID" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:textfield style="width: 175px;" name="order.symbol" label="Symbol" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:textfield style="width: 175px;" name="order.side" label="Side" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:textfield style="width: 175px;" name="order.status" label="Status" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:textfield style="width: 175px;" name="order.orderType" label="Order Type" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:textfield style="width: 175px;" name="order.orderQualifier" label="Order Qualifier"
			readonly="true" cssStyle="background:#C0C0C0" />

		<s:textfield style="width: 175px;" name="order.trader" label="Trader" readonly="true"
			cssStyle="background:#C0C0C0" />

		<s:textfield style="width: 173px;" name="order.accountType" label="Account Type"
			readonly="true" cssStyle="background:#C0C0C0" />

		<s:select style="width: 140px;" list="portfolio" name="order.portfolioName"
			label="Portfolio" listKey="portfolioName" listValue="portfolioName"></s:select>

		<s:textfield style="width: 134px;" name="order.totalQuantity" label="Quantity" />

		<s:textfield style="width: 134px;" name="order.stopPrice" label="Stop Price" />

		<s:textfield style="width: 134px;" name="order.limitPrice" label=" Limit Price" />

		<s:textarea style="width: 134px;" rows="5" cols="50" id="comments"
			label=" Add your comments here ">

		</s:textarea>

		<s:hidden name="order.cusip" />
		<s:hidden name="order.accountId" />
		<s:hidden name="order.manager" />
		<s:hidden name="order.blockOrderId" />

		<s:submit cssClass="button" value="Save"
			style="position:relative;left:-12px;">
		</s:submit>
	</s:form>

</div>

