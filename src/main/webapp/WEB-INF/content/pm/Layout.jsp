<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="CSS/login-pageboro.css" type="text/css">
<link rel="stylesheet" href="CSS/navigation-bar.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" /></title>
<style type="text/css">

/* body
{
	
	/*border:1px solid red;
		background-color:green;
} */
</style>
</head>
<body>
	

		<table style="height: 100%; width: 100%; position: fixed;" >
		<tr height="20%"><td colspan="2">

			<tiles:insertAttribute name="header" /></td></tr>

		
		<tr style="height: 70%;" id="menubodydiv">

			<td width="15%">
				<tiles:insertAttribute name="menu" />
			</td>
			<td width="85%" id="bodydiv" >
				<tiles:insertAttribute name="body" />
</td>
			</tr>
<tr height="10%"><td colspan="2"><tiles:insertAttribute name="footer"/></td></tr>
		</table>
	
</body>
</html>