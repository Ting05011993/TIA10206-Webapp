<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tia102g1.staff.entity.Staff" %>
<%@ page import="com.tia102g1.staff.service.StaffServiceImpl" %>
 <%
	Staff staff = (Staff) request.getAttribute("staff");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/tia102g1/staff/staffCSS/mainPage.css">
<title>新增員工</title>
</head>
<body>
    <h1>員工基本資料</h1>
    <c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下問題:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
    <form action="${pageContext.request.contextPath}/tia102g1/staff/staff.do" method="post">
        <table style="width:50%; text-align:center;">
  

            <tr>
                <td>員工姓名:</td>
                <td><input type="text" name="name" ></td>
            </tr>
            <tr>
                <td>員工電話:</td>
                <td><input type="text" name="phone" ></td>
            </tr>
            <tr>    
                <td>員工信箱:</td>
                <td><input type="email" name="email" ></td>
            </tr>
            <tr>    
                <td>到職日期:</td>
                <td><input type="date" name="employDt" ></td>
            </tr>    
            <tr>    
                <td>創建者:</td>
                <td><input type="text" name="createdBy" ></td>
            </tr>

        </table>
        <br>
        
        <input type="hidden" name="action" value="addStaff">
        <input type="submit" value="送出新增">
        <a href="${pageContext.request.contextPath}/tia102g1/staff/staffMainPage/mainPage.jsp">回首頁</a>
    </form>
</body>
</html>
