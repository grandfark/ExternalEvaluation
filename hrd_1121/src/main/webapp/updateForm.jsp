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
<h2 align="center">교과목 수정</h2>
<%
	Course c = (Course)request.getAttribute("CRS");
	ArrayList<Lecturer> list = 
		(ArrayList)request.getAttribute("LEC");
%>
<form action="update.do" method="post">
<table border="1">
<tr><th>교과목코드</th><td><input type="text" name="ID"
	value="<%= c.getId() %>" readonly="readonly"/></td></tr>
<tr><th>과목명</th><td><input type="text" name="NAME"
	value="<%= c.getName() %>"/></td></tr>
<tr><th>담당강사</th><td><select name="CODE">
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
<tr><th>학 점</th><td><input type="text" name="CREDIT"
	value="<%= c.getCredit() %>"/></td></tr>
<tr><th>요 일</th><td>
	<% if(c.getWeek().equals("1")){ %>
월<input type="radio" name="WEEK" checked="checked"
	value="1"/>
	<%	} else { %>
월<input type="radio" name="WEEK" value="1"/>
	<%  } if(c.getWeek().equals("2")) {%>
화<input type="radio" name="WEEK" checked="checked"
	value="2"/>
	<% } else { %>
화<input type="radio" name="WEEK" value="2"/>
	<% } if(c.getWeek().equals("3")) { %>
수<input type="radio" name="WEEK" checked="checked"
	value="3"/>
	<% } else { %>
수<input type="radio" name="WEEK" value="3"/>
	<% } if(c.getWeek().equals("4")) { %>
목<input type="radio" name="WEEK" checked="checked"
	value="4"/>
	<% } else {%>
목<input type="radio" name="WEEK" value="4"/>
	<% } if(c.getWeek().equals("5")) { %>
금<input type="radio" name="WEEK" checked="checked"
	value="5"/>
	<% } else {%>
금<input type="radio" name="WEEK" value="5"/>
	<%	} %></td></tr>
<tr><th>시 작</th><td><input type="text" name="START"	
	value="<%= c.getStart_hour() %>"/></td></tr>
<tr><th>종 료</th><td><input type="text" name="END"
	value="<%= c.getEnd_end() %>"/></td></tr>
<tr><td colspan="2">
	<input type="button" value="목록" onClick=""/>
	<input type="reset" value="취소"/>
	<input type="submit" value="확인"/>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022 정보처리산업기사</h3>
</footer>
</body>
</html>





