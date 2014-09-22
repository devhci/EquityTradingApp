<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Order Blotter</title>
<style type="text/css">
table.cruises {
	font-family: verdana, arial, helvetica, sans-serif;
	font-size: 13px;
	cellspacing: 0px;
	border-collapse: collapse;
	width: 100%;
}

table.testing1 th {
	background-color: #002110;
	color: #ffffff;
	font-size: 15px;
	background: -o-linear-gradient(bottom, #002110 5%, #558755 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #002110
		), color-stop(1, #558755) );
	background: -moz-linear-gradient(center top, #002110 5%, #558755 100%);
	background: -o-linear-gradient(top, #002110, 558755);
}

table.test th,table.cruises td { /* border-right: 2.5px solid black;
	border-bottom: 2.5px solid black;
	padding: 9px; */
	
}

table.cruises tr:nth-child(odd) {
	background-color: #9cad9e;
}

table.cruises tr:nth-child(even) {
	background-color: #ffffff;
}

table.cruises th:FIRST-CHILD {
	border-left: 2.5px solid black;
}

table.cruises td:FIRST-CHILD {
	border-left: 2.5px solid black;
}

table.cruises th {
	border-top: 2.5px solid black;
}

}
div.scrollableContainer {
	position: relative;
	width: 1300px;
	padding-top: 3.3em;
	margin: 40px;
	border: none;
	left: 50px;
	background: none;
}

div.scrollingArea {
	height: 400px;
	overflow: auto;
}

table.scrollable thead tr {
	
}

table.cruises .select {
	width: 30px;
	text-align: center;
}

table.cruises .orderid {
	width: 30px;
	text-align: center;
}

table.cruises .orderstatus {
	width: 55px;
	text-align: center;
}

table.cruises .symbol {
	width: 50px;
	text-align: center;
}

table.cruises .portfolio {
	width: 65px;
	text-align: center;
}

table.cruises .accountid {
	width: 30px;
	text-align: center;
}

table.cruises .side {
	width: 30px;
	text-align: center;
}

table.cruises .order {
	width: 30px;
	text-align: center;
}

table.cruises .qun {
	width: 30px;
	text-align: center;
}

table.cruises .stopprice {
	width: 20px;
	text-align: center;
}

table.cruises .limitprice {
	width: 20px;
	text-align: center;
}

table.cruises .orderqualifier {
	width: 50px;
	text-align: center;
}

table.cruises .accounttype {
	width: 50px;
	text-align: center;
}

table.cruises .trader {
	width: 50px;
	text-align: center;
}

#main {
	width: 80px; /* Spans the widsth of the page */
	height: 50px;
	margin: 0;
	/* Ensures there is no space between sides of the screen and the menu */
	z-index: 99;
	/* Makes sure that your menu remains on top of other page elements */
	background-color: #002110;
	border: 1px solid black;
	background: -o-linear-gradient(bottom, #002110 5%, #558755 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #002110
		), color-stop(1, #558755) );
	background: -moz-linear-gradient(center top, #002110 5%, #558755 100%);
	background: -o-linear-gradient(top, #002110, 558755);
	margin-top: 5px;
	margin-bottom: 60px;
}

.navbar1 td {
	height: 100%;
	width: 100%; /* Each menu item is 150px wide */
	float: up; /* This lines up the menu items horizontally */
	text-align: center; /* All text is placed in the center of the box */
	list-style: none;
	/* Removes the default styling (bullets) for the list */
	font: normal bold 12px/1.2em Arial, Verdana, Helvetica;
	padding: 0;
	margin: 0;
	background-color: transparent;
	border: none;
	color: white;
}

.navbar1 a {
	padding: 20px 0;
	/* Adds a padding on the top and bottom so the text appears centered vertically */
	border-left: 2px solid black;
	/* Creates a border in a slightly lighter shade of blue than the background.  Combined with the right border, this creates a nice effect. */
	border-right: 2px solid black;
	/* Creates a border in a slightly darker shade of blue than the background.  Combined with the left border, this creates a nice effect. */
	border-bottom: 2px solid black;
	border-top: 2px solid black;
	text-decoration: none; /* Removes the default hyperlink styling. */
	color: white; /* Text color is white */
	display: block;
	width: 80px;
}
</style>
</head>

<script>
	function check(i) {
		count = 0;
		str = '';
		var len= document.getElementsByName("checkboxes").length;
		for ( var x = 0; x <len; x++) {
			if (document.edit_form.elements["checkboxes"][x].checked == true) {
				str += document.edit_form.elements["checkboxes"][x].value + ',';
				count++;
			}
		}
		if (count == 0) {
			alert("You must choose at least 1 order");
			return false;
		} else if (count > 1 && i == 0) {
			alert("You cannot select more than 1 order together");
			return false;
		} else {
			return true;
		}
	}

	function cancel(i) {
		if (check(i)) {
			if (confirm("Are you sure about cancelling the order?")) {
				//alert("You pressed OK!");
				return true;
			} else {
				alert("You pressed Cancel!");
				return false;
			}
		} else
			return false;
	}

	function message_display() {
		var message = document.getElementsByName("showMessage")[0].value;
		if (message) {
			alert(message);
		}
	}
	window.onload = message_display;
</script>

<body>
	<%
		String msg = null;
		msg = (String) request.getAttribute("message");
		if ((msg) != null) {
	%><script type="text/javascript">alert("<%=msg%>
		");
	</script>
	<%
		}
	%>
	<table style="width: 100%; height: 100%;">
		<tr height="10%">
			<td width="15%"></td>
			<td width="80%">
				<center>
					<h1 style="color: white;">Order Blotter</h1>
					<s:hidden name="showMessage" />
				</center>
			</td>
			<td width="5%"></td>
		</tr>
		<tr height="90%">
			<s:form theme="simple" name="edit_form" action="getOrderId">
				<td width="15%">
					<center>


						<table id="main" style="margin-top: -50px;">
							<tr class="navbar1">
								<td><s:submit
										style="border: 2px solid black; height: 40px; width:120px; background-color:transparent; color:white; cursor: pointer;"
										value="Home" action="view-position"></s:submit></td>
							</tr>
							<tr class="navbar1">
								<td><s:submit
										style="border: 2px solid black; height: 40px; width:120px; background-color:transparent; color:white; cursor: pointer;"
										value="Create Order" action="create-order-prefill"></s:submit></td>
							</tr>
							<tr class="navbar1">
								<td><s:submit value="Edit New Order"
										style="border: 2px solid black; height: 40px; width:120px; background-color:transparent; color:white; cursor: pointer;"
										name="option" onclick="return check(0)" /></td>
							</tr>
							<tr class="navbar1">
								<td><s:submit value="Amend Order" name="option"
										style="border: 2px solid black; height: 40px; width:120px; background-color:transparent; color:white; cursor: pointer;"
										onclick="return check(0)" /></td>
							</tr>
							<tr class="navbar1">
								<td><s:submit value="Send Order" name="option"
										style="border: 2px solid black; height: 40px; width:120px; background-color:transparent; color:white; cursor: pointer;"
										onclick="return check(1)" /></td>
							</tr>
							<tr class="navbar1">
								<td><s:submit value="Cancel Order" name="option"
										style="border: 2px solid black; height: 40px; width:120px; background-color:transparent; color:white; cursor: pointer;"
										onclick="return cancel(0)" /></td>
							</tr>
						</table>
					</center>
				</td>
				<td width="80%">
					<%-- <s:form theme="simple" name="edit_form" action="getOrderId"> --%>
					<!-- <div  style="width:70%;margin-left:20%;height: 398px;  overflow: auto;" > -->
					<div id="orderlist" style="margin-top: -10px;">
						<s:if test="errorField!=null">
							<br />
							<s:textfield name="errorField" style="color: white;" />
							<br />
						</s:if>
						<table class="testing1" bgcolor="grey"
							style="position: relative; left: 60px;">

							<tr>
								<th style="width: 40px">Select</th>
								<th style="width: 40px">Order Id</th>
								<th style="width: 80px">Order Status</th>
								<th style="width: 55px">Symbol</th>
								<th style="width: 110px">Portfolio</th>
								<th style="width: 60px">Account ID</th>
								<th style="width: 40px">Side</th>
								<th style="width: 70px">Order</th>
								<th style="width: 40px">Quan</th>
								<th style="width: 45px">Stop Price</th>
								<th style="width: 45px">Limit Price</th>
								<th style="width: 60px">Order Qualifier</th>
								<th style="width: 70px">Account Type</th>
								<th style="width: 60px">Trader</th>
								<th style="width: 80px">Notes</th>
							</tr>
						</table>
						<div style="height: 450px; width: 1035px; overflow: auto;">
							<table class="testing2" style="position: relative; left: 60px;">
								<s:iterator value="orderList" status="stat">
									<tr>

										<td style="width: 40px"><input type="checkbox"
											name="checkboxes" value='<s:property value="orderId"/>'></td>
										<%-- <td style="width: 6%"><s:textfield name="orderId"
									readonly="true" size="4" /></td> --%>
										<s:hidden name="orderId"></s:hidden>
										<td style="width: 40px"><s:property value="orderId" /></td>
										<td style="width: 80px"><s:property value="status" /></td>
										<td style="width: 55px"><s:property value="symbol" /></td>
										<td style="width: 110px"><s:property
												value="portfolioName" /></td>
										<td style="width: 60px"><s:property value="accountId" /></td>
										<td style="width: 40px"><s:property value="side" /></td>
										<td style="width: 70px"><s:property value="orderType" /></td>
										<td style="width: 40px"><s:property value="totalQuantity" /></td>
										<td style="width: 45px"><s:property value="stopPrice" /></td>
										<td style="width: 45px"><s:property value="limitPrice" /></td>
										<td style="width: 60px"><s:property
												value="orderQualifier" /></td>
										<td style="width: 70px"><s:property value="accountType" /></td>
										<td style="width: 60px"><s:property value="trader" /></td>
										<td style="width: 80px"><s:property value="notes" /></td>
									</tr>
								</s:iterator>

							</table>



						</div>
					</div>


				</td>
				<td width="5%"></td>
		</tr>

		</s:form>
		</tr>
	</table>




</body>
</html>