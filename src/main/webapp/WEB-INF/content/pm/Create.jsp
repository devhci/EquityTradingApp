
<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
	function validate() {
		var quantity = document.getElementById("create_order_totalQuantity").value;
		var stop_price = document.getElementById("create_order_stopPrice").value;
		var limit_price = document.getElementById("create_order_limitPrice").value;
		if (isNaN(quantity) || isNaN(stop_price) || isNaN(limit_price)) {
			alert("Quantity,Limit price and Stop Price can only contain an integer");
			return false;
		} else if (Math.floor(quantity) != quantity) {
			alert("Quantity can only contain an integer");
			return false;
		} else
			return true;

	}
</script>
<table style="width: 100%;">
	<tr height="10%">
		<td style="text-align: center;">
			<h1 style="color: white; margin-left: -160px;">Create Order</h1> <%
 	session.setAttribute("sessionMessage", null);
 %>
		</td>
	</tr>
	<tr height="90%">

		<td><center>
				<table theme="simple"
					style="margin-left: -160px; width: 75%%; color: white; font-family: monospace; font-weight: bold; font-size: 15px;">

					<tr>
						<td><s:form action="create" validate="true"
								onsubmit="return validate()">
								<s:actionerror /></td>
					</tr>
					<%-- <sx:autocompleter label="What's your security symbol" list="security"
				name="order.symbol" listValue="symbol" forceValidOption="true" /> --%>
					<tr>
						<td><s:select style="width: 175px;"
								label="What's your security name" list="security"
								name="order.symbol" listKey="symbol" listValue="symbol" theme=""></s:select></td>
					</tr>
					<tr>
						<td><s:select style="width: 175px;"
								list="#{'BUY':'BUY', 'SELL':'SELL'}" name="order.side"
								label="Security Type Selection"></s:select></td>
					</tr>

					<tr>
						<td><s:select style="width: 175px;"
								list="#{'Market Order':'Market Order', 'Limit Order':'Limit Order', 'Stop Order':'Stop Order','Stop Limit Order':'Stop Limit Order'}"
								name="order.orderType" label="Order Type"></s:select></td>
					</tr>

					<tr>
						<td><s:select style="width: 175px;"
								list="#{'Day Order':'Day Order', 'Day Order':'Day Order', 'GTC':'GTC'}"
								name="order.orderQualifier" label="Order Qualifier"></s:select></td>
					</tr>

					<tr>
						<td><s:select style="width: 175px;" list="trader"
								name="order.trader" label="Trader" listKey="username"
								listValue="username"></s:select></td>
					</tr>


					<tr>
						<td><s:select style="width: 175px;"
								list="#{'cash':'cash', 'margin':'margin'}"
								name="order.accountType" label="Account Type"></s:select></td>
					</tr>

					<tr>
						<td><s:select style="width: 175px;" list="portfolio"
								name="order.portfolioName" label="Portfolio"
								listKey="portfolioName" listValue="portfolioName"></s:select></td>
					</tr>
					<tr>
						<td><s:textfield style="width: 175px;"
								name="order.totalQuantity" class="secondelement" value="0"
								label="Quantity" /></td>
					</tr>
					<tr>
						<td><s:textfield style="width: 175px;" name="order.stopPrice"
								class="secondelement" value="0" label="Stop Price" /></td>
					</tr>
					<tr>
						<td><s:textfield style="width: 175px;"
								name="order.limitPrice" class="secondelement" value="0"
								label=" Limit Price" /></td>
					</tr>
					<tr>
						<td><s:textarea style="width: 175px;" rows="5" cols="50"
								name="order.notes" label=" Add your comments here ">
							</s:textarea><br> <br></td>
					</tr>
					<tr valign="bottom">
						<td align="center" colspan=2><s:submit value="Save"
								align="center" cssClass="button" theme="simple"></s:submit>
							<s:reset cssClass="button" theme="simple"></s:reset></td>
					</tr>

					</s:form>

				</table>
			</center></td>
	</tr>

</table>
