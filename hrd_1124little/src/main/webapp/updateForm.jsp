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
<h3 align="center">ȸ�� �� ����</h3>
<%
	Watcher w = (Watcher)request.getAttribute("MEM");
%>
<form action="updateWatcher.do" method="post">
<table border="1">
<tr><th>ȸ����ȣ</th><td><input type="text" name="NO"
	value="<%= w.getNo() %>" readonly="readonly"/></td></tr>
<tr><th>ȸ���̸�</th><td><input type="text" name="NAME"
	value="<%= w.getName() %>"/></td></tr>
<tr><th>ȸ���ּ�</th><td><input type="text" name="ADDR"
	value="<%= w.getAddress() %>"/></td></tr>
<tr><th>�� �� ó</th><td><input type="text" name="PHONE"
	value="<%= w.getPhone() %>"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit"
	value="���� ����"/></td></tr>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>





