
<%@ taglib uri="/struts-tags" prefix="s"%>

<script>
	function submit_edit() {
		document.forms["edit_form"].submit();
		return true;
	}
</script>
<div style="position:relative;top:100px;left:100px;">
<table id="main">
	<tr class="navbar">
		<td><s:a action="view-position">Home</s:a></td>
	</tr>
	<tr class="navbar">
		<td><s:a action="view-order-blotter">Order Blotter</s:a></td>
	</tr>
	
	
</table>

</div>