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
	<h2 align="center">��ǰ ���� ���</h2>
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
<tr><th>��ǰ��ȣ</th><td><select name="ID">
<%
	for(String id : ids){
%>
	<option><%= id %></option>
<%	} %>
	</select></td></tr>
<tr><th>����ȣ</th><td><select name="NO">
<%
	for(Integer no : nos){
%>
	<option><%= no %></option>
<%	} %>
	</select></td></tr>
<tr><th>�ֹ���</th><td><input type="text" name="DATE"/></td></tr>
<tr><td colspan="2"><input type="submit" value="�ֹ����"/>
	</td></tr>
</table>
</form>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>