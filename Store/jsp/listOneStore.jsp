<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ page import="com.store.model.*"%>

<%
StoreVO storeVO = (StoreVO) request.getAttribute("storeVO");
%>

<html>
<head>
<meta charset="BIG5">
<title>門市資訊</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>
</head>
<body bgcolor='gold'>

	<table id="table-1">
		<tr>
			<td>
				<h3>門市資訊</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<th>門市編號</th>
			<th>門市名稱</th>
			<th>地址</th>
			<th>電話</th>
			<th>營業時間</th>
			<th>電子信箱</th>
		</tr>
		<tr>
			<td><%=storeVO.getStoreId()%></td>
			<td><%=storeVO.getStoreName()%></td>
			<td><%=storeVO.getStoreAddress()%></td>
			<td><%=storeVO.getStorePhone()%></td>
			<td><%=storeVO.getOpeningHours()%></td>
			<td><%=storeVO.getStoreMail()%></td>
		</tr>
	</table>

</body>
</html>