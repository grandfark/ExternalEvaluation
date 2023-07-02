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
	<h2 align="center">��ǰ ���� ����</h2>
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
<tr><th>��ǰ��ȣ</th><td><input type="text" name="ID"
	value="<%= goods.getId() %>" readonly="readonly"/>
	</td></tr>
<tr><th>��ǰ�̸�</th><td><input type="text" name="NAME"
	value="<%= goods.getName() %>"/></td></tr>
<tr><th>������</th><td><select name="MADE">
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
<tr><th>��ǰ����</th><td><input type="text" name="PRICE"
	value="<%= goods.getPrice() %>"/></td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="��ǰ ����"/></td></tr>
</table>
</form>
</div>
</section>
<footer>
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>





