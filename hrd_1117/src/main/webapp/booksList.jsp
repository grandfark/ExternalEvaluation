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
<%	ArrayList<BookInfo> bookInfo = 
		(ArrayList)request.getAttribute("bookList"); 
%>
<table border="1">
	<tr><th>������ȣ</th><th>������</th><th>���ڸ�</th>
		<th>���ǻ��</th><th>�� ��</th><th>������</th>
		<th>����/����</th></tr>
<%
	for(BookInfo info : bookInfo){
%>
	<tr><td><%= info.getId() %></td>
		<td><%= info.getName() %></td>
		<td><%= info.getW_name() %></td>
		<td><%= info.getPublisher() %></td>
		<td><%= info.getPrice() %></td>
		<td><%= info.getP_date() %></td>
		<td><a href="updateBook.do?ID=<%= info.getId() %>&NAME=<%= info.getW_name() %>">����</a>/
			<a href="deleteBook.do?ID=<%= info.getId() %>">����</a></td></tr>
<%	} %>
</table><br/>
	<input type="button" value="���� ���" 
				onclick="register()"/>
</section>
<footer>
<h3>Copyright 2022 �ڼ��� ���� ���߿�</h3>
</footer>
</div>
<script type="text/javascript">
function register(){
	location.href="bookEntryform.do"
}
</script>
</body>
</html>





