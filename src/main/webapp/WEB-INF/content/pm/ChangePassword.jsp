<%@taglib uri="/struts-tags" prefix="s"%>
<center>
<div style="">
<fieldset id="field3">
<script type="text/javascript">
	function alertConfirm() {
	    var newPass= document.getElementById('new').value;
		var confirmPass= document.getElementById('confirm').value;
		
		if (newPass==confirmPass && newPass.length>=6)
			{
				alert("The Password has been changed");
				
			}
		
	}
</script>

	<h1 >Change Password</h1>
	
		<s:actionerror />
		<s:form  action="changepassword" theme="simple">
		<table>
			<tr>
				<td>New Password:</td>
				<td><s:password name="newPassword" id="new" value="%{username}" /></td>
			</tr>
			<tr><td><br/></td></tr>
			<tr>
				<td>Confirm Password:</td>
				<td><s:password name="confirmPassword" id="confirm" /></td>
			</tr>
			<tr><td><br/></td></tr>
			<tr>
				<td><s:submit value="OK" cssClass="button" style="position:relative;left:20px;" onclick="alertConfirm()"/> </td>
				<td>
				<s:submit value="Cancel" action="pass-through-login" cssClass="button" style="position:relative;left:10px;"/></td>
			</tr>
			</table>
		</s:form>
		</fieldset>
	</div>
	</center>