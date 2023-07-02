<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String result = request.getParameter("R");
	if(result.equals("Y")){
%>
<script type="text/javascript">
	alert("영화정보가 등록되었습니다.");
</script>
<%	} else if(result.equals("N")){ %>
<script type="text/javascript">
	alert("영화정보가 등록되지 않았습니다. 영화번호를 확인하세요.");
</script>
<%	} %>
<script type="text/javascript">
	location.href="bookingList.do";
</script>
</body>
</html>








