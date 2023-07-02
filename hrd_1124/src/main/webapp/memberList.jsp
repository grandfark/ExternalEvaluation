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
<h2 align="center">영화 예매 관리</h2>
</header>
<nav><%@ include file="menu_file.jsp" %></nav>
<section>
<h3 align="center">회원 목록</h3>
<%
	ArrayList<Watcher> list = 
		(ArrayList)request.getAttribute("LIST");
%>
<table border="1">
	<tr><th>고객번호</th><th>고객이름</th><th>고객주소</th>
		<th>연 락 처</th></tr>
<%
	for(Watcher w : list){
%>
	<tr><td><a href="updateForm.do?ID=<%= w.getNo() %>"><%= w.getNo() %></a></td>
		<td><%= w.getName() %></td>
		<td><%= w.getAddress() %></td>
		<td><%= w.getPhone() %></td></tr>
<%	} %>
</table>
</section>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>






