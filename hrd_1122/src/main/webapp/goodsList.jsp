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
	<h2 align="center">��ǰ ���</h2>
</header>
<section>
<%
	ArrayList<Goods> list = 
		(ArrayList)request.getAttribute("LIST");
%>
<div align="center">
<table border="1">
	<tr><th>��ǰ��ȣ</th><th>��ǰ�̸�</th><th>�� ��</th>
		<th>������</th><th></th></tr>
<%	for(Goods g : list) { %>
	<tr><td><a href="goodsUpdateForm.do?ID=<%= g.getId() %>"><%= g.getId() %></a></td>
	<td><%= g.getName() %></td>
	<td><%= g.getPrice() %></td>
	<td><%= g.getMade() %></td>
	<td><a href="goodsDelete.do?ID=<%= g.getId() %>">�� ��</a></td></tr>
<%	} %>
</table>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>




