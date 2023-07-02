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
<%
	Integer count = (Integer)request.getAttribute("COUNT");
	ArrayList<Course> cList = 
			(ArrayList)request.getAttribute("LIST");
%>
<div align="left">�� <%= count%>���� �������� �ֽ��ϴ�.</div>
<table border="1">
	<tr><th>�����ڵ�</th><th>�����</th><th>�� ��</th>
		<th>��簭��</th><th>�� ��</th><th>���۽ð�</th>
		<th>����ð�</th><th>�� ��</th></tr>
<%
	for(Course c : cList ){
%>
<tr><td><%= c.getId() %></td><td><%= c.getName()%></td>
	<td><%= c.getCredit() %></td>
	<td><%= c.getLecturer() %></td><td><%= c.getWeek() %></td>
	<td><%= c.getStart_hour() %></td>
	<td><%= c.getEnd_end() %></td>
	<td><a href="updateForm.do?ID=<%= c.getId() %>">����</a>/
		<a href="deleteCourse.do?ID=<%= c.getId() %>">����</a></td></tr>
<%	} %>
</table>
<div align="right"><input type="button" value="���" 
		onClick="goEntry()"/></div>
</section>
<footer>
<h3 align="center">Copyright 2022 ����ó��������</h3>
</footer>
<script type="text/javascript">
function goEntry(){
	location.href="lectureEntry.do";
}
</script>
</body>
</html>







