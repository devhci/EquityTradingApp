
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<style>
th {
	background-color: #002110;
	color: #ffffff;
	font-size: 17px;
	background: -o-linear-gradient(bottom, #002110 5%, #558755 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #002110
		), color-stop(1, #558755) );
	background: -moz-linear-gradient(center top, #002110 5%, #558755 100%);
	background: -o-linear-gradient(top, #002110, 558755);
}
</style>
</head>
<body>
	<script>
		function anyFilter() {
			if (document.myForm.filterChoice.value == "Any") {
				document.myForm.filterValue.disabled = true;
			} else if (document.myForm.filterChoice.value != "Any"
					&& document.myForm.filterChoice.value != "Portfolio Name"
					&& document.myForm.filterChoice.value != "Security Symbol"
					&& document.myForm.filterChoice.value != "Account Name") {
				document.myForm.filterValue.disabled = true;
			} else if (document.myForm.filterChoice.value == "Portfolio Name") {
				document.myForm.filterValue.disabled = false;
			} else if (document.myForm.filterChoice.value == "Security Symbol") {
				document.myForm.filterValue.disabled = false;
			} else if (document.myForm.filterChoice.value == "Account Name") {
				document.myForm.filterValue.disabled = false;
			}
		}

		function fillText() {
			if (document.myForm.filterChoice.value == "Portfolio Name"
					&& document.myForm.filterValue.value == "") {
				alert("Fill up some Portfolio Name for filter.");
				return false;
			} else if (document.myForm.filterChoice.value == "Security Symbol"
					&& document.myForm.filterValue.value == "") {
				alert("Fill up some Security Symbol for filter.");
				return false;
			} else if (document.myForm.filterChoice.value == "Account Name"
					&& document.myForm.filterValue.value == "") {
				alert("Fill up some Account Name for filter.");
				return false;
			} else
				return true;
		}
	</script>

	<table style="width: 100%; margin-top: -70px;" >
		<tr>
			<td>
				<table >
					<tr>
						<td colspan="3"><h1 style="color: white;">Positions</h1></td>
					</tr>
					<tr style="color: white;">
						<s:form action="filter-portfolio" theme="simple" name="myForm"
							onsubmit="return fillText()">
							<td style="font-size: 22px;">Filter Criteria&nbsp;&nbsp;&nbsp;&nbsp;<s:select
									list="#{'Any':'Any', 'Portfolio Name':'Portfolio Name', 'Security Symbol':'Security Symbol', 'Account Name':'Account Name'}"
									name="filterChoice" label="What's your security name"
									onchange="return anyFilter()" headerKey="-1"
									headerValue="Select - -"></s:select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td style="font-size: 22px;">Filter Value&nbsp;&nbsp;<s:textfield name="filterValue"
									value="" />&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td><s:submit value="Filter" cssClass="button"
									name="filterButton"></s:submit> <!-- 	<s:select label="Filter " list="{'P1','P2','P3','P4'}"></s:select>-->
							</td>
						</s:form>
					</tr>

				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="80%"
					style="color: white; cellspacing: 0 px; cellpadding: 0 px;"
					id="outsidetable">
					<tr bgcolor="grey">
						<th width="20%">Portfolio</th>
						<th width="20%">Account Name</th>
						<th width="20%">Security Symbol</th>
						<th width="20%">Security</th>
						<th width="20%">Quantity</th>

					</tr>

					<s:iterator value="viewPositionList" var="holding">
						<br />
						<tr style="font-family: monospace; font-size: 15px;">
							<td width="20%"><s:property value="portfolioName" /></td>
							<td width="20%"><s:property value="accountName" /></td>
							<td colspan="3" width="60%">
								<table width="100%" class="insidetable"
									style="cellspacing: 0 px; cellpadding: 0 px;">
									<s:iterator value="securityList" var="security">
										<tr>
											<td width="33%"><s:property value="symbol" /></td>
											<td width="33%"><s:property value="securityName" /></td>
											<td width="33%"><s:property value="quantity" /></td>
										</tr>
									</s:iterator>
								</table>
							</td>
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>