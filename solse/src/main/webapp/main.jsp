<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#login {
	margin-left:10px; margin-top:10px;
	width:80%; height:70%; border:1px dashed red;
	background-color:pink;
}
#content{
	background-color:lightyellow;
}
.main{
	margin:10px; width:20%;
	background-color:lightgreen;
}
#body{
	align:"center"
}
#first{
background-color: lightgreen;
}
#second{
background-color: blue;
}
#third{
background-color:red;
}
#fourth{
background-color:gray;
}
</style>
</head>
<body>
<h1 align="center"><a href="main.jsp">FooD RecipE</a></h1>
<section>
	<table id="body" align="center" border="1">
		<tr>
		<td width="70%" id="content">
			<jsp:include page="${param.BODY }"/>
		</td>
			<td class="main">
			<div id="login">
			<c:choose>
			<c:when test="${sessionScope.USERID ==null &&
					sessionScope.MANAGER == null}">
					<jsp:include page="login.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="logout.jsp"/>
			</c:otherwise>
			</c:choose>
			</div>
 			<table border="1">
				<div>
					<a href="main.jsp?BODY=intro.jsp">■ 사이트 소개</a><br/><!-- 전체 공개 -->
					<c:if test="${sessionScope.USERID != null }" ><!-- session 에 일반 유저가 로그인 되어있을때 -->
						<a href="main.jsp?BODY=commentinput.jsp">■ 레시피 평가하기</a><br/>
					</c:if>
					<c:if test="${sessionScope.MANAGER != null }"><!-- 관리자가 로그인 되었을때 -->
						<a href="main.jsp?BODY=recipeInput.jsp">■ 레시피 쓰기</a><br/>
					</c:if>	
						<a href="main.jsp?BODY=commentlist.do">■ 한줄평</a><br/>
						<a href="main.jsp?BODY=recipeList.do">■ 레시피 및 한줄공지</a><br/><!-- 비로그인 읽기 가능 -->									
				</div>
				</table>
			</td></tr>
	</table>
</section>
<h2><table align="center"><tr><td>Copyright</td>
<td id="first"><font color="red">F</font></td>
<td id="second"><font color="yellow">D</font></td>
<td id="third"><font color="lightgreen">R</font></td>
<td id="fourth"><font color="violet">E</font></td></tr></table></h2>
</body>
</html>