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
<h3 align="center">ȸ�� ���</h3>
<%
	ArrayList<Watcher> list = 
		(ArrayList)request.getAttribute("LIST");
%>
<table border="1">
	<tr><th>����ȣ</th><th>���̸�</th><th>���ּ�</th>
		<th>�� �� ó</th></tr>
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
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>






