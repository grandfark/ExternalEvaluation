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
<h2 align="center">영화 예매 관리</h2>
</header>
<nav><%@ include file="menu_file.jsp" %></nav>
<section>
<h3 align="center">회원 상세 정보</h3>
<%
	Watcher w = (Watcher)request.getAttribute("MEM");
%>
<form action="updateWatcher.do" method="post">
<table border="1">
<tr><th>회원번호</th><td><input type="text" name="NO"
	value="<%= w.getNo() %>" readonly="readonly"/></td></tr>
<tr><th>회원이름</th><td><input type="text" name="NAME"
	value="<%= w.getName() %>"/></td></tr>
<tr><th>회원주소</th><td><input type="text" name="ADDR"
	value="<%= w.getAddress() %>"/></td></tr>
<tr><th>연 락 처</th><td><input type="text" name="PHONE"
	value="<%= w.getPhone() %>"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit"
	value="정보 수정"/></td></tr>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>





