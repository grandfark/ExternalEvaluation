<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${param.R == 'Y' }">
	<script type="text/javascript">
		alert("레시피가 등록되었습니다.");
		location.href="main.jsp";
	</script>
</c:if>
<c:if test="${param.R == 'N' }">
	<script type="text/javascript">
			alert("레시피가 등록되지 않았습니다.");
		location.href="main.jsp";
	</script>
</c:if>
</body>
</html>