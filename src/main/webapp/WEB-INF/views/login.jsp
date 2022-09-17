<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login.jsp</title>
<style>
.titleStr {
	text-align : center;
	font-size : 2em;
	font-weight : bold;
}
.btn {
	margin-top : 1em;
	text-align : center;
}
.centerBox {
	margin : 0 auto;
	padding : 2em;
	width : 15em;
	border : 2px solid gray;			
}
label {			
	position: absolute;			
	width : 4em;
	text-align : right;
}
input[type="text"], input[type="password"] {
	width : 10em;
	height : 1.2em; 
	margin-left : 6em;
	margin-bottom : 0.5em;
}
.atag {
	text-align: center;
}
</style>
</head>
<body>
<div class="atag">
	<p class="titleStr">Login</p>
	<a href="/board">Home</a> ${ msg } <a href="goList">List</a> 
</div>
	<form action="doLogin" method="post">
		<div class="centerBox">
			<label for="u_id">ID :</label> <input type="text" name="user_id" /><br/>
			<label for="u_pw">PW :</label> <input type="password" name="user_pw" /><br/>
			<div class="btn">
				<input type="submit" value="로그인" />
				<input type="submit" value="로그인" />
				<input type="submit" value="로그인" />
			</div>
		</div>
	</form>
</body>
</html>