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
	<h2 align="center">상품 목록</h2>
</header>
<section>
<%
	ArrayList<Goods> list = 
		(ArrayList)request.getAttribute("LIST");
%>
<div align="center">
<table border="1">
	<tr><th>상품번호</th><th>상품이름</th><th>가 격</th>
		<th>원산지</th><th></th></tr>
<%	for(Goods g : list) { %>
	<tr><td><a href="goodsUpdateForm.do?ID=<%= g.getId() %>"><%= g.getId() %></a></td>
	<td><%= g.getName() %></td>
	<td><%= g.getPrice() %></td>
	<td><%= g.getMade() %></td>
	<td><a href="goodsDelete.do?ID=<%= g.getId() %>">삭 제</a></td></tr>
<%	} %>
</table>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>




