<%@taglib uri="/struts-tags" prefix="s"%>
<div style="margin-top:-200px;">
<center>
	<h1 style="color:white;" >Role Select</h1>
	<s:form>
		<s:submit value="Portfolio Manager" action="view-position" cssClass="button" style="width:120px;"/>
		<s:submit value="Execution Trader" action="orders" cssClass="button" style="width:120px;"/>
	</s:form>
</center>
</div>