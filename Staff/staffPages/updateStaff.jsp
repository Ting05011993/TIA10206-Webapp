<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tia102g1.staff.entity.Staff" %>
<%@ page import="com.tia102g1.staff.service.StaffServiceImpl" %>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/tia102g1/staff/staffCSS/mainPage.css">
<title>員工資料修改</title>
</head>
<body>
	<h1>員工資料修改</h1>
	    <form action="${pageContext.request.contextPath}/tia102g1/staff/staff.do" method="post">
	    	 <table style="width:50%; text-align:center;">
	    	 	<c:forEach var="staff" items="${staffList}">
	    	 	<tr>
	    	 		<td>員工編號:</td>
	    	 		<td>${staff.staffId}</td>
	    	 	</tr>
<!-- 	    	 	<tr> -->
<!-- 	    	 		<td>員工密碼:</td> -->
<%-- 	    	 		<td>${staff.password}</td> --%>
<!-- 	    	 	</tr> -->
	    	 	<tr>
	    	 		<td>員工姓名:</td>
	    	 		<td><input type="text" name="name" value="${staff.name}"></td>
	    	 	</tr>
	    	 	<tr>
	    	 		<td>員工電話:</td>
	    	 		<td><input type="text" name="phone" value="${staff.phone}"></td>
	    	 	</tr>
	    	 	<tr>
	    	 		<td>員工信箱:</td>
	    	 		<td><input type="text" name="email" value="${staff.email}"></td>
	    	 	</tr>
<!-- 	    	 	<tr> -->
<!-- 	    	 		<td>員工到職日:</td> -->
<%-- 	    	 		<td>${staff.employDt}</td> --%>
<!-- 	    	 	</tr> -->
	    	 	<tr>
	    	 		<td>員工離職日:</td>
	    	 		<td><input type="date" name="leaveDt" value="${staff.leaveDt}"></td>
	    	 	</tr>
	    	 	<tr>
	    	 		<td>在職狀態:</td>
	    	 		<td><input type="text" name="status" value="${staff.status}"></td>
	    	 	</tr>
<!-- 	    	 	<tr> -->
<!-- 	    	 		<td>創建者:</td> -->
<%-- 	    	 		<td>${staff.createdBy}</td> --%>
<!-- 	    	 	</tr> -->
<!-- 	    	 	<tr> -->
<!-- 	    	 		<td>創建日期:</td> -->
<%-- 	    	 		<td>${staff.dateCreated}</td> --%>
<!-- 	    	 	</tr> -->
	    	 	<tr>
	    	 		<td>最後更新者:</td>
	    	 		<td><input type="text" name="lastUpdatedBy" value="${staff.lastUpdatedBy}"></td>
	    	 	</tr>
<!-- 	    	 	<tr> -->
<!-- 	    	 		<td>最後更新日期:</td> -->
<%-- 	    	 		<td><input type="date" name="lastUpdated" value="${staff.lastUpdated}"></td> --%>
<!-- 	    	 	</tr> -->
	    	 	<input type="hidden" name="staffId" value="${staff.staffId}">
	    	 	</c:forEach>
	    	 </table>
	    	 <br>
	    	 	<input type="hidden" name="action" value="update">
        	 	<input type="submit" value="確認修改">
		</form>
		<br>
		<a href="${pageContext.request.contextPath}/tia102g1/staff/staffMainPage/mainPage.jsp">回首頁</a>
</body>
</html>