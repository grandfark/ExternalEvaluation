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
<h2 align="center">���� ��û ����� ����Ʈ</h2>
</header>
<section>
<h2 align="center">������ �߰�</h2>
<%
	ArrayList<Lecturer> list = 
		(ArrayList)request.getAttribute("LIST");
%>
<form action="register.do" method="post">
<table border="1">
<tr><th>�������ڵ�</th><td><input type="text" name="CODE"/></td></tr>
<tr><th>�����</th><td><input type="text" name="NAME"/></td></tr>
<tr><th>��簭��</th><td><select name="LEC">
<%
	for(Lecturer l : list ){
%>
<option value="<%= l.getIdx() %>"><%=l.getName() %></option>
<%	} %>
	</select></td></tr>
<tr><th>����</th><td><input type="text" name="CREDIT"/></td></tr>
<tr><th>����</th><td>��<input type="radio" name="WEEK" value="1"/>
ȭ<input type="radio" name="WEEK" value="2"/>
��<input type="radio" name="WEEK" value="3"/>
��<input type="radio" name="WEEK" value="4"/>
��<input type="radio" name="WEEK" value="5"/>
��<input type="radio" name="WEEK" value="6"/></td></tr>
<tr><th>����</th><td><input type="text" name="START"/></td></tr>
<tr><th>����</th><td><input type="text" name="END"/></td></tr>
<tr><td colspan="2">
	<input type="button" value="���" onClick="goHome()"/>
	<input type="submit" value="�Ϸ�"/></td></tr>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022 ����ó��������</h3>
</footer>
</body>
</html>






