<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>레시피 등록하기</h2>
<form action="insertRecipe.do" method="post" onSubmit="return check(this)">
<table>
	<tr><th>메뉴 이름:</th><td><input type="text" name="TITLE" /></tr>
	<tr><th>제작 방법:</th><td><textarea rows="10" cols="40" name="CONTENT"></textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="작성하기"/>
	<input type="reset" value="새로쓰기"/></td></tr>
</table>
<script type="text/javascript">
function check(fm){
	if(fm.TITLE.value == ''){
		alert("메뉴이름을 입력하세요."); return false;
	}else{
		if(fm.TITLE.value.length > 30){
			alert("메뉴이름은 30자 이내로 입력하세요."); return false;
		}
	}
	if(fm.CONTENT.value == ''){
		alert("레시피를 입력하세요."); return false;
	}else{
		if(fm.CONTENT.value.length > 200){
			alert("레시피는 200자 이내로 작성하세요."); return false;
		}
	}
	if( ! confirm("업로드 하시겠습니까?")) return false;
}
</script>
</form>
</div>
</body>
</html>