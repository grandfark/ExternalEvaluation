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
<h2 align="center">��ȭ ���� ����</h2>
</header>
<nav><%@ include file="menu_file.jsp" %></nav>
<section>
<h3 align="center">�� ���� ���</h3>
<form action="entryMember.do" method="post">
<table border="1">
<tr><th>����ȣ</th><td><input type="text" name="ID"/></td></tr>
<tr><th>���̸�</th><td><input type="text" name="NAME"/></td></tr>
<tr><th>���ּ�</th><td><input type="text" name="ADDR"/></td></tr>
<tr><th>����ó</th><td><input type="text" name="TEL"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit"
		value="�����"/></td></tr>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>