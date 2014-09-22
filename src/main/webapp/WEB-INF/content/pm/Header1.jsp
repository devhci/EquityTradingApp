<%@taglib uri="/struts-tags" prefix="s"%>

<table  style="height: 100%; width: 100%;">
	<tr>
		<td width="15%"><img src="CSS/images/pmlogo1.png"
			style="position: relative;"></td>
		<td width="58%">
			<h5
				style="text-align: center; margin-left: 15%; text-shadow: 4px 4px 5px grey; color: #0099CC;">
				<b><font size="10">Portfolio Management System</font></b>
			</h5> <s:property value="%{#session.username}" />
		</td>

		<td width="27%"><font size="3" color="#339EE" style="margin-left: 50px;"> <b>Welcome-<s:property
						value="#session.sessionUsername" /> &nbsp;|&nbsp;<s:a
						action="Logout" style="color:#3399EE;">Logout</s:a></b></font></td>
	</tr>
</table>
