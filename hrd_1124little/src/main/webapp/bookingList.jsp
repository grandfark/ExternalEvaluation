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
<h3 align="center">영화 예매 정보</h3>
<%
	ArrayList<Booking> list=
		(ArrayList)request.getAttribute("LIST");
%>
<div align="center">
<table border="1">
	<tr><th>예매자</th><th>연락처</th><th>영화제목</th>
		<th>시작시간</th><th>종료시간</th><th>예약 매수</th>
		<th>예매일</th><th>비 고</th></tr>
<%
	for(Booking b : list){
%>
<form action="bookingDelete.do">
<input type="hidden" name="ID" value="<%= b.getId() %>"/>
<input type="hidden" name="NO" value="<%= b.getNo() %>"/>
<tr><td><%= b.getName() %></td><td><%= b.getPhone() %></td>
	<td><%= b.getTitle() %></td>
	<td><%= b.getStart_hour() %></td>
	<td><%= b.getEnd_hour() %></td>
	<td><%= b.getTickets() %></td>
	<td><%= b.getR_date() %></td>
	<td><input type="submit" value="삭제"/></td></tr>
</form>
<%	} %>
</table>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>





