<%@taglib uri="/struts-tags" prefix="s"%>


<div align="center" style="margin-top: -100px">
<table>
<tr>
<td><img src="CSS/images/login-icon.png" ></td>
<td><h4 style="color:white;" >Login<br/>Enter your credentials below</h4></td>
</tr></table>
	<div style="width:65%;">
			<fieldset id="field2">
			<div>
	<s:fielderror/>		
	<s:actionerror /> 	
	<table >
<%-- 	<s:actionerror/> --%>
		<s:form action="login" theme="simple" >
		<tr><td><br/></td></tr>
				<tr>
					<td>Username:</td>
					<td><s:textfield name="user.username" value="%{username}" /></td>
				</tr>
				<tr><td><br/></td><tr>
				
				<tr>
					<td>Password:</td>
					<td><s:password name="user.password" label="Password:" /></td>
				</tr>
				<tr><td><br/></td><tr>
				<tr><td></td>
					<td colspan="3" align="center"><s:submit cssClass="button"
							label="Login" /></td>
				</tr>

			</s:form>

			<tr><td></td>
				<td colspan="2" align="center"><br /> <s:a
						href="pass-through-forgot-password">Forgot Password</s:a></td>
			</tr>
		</table>
		</div>
		</fieldset>
	

</div>
</div>