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
<h2 align="center">������ ����</h2>
<%
	Course c = (Course)request.getAttribute("CRS");
	ArrayList<Lecturer> list = 
		(ArrayList)request.getAttribute("LEC");
%>
<form action="update.do" method="post">
<table border="1">
<tr><th>�������ڵ�</th><td><input type="text" name="ID"
	value="<%= c.getId() %>" readonly="readonly"/></td></tr>
<tr><th>�����</th><td><input type="text" name="NAME"
	value="<%= c.getName() %>"/></td></tr>
<tr><th>��簭��</th><td><select name="CODE">
<%
	for(Lecturer l : list ){
		if(l.getName().equals(c.getLecturer())){
%>
	<option selected="selected" 
			value="<%= l.getIdx() %>"><%=l.getName() %></option>
<%		} else { %>
	<option value="<%= l.getIdx() %>"><%=l.getName() %></option>
<%		} %>	
<%	} %>
</select></td></tr>
<tr><th>�� ��</th><td><input type="text" name="CREDIT"
	value="<%= c.getCredit() %>"/></td></tr>
<tr><th>�� ��</th><td>
	<% if(c.getWeek().equals("1")){ %>
��<input type="radio" name="WEEK" checked="checked"
	value="1"/>
	<%	} else { %>
��<input type="radio" name="WEEK" value="1"/>
	<%  } if(c.getWeek().equals("2")) {%>
ȭ<input type="radio" name="WEEK" checked="checked"
	value="2"/>
	<% } else { %>
ȭ<input type="radio" name="WEEK" value="2"/>
	<% } if(c.getWeek().equals("3")) { %>
��<input type="radio" name="WEEK" checked="checked"
	value="3"/>
	<% } else { %>
��<input type="radio" name="WEEK" value="3"/>
	<% } if(c.getWeek().equals("4")) { %>
��<input type="radio" name="WEEK" checked="checked"
	value="4"/>
	<% } else {%>
��<input type="radio" name="WEEK" value="4"/>
	<% } if(c.getWeek().equals("5")) { %>
��<input type="radio" name="WEEK" checked="checked"
	value="5"/>
	<% } else {%>
��<input type="radio" name="WEEK" value="5"/>
	<%	} %></td></tr>
<tr><th>�� ��</th><td><input type="text" name="START"	
	value="<%= c.getStart_hour() %>"/></td></tr>
<tr><th>�� ��</th><td><input type="text" name="END"
	value="<%= c.getEnd_end() %>"/></td></tr>
<tr><td colspan="2">
	<input type="button" value="���" onClick=""/>
	<input type="reset" value="���"/>
	<input type="submit" value="Ȯ��"/>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022 ����ó��������</h3>
</footer>
</body>
</html>





