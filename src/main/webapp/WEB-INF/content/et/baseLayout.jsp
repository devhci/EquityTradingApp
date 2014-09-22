<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" /></title>
<script src="JS/dragtable.js"></script>
<script src="JS/scripts.js"></script>
<style type="text/css">
.table1 {
	position: fixed;
}
</style>
<link rel="stylesheet" type="text/css" href="css/login-page.css" />
<link rel="stylesheet" type="text/css" href="CSS/login-pageboro.css" />
<link rel="stylesheet" type="text/css" href="CSS/navigation-bar.css" />
<style type="text/css">
h1 {
	font-size: large;
	color: white;
}

.table {
	font-size: small;
	color: white;
	position: absolute;
}
</style>
<style type="text/css">
h1 {
	font-size: large;
	color: white;
}

.drop-shadow {
	text-shadow: 4px 4px 5px grey;
	color: #0099CC;
}

table {
	font-size: small;
	color: black;
}

* {
	padding: 0;
	margin: 0;
}

table.cruises {
	font-family: verdana, arial, helvetica, sans-serif;
	font-size: 10px;
	cellspacing: 0px;
	border-collapse: collapse;
	width: 100px;
}

table.cruises th {
	background-color: #002110;
	color: #ffffff;
	font-size: 10px;
	background: -o-linear-gradient(bottom, #002110 5%, #558755 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #002110
		), color-stop(1, #558755) );
	background: -moz-linear-gradient(center top, #002110 5%, #558755 100%);
	background: -o-linear-gradient(top, #002110, 558755);
}

table.cruises th {
	height: 35px;
	padding: 3px;
}

table.cruises td {
	height: 25px;
	font-size: 12px;
	text-align: center;
	padding: 3px;
}

table.cruises tr:nth-child(odd) {
	background-color: #9cad9e;
}

table.cruises tr:nth-child(even) {
	background-color: #ffffff;
}

div.scrollableContainer {
	position: relative;
	width: 1152px;
	padding-top: 2.8em;
	margin: 20px;
	border: none;
	background: none;
	margin-left: 1%;
}

div.scrollingArea {
	height: 150px;
	overflow: auto;
}

table.scrollable thead tr {
	left: 0;
	top: 0;
	position: absolute;
}

table.cruises .checkbox {
	width: 15px;
	text-align: center;
}

table.cruises .order-id {
	width: 65px;
	text-align: center;
}

table.cruises .side {
	width: 60px;
	text-align: center;
}

table.cruises .symbol {
	width: 80px;
	text-align: center;
}

table.cruises .total-quantity {
	width: 80px;
	text-align: center;
}

table.cruises .limit-price {
	width: 100px;
	text-align: center;
}

table.cruises .stop-price {
	width: 95px;
	text-align: center;
}

table.cruises .allocated-quantity {
	width: 100px;
	text-align: center;
}

table.cruises .allocation-id {
	width: 100px;
	text-align: center;
}

table.cruises .execution-id {
	width: 100px;
	text-align: center;
}

table.cruises .transaction-price {
	width: 100px;
	text-align: center;
}

table.cruises .transaction-time {
	width: 100px;
	text-align: center;
}

table.cruises .transaction-fee {
	width: 100px;
	text-align: center;
}

table.cruises .executed-quantity {
	width: 100px;
	text-align: center;
}

table.cruises .open-quantity {
	width: 100px;
	text-align: center;
}

table.cruises .status {
	width: 80px;
	text-align: center;
}

table.cruises .trader {
	width: 80px;
	text-align: center;
}

table.cruises .manager {
	width: 90px;
	text-align: center;
}

table.cruises .account-type {
	width: 100px;
	text-align: center;
}

table.cruises .portfolio {
	width: 100px;
	text-align: center;
}

table.cruises .block-order-id {
	width: 110px;
	text-align: center;
}
</style>
</head>
<body id="body">

	<table class="table1" height="100%" width="100%" cellpadding="2"
		cellspacing="2" align="center" style="position: absolute;">
		<tr>
			<td height="15%" colspan="2"><tiles:insertAttribute
					name="header" /></td>
		</tr>
		<tr>
			<td width="10%" height="80%"><tiles:insertAttribute name="menu" /></td>
			<td width="90%" height="80%">
				<table style="position: relative;" height="100%" width="100%"
					align="center" >
					<tr>
						<td height="50%"><tiles:insertAttribute name="body1" /></td>
					</tr>
					<tr>
						<td class="td1" height="50%"><tiles:insertAttribute
								name="body2" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="5%" colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>
