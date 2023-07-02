<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*, java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<header>
	<h2 align="center">상품 정보 등록</h2>
</header>
<section>
<div align="center">
<%
	ArrayList<String> ids =
		(ArrayList)request.getAttribute("IDs");
	ArrayList<Integer> nos = 
		(ArrayList)request.getAttribute("NOs");
%>
<form action="registerOrder.do" method="post">
<table border="1">
<tr><th>상품번호</th><td><select name="ID">
<%
	for(String id : ids){
%>
	<option><%= id %></option>
<%	} %>
	</select></td></tr>
<tr><th>고객번호</th><td><select name="NO">
<%
	for(Integer no : nos){
%>
	<option><%= no %></option>
<%	} %>
	</select></td></tr>
<tr><th>주문일</th><td><input type="text" name="DATE"/></td></tr>
<tr><td colspan="2"><input type="submit" value="주문등록"/>
	</td></tr>
</table>
</form>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>