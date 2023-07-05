<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style type="text/css">
</style>
<body>
<div align="center">
</div>
<div align="center" id="main">
<h2>회원가입 양식서</h2>
<form action="joinMemer.do" method="post" name="fr"
	onSubmit="return checkk(this)">
<input type="hidden" name="idChecked">
ID: <input type="text" name="ID" id="ID"/>
<input type="button" value="중복검사" onClick="idCheck()"/><br/>
암호: <input type="password" name="PWD"/><br/>
암호 확인: <input type="password" name="CONF"/><br/>
이름: <input type="text" name="NAME"/><br/>
연락처: <input type="text" name="TEL"/><br/>
E-mail: <input type="text" name="EMAIL"/><br/>
주소: <input type="text" name="ADDR"/><br/>
<input type="submit" value="가입하기"/>
</form>
</div>
<script type="text/javascript">
function idCheck(){
	if(document.fr.ID.value==""){
		alert("계정을 입력하세요."); return;
	}
	var url="idCheck.do?USER_ID="+document.fr.ID.value;
	window.open(url,"_Blank_","width=450,height=600");
}
function checkk(frm){
	if(frm.NAME.value==""){
		alert("이름을 입력하세요."); return false;		
	}	
	if(frm.ID.value==""){
		alert("계정을 입력하세요."); return false;
	}
	if(frm.PWD.value==""){
		alert("암호를 입력하세요."); return false;
	}
	if(frm.PWD.value != frm.CONF.value){
		alert("암호가 일치하지않습니다. 다시 입력하세요."); return false;
	}
	if(frm.EMAIL.value==""){
		alert("이메일을 입력하세요."); return false;
	}
	if(frm.TEL.value==""){
		alert("연락처를 입력해주세요"); return false;
	}
	if(frm.ADDR.value==""){
		alert("주소를 입력해주세요."); return false;
	}
	if( ! confirm("진행하시겠습니까?")) return false;
}
</script>
</body>
</html>