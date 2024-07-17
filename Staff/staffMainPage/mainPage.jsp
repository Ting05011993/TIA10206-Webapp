<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tia102g1.staff.entity.Staff" %>
<%@ page import="com.tia102g1.staff.service.StaffServiceImpl" %>
<%@ page import="java.util.*"%>

<%
	com.tia102g1.staff.service.StaffServiceImpl svc = new com.tia102g1.staff.service.StaffServiceImpl();
	String pageStr = request.getParameter("page");
	int currentPage = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
	List<Staff> staffList = svc.getAllStaff(currentPage);
	pageContext.setAttribute("staffList", staffList);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/tia102g1/staff/staffCSS/mainPage.css">
<title>員工資料系統</title>
</head>
<body>
	<h1>Desserter 員工一覽</h1>
	<h2>員工資料系統</h2>
	<a href="${pageContext.request.contextPath}/tia102g1/staff/staff.do?action=getAll">查詢所有員工</a>
	<br>
	<a href="${pageContext.request.contextPath}/tia102g1/staff/staffPages/addStaff.jsp">新增員工</a>
	<form
		action="${pageContext.request.contextPath}/tia102g1/staff/staff.do"
		method="post">

		<p>
			<label>員工編號:</label> <select size="1" name="staffId">
				<c:forEach var="staff" items="${staffList}">
					<option value="${staff.staffId}">${staff.staffId}</option>
				</c:forEach>
			</select>
		<input type="submit" value="送出">
		<input type="hidden" name="action" value="getById">
		</p>
		</form>
		<hr>
		<form
		action="${pageContext.request.contextPath}/tia102g1/staff/staff.do"
		method="post">
		<p>
			<label>到職日期區間:</label> <input type="date" name="startemploydate">
			~ <input type="date" name="endemploydate"><br>
		<p>
			<label>是否還在職:</label> <select name="status">
				<option value="1">在職</option>
				<option value="0">已離職</option>
			</select>
		<p>
			<input type="submit" value="送出">
		</p>
			<input type="hidden" name="action" value="compositeQuery">
	</form>
</body>
</html>