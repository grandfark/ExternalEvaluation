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
	<h2 align="center">��ǰ �ֹ� ����</h2>
</header>
<section>
<div align="center">
<%
	ArrayList<Order> list = 
		(ArrayList)request.getAttribute("LIST");
%>
<table border="1">
<tr><th>��ǰ��ȣ</th><th>��ǰ��</th><th>�ֹ��ڸ�</th>
	<th>��ǰ����</th><th>�ֹ��� �ּ�</th><th>�ֹ��� ����ó</th>
	<th>�ֹ���</th><th>�� ��</th></tr>
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
	<td><input type="submit" value="����"/></td></tr>
</form>
<%	} %>
</table><br/>
<input type="button" value="�ֹ� ���" 
		onClick="orderForm()"/>
<input type="button" value="��ǰ ���"
		onClick="goodsForm()"/>
<input type="button" value="��ǰ ���"
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
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>


