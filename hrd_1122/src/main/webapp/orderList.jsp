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
	<h2 align="center">상품 주문 정보</h2>
</header>
<section>
<div align="center">
<%
	ArrayList<Order> list = 
		(ArrayList)request.getAttribute("LIST");
%>
<table border="1">
<tr><th>상품번호</th><th>상품명</th><th>주문자명</th>
	<th>상품가격</th><th>주문자 주소</th><th>주문자 연락처</th>
	<th>주문일</th><th>삭 제</th></tr>
<%
	for(Order order : list){
%>
<form action="orderDelete.do" method="post">
<input type="hidden" name="ID" value="<%= order.getId() %>"/>
<input type="hidden" name="NAME" 
					value="<%= order.getC_name() %>"/>
<input type="hidden" name="DATE"
					value="<%= order.getO_date() %>"/>
<tr><td><a href="goodsUpdateForm.do?ID=<%= order.getId() %>"><%= order.getId() %></a></td>
	<td><%= order.getG_name() %></td>
	<td><%= order.getC_name() %></td>
	<td><%= order.getPrice() %></td>
	<td><%= order.getAddr() %></td>
	<td><%= order.getPhone() %></td>
	<td><%= order.getO_date() %></td>
	<td><input type="submit" value="삭제"/></td></tr>
</form>
<%	} %>
</table><br/>
<input type="button" value="주문 등록" 
		onClick="orderForm()"/>
<input type="button" value="상품 등록"
		onClick="goodsForm()"/>
<input type="button" value="상품 목록"
		onClick="goodsList()"/>		
</div>
</section>
<script type="text/javascript">
function goodsList(){
	location.href="goodsList.do";
}
function goodsForm(){
	location.href="goodsEntryForm.do";
}
function orderForm(){
	location.href="orderForm.do";
}
</script>
<footer>
<h3 align="center">Copyright 2022. 코세아인재개발원</h3>
</footer>
</body>
</html>


