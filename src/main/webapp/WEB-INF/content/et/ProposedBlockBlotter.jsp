<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String msg = null;
	msg = (String) request.getAttribute("message1");
	if ((msg) != null) {
%><script type="text/javascript">alert("<%=msg%>");
		</script>
<%
	}
%>
<center>
	<font size="5" color="white"><b>Proposed Block</b></font>
</center>
<form action="CreateProposedBlockOrder">
	<div class="scrollableContainer">
		<div class="scrollingArea">
			<table class="cruises scrollable ">
				<thead>
					<tr>
						<th><div class="checkbox"></div></th>
						<th><div style="width: 90px;">SIDE</div></th>
						<th><div style="width: 110px;">SYMBOL</div></th>
						<th><div style="width: 120px;">ORDER TYPE</div></th>
						<th><div style="width: 115px;">QUALIFIER</div></th>
						<th><div style="width: 130px;">TOTAL QUANTITY</div></th>
						<th><div style="width: 130px;">OPEN QUANTITY</div></th>
						<th><div style="width: 130px;">LIMIT PRICE</div></th>
						<th><div style="width: 130px;">STOP PRICE</div></th>
						<th><div style="width: 105px;">STATUS</div></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="proposedList">
						<tr>
							<td><div class="checkbox">
									<input type="checkbox" name="proposedBlockIdList"
										value='<s:property value="blockId"/>'>
								</div></td>
							<td><div style="width: 90px;">
									<s:property value="side" />
								</div></td>
							<td><div style="width: 110px;">
									<s:property value="symbol" />
								</div></td>
							<td><div style="width: 120px;">
									<s:property value="blockOrderType" />
								</div></td>
							<td><div style="width: 115px;">
									<s:property value="qualifier" />
								</div></td>
							<td><div style="width: 130px;">
									<s:property value="totalQuantity" />
								</div></td>
							<td><div style="width: 130px;">
									<s:property value="openQuantity" />
								</div></td>
							<td><div style="width: 130px;">
									<s:property value="limitPrice" />
								</div></td>
							<td><div style="width: 130px;">
									<s:property value="stopPrice" />
								</div></td>
							<td><div style="width: 105px;">Proposed</div></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<center>
		<s:submit cssClass="button" id="button" name="buttonName"
			value="Create Block Order" theme="simple"
			style="width: 130px; margin-bottom: 30px;"></s:submit>
	</center>

</form>


