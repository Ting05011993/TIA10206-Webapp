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
<title>������ƭק�</title>

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
		<h3>������ƭק�</h3>
		<h4><a href="select_page.jsp">�^����</a></h4>
</table>

<h3>��ƭק�:</h3>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="store.do" name="form1">
<table>
	<tr>
		<td>�����s��:</td>
		<td><%=storeVO.getStoreId() %></td>
	</tr>
	<tr>
		<td>�����W��:</td>
		<td><input type="TEXT" name="storeName"	value="<%=storeVO.getStoreName()%>"	size="45" /></td>
	</tr>
	<tr>
<!-- 		=======================�ݭק�====================== -->
		<td>�����N�X:</td>
    <td>
        <select size="1" name="cntCode">
            <option value="10" ${storeVO.cntCode == 10 ? 'selected' : ''}>�x�_��</option>
            <option value="20" ${storeVO.cntCode == 20 ? 'selected' : ''}>�s�_��</option>
            <option value="30" ${storeVO.cntCode == 30 ? 'selected' : ''}>�s�˥�</option>
            <option value="40" ${storeVO.cntCode == 40 ? 'selected' : ''}>�x����</option>
            <option value="50" ${storeVO.cntCode == 50 ? 'selected' : ''}>������</option>
        </select>
    </td>
	</tr>
	<tr>
		<td>�ϰ�N�X:</td>
			<td>
        <select size="1" name="distCode">
            <option value="1" ${storeVO.distCode == 1 ? 'selected' : ''}>���s��</option>
            <option value="2" ${storeVO.distCode == 2 ? 'selected' : ''}>�s����</option>
            <option value="3" ${storeVO.distCode == 3 ? 'selected' : ''}>�F��</option>
            <option value="4" ${storeVO.distCode == 4 ? 'selected' : ''}>��ٰ�</option>
            <option value="5" ${storeVO.distCode == 5 ? 'selected' : ''}>�����</option>
        </select>
    </td>
	</tr>
	<tr>
		<td>�a�}:</td>
		<td><input type="TEXT" name="storeAddress" value="<%=storeVO.getStoreAddress()%>" size="45" /></td>
	</tr>
	<tr>
		<td>�g��:</td>
		<td><input type="TEXT" name="longitude" value="<%=storeVO.getLongitude()%>" size="45" /></td>
	</tr>
	<tr>
		<td>�n��:</td>
		<td><input type="TEXT" name="latitude" value="<%=storeVO.getLatitude()%>" size="45" /></td>
	</tr>
	<tr>
		<td>�����q��:</td>
		<td><input type="TEXT" name="storePhone" value="<%=storeVO.getStorePhone()%>" size="45" /></td>
	</tr>
	<tr>
		<td>��~�ɶ�:</td>
		<td><input type="TEXT" name="openingHours" value="<%=storeVO.getOpeningHours()%>" size="45" /></td>
	</tr>
	<tr>
		<td>�q�l�H�c:</td>
		<td><input type="TEXT" name="storeMail" value="<%=storeVO.getStoreMail()%>" size="45" /></td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="storeId" value="<%=storeVO.getStoreId()%>">
<input type="submit" value="�e�X�ק�">

</FORM>

</body>
</html>