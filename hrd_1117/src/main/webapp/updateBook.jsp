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
<div align="center">
<header>
<h2>���� ���� ���� ver1.0</h2>
</header>
<section>
<%
	BookInfo info = (BookInfo)request.getAttribute("INFO");
%>
<form action="changeBook.do" method="post">
<table border="1">
<tr><th>������ȣ</th><td><input type="text" name="ID"
	value="<%=info.getId() %>" readonly="readonly"/></td></tr>
<tr><th>������</th><td><input type="text" name="NAME"
	value="<%=info.getName() %>"/></td></tr>
<tr><th>���ڸ�</th><td><select name="WNAME">
	<option selected="selected"><%=info.getW_name() %></option>
<%
	ArrayList<String> names=
		(ArrayList)request.getAttribute("NAMES");
	for(String name : names){
%>
		<option><%= name %></option>
<%	} %>
	</select>
	</td></tr>
<tr><th>���ǻ��</th><td><input type="text" name="PUB"
	value="<%=info.getPublisher() %>"/></td></tr>
<tr><th>�� ��</th><td><input type="text" name="PRICE"
	value="<%=info.getPrice() %>"/></td></tr>
<tr><th>������</th><td><input type="date" name="DATE"
	value="<%=info.getP_date() %>"/></td></tr>	
</table><br/>
	<input type="submit" value="���� ����"/>
</form>
</section>
<footer>
<h3>Copyright 2022 �ڼ��� ���� ���߿�</h3>
</footer>
</div>
</body>
</html>


