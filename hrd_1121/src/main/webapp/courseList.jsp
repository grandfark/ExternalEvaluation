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
<%
	Integer count = (Integer)request.getAttribute("COUNT");
	ArrayList<Course> cList = 
			(ArrayList)request.getAttribute("LIST");
%>
<div align="left">총 <%= count%>개의 교과목이 있습니다.</div>
<table border="1">
	<tr><th>과목코드</th><th>과목명</th><th>학 점</th>
		<th>담당강사</th><th>요 일</th><th>시작시간</th>
		<th>종료시간</th><th>관 리</th></tr>
<%
	for(Course c : cList ){
%>
<tr><td><%= c.getId() %></td><td><%= c.getName()%></td>
	<td><%= c.getCredit() %></td>
	<td><%= c.getLecturer() %></td><td><%= c.getWeek() %></td>
	<td><%= c.getStart_hour() %></td>
	<td><%= c.getEnd_end() %></td>
	<td><a href="updateForm.do?ID=<%= c.getId() %>">수정</a>/
		<a href="deleteCourse.do?ID=<%= c.getId() %>">삭제</a></td></tr>
<%	} %>
</table>
<div align="right"><input type="button" value="등록" 
		onClick="goEntry()"/></div>
</section>
<footer>
<h3 align="center">Copyright 2022 정보처리산업기사</h3>
</footer>
<script type="text/javascript">
function goEntry(){
	location.href="lectureEntry.do";
}
</script>
</body>
</html>







