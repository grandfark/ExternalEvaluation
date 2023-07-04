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
<div align="center">
<h2>계정 중복 확인</h2>
<form action="idCheck.do" name="idCheck">
<input type="hidden" name="OkId" value="${ID }"/><!-- 부모페이지로 옮기기 위해 파라미터로 만든다. -->
계 정:<input type="text" name="USER_ID" 
		value="${ID }"/>
<input type="submit" value="중복 검사"/>
</form>
<c:if test="${ ! empty DUP }">
	${DUP }는 이미 사용중 입니다.
	<script type="text/javascript">
		opener.document.fr.ID.value = "";//본인 지칭 부모페이지를 열때는 opener를 붙여준다. 
		//opener가 붙는게 부모document이다. value가 공백으로 ID값이 null이 아니면 날린다. 
	</script>
</c:if>
<c:if test="${ empty DUP }">
	${ID }는 사용 가능합니다.
	<input type="button" value="사용" onClick="idOk()"/>
</c:if>	
<script type="text/javascript">
function idOk(){
	opener.document.fr.ID.value =
		document.idCheck.OkId.value;
	opener.document.fr.idChecked.value= "OK";
	opener.document.getElementById("ID").readOnly=true;// 엘레먼트 수신 명령어 아이디 사용버튼 클릭시 변경불가
	self.close();
}
</script>
</div>
</body>
</html>