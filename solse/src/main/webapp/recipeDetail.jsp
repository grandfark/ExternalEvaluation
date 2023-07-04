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
<div align="center">
<c:if test="${empty RCP}">
	<h1>존재 하지 않는 레시피 입니다.</h1>
</c:if>
<c:if test="${! empty RCP }">
	<form action="updateRecipe.do" method="post" onSubmit="return check(this)">

		<h1>레시피 상세보기</h1>
			<table>
				<input type="hidden" name="SEQ" value="${RCP.seqno }" readOnly="readonly"/>
				<tr><th>작성자</th><td><input type="text" name="WRITER" value="${RCP.writer }" readOnly="readonly"/></td></tr>
				<tr><th>글제목</th><td><input type="text" name="TITLE" value="${RCP.title }"/></td></tr>
				<tr><th>작성일</th><td><input type="text" name="R_DATE" value="${RCP.reg_date }" readOnly="readonly"></td></tr>
				<tr><th>내 용</th><td><textarea rows="5" cols="40" name="CONTENT">
				${RCP.content }
				</textarea></td></tr>
				<tr><td colspan="2" align="center">
				<input type="reset" value="새로고침" >
				<c:if test="${sessionScope.MANAGER != null }">
				<input type="submit" value="삭 제" name="BTN">
				<input type="submit" value="수 정" name="BTN">
				</c:if>
				</td></tr>
			</table>
	</form>
</c:if>
</div>
</body>
</html>