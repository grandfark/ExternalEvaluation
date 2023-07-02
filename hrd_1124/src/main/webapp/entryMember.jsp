<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<h3 align="center">고객 정보 등록</h3>
<form action="entryMember.do" method="post">
<table border="1">
<tr><th>고객번호</th><td><input type="text" name="ID"/></td></tr>
<tr><th>고객이름</th><td><input type="text" name="NAME"/></td></tr>
<tr><th>고객주소</th><td><input type="text" name="ADDR"/></td></tr>
<tr><th>연락처</th><td><input type="text" name="TEL"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit"
		value="고객등록"/></td></tr>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>