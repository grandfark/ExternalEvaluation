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
<h3 align="center">예매 정보 등록</h3>
<form action="bookingEntry.do" method="post">
<%
	ArrayList<Movie> mList=
		(ArrayList)request.getAttribute("mList");
	ArrayList<Watcher> wList=
		(ArrayList)request.getAttribute("wList");
%>
<table border="1">
	<tr><th>고객번호</th><td><select name="NO">
<%	for(Watcher w : wList ) { %>
	<option><%= w.getNo() %></option>
<%	} %>	
	</select></td></tr>
	<tr><th>영화번호</th><td><select name="ID">
<%	for(Movie m : mList) { %>
	<option><%= m.getId() %></option>
<%	} %>	
	</select></td></tr>
	<tr><th>예매 수</th><td><input type="text" name="NUM"/>
		</td></tr>
	<tr><th>예매 일</th><td><input type="date" name="DATE"/>
		</td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="예매 등록"/></td></tr>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>






