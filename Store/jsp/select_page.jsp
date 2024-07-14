<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Desserter 門市資訊</title>

<style>
table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
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
</head>
<body bgcolor='gold'>
	<table id="table-1">
		<tr>
			<td><h3>Desserter 店家資訊</h3></td>
		</tr>
	</table>

	<h3>門市查詢</h3>
	<hr>

	<%-- 錯誤列表 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul>
		<li>
			<FORM METHOD="post" ACTION="store.do">
				<b>輸入門市名稱:</b> 
				<input type="text" name="storeName"> 
				<input type="hidden" name="action" value="getName_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<jsp:useBean id="storeSvc" scope="page" class="com.store.model.StoreService"/>

		<li>
			<FORM METHOD="post" ACTION="store.do">
				<b>選擇門市名稱:</b>
				<select size="1" name="storeName">
					<c:forEach var ="storeVO" items="${storeSvc.all}">
						<option value="${storeVO.storeName}">${storeVO.storeName}
					</c:forEach>
				</select>
				<input type="hidden" name="action" value="getName_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
		
		<li>
			<FORM METHOD="post" ACTION="store.do">
				<b>選擇門市地區:</b>
				 <select size="1" name="storeId">
		            <option value="1" ${storeVO.cntCode == 10 ? 'selected' : ''}>台北市</option>
		            <option value="2" ${storeVO.cntCode == 20 ? 'selected' : ''}>新北市</option>
		            <option value="3" ${storeVO.cntCode == 30 ? 'selected' : ''}>新竹市</option>
		            <option value="4" ${storeVO.cntCode == 40 ? 'selected' : ''}>台中市</option>
		            <option value="5" ${storeVO.cntCode == 50 ? 'selected' : ''}>高雄市</option>
		            <option value="6" ${storeVO.cntCode == 60 ? 'selected' : ''}>台南市</option>
		        </select>
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>
	<br><hr>
	
	<h3>門市地圖</h3>
	<hr>
	
	<h3>門市列表</h3>
	<ul>
		<li><a href='listAllStore.jsp'>門市總覽</a></li>
	</ul>
	<hr>
	<ul>
		<li><a href='addStore.jsp'>新增</a>門市資訊</li>
	</ul>

</body>
</html>