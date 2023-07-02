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
	<h2 align="center">상품 정보 변경</h2>
</header>
<section>
<div align="center">
<%
	ArrayList<String> nations = 
		(ArrayList)request.getAttribute("NATIONS");
	Goods goods = (Goods)request.getAttribute("GOODS");
%>
<form action="goodsUpdate.do" method="post">
<table border="1">
<tr><th>상품번호</th><td><input type="text" name="ID"
	value="<%= goods.getId() %>" readonly="readonly"/>
	</td></tr>
<tr><th>상품이름</th><td><input type="text" name="NAME"
	value="<%= goods.getName() %>"/></td></tr>
<tr><th>원산지</th><td><select name="MADE">
<%	for(String name : nations) { 
		if(name.equals(goods.getMade())){
%>
	<option selected="selected"><%= name%></option>	
<%		} else { %>
	<option><%= name %></option>

<%		}
	}
%>
</select></td></tr>
<tr><th>상품가격</th><td><input type="text" name="PRICE"
	value="<%= goods.getPrice() %>"/></td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="상품 변경"/></td></tr>
</table>
</form>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>





