<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.store.model.*"%>

<%
	StoreVO storeVO = (StoreVO) request.getAttribute("storeVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>門市資料修改</title>

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
	width: 450px;
	background-color: gold;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>
</head>
<body bgcolor='gold'>

<table id="table-1">
	<tr><td>
		<h3>門市資料修改</h3>
		<h4><a href="select_page.jsp">回首頁</a></h4>
</table>

<h3>資料修改:</h3>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="store.do" name="form1">
<table>
	<tr>
		<td>門市編號:</td>
		<td><%=storeVO.getStoreId() %></td>
	</tr>
	<tr>
		<td>門市名稱:</td>
		<td><input type="TEXT" name="storeName"	value="<%=storeVO.getStoreName()%>"	size="45" /></td>
	</tr>
	<tr>
<!-- 		=======================需修改====================== -->
		<td>縣市代碼:</td>
    <td>
        <select size="1" name="cntCode">
            <option value="10" ${storeVO.cntCode == 10 ? 'selected' : ''}>台北市</option>
            <option value="20" ${storeVO.cntCode == 20 ? 'selected' : ''}>新北市</option>
            <option value="30" ${storeVO.cntCode == 30 ? 'selected' : ''}>新竹市</option>
            <option value="40" ${storeVO.cntCode == 40 ? 'selected' : ''}>台中市</option>
            <option value="50" ${storeVO.cntCode == 50 ? 'selected' : ''}>高雄市</option>
        </select>
    </td>
	</tr>
	<tr>
		<td>區域代碼:</td>
			<td>
        <select size="1" name="distCode">
            <option value="1" ${storeVO.distCode == 1 ? 'selected' : ''}>中山區</option>
            <option value="2" ${storeVO.distCode == 2 ? 'selected' : ''}>新店區</option>
            <option value="3" ${storeVO.distCode == 3 ? 'selected' : ''}>東區</option>
            <option value="4" ${storeVO.distCode == 4 ? 'selected' : ''}>西屯區</option>
            <option value="5" ${storeVO.distCode == 5 ? 'selected' : ''}>左營區</option>
        </select>
    </td>
	</tr>
	<tr>
		<td>地址:</td>
		<td><input type="TEXT" name="storeAddress" value="<%=storeVO.getStoreAddress()%>" size="45" /></td>
	</tr>
	<tr>
		<td>經度:</td>
		<td><input type="TEXT" name="longitude" value="<%=storeVO.getLongitude()%>" size="45" /></td>
	</tr>
	<tr>
		<td>緯度:</td>
		<td><input type="TEXT" name="latitude" value="<%=storeVO.getLatitude()%>" size="45" /></td>
	</tr>
	<tr>
		<td>門市電話:</td>
		<td><input type="TEXT" name="storePhone" value="<%=storeVO.getStorePhone()%>" size="45" /></td>
	</tr>
	<tr>
		<td>營業時間:</td>
		<td><input type="TEXT" name="openingHours" value="<%=storeVO.getOpeningHours()%>" size="45" /></td>
	</tr>
	<tr>
		<td>電子信箱:</td>
		<td><input type="TEXT" name="storeMail" value="<%=storeVO.getStoreMail()%>" size="45" /></td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="storeId" value="<%=storeVO.getStoreId()%>">
<input type="submit" value="送出修改">

</FORM>

</body>
</html>