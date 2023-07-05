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
<h1>레시피 한줄평 쓰기</h1>
<form action="commentIn.do" method="post" onSubmit="return check(this)">
<table>
	<tr><th>제 목</th><td><input type="text" size="30" name="TITLE"></td></tr>
	<tr><th>내 용</th><td><textarea rows="12" cols="30" name="CONTENT"></textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="쓰 기"/>
	<input type="reset" value="전부지우기"/></td></tr>
	</table>
<br/>
<script type="text/javascript">
function check(fm){
	if(fm.TITLE.value == ''){
		alert("제목을 입력하세요."); return false;
	}else{
		if(fm.TITLE.value.length > 30){
			alert("제목은 30자 이내로 입력하세요."); return false;
		}
	}
	if(fm.CONTENT.value == ''){
		alert("내용을 입력하세요."); return false;
	}else{
		if(fm.CONTENT.value.length > 100){
			alert("내용은 100자 이내로 작성하세요."); return false;
		}
	}
	if( ! confirm("업로드 하시겠습니까?")) return false;
}
</script>
</form>
</div>
</body>
</html>