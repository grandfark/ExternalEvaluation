<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<header>
<h2>���� ���� ���� ver1.0</h2>
</header>
<section>
<%
	ArrayList<String> nameList=
		(ArrayList)request.getAttribute("nameList");
%>
<form action="bookEntry.do" method="post" 
		onsubmit="return check(this)">
<table border="1">
<tr><th>������ȣ</th><td><input type="text" name="ID"/></td></tr>
<tr><th>������</th><td><input type="text" name="NAME"/></td></tr>
<tr><th>���ڸ�</th><td><select name="WRITER">
<%	for(String name : nameList) { %>
	<option><%= name %></option>
<%	} %>
	</select></td></tr>
<tr><th>���ǻ��</th><td><input type="text" name="PUB"/></td></tr>
<tr><th>�� ��</th><td><input type="text" name="PRICE"/></td></tr>
<tr><th>������</th><td><input type="date" name="DATE"/></td></tr>
</table><br/><br/>
	<input type="submit" value="���� ���"/>
</form>
</section>
<footer>
<h3>Copyright 2022 �ڼ��� ���� ���߿�</h3>
</footer>
</div>
</body>
</html>

