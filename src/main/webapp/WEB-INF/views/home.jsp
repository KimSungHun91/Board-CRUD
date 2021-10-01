<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	String msg = (String)session.getAttribute("msg");
	msg = "어서오세요";
%>
<html>
<head>
<meta charset="EUC-KR">
<title>home.jsp</title>
<style>
.titleStr {
	text-align : center;
	font-size : 2em;
	font-weight : bold;
}
.atag {
	text-align: center;
}
</style>
</head>
<body>
	<p class="titleStr">
		Wellcom
	</p>
<hr>
<div class="atag">
	<a href="goList">List</a> <a href="login">Login</a> <a href="join">Join</a>
</div>
<hr>
</body>
</html>