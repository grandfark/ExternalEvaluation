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
<h2 align="center">��ȭ ���� ����</h2>
</header>
<nav><%@ include file="menu_file.jsp" %></nav>
<section>
<h3 align="center">��ȭ ���� ����</h3>
<%
	ArrayList<Booking> list=
		(ArrayList)request.getAttribute("LIST");
%>
<div align="center">
<table border="1">
	<tr><th>������</th><th>����ó</th><th>��ȭ����</th>
		<th>���۽ð�</th><th>����ð�</th><th>���� �ż�</th>
		<th>������</th><th>�� ��</th></tr>
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
	<td><input type="submit" value="����"/></td></tr>
</form>
<%	} %>
</table>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>





