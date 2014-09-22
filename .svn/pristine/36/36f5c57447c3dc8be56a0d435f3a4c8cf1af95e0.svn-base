<%@taglib uri="/struts-tags" prefix="s"%>



<center>
<div >
<fieldset id="field3">
<h1>Forgot Password</h1>

<s:form action="forgot-password" theme="simple">
<s:actionerror />
<s:fielderror/>
	<table>
		<tr>
			<td>Username:</td>
			<td><s:textfield name="username" value="%{username}" /></td>
		</tr>
		<tr><td><br/></td></tr>
		<tr>
			<td>Security Question:</td>
			<td>Where do you work?</td>
		</tr>
		<tr><td><br/></td></tr>
		<tr>
			<td>Security Answer:</td>
			<td><s:password name="securityAnswer" /></td>
		</tr>
		<tr><td><br/></td></tr>
		<tr>
			<td colspan="2" align="right"><s:submit value="OK" cssClass="button" /> <s:submit
					value="Cancel" action="pass-through-login" cssClass="button" /></td>
		</tr>
	</table>
</s:form>
</fieldset>
</div>
</center>

