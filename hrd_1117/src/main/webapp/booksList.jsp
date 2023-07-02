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
<h2>도서 정보 관리 ver1.0</h2>
</header>
<section>
<%	ArrayList<BookInfo> bookInfo = 
		(ArrayList)request.getAttribute("bookList"); 
%>
<table border="1">
	<tr><th>도서번호</th><th>도서명</th><th>저자명</th>
		<th>출판사명</th><th>가 격</th><th>출판일</th>
		<th>변경/삭제</th></tr>
<%
	for(BookInfo info : bookInfo){
%>
	<tr><td><%= info.getId() %></td>
		<td><%= info.getName() %></td>
		<td><%= info.getW_name() %></td>
		<td><%= info.getPublisher() %></td>
		<td><%= info.getPrice() %></td>
		<td><%= info.getP_date() %></td>
		<td><a href="updateBook.do?ID=<%= info.getId() %>&NAME=<%= info.getW_name() %>">변경</a>/
			<a href="deleteBook.do?ID=<%= info.getId() %>">삭제</a></td></tr>
<%	} %>
</table><br/>
	<input type="button" value="도서 등록" 
				onclick="register()"/>
</section>
<footer>
<h3>Copyright 2022 코세아 인재 개발원</h3>
</footer>
</div>
<script type="text/javascript">
function register(){
	location.href="bookEntryform.do"
}
</script>
</body>
</html>





