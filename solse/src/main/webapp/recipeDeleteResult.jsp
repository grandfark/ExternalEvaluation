<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.R == 'true' }">
		<script type="text/javascript">
			alert("레시피가 삭제 되었습니다.");
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("레시피가 삭제되지 않았습니다.")
		</script>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	location.href="main.jsp";
</script>
</body>
<