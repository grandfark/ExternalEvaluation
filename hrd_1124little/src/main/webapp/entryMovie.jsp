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
<h3 align="center">��ȭ ���</h3>
<form action="entryMovie.do" method="post">
<table border="1">
<tr><th>��ȭ��ȣ</th><td><input type="text" name="ID"/></td></tr>
<tr><th>��ȭ����</th><td><input type="text" name="NAME"/></td></tr>
<tr><th>����</th><td><input type="date" name="DATE"/></td></tr>
<tr><th>���۽ð�</th><td><input type="text" name="START"/></td></tr>
<tr><th>����ð�</th><td><input type="text" name="END"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit"
		value="��ȭ���"/></td></tr>
</table>
</form>
</section>
<footer>
<h3 align="center">Copyright 2022. �ڼ������簳�߿�</h3>
</footer>
</body>
</html>






