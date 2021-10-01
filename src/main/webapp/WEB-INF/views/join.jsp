<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>join.jsp</title>
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
.phone {
	width : 4em;
	height : 1.2em; 
	margin-left : 6em;
	margin-bottom : 0.5em;
}
.atag {
	text-align: center;
}
</style>
<script>
	function checkAndMove() {
		var obj = document.joinForm;
		
		var flag = true;
		// joinForm����
		for(var i=0; flag && i<obj.length; i++) {
			// Ÿ���� button ��ư�� �ƴ� ��� 
			if(obj[i].type.toLowerCase() != "button") {
				// ���� Ȯ��
				if(obj[i].value.trim().length == 0) {
					alert("��� �׸��� �ʼ��Է��Դϴ�.");
					flag = false;
				}
			}
		}
		
		if(flag) {
			// ��й�ȣ�� ��й�ȣ ���Է� ��ġ Ȯ��
			if(obj.user_pw.value != obj.user_repw.value) {
				alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�."); 
				flag = false;
			}
		}
		
		// ��� ���� ����(ȸ������ ����), doJoin.jsp�� �̵�
		if(flag) {
			obj.method = "post";
			obj.action = "doJoin";
			obj.submit();
		}
	}

</script>
</head>
<body>
<div class="atag">
	<p class="titleStr">Join</p>
	<a href="/board">Home</a> <a href="goList">List</a>
</div>
<form name="joinForm">
	<div class="centerBox">
		<label for="id">ID :</label> <input type="text" name="user_id" title="ID" /><br/>
		<label for="pw">PW :</label> <input type="password" name="user_pw" title="PASSWORD" /><br/>
		<label for="pwcheck">RETRY :</label> <input type="password" name="user_repw" title="RETRY" /><br/>
		<label for="name">NAME :</label> <input type="text" name="user_name" title="NAME"  /><br/>
		<label for="phone">PHONE :</label>
		<select class="phone" name="user_phone1">
			<c:forEach items="${ phoneComCode }" var="phoneComCode">	
				<option value="${ phoneComCode.code_id }">${ phoneComCode.code_name }</option>
			</c:forEach>
		</select>
		<input type="text" name="user_phone2" title="phone2" />
		<input type="text" name="user_phone3" title="phone3" />
		<br/>				
		<div class="btn">
			<input type="button" value="ȸ������" onclick="checkAndMove()" />
		</div>
	</div>
</form>	
</body>
</html>