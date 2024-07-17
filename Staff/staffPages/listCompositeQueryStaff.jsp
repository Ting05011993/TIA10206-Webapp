<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/tia102g1/staff/staffCSS/mainPage.css">
<title>員工資料表-查詢</title>
</head>
<body>
	<h1>員工列表</h1>
	<br>
	<table style="width: 50%; text-align: center;">
		<tr>
			<th>員工編號</th>
			<th>員工姓名</th>
			<th>員工電話</th>
			<th>電子信箱</th>
			<th>到職日</th>
			<th>是否仍在職</th>
			<th>離職日</th>
			<th>修改</th>
		</tr>
		<c:forEach var="staff" items="${staffList}">
			<tr>
				<td>${staff.staffId}</td>
				<td>${staff.name}</td>
				<td>${staff.phone}</td>
				<td>${staff.email}</td>
				<td>${staff.employDt}</td>
				<td>${staff.status}</td>
				<td>${staff.leaveDt}</td>
				<td>
					<form action="${pageContext.request.contextPath}/tia102g1/staff/staff.do" method="post">
					<input type="submit" value="修改">
					<input type="hidden" name="staffId" value="${staff.staffId}">
					<input type="hidden" name="action" value="update">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/tia102g1/staff/staffMainPage/mainPage.jsp">回首頁</a>
</body>
</html>