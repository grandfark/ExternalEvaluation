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
<h2 align="center">수강 신청 도우미 사이트</h2>
</header>
<section>
<h2 align="center">교과목 추가</h2>
<%
	ArrayList<Lecturer> list = 
		(ArrayList)request.getAttribute("LIST");
%>
<form action="register.do" method="post">
<table border="1">
<tr><th>교과목코드</th><td><input type="text" name="CODE"/></td></tr>
<tr><th>과목명</th><td><input type="text" name="NAME"/></td></tr>
<tr><th>담당강사</th><td><select name="LEC">
<%
	for(Lecturer l : list ){
%>
<option value="<%= l.getIdx() %>"><%=l.getName() %></option>
<%	} %>
	</select></td></tr>
<tr><th>학점</th><td><input type="text" name="CREDIT"/></td></tr>
<tr><th>요일</th><td>월<input type="radio" name="WEEK" value="1"/>
화<input type="radio" name="WEEK" value="2"/>
수<input type="radio" name="WEEK" value="3"/>
목<input type="radio" name="WEEK" value="4"/>
금<input type="radio" name="WEEK" value="5"/>
토<input type="radio" name="WEEK" value="6"/></td></tr>
<tr><th>시작</th><td><input type="text" name="START"/></td></tr>
<tr><th>종료</th><td><input type="text" name="END"/></td></tr>
<tr><td colspan="2">
	<input type="button" value="목록" onClick="goHome()"/>
	<input type="submit" value="완료"/></td></tr>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022 정보처리산업기사</h3>
</footer>
</body>
</html>






