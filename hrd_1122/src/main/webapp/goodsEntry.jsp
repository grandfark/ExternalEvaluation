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
<%
	ArrayList<String> nations =
		(ArrayList)request.getAttribute("NATIONS");
%>
<div align="center">
<form action="goodsEntry.do" method="post">
<table border="1">
<tr><th>��ǰ��ȣ</th><td><input type="text" name="ID"/>
	</td></tr>
<tr><th>��ǰ�̸�</th><td><input type="text" name="NAME"/>
	</td></tr>
<tr><th>������</th><td><select name="MADE">
<%
	for(String name : nations){
%>
	<option><%= name %></option>
<%	} %>
</select></td></tr>
<tr><th>��ǰ����</th><td><input type="text" name="PRICE"/>
	</td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="��ǰ ���"/></td></tr>
</table>
</form>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>



