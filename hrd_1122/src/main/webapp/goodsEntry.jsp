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
	<h2 align="center">상품 정보 등록</h2>
</header>
<section>
<%
	ArrayList<String> nations =
		(ArrayList)request.getAttribute("NATIONS");
%>
<div align="center">
<form action="goodsEntry.do" method="post">
<table border="1">
<tr><th>상품번호</th><td><input type="text" name="ID"/>
	</td></tr>
<tr><th>상품이름</th><td><input type="text" name="NAME"/>
	</td></tr>
<tr><th>원산지</th><td><select name="MADE">
<%
	for(String name : nations){
%>
	<option><%= name %></option>
<%	} %>
</select></td></tr>
<tr><th>상품가격</th><td><input type="text" name="PRICE"/>
	</td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="상품 등록"/></td></tr>
</table>
</form>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>



