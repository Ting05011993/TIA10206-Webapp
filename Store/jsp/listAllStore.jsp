<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.store.model.*"%>

<%
	StoreService storeSvc = new StoreService();
	List<StoreVO> list = storeSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<html>
<head>
<meta charset="BIG5">
<title>�����`��</title>

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
	width: 800px;
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
	<tr><td>
		<h3>������T</h3>
		<h4><a href="select_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�����s��</th>
		<th>�����W��</th>
		<th>�a�}</th>
		<th>�q��</th>
		<th>��~�ɶ�</th>
		<th>�q�l�H�c</th>
		<th>�ק�</th>
			
	</tr>
	<c:forEach var="storeVO" items="${list}">
		
		<tr>
			<td>${storeVO.storeId}</td>
			<td>${storeVO.storeName}</td>
			<td>${storeVO.storeAddress}</td>
			<td>${storeVO.storePhone}</td>
			<td>${storeVO.openingHours}</td>
			<td>${storeVO.storeMail}</td>
			
			<td>
				<form METHOD="post" ACTION="<%=request.getContextPath()%>/store/store.do" style="margin-bottom: 0px;">
				<input type="submit" value="�ק�">
				<input type="hidden" name="storeId" value="${storeVO.storeId}">
				<input type="hidden" name="action" value="getOne_For_Update"></FORM>
			</td>
			
		</tr>
	</c:forEach>
</table>

</body>
</html>